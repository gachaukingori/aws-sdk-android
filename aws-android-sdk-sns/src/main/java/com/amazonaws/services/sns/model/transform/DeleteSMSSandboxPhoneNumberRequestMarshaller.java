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

package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.services.sns.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * StAX request marshaller for DeleteSMSSandboxPhoneNumberRequest
 */
public class DeleteSMSSandboxPhoneNumberRequestMarshaller implements
        Marshaller<Request<DeleteSMSSandboxPhoneNumberRequest>, DeleteSMSSandboxPhoneNumberRequest> {

    public Request<DeleteSMSSandboxPhoneNumberRequest> marshall(
            DeleteSMSSandboxPhoneNumberRequest deleteSMSSandboxPhoneNumberRequest) {
        if (deleteSMSSandboxPhoneNumberRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(DeleteSMSSandboxPhoneNumberRequest)");
        }

        Request<DeleteSMSSandboxPhoneNumberRequest> request = new DefaultRequest<DeleteSMSSandboxPhoneNumberRequest>(
                deleteSMSSandboxPhoneNumberRequest, "AmazonSNS");
        request.addParameter("Action", "DeleteSMSSandboxPhoneNumber");
        request.addParameter("Version", "2010-03-31");

        String prefix;
        if (deleteSMSSandboxPhoneNumberRequest.getPhoneNumber() != null) {
            prefix = "PhoneNumber";
            String phoneNumber = deleteSMSSandboxPhoneNumberRequest.getPhoneNumber();
            request.addParameter(prefix, StringUtils.fromString(phoneNumber));
        }

        return request;
    }
}
