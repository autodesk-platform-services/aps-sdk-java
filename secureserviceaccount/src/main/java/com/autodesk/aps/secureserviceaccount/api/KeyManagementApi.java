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


import com.autodesk.aps.secureserviceaccount.SecureServiceAccountApiException;
import com.autodesk.aps.secureserviceaccount.BaseApi;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.ApiResponse;


import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountKeyPayload;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountKeys;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountPrivateKey;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class KeyManagementApi extends BaseApi {

  public KeyManagementApi(SdkManager sdkManager) {
     super(sdkManager, sdkManager.getLogger());
  }



  /**
   * Create Keys
   * Creates a service account key. 
 * 
 * A service account key is a public-private key pair, generated using RSA with a key length of 2048 bits by the Identity Authorization Service (AuthZ).
 * 
 * The private key is returned once during its creation. AuthZ only stores the public key.
 * 
 * A service account can have up to 3 keys at any given time.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @return ServiceAccountPrivateKey
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccountPrivateKey> createServiceAccountKey(String serviceAccountId, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into createServiceAccountKey ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling createServiceAccountKey");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}/keys"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


            
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
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
      this.logger.info("createServiceAccountKey Request completed successfully with status " + statusCode);
      ServiceAccountPrivateKey serviceAccountPrivateKey = deserialize(entity, new TypeReference<ServiceAccountPrivateKey>() {});
      return new ApiResponse<ServiceAccountPrivateKey>(statusCode, response.getHeaders(), serviceAccountPrivateKey);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("createServiceAccountKey Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createServiceAccountKey Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Delete key
   * Deletes an existing key.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @param keyId The ID of the private key (required)
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<Void> deleteServiceAccountKey(String serviceAccountId, String keyId, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into deleteServiceAccountKey ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling deleteServiceAccountKey");
    }
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'keyId' when calling deleteServiceAccountKey");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}/keys/{keyId}"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId))
      .replaceAll("\\{" + "keyId" + "\\}", parameterToString(keyId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


            
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
            localVarPath,
            "Delete",
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
      this.logger.info("deleteServiceAccountKey Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("deleteServiceAccountKey Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteServiceAccountKey Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Enable or Disable Key
   * Enables or disables a service account key.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @param keyId The ID of the private key (required)
   * @param enableDisableServiceAccountKeyPayload  (required)
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<Void> enableDisableServiceAccountKey(String serviceAccountId, String keyId, EnableDisableServiceAccountKeyPayload enableDisableServiceAccountKeyPayload, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into enableDisableServiceAccountKey ");

    Object localVarPostBody = enableDisableServiceAccountKeyPayload;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling enableDisableServiceAccountKey");
    }
    
    // verify the required parameter 'keyId' is set
    if (keyId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'keyId' when calling enableDisableServiceAccountKey");
    }
    
    // verify the required parameter 'enableDisableServiceAccountKeyPayload' is set
    if (enableDisableServiceAccountKeyPayload == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'enableDisableServiceAccountKeyPayload' when calling enableDisableServiceAccountKey");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}/keys/{keyId}"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId))
      .replaceAll("\\{" + "keyId" + "\\}", parameterToString(keyId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


            
    localVarHeaderParams.put("Content-Type", "application/json");
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
            localVarPath,
            "Patch",
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
      this.logger.info("enableDisableServiceAccountKey Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("enableDisableServiceAccountKey Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("enableDisableServiceAccountKey Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Get All Keys
   * Lists all keys associated with the service account. This operation will only return key metadata, not the private or public key.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @return ServiceAccountKeys
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccountKeys> getAllServiceAccountKeys(String serviceAccountId, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into getAllServiceAccountKeys ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling getAllServiceAccountKeys");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}/keys"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId));

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


            
    localVarHeaderParams.put("Authorization", "Bearer " + accessToken);
    localVarHeaderParams.put("User-Agent", getUserAgent());

    try {
      ClassicHttpResponse response = invokeAPI(
            localVarPath,
            "Get",
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
      this.logger.info("getAllServiceAccountKeys Request completed successfully with status " + statusCode);
      ServiceAccountKeys serviceAccountKeys = deserialize(entity, new TypeReference<ServiceAccountKeys>() {});
      return new ApiResponse<ServiceAccountKeys>(statusCode, response.getHeaders(), serviceAccountKeys);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("getAllServiceAccountKeys Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getAllServiceAccountKeys Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

}
