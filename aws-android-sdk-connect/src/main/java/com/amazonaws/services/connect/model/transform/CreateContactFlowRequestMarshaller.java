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
import com.amazonaws.services.connect.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * JSON request marshaller for CreateContactFlowRequest
 */
public class CreateContactFlowRequestMarshaller implements
        Marshaller<Request<CreateContactFlowRequest>, CreateContactFlowRequest> {

    public Request<CreateContactFlowRequest> marshall(
            CreateContactFlowRequest createContactFlowRequest) {
        if (createContactFlowRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(CreateContactFlowRequest)");
        }

        Request<CreateContactFlowRequest> request = new DefaultRequest<CreateContactFlowRequest>(
                createContactFlowRequest, "AmazonConnect");
        request.setHttpMethod(HttpMethodName.PUT);

        String uriResourcePath = "/contact-flows/{InstanceId}";
        uriResourcePath = uriResourcePath.replace(
                "{InstanceId}",
                (createContactFlowRequest.getInstanceId() == null) ? "" : StringUtils
                        .fromString(createContactFlowRequest.getInstanceId()));
        request.setResourcePath(uriResourcePath);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();

            if (createContactFlowRequest.getName() != null) {
                String name = createContactFlowRequest.getName();
                jsonWriter.name("Name");
                jsonWriter.value(name);
            }
            if (createContactFlowRequest.getType() != null) {
                String type = createContactFlowRequest.getType();
                jsonWriter.name("Type");
                jsonWriter.value(type);
            }
            if (createContactFlowRequest.getDescription() != null) {
                String description = createContactFlowRequest.getDescription();
                jsonWriter.name("Description");
                jsonWriter.value(description);
            }
            if (createContactFlowRequest.getContent() != null) {
                String content = createContactFlowRequest.getContent();
                jsonWriter.name("Content");
                jsonWriter.value(content);
            }
            if (createContactFlowRequest.getTags() != null) {
                java.util.Map<String, String> tags = createContactFlowRequest.getTags();
                jsonWriter.name("Tags");
                jsonWriter.beginObject();
                for (java.util.Map.Entry<String, String> tagsEntry : tags.entrySet()) {
                    String tagsValue = tagsEntry.getValue();
                    if (tagsValue != null) {
                        jsonWriter.name(tagsEntry.getKey());
                        jsonWriter.value(tagsValue);
                    }
                }
                jsonWriter.endObject();
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
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        }

        return request;
    }
}
