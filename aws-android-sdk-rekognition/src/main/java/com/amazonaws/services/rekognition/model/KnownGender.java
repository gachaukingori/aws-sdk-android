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

package com.amazonaws.services.rekognition.model;

import java.io.Serializable;

/**
 * <p>
 * The known gender identity for the celebrity that matches the provided ID. The
 * known gender identity can be Male, Female, Nonbinary, or Unlisted.
 * </p>
 */
public class KnownGender implements Serializable {
    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     */
    private String type;

    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     *
     * @return <p>
     *         A string value of the KnownGender info about the Celebrity.
     *         </p>
     * @see KnownGenderType
     */
    public String getType() {
        return type;
    }

    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     *
     * @param type <p>
     *            A string value of the KnownGender info about the Celebrity.
     *            </p>
     * @see KnownGenderType
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     *
     * @param type <p>
     *            A string value of the KnownGender info about the Celebrity.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see KnownGenderType
     */
    public KnownGender withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     *
     * @param type <p>
     *            A string value of the KnownGender info about the Celebrity.
     *            </p>
     * @see KnownGenderType
     */
    public void setType(KnownGenderType type) {
        this.type = type.toString();
    }

    /**
     * <p>
     * A string value of the KnownGender info about the Celebrity.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>Male, Female, Nonbinary, Unlisted
     *
     * @param type <p>
     *            A string value of the KnownGender info about the Celebrity.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see KnownGenderType
     */
    public KnownGender withType(KnownGenderType type) {
        this.type = type.toString();
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
        if (getType() != null)
            sb.append("Type: " + getType());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getType() == null) ? 0 : getType().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof KnownGender == false)
            return false;
        KnownGender other = (KnownGender) obj;

        if (other.getType() == null ^ this.getType() == null)
            return false;
        if (other.getType() != null && other.getType().equals(this.getType()) == false)
            return false;
        return true;
    }
}
