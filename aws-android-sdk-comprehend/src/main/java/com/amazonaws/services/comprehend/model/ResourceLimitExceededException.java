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

package com.amazonaws.services.comprehend.model;

import com.amazonaws.AmazonServiceException;

/**
 * <p>
 * The maximum number of resources per account has been exceeded. Review the
 * resources, and then try your request again.
 * </p>
 */
public class ResourceLimitExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ResourceLimitExceededException with the specified error
     * message.
     *
     * @param message Describes the error encountered.
     */
    public ResourceLimitExceededException(String message) {
        super(message);
    }
}
