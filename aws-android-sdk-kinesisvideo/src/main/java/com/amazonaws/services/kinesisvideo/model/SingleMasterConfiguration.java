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

package com.amazonaws.services.kinesisvideo.model;

import java.io.Serializable;

/**
 * <p>
 * A structure that contains the configuration for the
 * <code>SINGLE_MASTER</code> channel type.
 * </p>
 */
public class SingleMasterConfiguration implements Serializable {
    /**
     * <p>
     * The period of time a signaling channel retains undelivered messages
     * before they are discarded.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>5 - 120<br/>
     */
    private Integer messageTtlSeconds;

    /**
     * <p>
     * The period of time a signaling channel retains undelivered messages
     * before they are discarded.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>5 - 120<br/>
     *
     * @return <p>
     *         The period of time a signaling channel retains undelivered
     *         messages before they are discarded.
     *         </p>
     */
    public Integer getMessageTtlSeconds() {
        return messageTtlSeconds;
    }

    /**
     * <p>
     * The period of time a signaling channel retains undelivered messages
     * before they are discarded.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>5 - 120<br/>
     *
     * @param messageTtlSeconds <p>
     *            The period of time a signaling channel retains undelivered
     *            messages before they are discarded.
     *            </p>
     */
    public void setMessageTtlSeconds(Integer messageTtlSeconds) {
        this.messageTtlSeconds = messageTtlSeconds;
    }

    /**
     * <p>
     * The period of time a signaling channel retains undelivered messages
     * before they are discarded.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>5 - 120<br/>
     *
     * @param messageTtlSeconds <p>
     *            The period of time a signaling channel retains undelivered
     *            messages before they are discarded.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public SingleMasterConfiguration withMessageTtlSeconds(Integer messageTtlSeconds) {
        this.messageTtlSeconds = messageTtlSeconds;
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
        if (getMessageTtlSeconds() != null)
            sb.append("MessageTtlSeconds: " + getMessageTtlSeconds());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getMessageTtlSeconds() == null) ? 0 : getMessageTtlSeconds().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof SingleMasterConfiguration == false)
            return false;
        SingleMasterConfiguration other = (SingleMasterConfiguration) obj;

        if (other.getMessageTtlSeconds() == null ^ this.getMessageTtlSeconds() == null)
            return false;
        if (other.getMessageTtlSeconds() != null
                && other.getMessageTtlSeconds().equals(this.getMessageTtlSeconds()) == false)
            return false;
        return true;
    }
}
