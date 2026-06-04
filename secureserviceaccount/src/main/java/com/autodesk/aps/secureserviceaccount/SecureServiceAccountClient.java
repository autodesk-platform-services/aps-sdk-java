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
package com.autodesk.aps.secureserviceaccount;

import com.autodesk.aps.sdkmanager.BaseClient;
import com.autodesk.aps.sdkmanager.IAuthenticationProvider;
import com.autodesk.aps.sdkmanager.SdkManager;
import com.autodesk.aps.sdkmanager.SdkManagerBuilder;
import com.autodesk.aps.secureserviceaccount.api.AccountManagementApi;
import com.autodesk.aps.secureserviceaccount.api.ExchangeTokenApi;
import com.autodesk.aps.secureserviceaccount.api.KeyManagementApi;
import com.autodesk.aps.secureserviceaccount.model.CreateServiceAccountKeyOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.CreateServiceAccountOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.CreateServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.DeleteServiceAccountKeyOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.DeleteServiceAccountOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountKeyOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountKeyPayload;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.EnableDisableServiceAccountPayload;
import com.autodesk.aps.secureserviceaccount.model.ExchangeJwtAssertionOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.ExchangeJwtToken;
import com.autodesk.aps.secureserviceaccount.model.GetAllServiceAccountKeysOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.GetAllServiceAccountsOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.GetServiceAccountOptionalParams;
import com.autodesk.aps.secureserviceaccount.model.GrantType;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccount;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountDetails;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountKeys;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountPrivateKey;
import com.autodesk.aps.secureserviceaccount.model.ServiceAccounts;


public class SecureServiceAccountClient extends BaseClient {
    private final ExchangeTokenApi exchangeTokenApi;
    private final KeyManagementApi keyManagementApi;
    private final AccountManagementApi accountManagementApi;

    /**
     * Initializes a new instance of the SecureServiceAccountClient class.
     * 
     * @param sdkManager             The SDK manager instance.
     * @param authenticationProvider The authentication provider.
     */
    public SecureServiceAccountClient(SdkManager sdkManager, IAuthenticationProvider authenticationProvider) {
        super(authenticationProvider);
        if (sdkManager == null) {
            sdkManager = SdkManagerBuilder.create().build();
        }
        this.exchangeTokenApi = new ExchangeTokenApi(sdkManager);
        this.keyManagementApi = new KeyManagementApi(sdkManager);
        this.accountManagementApi = new AccountManagementApi(sdkManager);

    }
    /**
     * Initializes a new instance of the SecureServiceAccountClient class with a default
     * SDK manager.
     * 
     * @param authenticationProvider The authentication provider.
     */
    public SecureServiceAccountClient(IAuthenticationProvider authenticationProvider) {
      this(SdkManagerBuilder.create().build(), authenticationProvider);
    }

    /**
     * Initializes a new instance of the SecureServiceAccountClient class without an
     * authentication provider.
     * 
     * @param sdkManager
     */

    public SecureServiceAccountClient(SdkManager sdkManager) {
      this(sdkManager, null);
    }

    /**
     * Initializes a new instance of the SecureServiceAccountClient class with a default
     * SDK manager and without an authentication provider.
     */
    public SecureServiceAccountClient() {
      this(SdkManagerBuilder.create().build(), null);
    }

    /**
     * Closes the underlying connection.
     */
    public void close() {
        this.accountManagementApi.close();
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
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccount createServiceAccount(CreateServiceAccountPayload body) throws SecureServiceAccountApiException {
  return createServiceAccount(body, null);
}


/**
 * Create Service Account
 * Creates a service account. Only a server-to-server application can own service accounts.
 * 
 * An application can have up to 10 service accounts at any given time.
 * 
 * Upon a successful response, the operation returns the service account ID and email address.
 * @param body  (required)
 * @param createServiceAccountOptionaParams class containing all optional parameters for the createServiceAccount method.
 * @return ServiceAccount
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccount createServiceAccount(CreateServiceAccountPayload body, CreateServiceAccountOptionalParams createServiceAccountOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (createServiceAccountOptionalParams == null) {
            createServiceAccountOptionalParams = new CreateServiceAccountOptionalParams.Builder().build();
        }
        if (createServiceAccountOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (createServiceAccountOptionalParams.getAccessToken() == null) {
                createServiceAccountOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return accountManagementApi.createServiceAccount(body, createServiceAccountOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
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
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccountPrivateKey createServiceAccountKey(String serviceAccountId) throws SecureServiceAccountApiException {
  return createServiceAccountKey(serviceAccountId, null);
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
 * @param createServiceAccountKeyOptionaParams class containing all optional parameters for the createServiceAccountKey method.
 * @return ServiceAccountPrivateKey
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccountPrivateKey createServiceAccountKey(String serviceAccountId, CreateServiceAccountKeyOptionalParams createServiceAccountKeyOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (createServiceAccountKeyOptionalParams == null) {
            createServiceAccountKeyOptionalParams = new CreateServiceAccountKeyOptionalParams.Builder().build();
        }
        if (createServiceAccountKeyOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (createServiceAccountKeyOptionalParams.getAccessToken() == null) {
                createServiceAccountKeyOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return keyManagementApi.createServiceAccountKey(serviceAccountId, createServiceAccountKeyOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Delete Service Account
 * Deletes an existing service account. When a service account is deleted, all associated keys will also be deleted.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public void deleteServiceAccount(String serviceAccountId) throws SecureServiceAccountApiException {
  deleteServiceAccount(serviceAccountId, null);
}


/**
 * Delete Service Account
 * Deletes an existing service account. When a service account is deleted, all associated keys will also be deleted.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param deleteServiceAccountOptionaParams class containing all optional parameters for the deleteServiceAccount method.
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public void deleteServiceAccount(String serviceAccountId, DeleteServiceAccountOptionalParams deleteServiceAccountOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (deleteServiceAccountOptionalParams == null) {
            deleteServiceAccountOptionalParams = new DeleteServiceAccountOptionalParams.Builder().build();
        }
        if (deleteServiceAccountOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (deleteServiceAccountOptionalParams.getAccessToken() == null) {
                deleteServiceAccountOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        accountManagementApi.deleteServiceAccount(serviceAccountId, deleteServiceAccountOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Delete key
 * Deletes an existing key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param keyId The ID of the private key (required)
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public void deleteServiceAccountKey(String serviceAccountId, String keyId) throws SecureServiceAccountApiException {
  deleteServiceAccountKey(serviceAccountId, keyId, null);
}


/**
 * Delete key
 * Deletes an existing key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param keyId The ID of the private key (required)
 * @param deleteServiceAccountKeyOptionaParams class containing all optional parameters for the deleteServiceAccountKey method.
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public void deleteServiceAccountKey(String serviceAccountId, String keyId, DeleteServiceAccountKeyOptionalParams deleteServiceAccountKeyOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (deleteServiceAccountKeyOptionalParams == null) {
            deleteServiceAccountKeyOptionalParams = new DeleteServiceAccountKeyOptionalParams.Builder().build();
        }
        if (deleteServiceAccountKeyOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (deleteServiceAccountKeyOptionalParams.getAccessToken() == null) {
                deleteServiceAccountKeyOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        keyManagementApi.deleteServiceAccountKey(serviceAccountId, keyId, deleteServiceAccountKeyOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
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
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccountDetails enableDisableServiceAccount(String serviceAccountId, EnableDisableServiceAccountPayload enableDisableServiceAccountPayload) throws SecureServiceAccountApiException {
  return enableDisableServiceAccount(serviceAccountId, enableDisableServiceAccountPayload, null);
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
 * @param enableDisableServiceAccountOptionaParams class containing all optional parameters for the enableDisableServiceAccount method.
 * @return ServiceAccountDetails
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccountDetails enableDisableServiceAccount(String serviceAccountId, EnableDisableServiceAccountPayload enableDisableServiceAccountPayload, EnableDisableServiceAccountOptionalParams enableDisableServiceAccountOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (enableDisableServiceAccountOptionalParams == null) {
            enableDisableServiceAccountOptionalParams = new EnableDisableServiceAccountOptionalParams.Builder().build();
        }
        if (enableDisableServiceAccountOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (enableDisableServiceAccountOptionalParams.getAccessToken() == null) {
                enableDisableServiceAccountOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return accountManagementApi.enableDisableServiceAccount(serviceAccountId, enableDisableServiceAccountPayload, enableDisableServiceAccountOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Enable or Disable Key
 * Enables or disables a service account key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param keyId The ID of the private key (required)
 * @param enableDisableServiceAccountKeyPayload  (required)
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public void enableDisableServiceAccountKey(String serviceAccountId, String keyId, EnableDisableServiceAccountKeyPayload enableDisableServiceAccountKeyPayload) throws SecureServiceAccountApiException {
  enableDisableServiceAccountKey(serviceAccountId, keyId, enableDisableServiceAccountKeyPayload, null);
}


/**
 * Enable or Disable Key
 * Enables or disables a service account key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param keyId The ID of the private key (required)
 * @param enableDisableServiceAccountKeyPayload  (required)
 * @param enableDisableServiceAccountKeyOptionaParams class containing all optional parameters for the enableDisableServiceAccountKey method.
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public void enableDisableServiceAccountKey(String serviceAccountId, String keyId, EnableDisableServiceAccountKeyPayload enableDisableServiceAccountKeyPayload, EnableDisableServiceAccountKeyOptionalParams enableDisableServiceAccountKeyOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (enableDisableServiceAccountKeyOptionalParams == null) {
            enableDisableServiceAccountKeyOptionalParams = new EnableDisableServiceAccountKeyOptionalParams.Builder().build();
        }
        if (enableDisableServiceAccountKeyOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (enableDisableServiceAccountKeyOptionalParams.getAccessToken() == null) {
                enableDisableServiceAccountKeyOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        keyManagementApi.enableDisableServiceAccountKey(serviceAccountId, keyId, enableDisableServiceAccountKeyPayload, enableDisableServiceAccountKeyOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Exchanging JWT assertion for token
 * Returns a three-legged access token for the JWT assertion you provide in the request body. See the Developer&#39;s Guide topic JWT Assertions for information on how to generate a JWT assertion for this operation.
 * 
 * This operation is only for confidential clients. It requires Basic Authorization (client_id, client_secret). Authentication information (client_id, client_secret) can be included either in the header or the body, but not both simultaneously.
 * @param grantType  (required)
 * @param assertion The value of the JWT assertion. (required)
 * @return ExchangeJwtToken
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ExchangeJwtToken exchangeJwtAssertion(GrantType grantType, String assertion) throws SecureServiceAccountApiException {
  return exchangeJwtAssertion(grantType, assertion, null);
}


/**
 * Exchanging JWT assertion for token
 * Returns a three-legged access token for the JWT assertion you provide in the request body. See the Developer&#39;s Guide topic JWT Assertions for information on how to generate a JWT assertion for this operation.
 * 
 * This operation is only for confidential clients. It requires Basic Authorization (client_id, client_secret). Authentication information (client_id, client_secret) can be included either in the header or the body, but not both simultaneously.
 * @param grantType  (required)
 * @param assertion The value of the JWT assertion. (required)
 * @param exchangeJwtAssertionOptionaParams class containing all optional parameters for the exchangeJwtAssertion method.
 * @return ExchangeJwtToken
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ExchangeJwtToken exchangeJwtAssertion(GrantType grantType, String assertion, ExchangeJwtAssertionOptionalParams exchangeJwtAssertionOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (exchangeJwtAssertionOptionalParams == null) {
            exchangeJwtAssertionOptionalParams = new ExchangeJwtAssertionOptionalParams.Builder().build();
        }
        return exchangeTokenApi.exchangeJwtAssertion(grantType, assertion, exchangeJwtAssertionOptionalParams.getAuthorization(), exchangeJwtAssertionOptionalParams.getClientId(), exchangeJwtAssertionOptionalParams.getClientSecret(), exchangeJwtAssertionOptionalParams.getScope()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Get All Keys
 * Lists all keys associated with the service account. This operation will only return key metadata, not the private or public key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @return ServiceAccountKeys
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccountKeys getAllServiceAccountKeys(String serviceAccountId) throws SecureServiceAccountApiException {
  return getAllServiceAccountKeys(serviceAccountId, null);
}


/**
 * Get All Keys
 * Lists all keys associated with the service account. This operation will only return key metadata, not the private or public key.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param getAllServiceAccountKeysOptionaParams class containing all optional parameters for the getAllServiceAccountKeys method.
 * @return ServiceAccountKeys
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccountKeys getAllServiceAccountKeys(String serviceAccountId, GetAllServiceAccountKeysOptionalParams getAllServiceAccountKeysOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (getAllServiceAccountKeysOptionalParams == null) {
            getAllServiceAccountKeysOptionalParams = new GetAllServiceAccountKeysOptionalParams.Builder().build();
        }
        if (getAllServiceAccountKeysOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (getAllServiceAccountKeysOptionalParams.getAccessToken() == null) {
                getAllServiceAccountKeysOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return keyManagementApi.getAllServiceAccountKeys(serviceAccountId, getAllServiceAccountKeysOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Get All Service Accounts
 * Retrieves all service accounts associated with an application.
 * @return ServiceAccounts
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccounts getAllServiceAccounts() throws SecureServiceAccountApiException {
  return getAllServiceAccounts(null);
}


/**
 * Get All Service Accounts
 * Retrieves all service accounts associated with an application.
 * @param getAllServiceAccountsOptionaParams class containing all optional parameters for the getAllServiceAccounts method.
 * @return ServiceAccounts
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccounts getAllServiceAccounts(GetAllServiceAccountsOptionalParams getAllServiceAccountsOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (getAllServiceAccountsOptionalParams == null) {
            getAllServiceAccountsOptionalParams = new GetAllServiceAccountsOptionalParams.Builder().build();
        }
        if (getAllServiceAccountsOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (getAllServiceAccountsOptionalParams.getAccessToken() == null) {
                getAllServiceAccountsOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return accountManagementApi.getAllServiceAccounts(getAllServiceAccountsOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }

/**
 * Get Service Account
 * Retrieves the details for a service account.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @return ServiceAccountDetails
 * @throws SecureServiceAccountApiException when an API call fails.
 */

public ServiceAccountDetails getServiceAccount(String serviceAccountId) throws SecureServiceAccountApiException {
  return getServiceAccount(serviceAccountId, null);
}


/**
 * Get Service Account
 * Retrieves the details for a service account.
 * @param serviceAccountId The Autodesk ID of the service account (required)
 * @param getServiceAccountOptionaParams class containing all optional parameters for the getServiceAccount method.
 * @return ServiceAccountDetails
 * @throws SecureServiceAccountApiException when an API call fails.
 */


public ServiceAccountDetails getServiceAccount(String serviceAccountId, GetServiceAccountOptionalParams getServiceAccountOptionalParams) throws SecureServiceAccountApiException {
  try  {
        if (getServiceAccountOptionalParams == null) {
            getServiceAccountOptionalParams = new GetServiceAccountOptionalParams.Builder().build();
        }
        if (getServiceAccountOptionalParams.getAccessToken() == null && this.getAuthenticationProvider() == null) {
                throw new SecureServiceAccountApiException("Please provide a valid access token!");
        } else if (getServiceAccountOptionalParams.getAccessToken() == null) {
                getServiceAccountOptionalParams.setAccessToken(this.getAuthenticationProvider().getAccessToken());
        }
        return accountManagementApi.getServiceAccount(serviceAccountId, getServiceAccountOptionalParams.getAccessToken()).getData();
        } catch (SecureServiceAccountApiException  e) {
            throw e;
        } catch (Exception e) {
            throw new SecureServiceAccountApiException (e);
        }
    }


}