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
 * JSON unmarshaller for POJO ThingAttribute
 */
class ThingAttributeJsonUnmarshaller implements
        Unmarshaller<ThingAttribute, JsonUnmarshallerContext> {

    public ThingAttribute unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ThingAttribute thingAttribute = new ThingAttribute();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("thingName")) {
                thingAttribute.setThingName(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("thingTypeName")) {
                thingAttribute.setThingTypeName(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("thingArn")) {
                thingAttribute.setThingArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("attributes")) {
                thingAttribute.setAttributes(new MapUnmarshaller<String>(StringJsonUnmarshaller
                        .getInstance()
                        )
                                .unmarshall(context));
            } else if (name.equals("version")) {
                thingAttribute.setVersion(LongJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return thingAttribute;
    }

    private static ThingAttributeJsonUnmarshaller instance;

    public static ThingAttributeJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ThingAttributeJsonUnmarshaller();
        return instance;
    }
}
