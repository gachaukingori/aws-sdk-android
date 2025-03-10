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

package com.amazonaws.services.transcribe.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Creates a new custom language model.
 * </p>
 * <p>
 * When creating a new language model, you must specify:
 * </p>
 * <ul>
 * <li>
 * <p>
 * If you want a Wideband (audio sample rates over 16,000 Hz) or Narrowband
 * (audio sample rates under 16,000 Hz) base model
 * </p>
 * </li>
 * <li>
 * <p>
 * The location of your training and tuning files (this must be an Amazon S3
 * URI)
 * </p>
 * </li>
 * <li>
 * <p>
 * The language of your model
 * </p>
 * </li>
 * <li>
 * <p>
 * A unique name for your model
 * </p>
 * </li>
 * </ul>
 * <p>
 * For more information, see <a href=
 * "https://docs.aws.amazon.com/transcribe/latest/dg/custom-language-models.html"
 * >Custom language models</a>.
 * </p>
 */
public class CreateLanguageModelRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     */
    private String languageCode;

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     */
    private String baseModelName;

    /**
     * <p>
     * A unique name, chosen by you, for your custom language model.
     * </p>
     * <p>
     * This name is case sensitive, cannot contain spaces, and must be unique
     * within an Amazon Web Services account. If you try to create a new
     * language model with the same name as an existing language model, you get
     * a <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     */
    private String modelName;

    /**
     * <p>
     * Contains the Amazon S3 location of the training data you want to use to
     * create a new custom language model, and permissions to access this
     * location.
     * </p>
     * <p>
     * When using <code>InputDataConfig</code>, you must include these
     * sub-parameters: <code>S3Uri</code>, which is the Amazon S3 location of
     * your training data, and <code>DataAccessRoleArn</code>, which is the
     * Amazon Resource Name (ARN) of the role that has permission to access your
     * specified Amazon S3 location. You can optionally include
     * <code>TuningDataS3Uri</code>, which is the Amazon S3 location of your
     * tuning data. If you specify different Amazon S3 locations for training
     * and tuning data, the ARN you use must have permissions to access both
     * locations.
     * </p>
     */
    private InputDataConfig inputDataConfig;

    /**
     * <p>
     * Adds one or more custom tags, each in the form of a key:value pair, to a
     * new custom language model at the time you create this new model.
     * </p>
     * <p>
     * To learn more about using tags with Amazon Transcribe, refer to <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     * >Tagging resources</a>.
     * </p>
     */
    private java.util.List<Tag> tags;

    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     *
     * @return <p>
     *         The language code that represents the language of your model.
     *         Each language model must contain terms in only one language, and
     *         the language you select for your model must match the language of
     *         your training and tuning data.
     *         </p>
     *         <p>
     *         For a list of supported languages and their associated language
     *         codes, refer to the <a href=
     *         "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     *         >Supported languages</a> table. Note that U.S. English (
     *         <code>en-US</code>) is the only language supported with Amazon
     *         Transcribe Medical.
     *         </p>
     *         <p>
     *         A custom language model can only be used to transcribe files in
     *         the same language as the model. For example, if you create a
     *         language model using US English (<code>en-US</code>), you can
     *         only apply this model to files that contain English audio.
     *         </p>
     * @see CLMLanguageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     *
     * @param languageCode <p>
     *            The language code that represents the language of your model.
     *            Each language model must contain terms in only one language,
     *            and the language you select for your model must match the
     *            language of your training and tuning data.
     *            </p>
     *            <p>
     *            For a list of supported languages and their associated
     *            language codes, refer to the <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     *            >Supported languages</a> table. Note that U.S. English (
     *            <code>en-US</code>) is the only language supported with Amazon
     *            Transcribe Medical.
     *            </p>
     *            <p>
     *            A custom language model can only be used to transcribe files
     *            in the same language as the model. For example, if you create
     *            a language model using US English (<code>en-US</code>), you
     *            can only apply this model to files that contain English audio.
     *            </p>
     * @see CLMLanguageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     *
     * @param languageCode <p>
     *            The language code that represents the language of your model.
     *            Each language model must contain terms in only one language,
     *            and the language you select for your model must match the
     *            language of your training and tuning data.
     *            </p>
     *            <p>
     *            For a list of supported languages and their associated
     *            language codes, refer to the <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     *            >Supported languages</a> table. Note that U.S. English (
     *            <code>en-US</code>) is the only language supported with Amazon
     *            Transcribe Medical.
     *            </p>
     *            <p>
     *            A custom language model can only be used to transcribe files
     *            in the same language as the model. For example, if you create
     *            a language model using US English (<code>en-US</code>), you
     *            can only apply this model to files that contain English audio.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see CLMLanguageCode
     */
    public CreateLanguageModelRequest withLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     *
     * @param languageCode <p>
     *            The language code that represents the language of your model.
     *            Each language model must contain terms in only one language,
     *            and the language you select for your model must match the
     *            language of your training and tuning data.
     *            </p>
     *            <p>
     *            For a list of supported languages and their associated
     *            language codes, refer to the <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     *            >Supported languages</a> table. Note that U.S. English (
     *            <code>en-US</code>) is the only language supported with Amazon
     *            Transcribe Medical.
     *            </p>
     *            <p>
     *            A custom language model can only be used to transcribe files
     *            in the same language as the model. For example, if you create
     *            a language model using US English (<code>en-US</code>), you
     *            can only apply this model to files that contain English audio.
     *            </p>
     * @see CLMLanguageCode
     */
    public void setLanguageCode(CLMLanguageCode languageCode) {
        this.languageCode = languageCode.toString();
    }

    /**
     * <p>
     * The language code that represents the language of your model. Each
     * language model must contain terms in only one language, and the language
     * you select for your model must match the language of your training and
     * tuning data.
     * </p>
     * <p>
     * For a list of supported languages and their associated language codes,
     * refer to the <a href=
     * "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     * >Supported languages</a> table. Note that U.S. English (
     * <code>en-US</code>) is the only language supported with Amazon Transcribe
     * Medical.
     * </p>
     * <p>
     * A custom language model can only be used to transcribe files in the same
     * language as the model. For example, if you create a language model using
     * US English (<code>en-US</code>), you can only apply this model to files
     * that contain English audio.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>en-US, hi-IN, es-US, en-GB, en-AU
     *
     * @param languageCode <p>
     *            The language code that represents the language of your model.
     *            Each language model must contain terms in only one language,
     *            and the language you select for your model must match the
     *            language of your training and tuning data.
     *            </p>
     *            <p>
     *            For a list of supported languages and their associated
     *            language codes, refer to the <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/supported-languages.html"
     *            >Supported languages</a> table. Note that U.S. English (
     *            <code>en-US</code>) is the only language supported with Amazon
     *            Transcribe Medical.
     *            </p>
     *            <p>
     *            A custom language model can only be used to transcribe files
     *            in the same language as the model. For example, if you create
     *            a language model using US English (<code>en-US</code>), you
     *            can only apply this model to files that contain English audio.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see CLMLanguageCode
     */
    public CreateLanguageModelRequest withLanguageCode(CLMLanguageCode languageCode) {
        this.languageCode = languageCode.toString();
        return this;
    }

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     *
     * @return <p>
     *         The Amazon Transcribe standard language model, or base model,
     *         used to create your custom language model. Amazon Transcribe
     *         offers two options for base models: Wideband and Narrowband.
     *         </p>
     *         <p>
     *         If the audio you want to transcribe has a sample rate of 16,000
     *         Hz or greater, choose <code>WideBand</code>. To transcribe audio
     *         with a sample rate less than 16,000 Hz, choose
     *         <code>NarrowBand</code>.
     *         </p>
     * @see BaseModelName
     */
    public String getBaseModelName() {
        return baseModelName;
    }

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     *
     * @param baseModelName <p>
     *            The Amazon Transcribe standard language model, or base model,
     *            used to create your custom language model. Amazon Transcribe
     *            offers two options for base models: Wideband and Narrowband.
     *            </p>
     *            <p>
     *            If the audio you want to transcribe has a sample rate of
     *            16,000 Hz or greater, choose <code>WideBand</code>. To
     *            transcribe audio with a sample rate less than 16,000 Hz,
     *            choose <code>NarrowBand</code>.
     *            </p>
     * @see BaseModelName
     */
    public void setBaseModelName(String baseModelName) {
        this.baseModelName = baseModelName;
    }

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     *
     * @param baseModelName <p>
     *            The Amazon Transcribe standard language model, or base model,
     *            used to create your custom language model. Amazon Transcribe
     *            offers two options for base models: Wideband and Narrowband.
     *            </p>
     *            <p>
     *            If the audio you want to transcribe has a sample rate of
     *            16,000 Hz or greater, choose <code>WideBand</code>. To
     *            transcribe audio with a sample rate less than 16,000 Hz,
     *            choose <code>NarrowBand</code>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see BaseModelName
     */
    public CreateLanguageModelRequest withBaseModelName(String baseModelName) {
        this.baseModelName = baseModelName;
        return this;
    }

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     *
     * @param baseModelName <p>
     *            The Amazon Transcribe standard language model, or base model,
     *            used to create your custom language model. Amazon Transcribe
     *            offers two options for base models: Wideband and Narrowband.
     *            </p>
     *            <p>
     *            If the audio you want to transcribe has a sample rate of
     *            16,000 Hz or greater, choose <code>WideBand</code>. To
     *            transcribe audio with a sample rate less than 16,000 Hz,
     *            choose <code>NarrowBand</code>.
     *            </p>
     * @see BaseModelName
     */
    public void setBaseModelName(BaseModelName baseModelName) {
        this.baseModelName = baseModelName.toString();
    }

    /**
     * <p>
     * The Amazon Transcribe standard language model, or base model, used to
     * create your custom language model. Amazon Transcribe offers two options
     * for base models: Wideband and Narrowband.
     * </p>
     * <p>
     * If the audio you want to transcribe has a sample rate of 16,000 Hz or
     * greater, choose <code>WideBand</code>. To transcribe audio with a sample
     * rate less than 16,000 Hz, choose <code>NarrowBand</code>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>NarrowBand, WideBand
     *
     * @param baseModelName <p>
     *            The Amazon Transcribe standard language model, or base model,
     *            used to create your custom language model. Amazon Transcribe
     *            offers two options for base models: Wideband and Narrowband.
     *            </p>
     *            <p>
     *            If the audio you want to transcribe has a sample rate of
     *            16,000 Hz or greater, choose <code>WideBand</code>. To
     *            transcribe audio with a sample rate less than 16,000 Hz,
     *            choose <code>NarrowBand</code>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see BaseModelName
     */
    public CreateLanguageModelRequest withBaseModelName(BaseModelName baseModelName) {
        this.baseModelName = baseModelName.toString();
        return this;
    }

    /**
     * <p>
     * A unique name, chosen by you, for your custom language model.
     * </p>
     * <p>
     * This name is case sensitive, cannot contain spaces, and must be unique
     * within an Amazon Web Services account. If you try to create a new
     * language model with the same name as an existing language model, you get
     * a <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @return <p>
     *         A unique name, chosen by you, for your custom language model.
     *         </p>
     *         <p>
     *         This name is case sensitive, cannot contain spaces, and must be
     *         unique within an Amazon Web Services account. If you try to
     *         create a new language model with the same name as an existing
     *         language model, you get a <code>ConflictException</code> error.
     *         </p>
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * <p>
     * A unique name, chosen by you, for your custom language model.
     * </p>
     * <p>
     * This name is case sensitive, cannot contain spaces, and must be unique
     * within an Amazon Web Services account. If you try to create a new
     * language model with the same name as an existing language model, you get
     * a <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @param modelName <p>
     *            A unique name, chosen by you, for your custom language model.
     *            </p>
     *            <p>
     *            This name is case sensitive, cannot contain spaces, and must
     *            be unique within an Amazon Web Services account. If you try to
     *            create a new language model with the same name as an existing
     *            language model, you get a <code>ConflictException</code>
     *            error.
     *            </p>
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * <p>
     * A unique name, chosen by you, for your custom language model.
     * </p>
     * <p>
     * This name is case sensitive, cannot contain spaces, and must be unique
     * within an Amazon Web Services account. If you try to create a new
     * language model with the same name as an existing language model, you get
     * a <code>ConflictException</code> error.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @param modelName <p>
     *            A unique name, chosen by you, for your custom language model.
     *            </p>
     *            <p>
     *            This name is case sensitive, cannot contain spaces, and must
     *            be unique within an Amazon Web Services account. If you try to
     *            create a new language model with the same name as an existing
     *            language model, you get a <code>ConflictException</code>
     *            error.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateLanguageModelRequest withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    /**
     * <p>
     * Contains the Amazon S3 location of the training data you want to use to
     * create a new custom language model, and permissions to access this
     * location.
     * </p>
     * <p>
     * When using <code>InputDataConfig</code>, you must include these
     * sub-parameters: <code>S3Uri</code>, which is the Amazon S3 location of
     * your training data, and <code>DataAccessRoleArn</code>, which is the
     * Amazon Resource Name (ARN) of the role that has permission to access your
     * specified Amazon S3 location. You can optionally include
     * <code>TuningDataS3Uri</code>, which is the Amazon S3 location of your
     * tuning data. If you specify different Amazon S3 locations for training
     * and tuning data, the ARN you use must have permissions to access both
     * locations.
     * </p>
     *
     * @return <p>
     *         Contains the Amazon S3 location of the training data you want to
     *         use to create a new custom language model, and permissions to
     *         access this location.
     *         </p>
     *         <p>
     *         When using <code>InputDataConfig</code>, you must include these
     *         sub-parameters: <code>S3Uri</code>, which is the Amazon S3
     *         location of your training data, and
     *         <code>DataAccessRoleArn</code>, which is the Amazon Resource Name
     *         (ARN) of the role that has permission to access your specified
     *         Amazon S3 location. You can optionally include
     *         <code>TuningDataS3Uri</code>, which is the Amazon S3 location of
     *         your tuning data. If you specify different Amazon S3 locations
     *         for training and tuning data, the ARN you use must have
     *         permissions to access both locations.
     *         </p>
     */
    public InputDataConfig getInputDataConfig() {
        return inputDataConfig;
    }

    /**
     * <p>
     * Contains the Amazon S3 location of the training data you want to use to
     * create a new custom language model, and permissions to access this
     * location.
     * </p>
     * <p>
     * When using <code>InputDataConfig</code>, you must include these
     * sub-parameters: <code>S3Uri</code>, which is the Amazon S3 location of
     * your training data, and <code>DataAccessRoleArn</code>, which is the
     * Amazon Resource Name (ARN) of the role that has permission to access your
     * specified Amazon S3 location. You can optionally include
     * <code>TuningDataS3Uri</code>, which is the Amazon S3 location of your
     * tuning data. If you specify different Amazon S3 locations for training
     * and tuning data, the ARN you use must have permissions to access both
     * locations.
     * </p>
     *
     * @param inputDataConfig <p>
     *            Contains the Amazon S3 location of the training data you want
     *            to use to create a new custom language model, and permissions
     *            to access this location.
     *            </p>
     *            <p>
     *            When using <code>InputDataConfig</code>, you must include
     *            these sub-parameters: <code>S3Uri</code>, which is the Amazon
     *            S3 location of your training data, and
     *            <code>DataAccessRoleArn</code>, which is the Amazon Resource
     *            Name (ARN) of the role that has permission to access your
     *            specified Amazon S3 location. You can optionally include
     *            <code>TuningDataS3Uri</code>, which is the Amazon S3 location
     *            of your tuning data. If you specify different Amazon S3
     *            locations for training and tuning data, the ARN you use must
     *            have permissions to access both locations.
     *            </p>
     */
    public void setInputDataConfig(InputDataConfig inputDataConfig) {
        this.inputDataConfig = inputDataConfig;
    }

    /**
     * <p>
     * Contains the Amazon S3 location of the training data you want to use to
     * create a new custom language model, and permissions to access this
     * location.
     * </p>
     * <p>
     * When using <code>InputDataConfig</code>, you must include these
     * sub-parameters: <code>S3Uri</code>, which is the Amazon S3 location of
     * your training data, and <code>DataAccessRoleArn</code>, which is the
     * Amazon Resource Name (ARN) of the role that has permission to access your
     * specified Amazon S3 location. You can optionally include
     * <code>TuningDataS3Uri</code>, which is the Amazon S3 location of your
     * tuning data. If you specify different Amazon S3 locations for training
     * and tuning data, the ARN you use must have permissions to access both
     * locations.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param inputDataConfig <p>
     *            Contains the Amazon S3 location of the training data you want
     *            to use to create a new custom language model, and permissions
     *            to access this location.
     *            </p>
     *            <p>
     *            When using <code>InputDataConfig</code>, you must include
     *            these sub-parameters: <code>S3Uri</code>, which is the Amazon
     *            S3 location of your training data, and
     *            <code>DataAccessRoleArn</code>, which is the Amazon Resource
     *            Name (ARN) of the role that has permission to access your
     *            specified Amazon S3 location. You can optionally include
     *            <code>TuningDataS3Uri</code>, which is the Amazon S3 location
     *            of your tuning data. If you specify different Amazon S3
     *            locations for training and tuning data, the ARN you use must
     *            have permissions to access both locations.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateLanguageModelRequest withInputDataConfig(InputDataConfig inputDataConfig) {
        this.inputDataConfig = inputDataConfig;
        return this;
    }

    /**
     * <p>
     * Adds one or more custom tags, each in the form of a key:value pair, to a
     * new custom language model at the time you create this new model.
     * </p>
     * <p>
     * To learn more about using tags with Amazon Transcribe, refer to <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     * >Tagging resources</a>.
     * </p>
     *
     * @return <p>
     *         Adds one or more custom tags, each in the form of a key:value
     *         pair, to a new custom language model at the time you create this
     *         new model.
     *         </p>
     *         <p>
     *         To learn more about using tags with Amazon Transcribe, refer to
     *         <a href=
     *         "https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     *         >Tagging resources</a>.
     *         </p>
     */
    public java.util.List<Tag> getTags() {
        return tags;
    }

    /**
     * <p>
     * Adds one or more custom tags, each in the form of a key:value pair, to a
     * new custom language model at the time you create this new model.
     * </p>
     * <p>
     * To learn more about using tags with Amazon Transcribe, refer to <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     * >Tagging resources</a>.
     * </p>
     *
     * @param tags <p>
     *            Adds one or more custom tags, each in the form of a key:value
     *            pair, to a new custom language model at the time you create
     *            this new model.
     *            </p>
     *            <p>
     *            To learn more about using tags with Amazon Transcribe, refer
     *            to <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     *            >Tagging resources</a>.
     *            </p>
     */
    public void setTags(java.util.Collection<Tag> tags) {
        if (tags == null) {
            this.tags = null;
            return;
        }

        this.tags = new java.util.ArrayList<Tag>(tags);
    }

    /**
     * <p>
     * Adds one or more custom tags, each in the form of a key:value pair, to a
     * new custom language model at the time you create this new model.
     * </p>
     * <p>
     * To learn more about using tags with Amazon Transcribe, refer to <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     * >Tagging resources</a>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tags <p>
     *            Adds one or more custom tags, each in the form of a key:value
     *            pair, to a new custom language model at the time you create
     *            this new model.
     *            </p>
     *            <p>
     *            To learn more about using tags with Amazon Transcribe, refer
     *            to <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     *            >Tagging resources</a>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateLanguageModelRequest withTags(Tag... tags) {
        if (getTags() == null) {
            this.tags = new java.util.ArrayList<Tag>(tags.length);
        }
        for (Tag value : tags) {
            this.tags.add(value);
        }
        return this;
    }

    /**
     * <p>
     * Adds one or more custom tags, each in the form of a key:value pair, to a
     * new custom language model at the time you create this new model.
     * </p>
     * <p>
     * To learn more about using tags with Amazon Transcribe, refer to <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     * >Tagging resources</a>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tags <p>
     *            Adds one or more custom tags, each in the form of a key:value
     *            pair, to a new custom language model at the time you create
     *            this new model.
     *            </p>
     *            <p>
     *            To learn more about using tags with Amazon Transcribe, refer
     *            to <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/tagging.html"
     *            >Tagging resources</a>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateLanguageModelRequest withTags(java.util.Collection<Tag> tags) {
        setTags(tags);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLanguageCode() != null)
            sb.append("LanguageCode: " + getLanguageCode() + ",");
        if (getBaseModelName() != null)
            sb.append("BaseModelName: " + getBaseModelName() + ",");
        if (getModelName() != null)
            sb.append("ModelName: " + getModelName() + ",");
        if (getInputDataConfig() != null)
            sb.append("InputDataConfig: " + getInputDataConfig() + ",");
        if (getTags() != null)
            sb.append("Tags: " + getTags());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getLanguageCode() == null) ? 0 : getLanguageCode().hashCode());
        hashCode = prime * hashCode
                + ((getBaseModelName() == null) ? 0 : getBaseModelName().hashCode());
        hashCode = prime * hashCode + ((getModelName() == null) ? 0 : getModelName().hashCode());
        hashCode = prime * hashCode
                + ((getInputDataConfig() == null) ? 0 : getInputDataConfig().hashCode());
        hashCode = prime * hashCode + ((getTags() == null) ? 0 : getTags().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateLanguageModelRequest == false)
            return false;
        CreateLanguageModelRequest other = (CreateLanguageModelRequest) obj;

        if (other.getLanguageCode() == null ^ this.getLanguageCode() == null)
            return false;
        if (other.getLanguageCode() != null
                && other.getLanguageCode().equals(this.getLanguageCode()) == false)
            return false;
        if (other.getBaseModelName() == null ^ this.getBaseModelName() == null)
            return false;
        if (other.getBaseModelName() != null
                && other.getBaseModelName().equals(this.getBaseModelName()) == false)
            return false;
        if (other.getModelName() == null ^ this.getModelName() == null)
            return false;
        if (other.getModelName() != null
                && other.getModelName().equals(this.getModelName()) == false)
            return false;
        if (other.getInputDataConfig() == null ^ this.getInputDataConfig() == null)
            return false;
        if (other.getInputDataConfig() != null
                && other.getInputDataConfig().equals(this.getInputDataConfig()) == false)
            return false;
        if (other.getTags() == null ^ this.getTags() == null)
            return false;
        if (other.getTags() != null && other.getTags().equals(this.getTags()) == false)
            return false;
        return true;
    }
}
