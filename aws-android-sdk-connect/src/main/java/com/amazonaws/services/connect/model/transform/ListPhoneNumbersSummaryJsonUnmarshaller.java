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

package com.amazonaws.services.connect.model.transform;

import com.amazonaws.services.connect.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for POJO ListPhoneNumbersSummary
 */
class ListPhoneNumbersSummaryJsonUnmarshaller implements
        Unmarshaller<ListPhoneNumbersSummary, JsonUnmarshallerContext> {

    public ListPhoneNumbersSummary unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ListPhoneNumbersSummary listPhoneNumbersSummary = new ListPhoneNumbersSummary();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("PhoneNumberId")) {
                listPhoneNumbersSummary.setPhoneNumberId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("PhoneNumberArn")) {
                listPhoneNumbersSummary.setPhoneNumberArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("PhoneNumber")) {
                listPhoneNumbersSummary.setPhoneNumber(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("PhoneNumberCountryCode")) {
                listPhoneNumbersSummary.setPhoneNumberCountryCode(StringJsonUnmarshaller
                        .getInstance()
                        .unmarshall(context));
            } else if (name.equals("PhoneNumberType")) {
                listPhoneNumbersSummary.setPhoneNumberType(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("TargetArn")) {
                listPhoneNumbersSummary.setTargetArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listPhoneNumbersSummary;
    }

    private static ListPhoneNumbersSummaryJsonUnmarshaller instance;

    public static ListPhoneNumbersSummaryJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListPhoneNumbersSummaryJsonUnmarshaller();
        return instance;
    }
}
