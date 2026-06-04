/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Secure Service Account
 * Operations to manage Service accounts and keys.   A service account is an identity that an application can use to make requests to other services without a user authorizing the requests. A service account is identified by a unique email address and has an Autodesk ID.  A service account has one or more private keys. A private key is generated through an asymmetric cryptography algorithm; the paired public key is stored by Autodesk Identity.  An application can use a service account's private key to generate a JWT token. The JWT token provides proof of implicit authentication and authorization for this service account; an application can exchange it for a three-legged access token for the service service.
 *
 * Contact: aps.help@autodesk.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.autodesk.aps.secureserviceaccount.api;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.autodesk.aps.sdkmanager.ApiResponse;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.secureserviceaccount.BaseApi;
import com.autodesk.aps.secureserviceaccount.SecureServiceAccountApiException;
import com.autodesk.aps.secureserviceaccount.model.ExchangeJwtToken;
import com.autodesk.aps.secureserviceaccount.model.GrantType;
import com.autodesk.aps.secureserviceaccount.model.Scope;
import com.fasterxml.jackson.core.type.TypeReference;



public class ExchangeTokenApi extends BaseApi {

  public ExchangeTokenApi(SdkManager sdkManager) {
     super(sdkManager, sdkManager.getLogger());
  }



  /**
   * Exchanging JWT assertion for token
   * Returns a three-legged access token for the JWT assertion you provide in the request body. See the Developer&#39;s Guide topic JWT Assertions for information on how to generate a JWT assertion for this operation.
 * 
 * This operation is only for confidential clients. It requires Basic Authorization (client_id, client_secret). Authentication information (client_id, client_secret) can be included either in the header or the body, but not both simultaneously.
   * @param grantType  (required)
   * @param assertion The value of the JWT assertion. (required)
   * @param authorization Must be Basic &lt;credentials&gt;, where &lt;credentials&gt; is a base64 encoded string of client_id:client_secret. This parameter is required only if client_id and client_secret are not provided in the request body. (optional)
   * @param clientId This attribute is optional; it serves as an additional option where the client can either use the authorization header or opt to send this information in the body. (optional)
   * @param clientSecret This attribute is optional; it serves as an additional option where the client can either use the authorization header or opt to send this information in the body. (optional)
   * @param scope This is a space-delimited list of scopes. The scope in the token endpoint request body should be a subset of or the same as the scope specified in the assertion. If the scope is not present, then the returned access token will have the same scope as the assertion. (optional)
   * @return ExchangeJwtToken
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ExchangeJwtToken> exchangeJwtAssertion(GrantType grantType, String assertion, String authorization, String clientId, String clientSecret, List<Scope> scope) throws SecureServiceAccountApiException {
    this.logger.info("Entered into exchangeJwtAssertion ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'grantType' is set
    if (grantType == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'grantType' when calling exchangeJwtAssertion");
    }
    
    // verify the required parameter 'assertion' is set
    if (assertion == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'assertion' when calling exchangeJwtAssertion");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/token";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


    if (authorization != null) {
      localVarHeaderParams.put("Authorization", parameterToString(authorization));
    }
    if (grantType != null) {
      localVarFormParams.put("grant_type", grantType);
    }
if (clientId != null) {
      localVarFormParams.put("client_id", clientId);
    }
if (clientSecret != null) {
      localVarFormParams.put("client_secret", clientSecret);
    }
if (assertion != null) {
      localVarFormParams.put("assertion", assertion);
    }
if (scope != null) {
      localVarFormParams.put("scope", scope);
    }
    
    localVarHeaderParams.put("Content-Type", "application/x-www-form-urlencoded");
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
            localVarPath,
            "Post",
            localVarQueryParams,
            localVarPostBody,
            localVarHeaderParams,
            localVarFormParams
        );
      int statusCode = response.getCode();
      HttpEntity entity = response.getEntity();
      if (!isSuccessfulStatus(statusCode)) {
          String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
          throw new SecureServiceAccountApiException(
                  "Request failed with status: " + statusCode + " and response: " + responseString,
                  statusCode, responseString);
      }
      this.logger.info("exchangeJwtAssertion Request completed successfully with status " + statusCode);
      ExchangeJwtToken exchangeJwtToken = deserialize(entity, new TypeReference<ExchangeJwtToken>() {});
      if (exchangeJwtToken != null && exchangeJwtToken.getExpiresIn() != null) {
          exchangeJwtToken.setExpiresAt(System.currentTimeMillis() + exchangeJwtToken.getExpiresIn().longValue() * 1000L);
      }
      return new ApiResponse<ExchangeJwtToken>(statusCode, response.getHeaders(), exchangeJwtToken);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("exchangeJwtAssertion Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("exchangeJwtAssertion Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

}
