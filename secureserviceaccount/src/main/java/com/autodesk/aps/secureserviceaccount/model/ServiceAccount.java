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

package com.autodesk.aps.secureserviceaccount.model;

import java.util.Objects;
import java.util.Arrays;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * Contains the details of a newly created service account
 */
@Schema(description = "Contains the details of a newly created service account")
@JsonPropertyOrder({
  ServiceAccount.JSON_PROPERTY_SERVICE_ACCOUNT_ID,
  ServiceAccount.JSON_PROPERTY_EMAIL
})
@JsonTypeName("service-account")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceAccount {
  public static final String JSON_PROPERTY_SERVICE_ACCOUNT_ID = "serviceAccountId";
  private String serviceAccountId;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;


  public ServiceAccount serviceAccountId(String serviceAccountId) {
    
    this.serviceAccountId = serviceAccountId;
    return this;
  }

   /**
   * The Autodesk ID of the service account
   * @return serviceAccountId
  **/
  @javax.annotation.Nullable
  @Schema(description = "The Autodesk ID of the service account")
  @JsonProperty(JSON_PROPERTY_SERVICE_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getServiceAccountId() {
    return serviceAccountId;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setServiceAccountId(String serviceAccountId) {
    this.serviceAccountId = serviceAccountId;
  }


  public ServiceAccount email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email address of the service account. It is of the form &lt;serviceAccountName&gt;@&lt;clientID&gt;.adskserviceaccount.autodesk.com.
   * @return email
  **/
  @javax.annotation.Nullable
  @Schema(description = "The email address of the service account. It is of the form <serviceAccountName>@<clientID>.adskserviceaccount.autodesk.com.")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceAccount serviceAccount = (ServiceAccount) o;
    return Objects.equals(this.serviceAccountId, serviceAccount.serviceAccountId) &&
        Objects.equals(this.email, serviceAccount.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceAccountId, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccount {\n");
    sb.append("    serviceAccountId: ").append(toIndentedString(serviceAccountId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

