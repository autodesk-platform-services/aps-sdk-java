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
 * 
 */
@Schema(description = "")
@JsonPropertyOrder({
  ServiceAccountKeyDetails.JSON_PROPERTY_KID,
  ServiceAccountKeyDetails.JSON_PROPERTY_STATUS,
  ServiceAccountKeyDetails.JSON_PROPERTY_CREATED_AT,
  ServiceAccountKeyDetails.JSON_PROPERTY_ACCESSED_AT
})
@JsonTypeName("service-account-key-details")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceAccountKeyDetails {
  public static final String JSON_PROPERTY_KID = "kid";
  private String kid;

  /**
   * The status of the key
   */
  public enum StatusEnum {
    ENABLED("ENABLED"),
    
    DISABLED("DISABLED");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
  private String createdAt;

  public static final String JSON_PROPERTY_ACCESSED_AT = "accessedAt";
  private String accessedAt;


  public ServiceAccountKeyDetails kid(String kid) {
    
    this.kid = kid;
    return this;
  }

   /**
   * The ID of the private key
   * @return kid
  **/
  @javax.annotation.Nullable
  @Schema(description = "The ID of the private key")
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


  public ServiceAccountKeyDetails status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the key
   * @return status
  **/
  @javax.annotation.Nullable
  @Schema(description = "The status of the key")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public StatusEnum getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public ServiceAccountKeyDetails createdAt(String createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The creation time of the key, in UTC format
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "The creation time of the key, in UTC format")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatedAt() {
    return createdAt;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }


  public ServiceAccountKeyDetails accessedAt(String accessedAt) {
    
    this.accessedAt = accessedAt;
    return this;
  }

   /**
   * This is the most recent time an access token was generated for this service account key, in UTC format
   * @return accessedAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "This is the most recent time an access token was generated for this service account key, in UTC format")
  @JsonProperty(JSON_PROPERTY_ACCESSED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getAccessedAt() {
    return accessedAt;
  }


  @JsonProperty(JSON_PROPERTY_ACCESSED_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAccessedAt(String accessedAt) {
    this.accessedAt = accessedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceAccountKeyDetails serviceAccountKeyDetails = (ServiceAccountKeyDetails) o;
    return Objects.equals(this.kid, serviceAccountKeyDetails.kid) &&
        Objects.equals(this.status, serviceAccountKeyDetails.status) &&
        Objects.equals(this.createdAt, serviceAccountKeyDetails.createdAt) &&
        Objects.equals(this.accessedAt, serviceAccountKeyDetails.accessedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kid, status, createdAt, accessedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccountKeyDetails {\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    accessedAt: ").append(toIndentedString(accessedAt)).append("\n");
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

