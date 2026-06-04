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
package com.autodesk.aps.secureserviceaccount.model;

import java.util.List;

/**
  * Represents optional parameters for the `exchangeJwtAssertion` method.
  * This class uses the Builder pattern to allow flexible construction of objects.
  */
public class ExchangeJwtAssertionOptionalParams{
    private String authorization;
    private String clientId;
    private String clientSecret;
    private List<Scope> scope;

    private ExchangeJwtAssertionOptionalParams(Builder builder){
        this.authorization = builder.authorization;
this.clientId = builder.clientId;
this.clientSecret = builder.clientSecret;
this.scope = builder.scope;
    }


    /**
     * Builder class for constructing instances of ExchangeJwtAssertionOptionalParams.
     */
    public static class Builder {
         private String authorization;
 private String clientId;
 private String clientSecret;
 private List<Scope> scope;
        /**
         * @param authorization Must be Basic &lt;credentials&gt;, where &lt;credentials&gt; is a base64 encoded string of client_id:client_secret. This parameter is required only if client_id and client_secret are not provided in the request body.
         *
         * @return The Builder instance for chaining.
         */
        public Builder authorization(String authorization){
            this.authorization = authorization;
            return this;
        }
        /**
         * @param clientId This attribute is optional; it serves as an additional option where the client can either use the authorization header or opt to send this information in the body.
         *
         * @return The Builder instance for chaining.
         */
        public Builder clientId(String clientId){
            this.clientId = clientId;
            return this;
        }
        /**
         * @param clientSecret This attribute is optional; it serves as an additional option where the client can either use the authorization header or opt to send this information in the body.
         *
         * @return The Builder instance for chaining.
         */
        public Builder clientSecret(String clientSecret){
            this.clientSecret = clientSecret;
            return this;
        }
        /**
         * @param scope This is a space-delimited list of scopes. The scope in the token endpoint request body should be a subset of or the same as the scope specified in the assertion. If the scope is not present, then the returned access token will have the same scope as the assertion.
         *
         * @return The Builder instance for chaining.
         */
        public Builder scope(List<Scope> scope){
            this.scope = scope;
            return this;
        }
        /**
         * Builds and returns an instance of ExchangeJwtAssertionOptionalParams.
         *
         * @return ExchangeJwtAssertionOptionalParams object.
         */
        public ExchangeJwtAssertionOptionalParams build() {
            return new ExchangeJwtAssertionOptionalParams(this);
        }
    }

    // Getters for each field
    /**
     * Gets the authorization value.
     *
     * @return String
     */
    public String getAuthorization(){
        return authorization;
    }
    /**
     * Gets the clientId value.
     *
     * @return String
     */
    public String getClientId(){
        return clientId;
    }
    /**
     * Gets the clientSecret value.
     *
     * @return String
     */
    public String getClientSecret(){
        return clientSecret;
    }
    /**
     * Gets the scope value.
     *
     * @return List&lt;Scope&gt;
     */
    public List<Scope> getScope(){
        return scope;
    }
}
