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

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets scope
 */
public enum Scope {
  
  USER_READ("user:read"),
  
  USER_WRITE("user:write"),
  
  USER_PROFILE_READ("user-profile:read"),
  
  VIEWABLES_READ("viewables:read"),
  
  DATA_READ("data:read"),
  
  DATA_READ_URN_OF_RESOURCE_("data:read:<URN_OF_RESOURCE>"),
  
  DATA_WRITE("data:write"),
  
  DATA_CREATE("data:create"),
  
  DATA_SEARCH("data:search"),
  
  BUCKET_CREATE("bucket:create"),
  
  BUCKET_READ("bucket:read"),
  
  BUCKET_UPDATE("bucket:update"),
  
  BUCKET_DELETE("bucket:delete"),
  
  CODE_ALL("code:all"),
  
  ACCOUNT_READ("account:read"),
  
  ACCOUNT_WRITE("account:write"),
  
  OPENID("openid"),
  
  APPLICATION_SERVICE_ACCOUNT_WRITE("application:service_account:write"),
  
  APPLICATION_SERVICE_ACCOUNT_READ("application:service_account:read"),
  
  APPLICATION_SERVICE_ACCOUNT_KEY_WRITE("application:service_account_key:write"),
  
  APPLICATION_SERVICE_ACCOUNT_KEY_READ("application:service_account_key:read");

  private String value;

  Scope(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Scope fromValue(String value) {
    for (Scope b : Scope.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

