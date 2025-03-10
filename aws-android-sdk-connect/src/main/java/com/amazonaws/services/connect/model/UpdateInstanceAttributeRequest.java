/*
 * Copyright 2010-2022 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.connect.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * This API is in preview release for Amazon Connect and is subject to change.
 * </p>
 * <p>
 * Updates the value for the specified attribute type.
 * </p>
 */
public class UpdateInstanceAttributeRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The identifier of the Amazon Connect instance. You can find the
     * instanceId in the ARN of the instance.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     */
    private String instanceId;

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     */
    private String attributeType;

    /**
     * <p>
     * The value for the attribute. Maximum character limit is 100.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     */
    private String value;

    /**
     * <p>
     * The identifier of the Amazon Connect instance. You can find the
     * instanceId in the ARN of the instance.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @return <p>
     *         The identifier of the Amazon Connect instance. You can find the
     *         instanceId in the ARN of the instance.
     *         </p>
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * <p>
     * The identifier of the Amazon Connect instance. You can find the
     * instanceId in the ARN of the instance.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @param instanceId <p>
     *            The identifier of the Amazon Connect instance. You can find
     *            the instanceId in the ARN of the instance.
     *            </p>
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * <p>
     * The identifier of the Amazon Connect instance. You can find the
     * instanceId in the ARN of the instance.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @param instanceId <p>
     *            The identifier of the Amazon Connect instance. You can find
     *            the instanceId in the ARN of the instance.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateInstanceAttributeRequest withInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     *
     * @return <p>
     *         The type of attribute.
     *         </p>
     *         <note>
     *         <p>
     *         Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To
     *         access this feature, contact Amazon Web Services Support for
     *         allowlisting.
     *         </p>
     *         </note>
     * @see InstanceAttributeType
     */
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     *
     * @param attributeType <p>
     *            The type of attribute.
     *            </p>
     *            <note>
     *            <p>
     *            Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES.
     *            To access this feature, contact Amazon Web Services Support
     *            for allowlisting.
     *            </p>
     *            </note>
     * @see InstanceAttributeType
     */
    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     *
     * @param attributeType <p>
     *            The type of attribute.
     *            </p>
     *            <note>
     *            <p>
     *            Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES.
     *            To access this feature, contact Amazon Web Services Support
     *            for allowlisting.
     *            </p>
     *            </note>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see InstanceAttributeType
     */
    public UpdateInstanceAttributeRequest withAttributeType(String attributeType) {
        this.attributeType = attributeType;
        return this;
    }

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     *
     * @param attributeType <p>
     *            The type of attribute.
     *            </p>
     *            <note>
     *            <p>
     *            Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES.
     *            To access this feature, contact Amazon Web Services Support
     *            for allowlisting.
     *            </p>
     *            </note>
     * @see InstanceAttributeType
     */
    public void setAttributeType(InstanceAttributeType attributeType) {
        this.attributeType = attributeType.toString();
    }

    /**
     * <p>
     * The type of attribute.
     * </p>
     * <note>
     * <p>
     * Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES. To access
     * this feature, contact Amazon Web Services Support for allowlisting.
     * </p>
     * </note>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INBOUND_CALLS, OUTBOUND_CALLS, CONTACTFLOW_LOGS,
     * CONTACT_LENS, AUTO_RESOLVE_BEST_VOICES, USE_CUSTOM_TTS_VOICES,
     * EARLY_MEDIA, MULTI_PARTY_CONFERENCE
     *
     * @param attributeType <p>
     *            The type of attribute.
     *            </p>
     *            <note>
     *            <p>
     *            Only allowlisted customers can consume USE_CUSTOM_TTS_VOICES.
     *            To access this feature, contact Amazon Web Services Support
     *            for allowlisting.
     *            </p>
     *            </note>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see InstanceAttributeType
     */
    public UpdateInstanceAttributeRequest withAttributeType(InstanceAttributeType attributeType) {
        this.attributeType = attributeType.toString();
        return this;
    }

    /**
     * <p>
     * The value for the attribute. Maximum character limit is 100.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @return <p>
     *         The value for the attribute. Maximum character limit is 100.
     *         </p>
     */
    public String getValue() {
        return value;
    }

    /**
     * <p>
     * The value for the attribute. Maximum character limit is 100.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @param value <p>
     *            The value for the attribute. Maximum character limit is 100.
     *            </p>
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * <p>
     * The value for the attribute. Maximum character limit is 100.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 100<br/>
     *
     * @param value <p>
     *            The value for the attribute. Maximum character limit is 100.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateInstanceAttributeRequest withValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getInstanceId() != null)
            sb.append("InstanceId: " + getInstanceId() + ",");
        if (getAttributeType() != null)
            sb.append("AttributeType: " + getAttributeType() + ",");
        if (getValue() != null)
            sb.append("Value: " + getValue());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        hashCode = prime * hashCode
                + ((getAttributeType() == null) ? 0 : getAttributeType().hashCode());
        hashCode = prime * hashCode + ((getValue() == null) ? 0 : getValue().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UpdateInstanceAttributeRequest == false)
            return false;
        UpdateInstanceAttributeRequest other = (UpdateInstanceAttributeRequest) obj;

        if (other.getInstanceId() == null ^ this.getInstanceId() == null)
            return false;
        if (other.getInstanceId() != null
                && other.getInstanceId().equals(this.getInstanceId()) == false)
            return false;
        if (other.getAttributeType() == null ^ this.getAttributeType() == null)
            return false;
        if (other.getAttributeType() != null
                && other.getAttributeType().equals(this.getAttributeType()) == false)
            return false;
        if (other.getValue() == null ^ this.getValue() == null)
            return false;
        if (other.getValue() != null && other.getValue().equals(this.getValue()) == false)
            return false;
        return true;
    }
}
