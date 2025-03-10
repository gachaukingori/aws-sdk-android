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

package com.amazonaws.services.transcribe.model.transform;

import com.amazonaws.services.transcribe.model.*;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.json.AwsJsonWriter;

/**
 * JSON marshaller for POJO InterruptionFilter
 */
class InterruptionFilterJsonMarshaller {

    public void marshall(InterruptionFilter interruptionFilter, AwsJsonWriter jsonWriter)
            throws Exception {
        jsonWriter.beginObject();
        if (interruptionFilter.getThreshold() != null) {
            Long threshold = interruptionFilter.getThreshold();
            jsonWriter.name("Threshold");
            jsonWriter.value(threshold);
        }
        if (interruptionFilter.getParticipantRole() != null) {
            String participantRole = interruptionFilter.getParticipantRole();
            jsonWriter.name("ParticipantRole");
            jsonWriter.value(participantRole);
        }
        if (interruptionFilter.getAbsoluteTimeRange() != null) {
            AbsoluteTimeRange absoluteTimeRange = interruptionFilter.getAbsoluteTimeRange();
            jsonWriter.name("AbsoluteTimeRange");
            AbsoluteTimeRangeJsonMarshaller.getInstance().marshall(absoluteTimeRange, jsonWriter);
        }
        if (interruptionFilter.getRelativeTimeRange() != null) {
            RelativeTimeRange relativeTimeRange = interruptionFilter.getRelativeTimeRange();
            jsonWriter.name("RelativeTimeRange");
            RelativeTimeRangeJsonMarshaller.getInstance().marshall(relativeTimeRange, jsonWriter);
        }
        if (interruptionFilter.getNegate() != null) {
            Boolean negate = interruptionFilter.getNegate();
            jsonWriter.name("Negate");
            jsonWriter.value(negate);
        }
        jsonWriter.endObject();
    }

    private static InterruptionFilterJsonMarshaller instance;

    public static InterruptionFilterJsonMarshaller getInstance() {
        if (instance == null)
            instance = new InterruptionFilterJsonMarshaller();
        return instance;
    }
}
