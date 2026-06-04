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
 * Describes a private key
 */
@Schema(description = "Describes a private key")
@JsonPropertyOrder({
  ServiceAccountPrivateKey.JSON_PROPERTY_KID,
  ServiceAccountPrivateKey.JSON_PROPERTY_PRIVATE_KEY
})
@JsonTypeName("service-account-private-key")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceAccountPrivateKey {
  public static final String JSON_PROPERTY_KID = "kid";
  private String kid;

  public static final String JSON_PROPERTY_PRIVATE_KEY = "privateKey";
  private String privateKey;


  public ServiceAccountPrivateKey kid(String kid) {
    
    this.kid = kid;
    return this;
  }

   /**
   * The ID of the private key.
   * @return kid
  **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the private key.")
  @JsonProperty(JSON_PROPERTY_KID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getKid() {
    return kid;
  }


  @JsonProperty(JSON_PROPERTY_KID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setKid(String kid) {
    this.kid = kid;
  }


  public ServiceAccountPrivateKey privateKey(String privateKey) {
    
    this.privateKey = privateKey;
    return this;
  }

   /**
   * The private key value, in PEM format.
   * @return privateKey
  **/
  @javax.annotation.Nullable
  @Schema(description = "The private key value, in PEM format.")
  @JsonProperty(JSON_PROPERTY_PRIVATE_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getPrivateKey() {
    return privateKey;
  }


  @JsonProperty(JSON_PROPERTY_PRIVATE_KEY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceAccountPrivateKey serviceAccountPrivateKey = (ServiceAccountPrivateKey) o;
    return Objects.equals(this.kid, serviceAccountPrivateKey.kid) &&
        Objects.equals(this.privateKey, serviceAccountPrivateKey.privateKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kid, privateKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccountPrivateKey {\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
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

