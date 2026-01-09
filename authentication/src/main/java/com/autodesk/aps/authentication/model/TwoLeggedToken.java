/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Authentication
 * OAuth2 token management APIs.
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

package com.autodesk.aps.authentication.model;

import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the payload returned in response to a client credentials grant
 * request.
 */
@Schema(description = "Represents the payload returned in response to a client credentials grant request.")
@JsonPropertyOrder({
    TwoLeggedToken.JSON_PROPERTY_ACCESS_TOKEN,
    TwoLeggedToken.JSON_PROPERTY_TOKEN_TYPE,
    TwoLeggedToken.JSON_PROPERTY_EXPIRES_IN,
    TwoLeggedToken.JSON_PROPERTY_EXPIRES_AT
})
@JsonTypeName("twoLeggedToken")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TwoLeggedToken {
  public static final String JSON_PROPERTY_ACCESS_TOKEN = "access_token";
  private String accessToken;

  public static final String JSON_PROPERTY_TOKEN_TYPE = "token_type";
  private String tokenType = "default: Bearer";

  public static final String JSON_PROPERTY_EXPIRES_IN = "expires_in";
  private Integer expiresIn;

  public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
  private Long expiresAt;

  public TwoLeggedToken accessToken(String accessToken) {

    this.accessToken = accessToken;
    return this;
  }

  /**
   * The access token.
   * 
   * @return accessToken
   **/
  @Schema(required = true, description = "The access token. ")
  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccessToken() {
    return accessToken;
  }

  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public TwoLeggedToken tokenType(String tokenType) {

    this.tokenType = tokenType;
    return this;
  }

  /**
   * Will always be Bearer.
   * 
   * @return tokenType
   **/
  @javax.annotation.Nullable
  @Schema(description = "Will always be Bearer. ")
  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getTokenType() {
    return tokenType;
  }

  @JsonProperty(JSON_PROPERTY_TOKEN_TYPE)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public TwoLeggedToken expiresIn(Integer expiresIn) {

    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Access token expiration time (in seconds).
   * 
   * @return expiresIn
   **/
  @Schema(required = true, description = "Access token expiration time (in seconds).")
  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getExpiresIn() {
    return expiresIn;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRES_IN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
    // set expiresAt based on expiresIn
    this.expiresAt = Instant.now().getEpochSecond() + expiresIn;
  }

  public TwoLeggedToken expiresAt(Long expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Access token expiration time (in seconds).
   * 
   * @return expiresAt
   **/
  @javax.annotation.Nullable
  @Schema(description = "Access token expiration time (in seconds).")
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
    TwoLeggedToken twoLeggedToken = (TwoLeggedToken) o;
    return Objects.equals(this.accessToken, twoLeggedToken.accessToken) &&
        Objects.equals(this.tokenType, twoLeggedToken.tokenType) &&
        Objects.equals(this.expiresIn, twoLeggedToken.expiresIn) &&
        Objects.equals(this.expiresAt, twoLeggedToken.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, tokenType, expiresIn, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TwoLeggedToken {\n");
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
