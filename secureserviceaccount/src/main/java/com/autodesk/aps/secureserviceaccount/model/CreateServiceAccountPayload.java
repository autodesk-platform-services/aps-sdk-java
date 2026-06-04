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
 * The request body for create service account
 */
@Schema(description = "The request body for create service account")
@JsonPropertyOrder({
  CreateServiceAccountPayload.JSON_PROPERTY_NAME,
  CreateServiceAccountPayload.JSON_PROPERTY_FIRST_NAME,
  CreateServiceAccountPayload.JSON_PROPERTY_LAST_NAME
})
@JsonTypeName("create-service-account-payload")
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateServiceAccountPayload {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  private String lastName;


  public CreateServiceAccountPayload name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the service account. This name must be between 5 and 100 characters, and can contain alphanumeric characters and dashes, and include at least one alphanumeric character.
   * @return name
  **/
  @Schema(required = true, description = "The name of the service account. This name must be between 5 and 100 characters, and can contain alphanumeric characters and dashes, and include at least one alphanumeric character.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public CreateServiceAccountPayload firstName(String firstName) {
    
    this.firstName = firstName;
    return this;
  }

   /**
   * The first name of the service account. For display purposes only. Must meet the following conditions: Length between 5 and 100 characters, contain only alphanumeric characters, dashes, and underscores, include at least one alphanumeric character, avoid inappropriate words, exclude invalid characters such as % and /, and avoid the character pattern &amp;#. For more information, see Naming Guidelines.
   * @return firstName
  **/
  @Schema(required = true, description = "The first name of the service account. For display purposes only. Must meet the following conditions: Length between 5 and 100 characters, contain only alphanumeric characters, dashes, and underscores, include at least one alphanumeric character, avoid inappropriate words, exclude invalid characters such as % and /, and avoid the character pattern &#. For more information, see Naming Guidelines.")
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFirstName() {
    return firstName;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public CreateServiceAccountPayload lastName(String lastName) {
    
    this.lastName = lastName;
    return this;
  }

   /**
   * The last name of the service account. For display purposes only. Must meet the following conditions: Length between 5 and 100 characters, contain only alphanumeric characters and dashes, include at least one alphanumeric character, avoid inappropriate words, exclude invalid characters such as % and /, and avoid the character pattern &amp;#. For more information, see Naming Guidelines.
   * @return lastName
  **/
  @Schema(required = true, description = "The last name of the service account. For display purposes only. Must meet the following conditions: Length between 5 and 100 characters, contain only alphanumeric characters and dashes, include at least one alphanumeric character, avoid inappropriate words, exclude invalid characters such as % and /, and avoid the character pattern &#. For more information, see Naming Guidelines.")
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastName() {
    return lastName;
  }


  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateServiceAccountPayload createServiceAccountPayload = (CreateServiceAccountPayload) o;
    return Objects.equals(this.name, createServiceAccountPayload.name) &&
        Objects.equals(this.firstName, createServiceAccountPayload.firstName) &&
        Objects.equals(this.lastName, createServiceAccountPayload.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, firstName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceAccountPayload {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

