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

public class GetCallAnalyticsCategoryResult implements Serializable {
    /**
     * <p>
     * Provides you with the properties of the Call Analytics category you
     * specified in your <code>GetCallAnalyticsCategory</code> request.
     * </p>
     */
    private CategoryProperties categoryProperties;

    /**
     * <p>
     * Provides you with the properties of the Call Analytics category you
     * specified in your <code>GetCallAnalyticsCategory</code> request.
     * </p>
     *
     * @return <p>
     *         Provides you with the properties of the Call Analytics category
     *         you specified in your <code>GetCallAnalyticsCategory</code>
     *         request.
     *         </p>
     */
    public CategoryProperties getCategoryProperties() {
        return categoryProperties;
    }

    /**
     * <p>
     * Provides you with the properties of the Call Analytics category you
     * specified in your <code>GetCallAnalyticsCategory</code> request.
     * </p>
     *
     * @param categoryProperties <p>
     *            Provides you with the properties of the Call Analytics
     *            category you specified in your
     *            <code>GetCallAnalyticsCategory</code> request.
     *            </p>
     */
    public void setCategoryProperties(CategoryProperties categoryProperties) {
        this.categoryProperties = categoryProperties;
    }

    /**
     * <p>
     * Provides you with the properties of the Call Analytics category you
     * specified in your <code>GetCallAnalyticsCategory</code> request.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param categoryProperties <p>
     *            Provides you with the properties of the Call Analytics
     *            category you specified in your
     *            <code>GetCallAnalyticsCategory</code> request.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public GetCallAnalyticsCategoryResult withCategoryProperties(
            CategoryProperties categoryProperties) {
        this.categoryProperties = categoryProperties;
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
        if (getCategoryProperties() != null)
            sb.append("CategoryProperties: " + getCategoryProperties());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getCategoryProperties() == null) ? 0 : getCategoryProperties().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetCallAnalyticsCategoryResult == false)
            return false;
        GetCallAnalyticsCategoryResult other = (GetCallAnalyticsCategoryResult) obj;

        if (other.getCategoryProperties() == null ^ this.getCategoryProperties() == null)
            return false;
        if (other.getCategoryProperties() != null
                && other.getCategoryProperties().equals(this.getCategoryProperties()) == false)
            return false;
        return true;
    }
}
