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

/**
 * <p>
 * Provides information about a custom vocabulary, including the language of the
 * vocabulary, when it was last modified, its name, and the processing state.
 * </p>
 */
public class VocabularyInfo implements Serializable {
    /**
     * <p>
     * A unique name, chosen by you, for your custom vocabulary. This name is
     * case sensitive, cannot contain spaces, and must be unique within an
     * Amazon Web Services account.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     */
    private String vocabularyName;

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     * The date and time the specified vocabulary was last modified.
     * </p>
     * <p>
     * Timestamps are in the format
     * <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     * <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32 PM UTC-7
     * on May 4, 2022.
     * </p>
     */
    private java.util.Date lastModifiedTime;

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     */
    private String vocabularyState;

    /**
     * <p>
     * A unique name, chosen by you, for your custom vocabulary. This name is
     * case sensitive, cannot contain spaces, and must be unique within an
     * Amazon Web Services account.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @return <p>
     *         A unique name, chosen by you, for your custom vocabulary. This
     *         name is case sensitive, cannot contain spaces, and must be unique
     *         within an Amazon Web Services account.
     *         </p>
     */
    public String getVocabularyName() {
        return vocabularyName;
    }

    /**
     * <p>
     * A unique name, chosen by you, for your custom vocabulary. This name is
     * case sensitive, cannot contain spaces, and must be unique within an
     * Amazon Web Services account.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 200<br/>
     * <b>Pattern: </b>^[0-9a-zA-Z._-]+<br/>
     *
     * @param vocabularyName <p>
     *            A unique name, chosen by you, for your custom vocabulary. This
     *            name is case sensitive, cannot contain spaces, and must be
     *            unique within an Amazon Web Services account.
     *            </p>
     */
    public void setVocabularyName(String vocabularyName) {
        this.vocabularyName = vocabularyName;
    }

    /**
     * <p>
     * A unique name, chosen by you, for your custom vocabulary. This name is
     * case sensitive, cannot contain spaces, and must be unique within an
     * Amazon Web Services account.
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
     *            A unique name, chosen by you, for your custom vocabulary. This
     *            name is case sensitive, cannot contain spaces, and must be
     *            unique within an Amazon Web Services account.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public VocabularyInfo withVocabularyName(String vocabularyName) {
        this.vocabularyName = vocabularyName;
        return this;
    }

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     *         The language code used to create your custom vocabulary. Each
     *         vocabulary must contain terms in only one language.
     *         </p>
     *         <p>
     *         A custom vocabulary can only be used to transcribe files in the
     *         same language as the vocabulary. For example, if you create a
     *         vocabulary using US English (<code>en-US</code>), you can only
     *         apply this vocabulary to files that contain English audio.
     *         </p>
     * @see LanguageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     *            The language code used to create your custom vocabulary. Each
     *            vocabulary must contain terms in only one language.
     *            </p>
     *            <p>
     *            A custom vocabulary can only be used to transcribe files in
     *            the same language as the vocabulary. For example, if you
     *            create a vocabulary using US English (<code>en-US</code>), you
     *            can only apply this vocabulary to files that contain English
     *            audio.
     *            </p>
     * @see LanguageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     *            The language code used to create your custom vocabulary. Each
     *            vocabulary must contain terms in only one language.
     *            </p>
     *            <p>
     *            A custom vocabulary can only be used to transcribe files in
     *            the same language as the vocabulary. For example, if you
     *            create a vocabulary using US English (<code>en-US</code>), you
     *            can only apply this vocabulary to files that contain English
     *            audio.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see LanguageCode
     */
    public VocabularyInfo withLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     *            The language code used to create your custom vocabulary. Each
     *            vocabulary must contain terms in only one language.
     *            </p>
     *            <p>
     *            A custom vocabulary can only be used to transcribe files in
     *            the same language as the vocabulary. For example, if you
     *            create a vocabulary using US English (<code>en-US</code>), you
     *            can only apply this vocabulary to files that contain English
     *            audio.
     *            </p>
     * @see LanguageCode
     */
    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode.toString();
    }

    /**
     * <p>
     * The language code used to create your custom vocabulary. Each vocabulary
     * must contain terms in only one language.
     * </p>
     * <p>
     * A custom vocabulary can only be used to transcribe files in the same
     * language as the vocabulary. For example, if you create a vocabulary using
     * US English (<code>en-US</code>), you can only apply this vocabulary to
     * files that contain English audio.
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
     *            The language code used to create your custom vocabulary. Each
     *            vocabulary must contain terms in only one language.
     *            </p>
     *            <p>
     *            A custom vocabulary can only be used to transcribe files in
     *            the same language as the vocabulary. For example, if you
     *            create a vocabulary using US English (<code>en-US</code>), you
     *            can only apply this vocabulary to files that contain English
     *            audio.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see LanguageCode
     */
    public VocabularyInfo withLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode.toString();
        return this;
    }

    /**
     * <p>
     * The date and time the specified vocabulary was last modified.
     * </p>
     * <p>
     * Timestamps are in the format
     * <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     * <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32 PM UTC-7
     * on May 4, 2022.
     * </p>
     *
     * @return <p>
     *         The date and time the specified vocabulary was last modified.
     *         </p>
     *         <p>
     *         Timestamps are in the format
     *         <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     *         <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32 PM
     *         UTC-7 on May 4, 2022.
     *         </p>
     */
    public java.util.Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * <p>
     * The date and time the specified vocabulary was last modified.
     * </p>
     * <p>
     * Timestamps are in the format
     * <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     * <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32 PM UTC-7
     * on May 4, 2022.
     * </p>
     *
     * @param lastModifiedTime <p>
     *            The date and time the specified vocabulary was last modified.
     *            </p>
     *            <p>
     *            Timestamps are in the format
     *            <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     *            <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32
     *            PM UTC-7 on May 4, 2022.
     *            </p>
     */
    public void setLastModifiedTime(java.util.Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * <p>
     * The date and time the specified vocabulary was last modified.
     * </p>
     * <p>
     * Timestamps are in the format
     * <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     * <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32 PM UTC-7
     * on May 4, 2022.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param lastModifiedTime <p>
     *            The date and time the specified vocabulary was last modified.
     *            </p>
     *            <p>
     *            Timestamps are in the format
     *            <code>YYYY-MM-DD'T'HH:MM:SS.SSSSSS-UTC</code>. For example,
     *            <code>2022-05-04T12:32:58.761000-07:00</code> represents 12:32
     *            PM UTC-7 on May 4, 2022.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public VocabularyInfo withLastModifiedTime(java.util.Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
        return this;
    }

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     *
     * @return <p>
     *         The processing state of your custom vocabulary. If the state is
     *         <code>READY</code>, you can use the vocabulary in a
     *         <code>StartTranscriptionJob</code> request.
     *         </p>
     * @see VocabularyState
     */
    public String getVocabularyState() {
        return vocabularyState;
    }

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     *
     * @param vocabularyState <p>
     *            The processing state of your custom vocabulary. If the state
     *            is <code>READY</code>, you can use the vocabulary in a
     *            <code>StartTranscriptionJob</code> request.
     *            </p>
     * @see VocabularyState
     */
    public void setVocabularyState(String vocabularyState) {
        this.vocabularyState = vocabularyState;
    }

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     *
     * @param vocabularyState <p>
     *            The processing state of your custom vocabulary. If the state
     *            is <code>READY</code>, you can use the vocabulary in a
     *            <code>StartTranscriptionJob</code> request.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see VocabularyState
     */
    public VocabularyInfo withVocabularyState(String vocabularyState) {
        this.vocabularyState = vocabularyState;
        return this;
    }

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     *
     * @param vocabularyState <p>
     *            The processing state of your custom vocabulary. If the state
     *            is <code>READY</code>, you can use the vocabulary in a
     *            <code>StartTranscriptionJob</code> request.
     *            </p>
     * @see VocabularyState
     */
    public void setVocabularyState(VocabularyState vocabularyState) {
        this.vocabularyState = vocabularyState.toString();
    }

    /**
     * <p>
     * The processing state of your custom vocabulary. If the state is
     * <code>READY</code>, you can use the vocabulary in a
     * <code>StartTranscriptionJob</code> request.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>PENDING, READY, FAILED
     *
     * @param vocabularyState <p>
     *            The processing state of your custom vocabulary. If the state
     *            is <code>READY</code>, you can use the vocabulary in a
     *            <code>StartTranscriptionJob</code> request.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see VocabularyState
     */
    public VocabularyInfo withVocabularyState(VocabularyState vocabularyState) {
        this.vocabularyState = vocabularyState.toString();
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
        if (getLastModifiedTime() != null)
            sb.append("LastModifiedTime: " + getLastModifiedTime() + ",");
        if (getVocabularyState() != null)
            sb.append("VocabularyState: " + getVocabularyState());
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
        hashCode = prime * hashCode
                + ((getLastModifiedTime() == null) ? 0 : getLastModifiedTime().hashCode());
        hashCode = prime * hashCode
                + ((getVocabularyState() == null) ? 0 : getVocabularyState().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof VocabularyInfo == false)
            return false;
        VocabularyInfo other = (VocabularyInfo) obj;

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
        if (other.getLastModifiedTime() == null ^ this.getLastModifiedTime() == null)
            return false;
        if (other.getLastModifiedTime() != null
                && other.getLastModifiedTime().equals(this.getLastModifiedTime()) == false)
            return false;
        if (other.getVocabularyState() == null ^ this.getVocabularyState() == null)
            return false;
        if (other.getVocabularyState() != null
                && other.getVocabularyState().equals(this.getVocabularyState()) == false)
            return false;
        return true;
    }
}
