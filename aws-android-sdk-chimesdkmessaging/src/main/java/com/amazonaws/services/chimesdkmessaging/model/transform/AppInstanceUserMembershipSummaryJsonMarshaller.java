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

package com.amazonaws.services.chimesdkmessaging.model.transform;

import com.amazonaws.services.chimesdkmessaging.model.*;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.json.AwsJsonWriter;

/**
 * JSON marshaller for POJO AppInstanceUserMembershipSummary
 */
class AppInstanceUserMembershipSummaryJsonMarshaller {

    public void marshall(AppInstanceUserMembershipSummary appInstanceUserMembershipSummary,
            AwsJsonWriter jsonWriter) throws Exception {
        jsonWriter.beginObject();
        if (appInstanceUserMembershipSummary.getType() != null) {
            String type = appInstanceUserMembershipSummary.getType();
            jsonWriter.name("Type");
            jsonWriter.value(type);
        }
        if (appInstanceUserMembershipSummary.getReadMarkerTimestamp() != null) {
            java.util.Date readMarkerTimestamp = appInstanceUserMembershipSummary
                    .getReadMarkerTimestamp();
            jsonWriter.name("ReadMarkerTimestamp");
            jsonWriter.value(readMarkerTimestamp);
        }
        jsonWriter.endObject();
    }

    private static AppInstanceUserMembershipSummaryJsonMarshaller instance;

    public static AppInstanceUserMembershipSummaryJsonMarshaller getInstance() {
        if (instance == null)
            instance = new AppInstanceUserMembershipSummaryJsonMarshaller();
        return instance;
    }
}
