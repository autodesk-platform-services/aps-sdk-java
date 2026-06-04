package com.autodesk.aps.samples;

import java.util.List;

import com.autodesk.aps.sdkmanager.StaticAuthenticationProvider;
import com.autodesk.aps.secureserviceaccount.SecureServiceAccountClient;
import com.autodesk.aps.secureserviceaccount.Utils;
import com.autodesk.aps.secureserviceaccount.model.CreateServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountKeyPayload;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.ExchangeJwtAssertionOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.ExchangeJwtToken;
import com.autodesk.aps.secureserviceaccount.model.GrantType;
import com.autodesk.aps.secureserviceaccount.model.Scope;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccount;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountDetails;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountKeyDetails;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountKeys;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountPrivateKey;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccounts;
import com.autodesk.aps.secureserviceaccount.model.Status;

import io.github.cdimascio.dotenv.Dotenv;

public class SecureServiceAccountSample {
    public static SecureServiceAccountClient secureServiceAccountClient;
    Dotenv dotenv = Dotenv.load();
    String accessToken = dotenv.get("ACCESS_TOKEN");
    String serviceAccountId = dotenv.get("SERVICE_ACCOUNT_ID");
    String keyId = dotenv.get("KEY_ID");
    String clientId = dotenv.get("CLIENT_ID");
    String clientSecret = dotenv.get("CLIENT_SECRET");
    String privateKey = dotenv.get("PRIVATE_KEY", "");
    
    void Initialize() {
        StaticAuthenticationProvider staticAuthenticationProvider = new StaticAuthenticationProvider(accessToken);
        secureServiceAccountClient = new SecureServiceAccountClient(staticAuthenticationProvider);
    }

    void createServiceAccount() {
        try {
            CreateServiceAccountPayload payload = new CreateServiceAccountPayload()
                    .name("my-service-account")
                    .firstName("Sample")
                    .lastName("ServiceAccount");

            ServiceAccount response = secureServiceAccountClient.createServiceAccount(payload);
            System.out.println("Service Account created successfully.");
            System.out.println("Service Account Id: " + response.getServiceAccountId());
            System.out.println("Email: " + response.getEmail());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void getAllServiceAccounts() {
        try {
            ServiceAccounts response = secureServiceAccountClient.getAllServiceAccounts();
            if (response.getServiceAccounts() != null) {
                for (ServiceAccountDetails sa : response.getServiceAccounts()) {
                    System.out.println("Service Account Id: " + sa.getServiceAccountId());
                    System.out.println("Email: " + sa.getEmail());
                    System.out.println("Created By: " + sa.getCreatedBy());
                    System.out.println("Status: " + sa.getStatus());
                    System.out.println("Created At: " + sa.getCreatedAt());
                    System.out.println("Accessed At: " + sa.getAccessedAt());
                    System.out.println("Expires At: " + sa.getExpiresAt());
                    System.out.println("---------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void getServiceAccount() {
        try {
            ServiceAccountDetails response = secureServiceAccountClient.getServiceAccount(serviceAccountId);
            System.out.println("Service Account Id: " + response.getServiceAccountId());
            System.out.println("Email: " + response.getEmail());
            System.out.println("Created By: " + response.getCreatedBy());
            System.out.println("Status: " + response.getStatus());
            System.out.println("Created At: " + response.getCreatedAt());
            System.out.println("Accessed At: " + response.getAccessedAt());
            System.out.println("Expires At: " + response.getExpiresAt());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void enableDisableServiceAccount() {
        try {
            EnableDisableServiceAccountPayload payload = new EnableDisableServiceAccountPayload()
                    .status(Status.ENABLED);

            ServiceAccountDetails response = secureServiceAccountClient.enableDisableServiceAccount(serviceAccountId,
                    payload);
            System.out.println("Service Account status updated successfully.");
            System.out.println("Service Account Id: " + response.getServiceAccountId());
            System.out.println("Status: " + response.getStatus());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void createServiceAccountKey() {
        try {
            ServiceAccountPrivateKey response = secureServiceAccountClient.createServiceAccountKey(serviceAccountId);
            System.out.println("Service Account key created successfully.");
            System.out.println("Key Id (kid): " + response.getKid());
            System.out.println("Private Key (PEM): " + response.getPrivateKey());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void getAllServiceAccountKeys() {
        try {
            ServiceAccountKeys response = secureServiceAccountClient.getAllServiceAccountKeys(serviceAccountId);
            if (response.getKeys() != null) {
                for (ServiceAccountKeyDetails key : response.getKeys()) {
                    System.out.println("Key Id (kid): " + key.getKid());
                    System.out.println("Status: " + key.getStatus());
                    System.out.println("Created At: " + key.getCreatedAt());
                    System.out.println("Accessed At: " + key.getAccessedAt());
                    System.out.println("---------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void enableDisableServiceAccountKey() {
        try {
            EnableDisableServiceAccountKeyPayload payload = new EnableDisableServiceAccountKeyPayload()
                    .status(Status.DISABLED);

            secureServiceAccountClient.enableDisableServiceAccountKey(serviceAccountId, keyId, payload);
            System.out.println("Service Account key status updated successfully.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    static String generateJwtAssertion(String clientId, String serviceAccountId, String privateKey,
                                       String keyId, List<Scope> scopes, int lifetimeSeconds) {
        return Utils.generateJwtAssertion(keyId, privateKey, clientId, serviceAccountId, scopes,
                lifetimeSeconds);
    }

    static void showJwtAssertionStructure(String serviceAccountId, String clientId, String keyId,
                                          List<String> scopes) {
        long now = System.currentTimeMillis() / 1000L;
        String scopeJson = scopes.stream()
                .map(s -> "\"" + s + "\"")
                .collect(java.util.stream.Collectors.joining(", ", "[", "]"));
        System.out.println("JWT Header:");
        System.out.println("  { \"alg\": \"RS256\", \"typ\": \"JWT\", \"kid\": \"" + keyId + "\" }");
        System.out.println("JWT Payload:");
        System.out.println("  {");
        System.out.println("    \"iss\": \"" + clientId + "\",");
        System.out.println("    \"sub\": \"" + serviceAccountId + "\",");
        System.out.println("    \"aud\": \"https://developer.api.autodesk.com/authentication/v2/token\",");
        System.out.println("    \"scope\": " + scopeJson + ",");
        System.out.println("    \"iat\": " + now + ",");
        System.out.println("    \"exp\": " + (now + 300));
        System.out.println("  }");
        System.out.println("JWT Signature: <RS256 signature using PRIVATE_KEY>");
    }

    void exchangeJwtAssertion() {
        try {
            if (privateKey == null || privateKey.isEmpty()) {
                System.out.println("No private key provided - showing JWT structure example:");
                showJwtAssertionStructure(serviceAccountId, clientId, keyId,
                        List.of("data:read", "data:write"));
                System.out.println("\n To actually exchange tokens, set PRIVATE_KEY (PEM, PKCS#8) " +
                        "and KEY_ID in your .env file.");
                return;
            }

            List<Scope> scopes = List.of(Scope.DATA_READ, Scope.DATA_WRITE);

            System.out.println("Generating JWT assertion...");
            String jwtAssertion = generateJwtAssertion(
                    clientId, serviceAccountId, privateKey, keyId, scopes, 300);
            System.out.println("JWT assertion generated successfully: " + jwtAssertion);
            System.out.println("JWT length: " + jwtAssertion.length() + " characters");

            ExchangeJwtAssertionOptionalParams params = new ExchangeJwtAssertionOptionalParams.Builder()
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .scope(scopes)
                    .build();

            ExchangeJwtToken response = secureServiceAccountClient.exchangeJwtAssertion(
                    GrantType.URN_IETF_PARAMS_OAUTH_GRANT_TYPE_JWT_BEARER, jwtAssertion, params);
            System.out.println("Token exchange successful:");
            System.out.println("Access Token: " + response.getAccessToken());
            System.out.println("Token Type: " + response.getTokenType());
            System.out.println("Expires In: " + response.getExpiresIn() + " seconds");
            System.out.println("Expires At: " + response.getExpiresAt());
        } catch (Exception e) {
            System.out.println("Error exchanging JWT for token: " + e.getMessage());
        }
    }

    void deleteServiceAccountKey() {
        try {
            secureServiceAccountClient.deleteServiceAccountKey(serviceAccountId, keyId);
            System.out.println("Service Account key deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    void deleteServiceAccount() {
        try {
            secureServiceAccountClient.deleteServiceAccount(serviceAccountId);
            System.out.println("Service Account deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SecureServiceAccountSample sample = new SecureServiceAccountSample();
            // Initialize the Secure Service Account sample class
            sample.Initialize();
            // Create a service account
            // sample.createServiceAccount();
            // // Get all service accounts
            // sample.getAllServiceAccounts();
            // // Get details of a specific service account
            // sample.getServiceAccount();
            // // Enable or disable a service account
            // sample.enableDisableServiceAccount();
            // // Create a service account key
            // sample.createServiceAccountKey();
            // // Get all keys for a service account
            // sample.getAllServiceAccountKeys();
            // // Enable or disable a service account key
            // sample.enableDisableServiceAccountKey();
            // // Exchange a JWT assertion for an access token
            sample.exchangeJwtAssertion();
            // // Delete a service account key
            // sample.deleteServiceAccountKey();
            // // Delete a service account
            // sample.deleteServiceAccount();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (secureServiceAccountClient != null) {
                secureServiceAccountClient.close();
            }
        }
    }
}
