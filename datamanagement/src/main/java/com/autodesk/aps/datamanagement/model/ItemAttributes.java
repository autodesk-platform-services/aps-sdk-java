/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Data Management
 * The Data Management API provides a unified and consistent way to access data across BIM 360 Team, Fusion Team (formerly known as A360 Team), BIM 360 Docs, A360 Personal, and the Object Storage Service.  With this API, you can accomplish a number of workflows, including accessing a Fusion model in Fusion Team and getting an ordered structure of items, IDs, and properties for generating a bill of materials in a 3rd-party process. Or, you might want to superimpose a Fusion model and a building model to use in the Viewer.
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

package com.autodesk.aps.datamanagement.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Properties of an item.
 */
@Schema(description = "Properties of an item.")
@JsonPropertyOrder({
    ItemAttributes.JSON_PROPERTY_DISPLAY_NAME,
    ItemAttributes.JSON_PROPERTY_CREATE_TIME,
    ItemAttributes.JSON_PROPERTY_CREATE_USER_ID,
    ItemAttributes.JSON_PROPERTY_CREATE_USER_NAME,
    ItemAttributes.JSON_PROPERTY_LAST_MODIFIED_TIME,
    ItemAttributes.JSON_PROPERTY_LAST_MODIFIED_USER_ID,
    ItemAttributes.JSON_PROPERTY_LAST_MODIFIED_USER_NAME,
    ItemAttributes.JSON_PROPERTY_HIDDEN,
    ItemAttributes.JSON_PROPERTY_RESERVED,
    ItemAttributes.JSON_PROPERTY_RESERVED_TIME,
    ItemAttributes.JSON_PROPERTY_RESERVED_USER_ID,
    ItemAttributes.JSON_PROPERTY_RESERVED_USER_NAME,
    ItemAttributes.JSON_PROPERTY_EXTENSION,
    ItemAttributes.JSON_PROPERTY_PATH_IN_PROJECT
})
@JsonTypeName("ItemAttributes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemAttributes {
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private OffsetDateTime createTime;

  public static final String JSON_PROPERTY_CREATE_USER_ID = "createUserId";
  private String createUserId;

  public static final String JSON_PROPERTY_CREATE_USER_NAME = "createUserName";
  private String createUserName;

  public static final String JSON_PROPERTY_LAST_MODIFIED_TIME = "lastModifiedTime";
  private OffsetDateTime lastModifiedTime;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER_ID = "lastModifiedUserId";
  private String lastModifiedUserId;

  public static final String JSON_PROPERTY_LAST_MODIFIED_USER_NAME = "lastModifiedUserName";
  private String lastModifiedUserName;

  public static final String JSON_PROPERTY_HIDDEN = "hidden";
  private Boolean hidden;

  public static final String JSON_PROPERTY_RESERVED = "reserved";
  private Boolean reserved;

  public static final String JSON_PROPERTY_RESERVED_TIME = "reservedTime";
  private OffsetDateTime reservedTime;

  public static final String JSON_PROPERTY_RESERVED_USER_ID = "reservedUserId";
  private String reservedUserId;

  public static final String JSON_PROPERTY_RESERVED_USER_NAME = "reservedUserName";
  private String reservedUserName;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private ItemExtensionWithSchemaLink extension;

  public static final String JSON_PROPERTY_PATH_IN_PROJECT = "pathInProject";
  private String pathInProject;

  public ItemAttributes displayName(String displayName) {

    this.displayName = displayName;
    return this;
  }

  /**
   * A human friendly name to identify the item.
   * Note that for BIM 360 projects, this attribute is reserved for future
   * releases and should not be used. Use a version&#39;s
   * &#x60;&#x60;attributes.name&#x60;&#x60; for the file name.
   * 
   * @return displayName
   **/
  @Schema(required = true, description = "A human friendly name to identify the item.  Note that for BIM 360 projects, this attribute is reserved for future releases and should not be used. Use a version's ``attributes.name`` for the file name.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ItemAttributes createTime(OffsetDateTime createTime) {

    this.createTime = createTime;
    return this;
  }

  /**
   * The time that the resource was created at.
   * 
   * @return createTime
   **/
  @Schema(required = true, description = "The time that the resource was created at.")
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreateTime() {
    return createTime;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateTime(OffsetDateTime createTime) {
    this.createTime = createTime;
  }

  public ItemAttributes createUserId(String createUserId) {

    this.createUserId = createUserId;
    return this;
  }

  /**
   * The ID of the user that created the version.
   * 
   * @return createUserId
   **/
  @Schema(required = true, description = "The ID of the user that created the version.")
  @JsonProperty(JSON_PROPERTY_CREATE_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreateUserId() {
    return createUserId;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  public ItemAttributes createUserName(String createUserName) {

    this.createUserName = createUserName;
    return this;
  }

  /**
   * The user name of the user that created the version.
   * 
   * @return createUserName
   **/
  @Schema(required = true, description = "The user name of the user that created the version.")
  @JsonProperty(JSON_PROPERTY_CREATE_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreateUserName() {
    return createUserName;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public ItemAttributes lastModifiedTime(OffsetDateTime lastModifiedTime) {

    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

  /**
   * The time that the version was last modified.
   * 
   * @return lastModifiedTime
   **/
  @Schema(required = true, description = "The time that the version was last modified.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getLastModifiedTime() {
    return lastModifiedTime;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedTime(OffsetDateTime lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public ItemAttributes lastModifiedUserId(String lastModifiedUserId) {

    this.lastModifiedUserId = lastModifiedUserId;
    return this;
  }

  /**
   * The ID of the user that last modified the version.
   * 
   * @return lastModifiedUserId
   **/
  @Schema(required = true, description = "The ID of the user that last modified the version.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastModifiedUserId() {
    return lastModifiedUserId;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedUserId(String lastModifiedUserId) {
    this.lastModifiedUserId = lastModifiedUserId;
  }

  public ItemAttributes lastModifiedUserName(String lastModifiedUserName) {

    this.lastModifiedUserName = lastModifiedUserName;
    return this;
  }

  /**
   * The user name of the user that last modified the version.
   * 
   * @return lastModifiedUserName
   **/
  @Schema(required = true, description = "The user name of the user that last modified the version.")
  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastModifiedUserName() {
    return lastModifiedUserName;
  }

  @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastModifiedUserName(String lastModifiedUserName) {
    this.lastModifiedUserName = lastModifiedUserName;
  }

  public ItemAttributes hidden(Boolean hidden) {

    this.hidden = hidden;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60;: The file has been deleted.
   * 
   * &#x60;&#x60;false&#x60;&#x60;: The file has not been deleted.
   * 
   * @return hidden
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true``: The file has been deleted.   ``false``: The file has not been deleted. ")
  @JsonProperty(JSON_PROPERTY_HIDDEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getHidden() {
    return hidden;
  }

  @JsonProperty(JSON_PROPERTY_HIDDEN)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public ItemAttributes reserved(Boolean reserved) {

    this.reserved = reserved;
    return this;
  }

  /**
   * &#x60;&#x60;true&#x60;&#x60;: The file is locked.
   * 
   * &#x60;&#x60;false&#x60;&#x60; The file is not locked.
   ** 
   * Note:** You can lock BIM 360 Project Files folder files and A360 files, but
   * you cannot lock BIM 360 Plans Folder files.
   * 
   * @return reserved
   **/
  @javax.annotation.Nullable
  @Schema(description = "``true``: The file is locked.  ``false`` The file is not locked.   **Note:** You can lock BIM 360 Project Files folder files and A360 files, but you cannot lock BIM 360 Plans Folder files. ")
  @JsonProperty(JSON_PROPERTY_RESERVED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public Boolean getReserved() {
    return reserved;
  }

  @JsonProperty(JSON_PROPERTY_RESERVED)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReserved(Boolean reserved) {
    this.reserved = reserved;
  }

  public ItemAttributes reservedTime(OffsetDateTime reservedTime) {

    this.reservedTime = reservedTime;
    return this;
  }

  /**
   * The time the item was reserved in the following format:
   * &#x60;&#x60;YYYY-MM-DDThh:mm:ss.sz&#x60;&#x60;.
   * 
   * @return reservedTime
   **/
  @javax.annotation.Nullable
  @Schema(description = "The time the item was reserved in the following format: ``YYYY-MM-DDThh:mm:ss.sz``.")
  @JsonProperty(JSON_PROPERTY_RESERVED_TIME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public OffsetDateTime getReservedTime() {
    return reservedTime;
  }

  @JsonProperty(JSON_PROPERTY_RESERVED_TIME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReservedTime(OffsetDateTime reservedTime) {
    this.reservedTime = reservedTime;
  }

  public ItemAttributes reservedUserId(String reservedUserId) {

    this.reservedUserId = reservedUserId;
    return this;
  }

  /**
   * The unique identifier of the user who reserved the item.
   * 
   * @return reservedUserId
   **/
  @javax.annotation.Nullable
  @Schema(description = "The unique identifier of the user who reserved the item.")
  @JsonProperty(JSON_PROPERTY_RESERVED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getReservedUserId() {
    return reservedUserId;
  }

  @JsonProperty(JSON_PROPERTY_RESERVED_USER_ID)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReservedUserId(String reservedUserId) {
    this.reservedUserId = reservedUserId;
  }

  public ItemAttributes reservedUserName(String reservedUserName) {

    this.reservedUserName = reservedUserName;
    return this;
  }

  /**
   * The name of the user who reserved the item.
   * 
   * @return reservedUserName
   **/
  @javax.annotation.Nullable
  @Schema(description = "The name of the user who reserved the item.")
  @JsonProperty(JSON_PROPERTY_RESERVED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)

  public String getReservedUserName() {
    return reservedUserName;
  }

  @JsonProperty(JSON_PROPERTY_RESERVED_USER_NAME)
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  public void setReservedUserName(String reservedUserName) {
    this.reservedUserName = reservedUserName;
  }

  public ItemAttributes extension(ItemExtensionWithSchemaLink extension) {

    this.extension = extension;
    return this;
  }

  /**
   * Get extension
   * 
   * @return extension
   **/
  @Schema(required = true, description = "")
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ItemExtensionWithSchemaLink getExtension() {
    return extension;
  }

  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExtension(ItemExtensionWithSchemaLink extension) {
    this.extension = extension;
  }

  public ItemAttributes pathInProject(String pathInProject) {

    this.pathInProject = pathInProject;
    return this;
  }

  /**
   * The relative path of the item starting from the root folder of the project.
   * 
   * @return pathInProject
   **/
  @Schema(required = true, description = "The relative path of the item starting from the root folder of the project.")
  @JsonProperty(JSON_PROPERTY_PATH_IN_PROJECT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPathInProject() {
    return pathInProject;
  }

  @JsonProperty(JSON_PROPERTY_PATH_IN_PROJECT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPathInProject(String pathInProject) {
    this.pathInProject = pathInProject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemAttributes itemAttributes = (ItemAttributes) o;
    return Objects.equals(this.displayName, itemAttributes.displayName) &&
        Objects.equals(this.createTime, itemAttributes.createTime) &&
        Objects.equals(this.createUserId, itemAttributes.createUserId) &&
        Objects.equals(this.createUserName, itemAttributes.createUserName) &&
        Objects.equals(this.lastModifiedTime, itemAttributes.lastModifiedTime) &&
        Objects.equals(this.lastModifiedUserId, itemAttributes.lastModifiedUserId) &&
        Objects.equals(this.lastModifiedUserName, itemAttributes.lastModifiedUserName) &&
        Objects.equals(this.hidden, itemAttributes.hidden) &&
        Objects.equals(this.reserved, itemAttributes.reserved) &&
        Objects.equals(this.reservedTime, itemAttributes.reservedTime) &&
        Objects.equals(this.reservedUserId, itemAttributes.reservedUserId) &&
        Objects.equals(this.reservedUserName, itemAttributes.reservedUserName) &&
        Objects.equals(this.extension, itemAttributes.extension) &&
        Objects.equals(this.pathInProject, itemAttributes.pathInProject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, createTime, createUserId, createUserName, lastModifiedTime, lastModifiedUserId,
        lastModifiedUserName, hidden, reserved, reservedTime, reservedUserId, reservedUserName, extension, pathInProject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemAttributes {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUserId: ").append(toIndentedString(createUserId)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
    sb.append("    lastModifiedUserId: ").append(toIndentedString(lastModifiedUserId)).append("\n");
    sb.append("    lastModifiedUserName: ").append(toIndentedString(lastModifiedUserName)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
    sb.append("    reserved: ").append(toIndentedString(reserved)).append("\n");
    sb.append("    reservedTime: ").append(toIndentedString(reservedTime)).append("\n");
    sb.append("    reservedUserId: ").append(toIndentedString(reservedUserId)).append("\n");
    sb.append("    reservedUserName: ").append(toIndentedString(reservedUserName)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    pathInProject: ").append(toIndentedString(pathInProject)).append("\n");
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
