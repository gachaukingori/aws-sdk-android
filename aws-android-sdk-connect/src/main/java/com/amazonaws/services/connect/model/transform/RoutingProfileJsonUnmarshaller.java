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
 * JSON unmarshaller for POJO RoutingProfile
 */
class RoutingProfileJsonUnmarshaller implements
        Unmarshaller<RoutingProfile, JsonUnmarshallerContext> {

    public RoutingProfile unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RoutingProfile routingProfile = new RoutingProfile();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("InstanceId")) {
                routingProfile.setInstanceId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Name")) {
                routingProfile.setName(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("RoutingProfileArn")) {
                routingProfile.setRoutingProfileArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("RoutingProfileId")) {
                routingProfile.setRoutingProfileId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Description")) {
                routingProfile.setDescription(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("MediaConcurrencies")) {
                routingProfile.setMediaConcurrencies(new ListUnmarshaller<MediaConcurrency>(
                        MediaConcurrencyJsonUnmarshaller.getInstance()
                        )
                                .unmarshall(context));
            } else if (name.equals("DefaultOutboundQueueId")) {
                routingProfile.setDefaultOutboundQueueId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Tags")) {
                routingProfile.setTags(new MapUnmarshaller<String>(StringJsonUnmarshaller
                        .getInstance()
                        )
                                .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return routingProfile;
    }

    private static RoutingProfileJsonUnmarshaller instance;

    public static RoutingProfileJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new RoutingProfileJsonUnmarshaller();
        return instance;
    }
}
