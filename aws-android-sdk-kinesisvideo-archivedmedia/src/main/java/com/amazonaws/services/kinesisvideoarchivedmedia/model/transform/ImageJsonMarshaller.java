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

package com.amazonaws.services.kinesisvideoarchivedmedia.model.transform;

import com.amazonaws.services.kinesisvideoarchivedmedia.model.*;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.json.AwsJsonWriter;

/**
 * JSON marshaller for POJO Image
 */
class ImageJsonMarshaller {

    public void marshall(Image image, AwsJsonWriter jsonWriter) throws Exception {
        jsonWriter.beginObject();
        if (image.getTimeStamp() != null) {
            java.util.Date timeStamp = image.getTimeStamp();
            jsonWriter.name("TimeStamp");
            jsonWriter.value(timeStamp);
        }
        if (image.getError() != null) {
            String error = image.getError();
            jsonWriter.name("Error");
            jsonWriter.value(error);
        }
        if (image.getImageContent() != null) {
            String imageContent = image.getImageContent();
            jsonWriter.name("ImageContent");
            jsonWriter.value(imageContent);
        }
        jsonWriter.endObject();
    }

    private static ImageJsonMarshaller instance;

    public static ImageJsonMarshaller getInstance() {
        if (instance == null)
            instance = new ImageJsonMarshaller();
        return instance;
    }
}
