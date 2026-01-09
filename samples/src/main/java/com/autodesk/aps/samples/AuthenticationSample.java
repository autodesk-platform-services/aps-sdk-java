package com.autodesk.aps.samples;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.event.Level;

import com.autodesk.aps.authentication.AuthenticationApiException;
import com.autodesk.aps.authentication.AuthenticationClient;
import com.autodesk.aps.authentication.model.Jwks;
import com.autodesk.aps.authentication.model.OidcSpec;
import com.autodesk.aps.authentication.model.RefreshTokenOptionalParams;
import com.autodesk.aps.authentication.model.ResponseType;
import com.autodesk.aps.authentication.model.RevokeOptionalParams;
import com.autodesk.aps.authentication.model.Scopes;
import com.autodesk.aps.authentication.model.ThreeLeggedOptionalParams;
import com.autodesk.aps.authentication.model.ThreeLeggedToken;
import com.autodesk.aps.authentication.model.TokenTypeHint;
import com.autodesk.aps.authentication.model.TwoLeggedToken;
import com.autodesk.aps.authentication.model.UserInfo;
import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.ApsLogger;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;

import io.github.cdimascio.dotenv.Dotenv;

public class AuthenticationSample {

    public static AuthenticationClient authenticationClient = null;
    Dotenv dotenv = Dotenv.load();
    String clientId = dotenv.get("CLIENT_ID");
    String clientSecret = dotenv.get("CLIENT_SECRET");
    String accessToken = dotenv.get("ACCESS_TOKEN");

    void initialize() {
        SdkManager sdkManager = SdkManagerBuilder.create()
                .addLogger(new ApsLogger(Level.DEBUG))
                .build();
        authenticationClient = new AuthenticationClient(sdkManager);
    }

    void getTwoLeggedToken() {
        try {
            TwoLeggedToken response = authenticationClient.getTwoLeggedToken(
                    clientId, clientSecret, new Scopes[] { Scopes.BUCKET_CREATE });
            System.out.println("AccessToken : " + response.getAccessToken());
            System.out.println("ExpiresIn : " + response.getExpiresIn());
            System.out.println("TokenType : " + response.getTokenType());

            LocalDateTime expiresAtLocal = LocalDateTime.ofInstant(Instant.ofEpochSecond(response.getExpiresAt()),
                    ZoneId.systemDefault());
            System.out.println("ExpiresAt (Local Time) : " + expiresAtLocal);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getAuthorizationUrl() {
        try {
            String redirectUri = "http://localhost:8080/api/auth/callback";
            String url = authenticationClient.authorize(
                    clientId, ResponseType.CODE, redirectUri, new Scopes[] { Scopes.DATA_READ });
            System.out.println("Authorization URL: " + url);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getThreeLeggedToken() {
        try {
            String code = "ue1c1.i-PO8aIVKr1kCg4T9JVVT-jzs8lTbn-BgzNLr8vc"; // You should set this in your .env
            String redirectUri = "http://localhost:8080/api/auth/callback";
            ThreeLeggedToken response = authenticationClient.getThreeLeggedToken(
                    clientId, code, redirectUri,
                    new ThreeLeggedOptionalParams.Builder().clientSecret(clientSecret).build());
            System.out.println("ThreeLegged Access Token: " + response.getAccessToken() +
                    " Refresh Token: " + response.getRefreshToken());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getRefreshToken() {
        try {
            String refreshToken = "ue1c1.j3kfrPjhTMX9gBTODSYHBSz8yfVyosOYlOjzHdFbeM"; // You should set this in your
                                                                                      // .env
            RefreshTokenOptionalParams params = new RefreshTokenOptionalParams.Builder()
                    .clientSecret(clientSecret)
                    .build();
            ThreeLeggedToken response = authenticationClient.refreshToken(refreshToken, clientId, params);

            System.out.println("ThreeLegged Access Token: " + response.getAccessToken() +
                    " Refresh Token: " + response.getRefreshToken());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void revokeToken() {
        try {
            ApiResponse<?> response = authenticationClient.revoke(accessToken, clientId, TokenTypeHint.ACCESS_TOKEN,
                    new RevokeOptionalParams.Builder().clientSecret(clientSecret).build());
            System.out.println("Token revoked successfully." + response.getStatusCode());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getOidcSpecs() {
        try {
            OidcSpec response = authenticationClient.getOidcSpec();
            System.out.println("OIDC Specs: " + response);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getKeys() {
        try {
            Jwks jwkskeys = authenticationClient.getKeys();
            System.out.println(jwkskeys);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void getUserInfo(String accessToken) {
        try {
            UserInfo userInfo = authenticationClient.getUserInfo(accessToken);
            System.out.println(userInfo);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    void logout() {
        try {
            String url = authenticationClient.logout();
            System.out.println("Logout URL: " + url);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void main(String[] args) throws AuthenticationApiException {
        try {
            AuthenticationSample authenticationSample = new AuthenticationSample();
            authenticationSample.initialize();

            // Endpoint function to test:
            authenticationSample.getTwoLeggedToken();
            authenticationSample.getAuthorizationUrl();
            authenticationSample.getThreeLeggedToken();
            authenticationSample.getRefreshToken();
            authenticationSample.revokeToken();
            authenticationSample.getOidcSpecs();
            authenticationSample.getKeys();
            authenticationSample.getUserInfo("YOUR_ACCESS_TOKEN");
            authenticationSample.logout();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            if (authenticationClient != null) {
                authenticationClient.close();
            }
        }
    }
}