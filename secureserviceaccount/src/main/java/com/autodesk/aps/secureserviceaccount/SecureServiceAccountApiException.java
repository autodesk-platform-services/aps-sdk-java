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


public class SecureServiceAccountApiException extends RuntimeException {
    private int statusCode;
    private String responseBody;

    /**
     * Initializes a new instance of the SecureServiceAccountApiException class with a specified cause.
     * @param cause The cause of the exception.
     */
    public SecureServiceAccountApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Initializes a new instance of the SecureServiceAccountApiException class with a specified error message.
     * @param message The error message.
     */
    public SecureServiceAccountApiException(String message) {
        super(message);
    }
    
    /**
     * Initializes a new instance of the SecureServiceAccountApiException class with a specified HTTP status code and error message.
     * @param statusCode The HTTP status code.
     * @param message The error message.
     */
    public SecureServiceAccountApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Initializes a new instance of the SecureServiceAccountApiException class with a specified error message, HTTP status code, and response body.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     */
    public SecureServiceAccountApiException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Initializes a new instance of the SecureServiceAccountApiException class with a specified error message, HTTP status code, response body, and a reference to the inner exception that is the cause of this exception.
     * @param message The error message.
     * @param statusCode The HTTP status code.
     * @param responseBody The HTTP response body.
     * @param cause The exception that is the cause of the current exception.
     */
    public SecureServiceAccountApiException(String message, int statusCode, String responseBody, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    /**
     * Gets the HTTP status code.
     * @return The HTTP status code.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the HTTP response body.
     * @return The HTTP response body.
     */
    public String getResponseBody() {
        return responseBody;
    }
}