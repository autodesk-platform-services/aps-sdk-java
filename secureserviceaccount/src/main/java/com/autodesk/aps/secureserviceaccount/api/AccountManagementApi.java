/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Secure Service Account
 * Operations to manage Service accounts and keys.  A service account is an identity that an application can use to make requests to other services without a user authorizing the requests. A service account is identified by a unique email address and has an Autodesk ID.  A service account has one or more private keys. A private key is generated through an asymmetric cryptography algorithm; the paired public key is stored by Autodesk Identity.  An application can use a service account's private key to generate a JWT token. The JWT token provides proof of implicit authentication and authorization for this service account; an application can exchange it for a three-legged access token for the service account.
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


import com.autodesk.aps.secureserviceaccount.model.CreateServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccount;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountDetails;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccounts;

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



public class AccountManagementApi extends BaseApi {

  public AccountManagementApi(SdkManager sdkManager) {
     super(sdkManager, sdkManager.getLogger());
  }



  /**
   * Create Service Account
   * Creates a service account. Only a server-to-server application can own service accounts.
 * 
 * An application can have up to 10 service accounts at any given time.
 * 
 * Upon a successful response, the operation returns the service account ID and email address.
   * @param body  (required)
   * @return ServiceAccount
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccount> createServiceAccount(CreateServiceAccountPayload body, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into createServiceAccount ");

    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'body' when calling createServiceAccount");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts";

    Map<String, String> localVarQueryParams = new HashMap<String, String>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object>  localVarFormParams = new HashMap<String, Object> ();


            
    localVarHeaderParams.put("Content-Type", "application/json");
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
      this.logger.info("createServiceAccount Request completed successfully with status " + statusCode);
      ServiceAccount serviceAccount = deserialize(entity, new TypeReference<ServiceAccount>() {});
      return new ApiResponse<ServiceAccount>(statusCode, response.getHeaders(), serviceAccount);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("createServiceAccount Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("createServiceAccount Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Delete Service Account
   * Deletes an existing service account. When a service account is deleted, all associated keys will also be deleted.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<Void> deleteServiceAccount(String serviceAccountId, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into deleteServiceAccount ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling deleteServiceAccount");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId));

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
      this.logger.info("deleteServiceAccount Request completed successfully with status " + statusCode);
      return new ApiResponse<Void>(statusCode, response.getHeaders());
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("deleteServiceAccount Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("deleteServiceAccount Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Enable or Disable Service Account
   * Enables or disables a service account.
 * 
 * When a service account is disabled state, it loses its capability to manage its service account key.
 * Assertions signed by the key will be treated as invalid.
 * 
 * This operation allows enabling a service account that is in a deactivated state.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @param enableDisableServiceAccountPayload  (required)
   * @return ServiceAccountDetails
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccountDetails> enableDisableServiceAccount(String serviceAccountId, EnableDisableServiceAccountPayload enableDisableServiceAccountPayload, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into enableDisableServiceAccount ");

    Object localVarPostBody = enableDisableServiceAccountPayload;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling enableDisableServiceAccount");
    }
    
    // verify the required parameter 'enableDisableServiceAccountPayload' is set
    if (enableDisableServiceAccountPayload == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'enableDisableServiceAccountPayload' when calling enableDisableServiceAccount");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}"
      .replaceAll("\\{" + "serviceAccountId" + "\\}", parameterToString(serviceAccountId));

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
      this.logger.info("enableDisableServiceAccount Request completed successfully with status " + statusCode);
      ServiceAccountDetails serviceAccountDetails = deserialize(entity, new TypeReference<ServiceAccountDetails>() {});
      return new ApiResponse<ServiceAccountDetails>(statusCode, response.getHeaders(), serviceAccountDetails);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("enableDisableServiceAccount Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("enableDisableServiceAccount Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Get All Service Accounts
   * Retrieves all service accounts associated with an application.
   * @return ServiceAccounts
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccounts> getAllServiceAccounts(String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into getAllServiceAccounts ");

    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts";

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
      this.logger.info("getAllServiceAccounts Request completed successfully with status " + statusCode);
      ServiceAccounts serviceAccounts = deserialize(entity, new TypeReference<ServiceAccounts>() {});
      return new ApiResponse<ServiceAccounts>(statusCode, response.getHeaders(), serviceAccounts);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("getAllServiceAccounts Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getAllServiceAccounts Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

  /**
   * Get Service Account
   * Retrieves the details for a service account.
   * @param serviceAccountId The Autodesk ID of the service account (required)
   * @return ServiceAccountDetails
   * @throws SecureServiceAccountApiException if fails to make API call
   */
  public ApiResponse<ServiceAccountDetails> getServiceAccount(String serviceAccountId, String accessToken) throws SecureServiceAccountApiException {
    this.logger.info("Entered into getServiceAccount ");

    Object localVarPostBody = null;
    
    // verify the required parameter 'serviceAccountId' is set
    if (serviceAccountId == null) {
      throw new SecureServiceAccountApiException(400, "Missing the required parameter 'serviceAccountId' when calling getServiceAccount");
    }
    
    // create path and map variables
    String localVarPath = "/authentication/v2/service-accounts/{serviceAccountId}"
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
      this.logger.info("getServiceAccount Request completed successfully with status " + statusCode);
      ServiceAccountDetails serviceAccountDetails = deserialize(entity, new TypeReference<ServiceAccountDetails>() {});
      return new ApiResponse<ServiceAccountDetails>(statusCode, response.getHeaders(), serviceAccountDetails);
    } catch (SecureServiceAccountApiException e) {
      this.logger.error("getServiceAccount Request failed with exception: " + e.getMessage());
      throw e;
    } catch (Exception e) {
      this.logger.error("getServiceAccount Request failed with exception: " + e.getMessage());
      throw new SecureServiceAccountApiException(e);
    }
  }

}
