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

package com.amazonaws.services.rekognition.model.transform;

import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.json.AwsJsonWriter;

/**
 * JSON marshaller for POJO ValidationData
 */
class ValidationDataJsonMarshaller {

    public void marshall(ValidationData validationData, AwsJsonWriter jsonWriter) throws Exception {
        jsonWriter.beginObject();
        if (validationData.getAssets() != null) {
            java.util.List<Asset> assets = validationData.getAssets();
            jsonWriter.name("Assets");
            jsonWriter.beginArray();
            for (Asset assetsItem : assets) {
                if (assetsItem != null) {
                    AssetJsonMarshaller.getInstance().marshall(assetsItem, jsonWriter);
                }
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    private static ValidationDataJsonMarshaller instance;

    public static ValidationDataJsonMarshaller getInstance() {
        if (instance == null)
            instance = new ValidationDataJsonMarshaller();
        return instance;
    }
}
