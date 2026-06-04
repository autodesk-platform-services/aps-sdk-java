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
 * Contains details of a service account
 */
@Schema(description = "Contains details of a service account")
@JsonPropertyOrder({
  ServiceAccountDetails.JSON_PROPERTY_SERVICE_ACCOUNT_ID,
  ServiceAccountDetails.JSON_PROPERTY_EMAIL,
  ServiceAccountDetails.JSON_PROPERTY_CREATED_BY,
  ServiceAccountDetails.JSON_PROPERTY_STATUS,
  ServiceAccountDetails.JSON_PROPERTY_CREATED_AT,
  ServiceAccountDetails.JSON_PROPERTY_ACCESSED_AT,
  ServiceAccountDetails.JSON_PROPERTY_EXPIRES_AT
})
@JsonTypeName("service-account-details")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceAccountDetails {
  public static final String JSON_PROPERTY_SERVICE_ACCOUNT_ID = "serviceAccountId";
  private String serviceAccountId;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  /**
   * The status of the service account
   */
  public enum StatusEnum {
    ENABLED("ENABLED"),
    
    DISABLED("DISABLED"),
    
    DEACTIVATED("DEACTIVATED");

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

  public static final String JSON_PROPERTY_EXPIRES_AT = "expiresAt";
  private String expiresAt;


  public ServiceAccountDetails serviceAccountId(String serviceAccountId) {
    
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


  public ServiceAccountDetails email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * The email address of the service account
   * @return email
  **/
  @javax.annotation.Nullable
  @Schema(description = "The email address of the service account")
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


  public ServiceAccountDetails createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * The client ID used to create the service account
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @Schema(description = "The client ID used to create the service account")
  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getCreatedBy() {
    return createdBy;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public ServiceAccountDetails status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the service account
   * @return status
  **/
  @javax.annotation.Nullable
  @Schema(description = "The status of the service account")
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


  public ServiceAccountDetails createdAt(String createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The creation time of the service account
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "The creation time of the service account")
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


  public ServiceAccountDetails accessedAt(String accessedAt) {
    
    this.accessedAt = accessedAt;
    return this;
  }

   /**
   * This is the most recent time an access token was generated for this service account
   * @return accessedAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "This is the most recent time an access token was generated for this service account")
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


  public ServiceAccountDetails expiresAt(String expiresAt) {
    
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * The expiration time of the service account
   * @return expiresAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "The expiration time of the service account")
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getExpiresAt() {
    return expiresAt;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceAccountDetails serviceAccountDetails = (ServiceAccountDetails) o;
    return Objects.equals(this.serviceAccountId, serviceAccountDetails.serviceAccountId) &&
        Objects.equals(this.email, serviceAccountDetails.email) &&
        Objects.equals(this.createdBy, serviceAccountDetails.createdBy) &&
        Objects.equals(this.status, serviceAccountDetails.status) &&
        Objects.equals(this.createdAt, serviceAccountDetails.createdAt) &&
        Objects.equals(this.accessedAt, serviceAccountDetails.accessedAt) &&
        Objects.equals(this.expiresAt, serviceAccountDetails.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceAccountId, email, createdBy, status, createdAt, accessedAt, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccountDetails {\n");
    sb.append("    serviceAccountId: ").append(toIndentedString(serviceAccountId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    accessedAt: ").append(toIndentedString(accessedAt)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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

