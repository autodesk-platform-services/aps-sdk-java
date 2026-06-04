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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The response for exchange JWT
 */
@Schema(description = "The response for exchange JWT")
@JsonPropertyOrder({
  ExchangeJwtToken.JSON_PROPERTY_ACCESS_TOKEN,
  ExchangeJwtToken.JSON_PROPERTY_TOKEN_TYPE,
  ExchangeJwtToken.JSON_PROPERTY_EXPIRES_IN,
  ExchangeJwtToken.JSON_PROPERTY_EXPIRES_AT
})
@JsonTypeName("exchange-jwt-token")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExchangeJwtToken {
  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  private String accessToken;

  /**
   * type of token
   */
  public enum TokenTypeEnum {
    BEARER("Bearer");

    private String value;

    TokenTypeEnum(String value) {
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
    public static TokenTypeEnum fromValue(String value) {
      for (TokenTypeEnum b : TokenTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TOKEN_TYPE = "token_type";
  private TokenTypeEnum tokenType;

  public static final String JSON_PROPERTY_EXPIRES_IN = "expires_in";
  private Integer expiresIn;

  public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
  private Long expiresAt;


  public ExchangeJwtToken accessToken(String accessToken) {
    
    this.accessToken = accessToken;
    return this;
  }

   /**
   * access token value
   * @return accessToken
  **/
  @javax.annotation.Nullable
  @Schema(description = "access token value")
  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getAccessToken() {
    return accessToken;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public ExchangeJwtToken tokenType(TokenTypeEnum tokenType) {
    
    this.tokenType = tokenType;
    return this;
  }

   /**
   * type of token
   * @return tokenType
  **/
  @javax.annotation.Nullable
  @Schema(description = "type of token")
  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public TokenTypeEnum getTokenType() {
    return tokenType;
  }


  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTokenType(TokenTypeEnum tokenType) {
    this.tokenType = tokenType;
  }


  public ExchangeJwtToken expiresIn(Integer expiresIn) {
    
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * access token expiry time in seconds
   * @return expiresIn
  **/
  @javax.annotation.Nullable
  @Schema(description = "access token expiry time in seconds")
  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Integer getExpiresIn() {
    return expiresIn;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }


  public ExchangeJwtToken expiresAt(Long expiresAt) {

    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * Absolute expiration time of the access token, in epoch milliseconds.
   * Computed client-side as {@code System.currentTimeMillis() + expiresIn * 1000} after a successful token exchange.
   * @return expiresAt
  **/
  @javax.annotation.Nullable
  @Schema(description = "Absolute expiration time of the access token, in epoch milliseconds.")
  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Long getExpiresAt() {
    return expiresAt;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setExpiresAt(Long expiresAt) {
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
    ExchangeJwtToken exchangeJwtToken = (ExchangeJwtToken) o;
    return Objects.equals(this.accessToken, exchangeJwtToken.accessToken) &&
        Objects.equals(this.tokenType, exchangeJwtToken.tokenType) &&
        Objects.equals(this.expiresIn, exchangeJwtToken.expiresIn) &&
        Objects.equals(this.expiresAt, exchangeJwtToken.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, tokenType, expiresIn, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExchangeJwtToken {\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
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

