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
import com.amazonaws.services.chimesdkidentity.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

import android.net.Uri;

/**
 * JSON request marshaller for CreateAppInstanceUserRequest
 */
public class CreateAppInstanceUserRequestMarshaller implements
        Marshaller<Request<CreateAppInstanceUserRequest>, CreateAppInstanceUserRequest> {

    public Request<CreateAppInstanceUserRequest> marshall(
            CreateAppInstanceUserRequest createAppInstanceUserRequest) {
        if (createAppInstanceUserRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(CreateAppInstanceUserRequest)");
        }

        Request<CreateAppInstanceUserRequest> request = new DefaultRequest<CreateAppInstanceUserRequest>(
                createAppInstanceUserRequest, "AmazonChimeSDKIdentity");
        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/app-instance-users";
        request.setResourcePath(uriResourcePath);
        String encodedUriResourcePath = "/app-instance-users";
        request.setEncodedResourcePath(encodedUriResourcePath);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();

            if (createAppInstanceUserRequest.getAppInstanceArn() != null) {
                String appInstanceArn = createAppInstanceUserRequest.getAppInstanceArn();
                jsonWriter.name("AppInstanceArn");
                jsonWriter.value(appInstanceArn);
            }
            if (createAppInstanceUserRequest.getAppInstanceUserId() != null) {
                String appInstanceUserId = createAppInstanceUserRequest.getAppInstanceUserId();
                jsonWriter.name("AppInstanceUserId");
                jsonWriter.value(appInstanceUserId);
            }
            if (createAppInstanceUserRequest.getName() != null) {
                String name = createAppInstanceUserRequest.getName();
                jsonWriter.name("Name");
                jsonWriter.value(name);
            }
            if (createAppInstanceUserRequest.getMetadata() != null) {
                String metadata = createAppInstanceUserRequest.getMetadata();
                jsonWriter.name("Metadata");
                jsonWriter.value(metadata);
            }
            if (createAppInstanceUserRequest.getClientRequestToken() != null) {
                String clientRequestToken = createAppInstanceUserRequest.getClientRequestToken();
                jsonWriter.name("ClientRequestToken");
                jsonWriter.value(clientRequestToken);
            }
            if (createAppInstanceUserRequest.getTags() != null) {
                java.util.List<Tag> tags = createAppInstanceUserRequest.getTags();
                jsonWriter.name("Tags");
                jsonWriter.beginArray();
                for (Tag tagsItem : tags) {
                    if (tagsItem != null) {
                        TagJsonMarshaller.getInstance().marshall(tagsItem, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();
            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", "application/x-amz-json-1.0");
        }

        return request;
    }
}
