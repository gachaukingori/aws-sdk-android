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

package com.amazonaws.services.iot.model.transform;

import com.amazonaws.services.iot.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for POJO JobSummary
 */
class JobSummaryJsonUnmarshaller implements Unmarshaller<JobSummary, JsonUnmarshallerContext> {

    public JobSummary unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        JobSummary jobSummary = new JobSummary();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("jobArn")) {
                jobSummary.setJobArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("jobId")) {
                jobSummary.setJobId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("thingGroupId")) {
                jobSummary.setThingGroupId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("targetSelection")) {
                jobSummary.setTargetSelection(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("status")) {
                jobSummary.setStatus(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("createdAt")) {
                jobSummary.setCreatedAt(DateJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("lastUpdatedAt")) {
                jobSummary.setLastUpdatedAt(DateJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("completedAt")) {
                jobSummary.setCompletedAt(DateJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("isConcurrent")) {
                jobSummary.setIsConcurrent(BooleanJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return jobSummary;
    }

    private static JobSummaryJsonUnmarshaller instance;

    public static JobSummaryJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new JobSummaryJsonUnmarshaller();
        return instance;
    }
}
