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

import java.util.HashMap;
import java.util.Map;

/**
 * Reason
 */
public enum Reason {

    EXCEEDS_MAX_FACES("EXCEEDS_MAX_FACES"),
    EXTREME_POSE("EXTREME_POSE"),
    LOW_BRIGHTNESS("LOW_BRIGHTNESS"),
    LOW_SHARPNESS("LOW_SHARPNESS"),
    LOW_CONFIDENCE("LOW_CONFIDENCE"),
    SMALL_BOUNDING_BOX("SMALL_BOUNDING_BOX"),
    LOW_FACE_QUALITY("LOW_FACE_QUALITY");

    private String value;

    private Reason(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, Reason> enumMap;
    static {
        enumMap = new HashMap<String, Reason>();
        enumMap.put("EXCEEDS_MAX_FACES", EXCEEDS_MAX_FACES);
        enumMap.put("EXTREME_POSE", EXTREME_POSE);
        enumMap.put("LOW_BRIGHTNESS", LOW_BRIGHTNESS);
        enumMap.put("LOW_SHARPNESS", LOW_SHARPNESS);
        enumMap.put("LOW_CONFIDENCE", LOW_CONFIDENCE);
        enumMap.put("SMALL_BOUNDING_BOX", SMALL_BOUNDING_BOX);
        enumMap.put("LOW_FACE_QUALITY", LOW_FACE_QUALITY);
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value real value
     * @return Reason corresponding to the value
     */
    public static Reason fromValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if (enumMap.containsKey(value)) {
            return enumMap.get(value);
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        }
    }
}
