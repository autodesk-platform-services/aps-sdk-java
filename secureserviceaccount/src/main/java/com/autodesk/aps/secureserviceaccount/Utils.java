package com.autodesk.aps.secureserviceaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.autodesk.aps.secureserviceaccount.model.Scope;

/**
 * Provides helper methods for secure service account authentication operations,
 * including JWT assertion generation for APS token exchange.
 */
public class Utils {

    private static final int DEFAULT_ASSERTION_LIFETIME_SECONDS = 300;
    private static final String AUDIENCE = "https://developer.api.autodesk.com/authentication/v2/token";

    // NOTE: Ensure that your system clock is set correctly before running this code.

    /**
     * Generates a signed JWT assertion for APS token exchange using the provided RSA private key,
     * with a default assertion lifetime of 300 seconds (5 minutes).
     *
     * @param keyId            The key identifier (kid) included in the JWT header.
     * @param privateKey       PEM-formatted RSA private key (PKCS#8) used to sign the token.
     * @param clientId         The OAuth client ID, used as the {@code iss} claim.
     * @param serviceAccountId The service account identifier, used as the {@code sub} claim.
     * @param scopes           Requested scopes to include in the {@code scope} claim.
     * @return A compact serialized JWT assertion string.
     */
    public static String generateJwtAssertion(String keyId, String privateKey, String clientId,
                                              String serviceAccountId, List<Scope> scopes) {
        return generateJwtAssertion(keyId, privateKey, clientId, serviceAccountId, scopes,
                DEFAULT_ASSERTION_LIFETIME_SECONDS);
    }

    /**
     * Generates a signed JWT assertion for APS token exchange using the provided RSA private key.
     * NOTE: Ensure that your system clock is set correctly before running this code.
     *
     * @param keyId                    The key identifier (kid) included in the JWT header.
     * @param privateKey               PEM-formatted RSA private key (PKCS#8) used to sign the token.
     * @param clientId                 The OAuth client ID, used as the {@code iss} claim.
     * @param serviceAccountId         The service account identifier, used as the {@code sub} claim.
     * @param scopes                   Requested scopes to include in the {@code scope} claim.
     * @param assertionLifetimeSeconds The lifetime of the assertion in seconds. Must be 0 - 5 minutes
     *                                 in the future. Default is 300 seconds (5 minutes).
     * @return A compact serialized JWT assertion string.
     */
    public static String generateJwtAssertion(String keyId, String privateKey, String clientId,
                                              String serviceAccountId, List<Scope> scopes,
                                              int assertionLifetimeSeconds) {
        try {
            PrivateKey rsaPrivateKey = parsePrivateKeyFromPem(privateKey);

            long nowEpoch = Instant.now().getEpochSecond();
            long expEpoch = nowEpoch + assertionLifetimeSeconds;

            String header = "{\"alg\":\"RS256\",\"typ\":\"JWT\",\"kid\":\""
                    + escapeJson(keyId) + "\"}";

            String scopeJson = scopes.stream()
                    .map(s -> "\"" + escapeJson(s.getValue()) + "\"")
                    .collect(Collectors.joining(",", "[", "]"));

            String payload = "{\"iss\":\"" + escapeJson(clientId)
                    + "\",\"sub\":\"" + escapeJson(serviceAccountId)
                    + "\",\"aud\":\"" + AUDIENCE
                    + "\",\"scope\":" + scopeJson
                    + ",\"exp\":" + expEpoch
                    + ",\"iat\":" + nowEpoch + "}";

            String encodedHeader = base64UrlEncode(header.getBytes(StandardCharsets.UTF_8));
            String encodedPayload = base64UrlEncode(payload.getBytes(StandardCharsets.UTF_8));
            String signingInput = encodedHeader + "." + encodedPayload;

            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(rsaPrivateKey);
            signer.update(signingInput.getBytes(StandardCharsets.UTF_8));
            String encodedSignature = base64UrlEncode(signer.sign());

            return signingInput + "." + encodedSignature;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate JWT assertion: " + e.getMessage(), e);
        }
    }

    /**
     * Generates a signed JWT assertion for APS token exchange using a readable input stream
     * containing a PEM-formatted RSA private key, with a default assertion lifetime of 300 seconds.
     *
     * @param keyId            The key identifier (kid) included in the JWT header.
     * @param privateKeyStream A readable input stream containing the PEM-formatted RSA private key.
     * @param clientId         The OAuth client ID, used as the {@code iss} claim.
     * @param serviceAccountId The service account identifier, used as the {@code sub} claim.
     * @param scopes           Requested scopes to include in the {@code scope} claim.
     * @return A compact serialized JWT assertion string.
     * @throws IllegalArgumentException when {@code privateKeyStream} is null.
     */
    public static String generateJwtAssertion(String keyId, InputStream privateKeyStream, String clientId,
                                              String serviceAccountId, List<Scope> scopes) {
        return generateJwtAssertion(keyId, privateKeyStream, clientId, serviceAccountId, scopes,
                DEFAULT_ASSERTION_LIFETIME_SECONDS);
    }

    /**
     * Generates a signed JWT assertion for APS token exchange using a readable input stream
     * containing a PEM-formatted RSA private key.
     *
     * @param keyId                    The key identifier (kid) included in the JWT header.
     * @param privateKeyStream         A readable input stream containing the PEM-formatted RSA private key.
     * @param clientId                 The OAuth client ID, used as the {@code iss} claim.
     * @param serviceAccountId         The service account identifier, used as the {@code sub} claim.
     * @param scopes                   Requested scopes to include in the {@code scope} claim.
     * @param assertionLifetimeSeconds The lifetime of the assertion in seconds. Must be 0 - 5 minutes
     *                                 in the future. Default is 300 seconds (5 minutes).
     * @return A compact serialized JWT assertion string.
     * @throws IllegalArgumentException when {@code privateKeyStream} is null.
     */
    public static String generateJwtAssertion(String keyId, InputStream privateKeyStream, String clientId,
                                              String serviceAccountId, List<Scope> scopes,
                                              int assertionLifetimeSeconds) {
        if (privateKeyStream == null) {
            throw new IllegalArgumentException("privateKeyStream must be a readable stream.");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(privateKeyStream, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read private key stream: " + e.getMessage(), e);
        }

        return generateJwtAssertion(keyId, sb.toString(), clientId, serviceAccountId, scopes,
                assertionLifetimeSeconds);
    }

    private static PrivateKey parsePrivateKeyFromPem(String pem) throws Exception {
        if (pem == null) {
            throw new IllegalArgumentException("privateKey must not be null.");
        }
        String normalized = pem.trim();
        boolean isPkcs1 = normalized.contains("-----BEGIN RSA PRIVATE KEY-----");
        String base64 = normalized
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(base64);
        if (isPkcs1) {
            decoded = wrapPkcs1AsPkcs8(decoded);
        }
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decoded));
    }

    private static byte[] wrapPkcs1AsPkcs8(byte[] pkcs1) {
        byte[] version = new byte[] { 0x02, 0x01, 0x00 };
        byte[] algId = new byte[] {
                0x30, 0x0d, 0x06, 0x09, 0x2a, (byte) 0x86, 0x48, (byte) 0x86,
                (byte) 0xf7, 0x0d, 0x01, 0x01, 0x01, 0x05, 0x00
        };
        byte[] octetString = derTagged((byte) 0x04, pkcs1);
        byte[] inner = concat(version, algId, octetString);
        return derTagged((byte) 0x30, inner);
    }

    private static byte[] derTagged(byte tag, byte[] content) {
        byte[] length = derLength(content.length);
        byte[] result = new byte[1 + length.length + content.length];
        result[0] = tag;
        System.arraycopy(length, 0, result, 1, length.length);
        System.arraycopy(content, 0, result, 1 + length.length, content.length);
        return result;
    }

    private static byte[] derLength(int length) {
        if (length < 0x80) {
            return new byte[] { (byte) length };
        } else if (length < 0x100) {
            return new byte[] { (byte) 0x81, (byte) length };
        } else if (length < 0x10000) {
            return new byte[] { (byte) 0x82, (byte) (length >> 8), (byte) length };
        } else {
            return new byte[] { (byte) 0x83, (byte) (length >> 16), (byte) (length >> 8), (byte) length };
        }
    }

    private static byte[] concat(byte[]... arrays) {
        int total = 0;
        for (byte[] a : arrays) {
            total += a.length;
        }
        byte[] result = new byte[total];
        int pos = 0;
        for (byte[] a : arrays) {
            System.arraycopy(a, 0, result, pos, a.length);
            pos += a.length;
        }
        return result;
    }

    private static String base64UrlEncode(byte[] data) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
    }

    private static String escapeJson(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"':  sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\b': sb.append("\\b"); break;
                case '\f': sb.append("\\f"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c < 0x20) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }
}
