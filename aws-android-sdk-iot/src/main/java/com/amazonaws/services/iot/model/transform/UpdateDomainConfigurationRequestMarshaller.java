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
import com.amazonaws.services.iot.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * JSON request marshaller for UpdateDomainConfigurationRequest
 */
public class UpdateDomainConfigurationRequestMarshaller implements
        Marshaller<Request<UpdateDomainConfigurationRequest>, UpdateDomainConfigurationRequest> {

    public Request<UpdateDomainConfigurationRequest> marshall(
            UpdateDomainConfigurationRequest updateDomainConfigurationRequest) {
        if (updateDomainConfigurationRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(UpdateDomainConfigurationRequest)");
        }

        Request<UpdateDomainConfigurationRequest> request = new DefaultRequest<UpdateDomainConfigurationRequest>(
                updateDomainConfigurationRequest, "AWSIot");
        request.setHttpMethod(HttpMethodName.PUT);

        String uriResourcePath = "/domainConfigurations/{domainConfigurationName}";
        uriResourcePath = uriResourcePath.replace(
                "{domainConfigurationName}",
                (updateDomainConfigurationRequest.getDomainConfigurationName() == null) ? ""
                        : StringUtils.fromString(updateDomainConfigurationRequest
                                .getDomainConfigurationName()));
        request.setResourcePath(uriResourcePath);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();

            if (updateDomainConfigurationRequest.getAuthorizerConfig() != null) {
                AuthorizerConfig authorizerConfig = updateDomainConfigurationRequest
                        .getAuthorizerConfig();
                jsonWriter.name("authorizerConfig");
                AuthorizerConfigJsonMarshaller.getInstance().marshall(authorizerConfig, jsonWriter);
            }
            if (updateDomainConfigurationRequest.getDomainConfigurationStatus() != null) {
                String domainConfigurationStatus = updateDomainConfigurationRequest
                        .getDomainConfigurationStatus();
                jsonWriter.name("domainConfigurationStatus");
                jsonWriter.value(domainConfigurationStatus);
            }
            if (updateDomainConfigurationRequest.getRemoveAuthorizerConfig() != null) {
                Boolean removeAuthorizerConfig = updateDomainConfigurationRequest
                        .getRemoveAuthorizerConfig();
                jsonWriter.name("removeAuthorizerConfig");
                jsonWriter.value(removeAuthorizerConfig);
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
