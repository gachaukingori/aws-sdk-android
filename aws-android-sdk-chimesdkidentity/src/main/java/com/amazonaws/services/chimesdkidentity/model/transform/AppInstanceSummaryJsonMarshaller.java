/*
 * Copyright 2010-2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.amazonaws.services.chimesdkidentity.model.transform;

import com.amazonaws.services.chimesdkidentity.model.*;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.json.AwsJsonWriter;

/**
 * JSON marshaller for POJO AppInstanceSummary
 */
class AppInstanceSummaryJsonMarshaller {

    public void marshall(AppInstanceSummary appInstanceSummary, AwsJsonWriter jsonWriter)
            throws Exception {
        jsonWriter.beginObject();
        if (appInstanceSummary.getAppInstanceArn() != null) {
            String appInstanceArn = appInstanceSummary.getAppInstanceArn();
            jsonWriter.name("AppInstanceArn");
            jsonWriter.value(appInstanceArn);
        }
        if (appInstanceSummary.getName() != null) {
            String name = appInstanceSummary.getName();
            jsonWriter.name("Name");
            jsonWriter.value(name);
        }
        if (appInstanceSummary.getMetadata() != null) {
            String metadata = appInstanceSummary.getMetadata();
            jsonWriter.name("Metadata");
            jsonWriter.value(metadata);
        }
        jsonWriter.endObject();
    }

    private static AppInstanceSummaryJsonMarshaller instance;

    public static AppInstanceSummaryJsonMarshaller getInstance() {
        if (instance == null)
            instance = new AppInstanceSummaryJsonMarshaller();
        return instance;
    }
}
