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

package com.amazonaws.services.lambda.model;

import com.amazonaws.AmazonServiceException;

/**
 * <p>
 * The function couldn't make a network connection to the configured file
 * system.
 * </p>
 */
public class EFSMountConnectivityException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;

    private String type;

    /**
     * Constructs a new EFSMountConnectivityException with the specified error
     * message.
     *
     * @param message Describes the error encountered.
     */
    public EFSMountConnectivityException(String message) {
        super(message);
    }

    /**
     * Returns the value of the type property for this object.
     *
     * @return The value of the type property for this object.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of type
     *
     * @param type The new value for the type property for this object.
     */
    public void setType(String type) {
        this.type = type;
    }
}
