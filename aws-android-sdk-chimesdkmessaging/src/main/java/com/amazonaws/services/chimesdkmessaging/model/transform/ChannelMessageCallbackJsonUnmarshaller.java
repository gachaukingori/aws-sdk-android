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
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for POJO ChannelMessageCallback
 */
class ChannelMessageCallbackJsonUnmarshaller implements
        Unmarshaller<ChannelMessageCallback, JsonUnmarshallerContext> {

    public ChannelMessageCallback unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ChannelMessageCallback channelMessageCallback = new ChannelMessageCallback();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("MessageId")) {
                channelMessageCallback.setMessageId(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Content")) {
                channelMessageCallback.setContent(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Metadata")) {
                channelMessageCallback.setMetadata(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("PushNotification")) {
                channelMessageCallback
                        .setPushNotification(PushNotificationConfigurationJsonUnmarshaller
                                .getInstance()
                                .unmarshall(context));
            } else if (name.equals("MessageAttributes")) {
                channelMessageCallback
                        .setMessageAttributes(new MapUnmarshaller<MessageAttributeValue>(
                                MessageAttributeValueJsonUnmarshaller.getInstance()
                        )
                                .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return channelMessageCallback;
    }

    private static ChannelMessageCallbackJsonUnmarshaller instance;

    public static ChannelMessageCallbackJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ChannelMessageCallbackJsonUnmarshaller();
        return instance;
    }
}
