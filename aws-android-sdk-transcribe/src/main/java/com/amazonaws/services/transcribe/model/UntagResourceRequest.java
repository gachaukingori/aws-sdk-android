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

package com.amazonaws.services.transcribe.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Removes the specified tags from the specified Amazon Transcribe resource.
 * </p>
 * <p>
 * If you include <code>UntagResource</code> in your request, you must also
 * include <code>ResourceArn</code> and <code>TagKeys</code>.
 * </p>
 */
public class UntagResourceRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The Amazon Resource Name (ARN) of the Amazon Transcribe resource you want
     * to remove tags from. ARNs have the format
     * <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     * .
     * </p>
     * <p>
     * For example,
     * <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     * .
     * </p>
     * <p>
     * Valid values for <code>resource-type</code> are:
     * <code>transcription-job</code>, <code>medical-transcription-job</code>,
     * <code>vocabulary</code>, <code>medical-vocabulary</code>,
     * <code>vocabulary-filter</code>, and <code>language-model</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1011<br/>
     * <b>Pattern:
     * </b>arn:aws(-[^:]+)?:transcribe:[a-zA-Z0-9-]*:[0-9]{12}:[a-zA-Z-]
     * {@literal *}/[0-9a-zA-Z._-]+<br/>
     */
    private String resourceArn;

    /**
     * <p>
     * Removes the specified tag keys from the specified Amazon Transcribe
     * resource.
     * </p>
     */
    private java.util.List<String> tagKeys;

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the Amazon Transcribe resource you want
     * to remove tags from. ARNs have the format
     * <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     * .
     * </p>
     * <p>
     * For example,
     * <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     * .
     * </p>
     * <p>
     * Valid values for <code>resource-type</code> are:
     * <code>transcription-job</code>, <code>medical-transcription-job</code>,
     * <code>vocabulary</code>, <code>medical-vocabulary</code>,
     * <code>vocabulary-filter</code>, and <code>language-model</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1011<br/>
     * <b>Pattern:
     * </b>arn:aws(-[^:]+)?:transcribe:[a-zA-Z0-9-]*:[0-9]{12}:[a-zA-Z-]
     * {@literal *}/[0-9a-zA-Z._-]+<br/>
     *
     * @return <p>
     *         The Amazon Resource Name (ARN) of the Amazon Transcribe resource
     *         you want to remove tags from. ARNs have the format
     *         <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     *         .
     *         </p>
     *         <p>
     *         For example,
     *         <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     *         .
     *         </p>
     *         <p>
     *         Valid values for <code>resource-type</code> are:
     *         <code>transcription-job</code>,
     *         <code>medical-transcription-job</code>, <code>vocabulary</code>,
     *         <code>medical-vocabulary</code>, <code>vocabulary-filter</code>,
     *         and <code>language-model</code>.
     *         </p>
     */
    public String getResourceArn() {
        return resourceArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the Amazon Transcribe resource you want
     * to remove tags from. ARNs have the format
     * <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     * .
     * </p>
     * <p>
     * For example,
     * <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     * .
     * </p>
     * <p>
     * Valid values for <code>resource-type</code> are:
     * <code>transcription-job</code>, <code>medical-transcription-job</code>,
     * <code>vocabulary</code>, <code>medical-vocabulary</code>,
     * <code>vocabulary-filter</code>, and <code>language-model</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1011<br/>
     * <b>Pattern:
     * </b>arn:aws(-[^:]+)?:transcribe:[a-zA-Z0-9-]*:[0-9]{12}:[a-zA-Z-]
     * {@literal *}/[0-9a-zA-Z._-]+<br/>
     *
     * @param resourceArn <p>
     *            The Amazon Resource Name (ARN) of the Amazon Transcribe
     *            resource you want to remove tags from. ARNs have the format
     *            <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     *            .
     *            </p>
     *            <p>
     *            For example,
     *            <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     *            .
     *            </p>
     *            <p>
     *            Valid values for <code>resource-type</code> are:
     *            <code>transcription-job</code>,
     *            <code>medical-transcription-job</code>,
     *            <code>vocabulary</code>, <code>medical-vocabulary</code>,
     *            <code>vocabulary-filter</code>, and
     *            <code>language-model</code>.
     *            </p>
     */
    public void setResourceArn(String resourceArn) {
        this.resourceArn = resourceArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the Amazon Transcribe resource you want
     * to remove tags from. ARNs have the format
     * <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     * .
     * </p>
     * <p>
     * For example,
     * <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     * .
     * </p>
     * <p>
     * Valid values for <code>resource-type</code> are:
     * <code>transcription-job</code>, <code>medical-transcription-job</code>,
     * <code>vocabulary</code>, <code>medical-vocabulary</code>,
     * <code>vocabulary-filter</code>, and <code>language-model</code>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 1011<br/>
     * <b>Pattern:
     * </b>arn:aws(-[^:]+)?:transcribe:[a-zA-Z0-9-]*:[0-9]{12}:[a-zA-Z-]
     * {@literal *}/[0-9a-zA-Z._-]+<br/>
     *
     * @param resourceArn <p>
     *            The Amazon Resource Name (ARN) of the Amazon Transcribe
     *            resource you want to remove tags from. ARNs have the format
     *            <code>arn:partition:service:region:account-id:resource-type/resource-id</code>
     *            .
     *            </p>
     *            <p>
     *            For example,
     *            <code>arn:aws:transcribe:us-west-2:account-id:transcription-job/transcription-job-name</code>
     *            .
     *            </p>
     *            <p>
     *            Valid values for <code>resource-type</code> are:
     *            <code>transcription-job</code>,
     *            <code>medical-transcription-job</code>,
     *            <code>vocabulary</code>, <code>medical-vocabulary</code>,
     *            <code>vocabulary-filter</code>, and
     *            <code>language-model</code>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UntagResourceRequest withResourceArn(String resourceArn) {
        this.resourceArn = resourceArn;
        return this;
    }

    /**
     * <p>
     * Removes the specified tag keys from the specified Amazon Transcribe
     * resource.
     * </p>
     *
     * @return <p>
     *         Removes the specified tag keys from the specified Amazon
     *         Transcribe resource.
     *         </p>
     */
    public java.util.List<String> getTagKeys() {
        return tagKeys;
    }

    /**
     * <p>
     * Removes the specified tag keys from the specified Amazon Transcribe
     * resource.
     * </p>
     *
     * @param tagKeys <p>
     *            Removes the specified tag keys from the specified Amazon
     *            Transcribe resource.
     *            </p>
     */
    public void setTagKeys(java.util.Collection<String> tagKeys) {
        if (tagKeys == null) {
            this.tagKeys = null;
            return;
        }

        this.tagKeys = new java.util.ArrayList<String>(tagKeys);
    }

    /**
     * <p>
     * Removes the specified tag keys from the specified Amazon Transcribe
     * resource.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tagKeys <p>
     *            Removes the specified tag keys from the specified Amazon
     *            Transcribe resource.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UntagResourceRequest withTagKeys(String... tagKeys) {
        if (getTagKeys() == null) {
            this.tagKeys = new java.util.ArrayList<String>(tagKeys.length);
        }
        for (String value : tagKeys) {
            this.tagKeys.add(value);
        }
        return this;
    }

    /**
     * <p>
     * Removes the specified tag keys from the specified Amazon Transcribe
     * resource.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tagKeys <p>
     *            Removes the specified tag keys from the specified Amazon
     *            Transcribe resource.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UntagResourceRequest withTagKeys(java.util.Collection<String> tagKeys) {
        setTagKeys(tagKeys);
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
        if (getResourceArn() != null)
            sb.append("ResourceArn: " + getResourceArn() + ",");
        if (getTagKeys() != null)
            sb.append("TagKeys: " + getTagKeys());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getResourceArn() == null) ? 0 : getResourceArn().hashCode());
        hashCode = prime * hashCode + ((getTagKeys() == null) ? 0 : getTagKeys().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UntagResourceRequest == false)
            return false;
        UntagResourceRequest other = (UntagResourceRequest) obj;

        if (other.getResourceArn() == null ^ this.getResourceArn() == null)
            return false;
        if (other.getResourceArn() != null
                && other.getResourceArn().equals(this.getResourceArn()) == false)
            return false;
        if (other.getTagKeys() == null ^ this.getTagKeys() == null)
            return false;
        if (other.getTagKeys() != null && other.getTagKeys().equals(this.getTagKeys()) == false)
            return false;
        return true;
    }
}
