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

package com.amazonaws.services.transcribe.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Creates a new custom vocabulary that you can use to change the way Amazon
 * Transcribe handles transcription of an audio file.
 * </p>
 */
public class CreateVocabularyRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The name of the vocabulary. The name must be unique within an Amazon Web
     * Services account. The name is case sensitive. If you try to create a
     * vocabulary with the same name as a previous vocabulary you will receive a
     * <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     */
    private String vocabularyName;

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     */
    private String languageCode;

    /**
     * <p>
     * An array of strings that contains the vocabulary entries.
     * </p>
     */
    private java.util.List<String> phrases;

    /**
     * <p>
     * The S3 location of the text file that contains the definition of the
     * custom vocabulary. The URI must be in the same region as the API endpoint
     * that you are calling. The general form is:
     * </p>
     * <p>
     * For more information about S3 object names, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     * >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     * </p>
     * <p>
     * For more information about custom vocabularies, see <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     * >Custom vocabularies</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2000<br/>
     * <b>Pattern: </b>(s3://|http(s*)://).+<br/>
     */
    private String vocabularyFileUri;

    /**
     * <p>
     * Adds one or more tags, each in the form of a key:value pair, to a new
     * Amazon Transcribe vocabulary at the time you create this new vocabulary.
     * </p>
     */
    private java.util.List<Tag> tags;

    /**
     * <p>
     * The name of the vocabulary. The name must be unique within an Amazon Web
     * Services account. The name is case sensitive. If you try to create a
     * vocabulary with the same name as a previous vocabulary you will receive a
     * <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @return <p>
     *         The name of the vocabulary. The name must be unique within an
     *         Amazon Web Services account. The name is case sensitive. If you
     *         try to create a vocabulary with the same name as a previous
     *         vocabulary you will receive a <code>ConflictException</code>
     *         error.
     *         </p>
     */
    public String getVocabularyName() {
        return vocabularyName;
    }

    /**
     * <p>
     * The name of the vocabulary. The name must be unique within an Amazon Web
     * Services account. The name is case sensitive. If you try to create a
     * vocabulary with the same name as a previous vocabulary you will receive a
     * <code>ConflictException</code> error.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @param vocabularyName <p>
     *            The name of the vocabulary. The name must be unique within an
     *            Amazon Web Services account. The name is case sensitive. If
     *            you try to create a vocabulary with the same name as a
     *            previous vocabulary you will receive a
     *            <code>ConflictException</code> error.
     *            </p>
     */
    public void setVocabularyName(String vocabularyName) {
        this.vocabularyName = vocabularyName;
    }

    /**
     * <p>
     * The name of the vocabulary. The name must be unique within an Amazon Web
     * Services account. The name is case sensitive. If you try to create a
     * vocabulary with the same name as a previous vocabulary you will receive a
     * <code>ConflictException</code> error.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @param vocabularyName <p>
     *            The name of the vocabulary. The name must be unique within an
     *            Amazon Web Services account. The name is case sensitive. If
     *            you try to create a vocabulary with the same name as a
     *            previous vocabulary you will receive a
     *            <code>ConflictException</code> error.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withVocabularyName(String vocabularyName) {
        this.vocabularyName = vocabularyName;
        return this;
    }

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     *
     * @return <p>
     *         The language code of the vocabulary entries. For a list of
     *         languages and their corresponding language codes, see
     *         <a>transcribe-whatis</a>.
     *         </p>
     * @see LanguageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     *
     * @param languageCode <p>
     *            The language code of the vocabulary entries. For a list of
     *            languages and their corresponding language codes, see
     *            <a>transcribe-whatis</a>.
     *            </p>
     * @see LanguageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     *
     * @param languageCode <p>
     *            The language code of the vocabulary entries. For a list of
     *            languages and their corresponding language codes, see
     *            <a>transcribe-whatis</a>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see LanguageCode
     */
    public CreateVocabularyRequest withLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     *
     * @param languageCode <p>
     *            The language code of the vocabulary entries. For a list of
     *            languages and their corresponding language codes, see
     *            <a>transcribe-whatis</a>.
     *            </p>
     * @see LanguageCode
     */
    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode.toString();
    }

    /**
     * <p>
     * The language code of the vocabulary entries. For a list of languages and
     * their corresponding language codes, see <a>transcribe-whatis</a>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>af-ZA, ar-AE, ar-SA, cy-GB, da-DK, de-CH, de-DE,
     * en-AB, en-AU, en-GB, en-IE, en-IN, en-US, en-WL, es-ES, es-US, fa-IR,
     * fr-CA, fr-FR, ga-IE, gd-GB, he-IL, hi-IN, id-ID, it-IT, ja-JP, ko-KR,
     * ms-MY, nl-NL, pt-BR, pt-PT, ru-RU, ta-IN, te-IN, tr-TR, zh-CN, zh-TW,
     * th-TH, en-ZA, en-NZ
     *
     * @param languageCode <p>
     *            The language code of the vocabulary entries. For a list of
     *            languages and their corresponding language codes, see
     *            <a>transcribe-whatis</a>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see LanguageCode
     */
    public CreateVocabularyRequest withLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode.toString();
        return this;
    }

    /**
     * <p>
     * An array of strings that contains the vocabulary entries.
     * </p>
     *
     * @return <p>
     *         An array of strings that contains the vocabulary entries.
     *         </p>
     */
    public java.util.List<String> getPhrases() {
        return phrases;
    }

    /**
     * <p>
     * An array of strings that contains the vocabulary entries.
     * </p>
     *
     * @param phrases <p>
     *            An array of strings that contains the vocabulary entries.
     *            </p>
     */
    public void setPhrases(java.util.Collection<String> phrases) {
        if (phrases == null) {
            this.phrases = null;
            return;
        }

        this.phrases = new java.util.ArrayList<String>(phrases);
    }

    /**
     * <p>
     * An array of strings that contains the vocabulary entries.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param phrases <p>
     *            An array of strings that contains the vocabulary entries.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withPhrases(String... phrases) {
        if (getPhrases() == null) {
            this.phrases = new java.util.ArrayList<String>(phrases.length);
        }
        for (String value : phrases) {
            this.phrases.add(value);
        }
        return this;
    }

    /**
     * <p>
     * An array of strings that contains the vocabulary entries.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param phrases <p>
     *            An array of strings that contains the vocabulary entries.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withPhrases(java.util.Collection<String> phrases) {
        setPhrases(phrases);
        return this;
    }

    /**
     * <p>
     * The S3 location of the text file that contains the definition of the
     * custom vocabulary. The URI must be in the same region as the API endpoint
     * that you are calling. The general form is:
     * </p>
     * <p>
     * For more information about S3 object names, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     * >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     * </p>
     * <p>
     * For more information about custom vocabularies, see <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     * >Custom vocabularies</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2000<br/>
     * <b>Pattern: </b>(s3://|http(s*)://).+<br/>
     *
     * @return <p>
     *         The S3 location of the text file that contains the definition of
     *         the custom vocabulary. The URI must be in the same region as the
     *         API endpoint that you are calling. The general form is:
     *         </p>
     *         <p>
     *         For more information about S3 object names, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     *         >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     *         </p>
     *         <p>
     *         For more information about custom vocabularies, see <a href=
     *         "https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     *         >Custom vocabularies</a>.
     *         </p>
     */
    public String getVocabularyFileUri() {
        return vocabularyFileUri;
    }

    /**
     * <p>
     * The S3 location of the text file that contains the definition of the
     * custom vocabulary. The URI must be in the same region as the API endpoint
     * that you are calling. The general form is:
     * </p>
     * <p>
     * For more information about S3 object names, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     * >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     * </p>
     * <p>
     * For more information about custom vocabularies, see <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     * >Custom vocabularies</a>.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2000<br/>
     * <b>Pattern: </b>(s3://|http(s*)://).+<br/>
     *
     * @param vocabularyFileUri <p>
     *            The S3 location of the text file that contains the definition
     *            of the custom vocabulary. The URI must be in the same region
     *            as the API endpoint that you are calling. The general form is:
     *            </p>
     *            <p>
     *            For more information about S3 object names, see <a href=
     *            "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     *            >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     *            </p>
     *            <p>
     *            For more information about custom vocabularies, see <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     *            >Custom vocabularies</a>.
     *            </p>
     */
    public void setVocabularyFileUri(String vocabularyFileUri) {
        this.vocabularyFileUri = vocabularyFileUri;
    }

    /**
     * <p>
     * The S3 location of the text file that contains the definition of the
     * custom vocabulary. The URI must be in the same region as the API endpoint
     * that you are calling. The general form is:
     * </p>
     * <p>
     * For more information about S3 object names, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     * >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     * </p>
     * <p>
     * For more information about custom vocabularies, see <a
     * href="https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     * >Custom vocabularies</a>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2000<br/>
     * <b>Pattern: </b>(s3://|http(s*)://).+<br/>
     *
     * @param vocabularyFileUri <p>
     *            The S3 location of the text file that contains the definition
     *            of the custom vocabulary. The URI must be in the same region
     *            as the API endpoint that you are calling. The general form is:
     *            </p>
     *            <p>
     *            For more information about S3 object names, see <a href=
     *            "https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys"
     *            >Object Keys</a> in the <i>Amazon S3 Developer Guide</i>.
     *            </p>
     *            <p>
     *            For more information about custom vocabularies, see <a href=
     *            "https://docs.aws.amazon.com/transcribe/latest/dg/how-vocabulary"
     *            >Custom vocabularies</a>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withVocabularyFileUri(String vocabularyFileUri) {
        this.vocabularyFileUri = vocabularyFileUri;
        return this;
    }

    /**
     * <p>
     * Adds one or more tags, each in the form of a key:value pair, to a new
     * Amazon Transcribe vocabulary at the time you create this new vocabulary.
     * </p>
     *
     * @return <p>
     *         Adds one or more tags, each in the form of a key:value pair, to a
     *         new Amazon Transcribe vocabulary at the time you create this new
     *         vocabulary.
     *         </p>
     */
    public java.util.List<Tag> getTags() {
        return tags;
    }

    /**
     * <p>
     * Adds one or more tags, each in the form of a key:value pair, to a new
     * Amazon Transcribe vocabulary at the time you create this new vocabulary.
     * </p>
     *
     * @param tags <p>
     *            Adds one or more tags, each in the form of a key:value pair,
     *            to a new Amazon Transcribe vocabulary at the time you create
     *            this new vocabulary.
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
     * Adds one or more tags, each in the form of a key:value pair, to a new
     * Amazon Transcribe vocabulary at the time you create this new vocabulary.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tags <p>
     *            Adds one or more tags, each in the form of a key:value pair,
     *            to a new Amazon Transcribe vocabulary at the time you create
     *            this new vocabulary.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withTags(Tag... tags) {
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
     * Adds one or more tags, each in the form of a key:value pair, to a new
     * Amazon Transcribe vocabulary at the time you create this new vocabulary.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param tags <p>
     *            Adds one or more tags, each in the form of a key:value pair,
     *            to a new Amazon Transcribe vocabulary at the time you create
     *            this new vocabulary.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public CreateVocabularyRequest withTags(java.util.Collection<Tag> tags) {
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
        if (getVocabularyName() != null)
            sb.append("VocabularyName: " + getVocabularyName() + ",");
        if (getLanguageCode() != null)
            sb.append("LanguageCode: " + getLanguageCode() + ",");
        if (getPhrases() != null)
            sb.append("Phrases: " + getPhrases() + ",");
        if (getVocabularyFileUri() != null)
            sb.append("VocabularyFileUri: " + getVocabularyFileUri() + ",");
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
                + ((getVocabularyName() == null) ? 0 : getVocabularyName().hashCode());
        hashCode = prime * hashCode
                + ((getLanguageCode() == null) ? 0 : getLanguageCode().hashCode());
        hashCode = prime * hashCode + ((getPhrases() == null) ? 0 : getPhrases().hashCode());
        hashCode = prime * hashCode
                + ((getVocabularyFileUri() == null) ? 0 : getVocabularyFileUri().hashCode());
        hashCode = prime * hashCode + ((getTags() == null) ? 0 : getTags().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateVocabularyRequest == false)
            return false;
        CreateVocabularyRequest other = (CreateVocabularyRequest) obj;

        if (other.getVocabularyName() == null ^ this.getVocabularyName() == null)
            return false;
        if (other.getVocabularyName() != null
                && other.getVocabularyName().equals(this.getVocabularyName()) == false)
            return false;
        if (other.getLanguageCode() == null ^ this.getLanguageCode() == null)
            return false;
        if (other.getLanguageCode() != null
                && other.getLanguageCode().equals(this.getLanguageCode()) == false)
            return false;
        if (other.getPhrases() == null ^ this.getPhrases() == null)
            return false;
        if (other.getPhrases() != null && other.getPhrases().equals(this.getPhrases()) == false)
            return false;
        if (other.getVocabularyFileUri() == null ^ this.getVocabularyFileUri() == null)
            return false;
        if (other.getVocabularyFileUri() != null
                && other.getVocabularyFileUri().equals(this.getVocabularyFileUri()) == false)
            return false;
        if (other.getTags() == null ^ this.getTags() == null)
            return false;
        if (other.getTags() != null && other.getTags().equals(this.getTags()) == false)
            return false;
        return true;
    }
}
