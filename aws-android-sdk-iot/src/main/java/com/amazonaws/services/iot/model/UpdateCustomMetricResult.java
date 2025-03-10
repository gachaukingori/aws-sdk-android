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

package com.amazonaws.services.iot.model;

import java.io.Serializable;

public class UpdateCustomMetricResult implements Serializable {
    /**
     * <p>
     * The name of the custom metric.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[a-zA-Z0-9:_-]+<br/>
     */
    private String metricName;

    /**
     * <p>
     * The Amazon Resource Number (ARN) of the custom metric.
     * </p>
     */
    private String metricArn;

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     */
    private String metricType;

    /**
     * <p>
     * A friendly name in the console for the custom metric
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b> - 128<br/>
     * <b>Pattern: </b>[\p{Graph}\x20]*<br/>
     */
    private String displayName;

    /**
     * <p>
     * The creation date of the custom metric in milliseconds since epoch.
     * </p>
     */
    private java.util.Date creationDate;

    /**
     * <p>
     * The time the custom metric was last modified in milliseconds since epoch.
     * </p>
     */
    private java.util.Date lastModifiedDate;

    /**
     * <p>
     * The name of the custom metric.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[a-zA-Z0-9:_-]+<br/>
     *
     * @return <p>
     *         The name of the custom metric.
     *         </p>
     */
    public String getMetricName() {
        return metricName;
    }

    /**
     * <p>
     * The name of the custom metric.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[a-zA-Z0-9:_-]+<br/>
     *
     * @param metricName <p>
     *            The name of the custom metric.
     *            </p>
     */
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * <p>
     * The name of the custom metric.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[a-zA-Z0-9:_-]+<br/>
     *
     * @param metricName <p>
     *            The name of the custom metric.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateCustomMetricResult withMetricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    /**
     * <p>
     * The Amazon Resource Number (ARN) of the custom metric.
     * </p>
     *
     * @return <p>
     *         The Amazon Resource Number (ARN) of the custom metric.
     *         </p>
     */
    public String getMetricArn() {
        return metricArn;
    }

    /**
     * <p>
     * The Amazon Resource Number (ARN) of the custom metric.
     * </p>
     *
     * @param metricArn <p>
     *            The Amazon Resource Number (ARN) of the custom metric.
     *            </p>
     */
    public void setMetricArn(String metricArn) {
        this.metricArn = metricArn;
    }

    /**
     * <p>
     * The Amazon Resource Number (ARN) of the custom metric.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param metricArn <p>
     *            The Amazon Resource Number (ARN) of the custom metric.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateCustomMetricResult withMetricArn(String metricArn) {
        this.metricArn = metricArn;
        return this;
    }

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     *
     * @return <p>
     *         The type of the custom metric.
     *         </p>
     *         <important>
     *         <p>
     *         The type <code>number</code> only takes a single metric value as
     *         an input, but while submitting the metrics value in the
     *         DeviceMetrics report, it must be passed as an array with a single
     *         value.
     *         </p>
     *         </important>
     * @see CustomMetricType
     */
    public String getMetricType() {
        return metricType;
    }

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     *
     * @param metricType <p>
     *            The type of the custom metric.
     *            </p>
     *            <important>
     *            <p>
     *            The type <code>number</code> only takes a single metric value
     *            as an input, but while submitting the metrics value in the
     *            DeviceMetrics report, it must be passed as an array with a
     *            single value.
     *            </p>
     *            </important>
     * @see CustomMetricType
     */
    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     *
     * @param metricType <p>
     *            The type of the custom metric.
     *            </p>
     *            <important>
     *            <p>
     *            The type <code>number</code> only takes a single metric value
     *            as an input, but while submitting the metrics value in the
     *            DeviceMetrics report, it must be passed as an array with a
     *            single value.
     *            </p>
     *            </important>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see CustomMetricType
     */
    public UpdateCustomMetricResult withMetricType(String metricType) {
        this.metricType = metricType;
        return this;
    }

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     *
     * @param metricType <p>
     *            The type of the custom metric.
     *            </p>
     *            <important>
     *            <p>
     *            The type <code>number</code> only takes a single metric value
     *            as an input, but while submitting the metrics value in the
     *            DeviceMetrics report, it must be passed as an array with a
     *            single value.
     *            </p>
     *            </important>
     * @see CustomMetricType
     */
    public void setMetricType(CustomMetricType metricType) {
        this.metricType = metricType.toString();
    }

    /**
     * <p>
     * The type of the custom metric.
     * </p>
     * <important>
     * <p>
     * The type <code>number</code> only takes a single metric value as an
     * input, but while submitting the metrics value in the DeviceMetrics
     * report, it must be passed as an array with a single value.
     * </p>
     * </important>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>string-list, ip-address-list, number-list, number
     *
     * @param metricType <p>
     *            The type of the custom metric.
     *            </p>
     *            <important>
     *            <p>
     *            The type <code>number</code> only takes a single metric value
     *            as an input, but while submitting the metrics value in the
     *            DeviceMetrics report, it must be passed as an array with a
     *            single value.
     *            </p>
     *            </important>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see CustomMetricType
     */
    public UpdateCustomMetricResult withMetricType(CustomMetricType metricType) {
        this.metricType = metricType.toString();
        return this;
    }

    /**
     * <p>
     * A friendly name in the console for the custom metric
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b> - 128<br/>
     * <b>Pattern: </b>[\p{Graph}\x20]*<br/>
     *
     * @return <p>
     *         A friendly name in the console for the custom metric
     *         </p>
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * <p>
     * A friendly name in the console for the custom metric
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b> - 128<br/>
     * <b>Pattern: </b>[\p{Graph}\x20]*<br/>
     *
     * @param displayName <p>
     *            A friendly name in the console for the custom metric
     *            </p>
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * <p>
     * A friendly name in the console for the custom metric
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b> - 128<br/>
     * <b>Pattern: </b>[\p{Graph}\x20]*<br/>
     *
     * @param displayName <p>
     *            A friendly name in the console for the custom metric
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateCustomMetricResult withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * <p>
     * The creation date of the custom metric in milliseconds since epoch.
     * </p>
     *
     * @return <p>
     *         The creation date of the custom metric in milliseconds since
     *         epoch.
     *         </p>
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * <p>
     * The creation date of the custom metric in milliseconds since epoch.
     * </p>
     *
     * @param creationDate <p>
     *            The creation date of the custom metric in milliseconds since
     *            epoch.
     *            </p>
     */
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * <p>
     * The creation date of the custom metric in milliseconds since epoch.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param creationDate <p>
     *            The creation date of the custom metric in milliseconds since
     *            epoch.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateCustomMetricResult withCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * <p>
     * The time the custom metric was last modified in milliseconds since epoch.
     * </p>
     *
     * @return <p>
     *         The time the custom metric was last modified in milliseconds
     *         since epoch.
     *         </p>
     */
    public java.util.Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * <p>
     * The time the custom metric was last modified in milliseconds since epoch.
     * </p>
     *
     * @param lastModifiedDate <p>
     *            The time the custom metric was last modified in milliseconds
     *            since epoch.
     *            </p>
     */
    public void setLastModifiedDate(java.util.Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * <p>
     * The time the custom metric was last modified in milliseconds since epoch.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param lastModifiedDate <p>
     *            The time the custom metric was last modified in milliseconds
     *            since epoch.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateCustomMetricResult withLastModifiedDate(java.util.Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
        if (getMetricName() != null)
            sb.append("metricName: " + getMetricName() + ",");
        if (getMetricArn() != null)
            sb.append("metricArn: " + getMetricArn() + ",");
        if (getMetricType() != null)
            sb.append("metricType: " + getMetricType() + ",");
        if (getDisplayName() != null)
            sb.append("displayName: " + getDisplayName() + ",");
        if (getCreationDate() != null)
            sb.append("creationDate: " + getCreationDate() + ",");
        if (getLastModifiedDate() != null)
            sb.append("lastModifiedDate: " + getLastModifiedDate());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getMetricName() == null) ? 0 : getMetricName().hashCode());
        hashCode = prime * hashCode + ((getMetricArn() == null) ? 0 : getMetricArn().hashCode());
        hashCode = prime * hashCode + ((getMetricType() == null) ? 0 : getMetricType().hashCode());
        hashCode = prime * hashCode
                + ((getDisplayName() == null) ? 0 : getDisplayName().hashCode());
        hashCode = prime * hashCode
                + ((getCreationDate() == null) ? 0 : getCreationDate().hashCode());
        hashCode = prime * hashCode
                + ((getLastModifiedDate() == null) ? 0 : getLastModifiedDate().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UpdateCustomMetricResult == false)
            return false;
        UpdateCustomMetricResult other = (UpdateCustomMetricResult) obj;

        if (other.getMetricName() == null ^ this.getMetricName() == null)
            return false;
        if (other.getMetricName() != null
                && other.getMetricName().equals(this.getMetricName()) == false)
            return false;
        if (other.getMetricArn() == null ^ this.getMetricArn() == null)
            return false;
        if (other.getMetricArn() != null
                && other.getMetricArn().equals(this.getMetricArn()) == false)
            return false;
        if (other.getMetricType() == null ^ this.getMetricType() == null)
            return false;
        if (other.getMetricType() != null
                && other.getMetricType().equals(this.getMetricType()) == false)
            return false;
        if (other.getDisplayName() == null ^ this.getDisplayName() == null)
            return false;
        if (other.getDisplayName() != null
                && other.getDisplayName().equals(this.getDisplayName()) == false)
            return false;
        if (other.getCreationDate() == null ^ this.getCreationDate() == null)
            return false;
        if (other.getCreationDate() != null
                && other.getCreationDate().equals(this.getCreationDate()) == false)
            return false;
        if (other.getLastModifiedDate() == null ^ this.getLastModifiedDate() == null)
            return false;
        if (other.getLastModifiedDate() != null
                && other.getLastModifiedDate().equals(this.getLastModifiedDate()) == false)
            return false;
        return true;
    }
}
