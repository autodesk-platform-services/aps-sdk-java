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
import com.autodesk.aps.secureserviceaccount.model.ServiceAccountDetails;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.*;

/**
 * 
 */
@Schema(description = "")
@JsonPropertyOrder({
  ServiceAccounts.JSON_PROPERTY_SERVICE_ACCOUNTS
})
@JsonTypeName("service-accounts")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ServiceAccounts {
  public static final String JSON_PROPERTY_SERVICE_ACCOUNTS = "serviceAccounts";
  private List<ServiceAccountDetails> serviceAccounts = null;


  public ServiceAccounts serviceAccounts(List<ServiceAccountDetails> serviceAccounts) {
    
    this.serviceAccounts = serviceAccounts;
    return this;
  }

  public ServiceAccounts addserviceAccountsItem(ServiceAccountDetails serviceAccountsItem) {
    if (this.serviceAccounts == null) {
      this.serviceAccounts = new ArrayList<>();
    }
    this.serviceAccounts.add(serviceAccountsItem);
    return this;
  }

   /**
   * Contains details of a list of service accounts
   * @return serviceAccounts
  **/
  @javax.annotation.Nullable
  @Schema(description = "Contains details of a list of service accounts")
  @JsonProperty(JSON_PROPERTY_SERVICE_ACCOUNTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public List<ServiceAccountDetails> getServiceAccounts() {
    return serviceAccounts;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_ACCOUNTS)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setServiceAccounts(List<ServiceAccountDetails> serviceAccounts) {
    this.serviceAccounts = serviceAccounts;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceAccounts serviceAccounts = (ServiceAccounts) o;
    return Objects.equals(this.serviceAccounts, serviceAccounts.serviceAccounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceAccounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccounts {\n");
    sb.append("    serviceAccounts: ").append(toIndentedString(serviceAccounts)).append("\n");
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

