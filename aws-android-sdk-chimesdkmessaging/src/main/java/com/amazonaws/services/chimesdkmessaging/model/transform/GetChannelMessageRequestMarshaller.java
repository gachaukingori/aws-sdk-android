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

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

import android.text.TextUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.chimesdkmessaging.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

import android.net.Uri;

/**
 * JSON request marshaller for GetChannelMessageRequest
 */
public class GetChannelMessageRequestMarshaller implements
        Marshaller<Request<GetChannelMessageRequest>, GetChannelMessageRequest> {

    public Request<GetChannelMessageRequest> marshall(
            GetChannelMessageRequest getChannelMessageRequest) {
        if (getChannelMessageRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(GetChannelMessageRequest)");
        }

        Request<GetChannelMessageRequest> request = new DefaultRequest<GetChannelMessageRequest>(
                getChannelMessageRequest, "AmazonChimeSDKMessaging");
        request.setHttpMethod(HttpMethodName.GET);

        if (getChannelMessageRequest.getChimeBearer() != null) {
            request.addHeader("x-amz-chime-bearer",
                    StringUtils.fromString(getChannelMessageRequest.getChimeBearer()));
        }
        String uriResourcePath = "/channels/{channelArn}/messages/{messageId}";
        uriResourcePath = uriResourcePath.replace(
                "{channelArn}",
                (getChannelMessageRequest.getChannelArn() == null) ? "" : StringUtils
                        .fromString(getChannelMessageRequest.getChannelArn()));
        uriResourcePath = uriResourcePath.replace(
                "{messageId}",
                (getChannelMessageRequest.getMessageId() == null) ? "" : StringUtils
                        .fromString(getChannelMessageRequest.getMessageId()));
        request.setResourcePath(uriResourcePath);
        String encodedUriResourcePath = "/channels/{channelArn}/messages/{messageId}";
        encodedUriResourcePath = encodedUriResourcePath.replace(
                "{channelArn}",
                (getChannelMessageRequest.getChannelArn() == null) ? "" : Uri.encode(StringUtils
                        .fromString(getChannelMessageRequest.getChannelArn())));
        encodedUriResourcePath = encodedUriResourcePath.replace(
                "{messageId}",
                (getChannelMessageRequest.getMessageId() == null) ? "" : Uri.encode(StringUtils
                        .fromString(getChannelMessageRequest.getMessageId())));
        request.setEncodedResourcePath(encodedUriResourcePath);
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", "application/x-amz-json-1.0");
        }

        return request;
    }
}
