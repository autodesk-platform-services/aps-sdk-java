/** 
 * APS SDK
 *
 * The APS Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * Webhooks
 * The Webhooks API enables applications to listen to APS events and receive notifications when they occur. When an event is triggered, the Webhooks service sends a notification to a callback URL you have defined. You can customize the types of events and resources for which you receive notifications. For example, you can set up a webhook to send notifications when files are modified or deleted in a specified hub or project. Below is quick summary of this workflow: 1. Identify the data for which you want to receive notifications. 2. Use the Webhooks API to create one or more hooks. 3. The Webhooks service will notify the webhook when there is a change in the data. 
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

package com.autodesk.aps.webhooks.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Events
 */
public enum Events {
  
  EXTRACTION_FINISHED("extraction.finished"),
  
  EXTRACTION_UPDATED("extraction.updated"),
  
  MODEL_SYNC("model.sync"),
  
  MODEL_PUBLISH("model.publish"),
  
  DM_VERSION_ADDED("dm.version.added"),
  
  DM_VERSION_MODIFIED("dm.version.modified"),
  
  DM_VERSION_DELETED("dm.version.deleted"),
  
  DM_VERSION_MOVED("dm.version.moved"),
  
  DM_VERSION_MOVED_OUT("dm.version.moved.out"),
  
  DM_VERSION_COPIED("dm.version.copied"),
  
  DM_VERSION_COPIED_OUT("dm.version.copied.out"),
  
  DM_LINEAGE_RESERVED("dm.lineage.reserved"),
  
  DM_LINEAGE_UNRESERVED("dm.lineage.unreserved"),
  
  DM_LINEAGE_UPDATED("dm.lineage.updated"),
  
  DM_FOLDER_ADDED("dm.folder.added"),
  
  DM_FOLDER_MODIFIED("dm.folder.modified"),
  
  DM_FOLDER_DELETED("dm.folder.deleted"),
  
  DM_FOLDER_PURGED("dm.folder.purged"),
  
  DM_FOLDER_MOVED("dm.folder.moved"),
  
  DM_FOLDER_MOVED_OUT("dm.folder.moved.out"),
  
  DM_FOLDER_COPIED("dm.folder.copied"),
  
  DM_FOLDER_COPIED_OUT("dm.folder.copied.out"),
  
  DM_OPERATION_STARTED("dm.operation.started"),
  
  DM_OPERATION_COMPLETED("dm.operation.completed"),
  
  ITEM_CLONE("item.clone"),
  
  ITEM_CREATE("item.create"),
  
  ITEM_LOCK("item.lock"),
  
  ITEM_RELEASE("item.release"),
  
  ITEM_UNLOCK("item.unlock"),
  
  ITEM_UPDATE("item.update"),
  
  WORKFLOW_TRANSITION("workflow.transition"),
  
  BUDGET_CREATED_1_0("budget.created-1.0"),
  
  BUDGET_UPDATED_1_0("budget.updated-1.0"),
  
  BUDGET_DELETED_1_0("budget.deleted-1.0"),
  
  BUDGETPAYMENT_CREATED_1_0("budgetPayment.created-1.0"),
  
  BUDGETPAYMENT_UPDATED_1_0("budgetPayment.updated-1.0"),
  
  BUDGETPAYMENT_DELETED_1_0("budgetPayment.deleted-1.0"),
  
  CONTRACT_CREATED_1_0("contract.created-1.0"),
  
  CONTRACT_UPDATED_1_0("contract.updated-1.0"),
  
  CONTRACT_DELETED_1_0("contract.deleted-1.0"),
  
  COR_CREATED_1_0("cor.created-1.0"),
  
  COR_UPDATED_1_0("cor.updated-1.0"),
  
  COR_DELETED_1_0("cor.deleted-1.0"),
  
  COSTPAYMENT_CREATED_1_0("costPayment.created-1.0"),
  
  COSTPAYMENT_UPDATED_1_0("costPayment.updated-1.0"),
  
  COSTPAYMENT_DELETED_1_0("costPayment.deleted-1.0"),
  
  EXPENSE_CREATED_1_0("expense.created-1.0"),
  
  EXPENSE_UPDATED_1_0("expense.updated-1.0"),
  
  EXPENSE_DELETED_1_0("expense.deleted-1.0"),
  
  EXPENSEITEM_CREATED_1_0("expenseItem.created-1.0"),
  
  EXPENSEITEM_UPDATED_1_0("expenseItem.updated-1.0"),
  
  EXPENSEITEM_DELETED_1_0("expenseItem.deleted-1.0"),
  
  MAINCONTRACT_CREATED_1_0("mainContract.created-1.0"),
  
  MAINCONTRACT_UPDATED_1_0("mainContract.updated-1.0"),
  
  MAINCONTRACT_DELETED_1_0("mainContract.deleted-1.0"),
  
  MAINCONTRACTITEM_CREATED_1_0("mainContractItem.created-1.0"),
  
  MAINCONTRACTITEM_UPDATED_1_0("mainContractItem.updated-1.0"),
  
  MAINCONTRACTITEM_DELETED_1_0("mainContractItem.deleted-1.0"),
  
  OCO_CREATED_1_0("oco.created-1.0"),
  
  OCO_UPDATED_1_0("oco.updated-1.0"),
  
  OCO_DELETED_1_0("oco.deleted-1.0"),
  
  PCO_CREATED_1_0("pco.created-1.0"),
  
  PCO_UPDATED_1_0("pco.updated-1.0"),
  
  PCO_DELETED_1_0("pco.deleted-1.0"),
  
  PROJECT_INITIALIZED_1_0("project.initialized-1.0"),
  
  RFQ_CREATED_1_0("rfq.created-1.0"),
  
  RFQ_UPDATED_1_0("rfq.updated-1.0"),
  
  RFQ_DELETED_1_0("rfq.deleted-1.0"),
  
  SCHEDULEOFVALUE_CREATED_1_0("scheduleOfValue.created-1.0"),
  
  SCHEDULEOFVALUE_UPDATED_1_0("scheduleOfValue.updated-1.0"),
  
  SCHEDULEOFVALUE_DELETED_1_0("scheduleOfValue.deleted-1.0"),
  
  SCO_CREATED_1_0("sco.created-1.0"),
  
  SCO_UPDATED_1_0("sco.updated-1.0"),
  
  SCO_DELETED_1_0("sco.deleted-1.0"),
  
  BID_CREATED("bid.created"),
  
  OPPORTUNITY_COMMENT_CREATED("opportunity.comment.created"),
  
  OPPORTUNITY_COMMENT_DELETED("opportunity.comment.deleted"),
  
  OPPORTUNITY_COMMENT_UPDATED("opportunity.comment.updated"),
  
  OPPORTUNITY_CREATED("opportunity.created"),
  
  OPPORTUNITY_STATUS_UPDATED("opportunity.status.updated"),
  
  ISSUE_CREATED_1_0("issue.created-1.0"),
  
  ISSUE_UPDATED_1_0("issue.updated-1.0"),
  
  ISSUE_DELETED_1_0("issue.deleted-1.0"),
  
  ISSUE_RESTORED_1_0("issue.restored-1.0"),
  
  ISSUE_UNLINKED_1_0("issue.unlinked-1.0"),
  
  DT_APPLY_TEMPLATE("dt.applyTemplate"),
  
  DT_REMOVE_TEMPLATE("dt.removeTemplate"),
  
  DT_MUTATION("dt.mutation"),
  
  DT_ALERT("dt.alert");

  private String value;

  Events(String value) {
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
  public static Events fromValue(String value) {
    for (Events b : Events.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

