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
import com.autodesk.aps.secureserviceaccount.model.Status;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * The request body for enable or disable service account key
 */
@Schema(description = "The request body for enable or disable service account key")
@JsonPropertyOrder({
  EnableDisableServiceAccountKeyPayload.JSON_PROPERTY_STATUS
})
@JsonTypeName("enable-disable-service-account-key-payload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class EnableDisableServiceAccountKeyPayload {
  public static final String JSON_PROPERTY_STATUS = "status";
  private Status status;


  public EnableDisableServiceAccountKeyPayload status(Status status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Status getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnableDisableServiceAccountKeyPayload enableDisableServiceAccountKeyPayload = (EnableDisableServiceAccountKeyPayload) o;
    return Objects.equals(this.status, enableDisableServiceAccountKeyPayload.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnableDisableServiceAccountKeyPayload {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

