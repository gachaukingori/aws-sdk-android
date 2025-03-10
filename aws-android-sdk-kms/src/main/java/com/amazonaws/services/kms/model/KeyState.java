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

package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Key State
 */
public enum KeyState {

    Creating("Creating"),
    Enabled("Enabled"),
    Disabled("Disabled"),
    PendingDeletion("PendingDeletion"),
    PendingImport("PendingImport"),
    PendingReplicaDeletion("PendingReplicaDeletion"),
    Unavailable("Unavailable"),
    Updating("Updating");

    private String value;

    private KeyState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, KeyState> enumMap;
    static {
        enumMap = new HashMap<String, KeyState>();
        enumMap.put("Creating", Creating);
        enumMap.put("Enabled", Enabled);
        enumMap.put("Disabled", Disabled);
        enumMap.put("PendingDeletion", PendingDeletion);
        enumMap.put("PendingImport", PendingImport);
        enumMap.put("PendingReplicaDeletion", PendingReplicaDeletion);
        enumMap.put("Unavailable", Unavailable);
        enumMap.put("Updating", Updating);
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value real value
     * @return KeyState corresponding to the value
     */
    public static KeyState fromValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if (enumMap.containsKey(value)) {
            return enumMap.get(value);
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        }
    }
}
