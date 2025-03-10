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

package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Responds to the authentication challenge.
 * </p>
 * <note>
 * <p>
 * This action might generate an SMS text message. Starting June 1, 2021, US
 * telecom carriers require you to register an origination phone number before
 * you can send SMS messages to US phone numbers. If you use SMS text messages
 * in Amazon Cognito, you must register a phone number with <a
 * href="https://console.aws.amazon.com/pinpoint/home/">Amazon Pinpoint</a>.
 * Amazon Cognito uses the registered number automatically. Otherwise, Amazon
 * Cognito users who must receive SMS messages might not be able to sign up,
 * activate their accounts, or sign in.
 * </p>
 * <p>
 * If you have never used SMS text messages with Amazon Cognito or any other
 * Amazon Web Service, Amazon Simple Notification Service might place your
 * account in the SMS sandbox. In <i> <a
 * href="https://docs.aws.amazon.com/sns/latest/dg/sns-sms-sandbox.html">sandbox
 * mode</a> </i>, you can send messages only to verified phone numbers. After
 * you test your app while in the sandbox environment, you can move out of the
 * sandbox and into production. For more information, see <a href=
 * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-sms-userpool-settings.html"
 * > SMS message settings for Amazon Cognito user pools</a> in the <i>Amazon
 * Cognito Developer Guide</i>.
 * </p>
 * </note>
 */
public class RespondToAuthChallengeRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The app client ID.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[\w+]+<br/>
     */
    private String clientId;

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     */
    private String challengeName;

    /**
     * <p>
     * The session that should be passed both ways in challenge-response calls
     * to the service. If <code>InitiateAuth</code> or
     * <code>RespondToAuthChallenge</code> API call determines that the caller
     * must pass another challenge, they return a session with other challenge
     * parameters. This session should be passed as it is to the next
     * <code>RespondToAuthChallenge</code> API call.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>20 - 2048<br/>
     */
    private String session;

    /**
     * <p>
     * The challenge responses. These are inputs corresponding to the value of
     * <code>ChallengeName</code>, for example:
     * </p>
     * <note>
     * <p>
     * <code>SECRET_HASH</code> (if app client is configured with client secret)
     * applies to all of the inputs that follow (including
     * <code>SOFTWARE_TOKEN_MFA</code>).
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>, <code>USERNAME</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PASSWORD_VERIFIER</code>: <code>PASSWORD_CLAIM_SIGNATURE</code>,
     * <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     * <code>USERNAME</code>.
     * </p>
     * <note>
     * <p>
     * <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code> when you
     * sign in with a remembered device.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     * <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     * configured with client secret). To set any required attributes that
     * Amazon Cognito returned as <code>requiredAttributes</code> in the
     * <code>InitiateAuth</code> response, add a
     * <code>userAttributes.<i>attributename</i> </code> parameter. This
     * parameter can also set values for writable attributes that aren't
     * required by your user pool.
     * </p>
     * <note>
     * <p>
     * In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you can't
     * modify a required attribute that already has a value. In
     * <code>RespondToAuthChallenge</code>, set a value for any keys that Amazon
     * Cognito returned in the <code>requiredAttributes</code> parameter, then
     * use the <code>UpdateUserAttributes</code> API operation to modify the
     * value of any additional attributes.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     * <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     * <code>DEVICE_KEY</code>, <code>SRP_A</code> (and <code>SECRET_HASH</code>
     * ).
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     * <code>PASSWORD_VERIFIER</code> requires, plus <code>DEVICE_KEY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you must use
     * the session value returned by <code>VerifySoftwareToken</code> in the
     * <code>Session</code> parameter.
     * </p>
     * </li>
     * </ul>
     */
    private java.util.Map<String, String> challengeResponses;

    /**
     * <p>
     * The Amazon Pinpoint analytics metadata that contributes to your metrics
     * for <code>RespondToAuthChallenge</code> calls.
     * </p>
     */
    private AnalyticsMetadataType analyticsMetadata;

    /**
     * <p>
     * Contextual data about your user session, such as the device fingerprint,
     * IP address, or location. Amazon Cognito advanced security evaluates the
     * risk of an authentication event based on the context that your app
     * generates and passes to Amazon Cognito when it makes API requests.
     * </p>
     */
    private UserContextDataType userContextData;

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for any
     * custom workflows that this action triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning Lambda functions to user pool
     * triggers. When you use the RespondToAuthChallenge API action, Amazon
     * Cognito invokes any functions that are assigned to the following
     * triggers: <i>post authentication</i>, <i>pre token generation</i>,
     * <i>define auth challenge</i>, <i>create auth challenge</i>, and <i>verify
     * auth challenge</i>. When Amazon Cognito invokes any of these functions,
     * it passes a JSON payload, which the function receives as input. This
     * payload contains a <code>clientMetadata</code> attribute, which provides
     * the data that you assigned to the ClientMetadata parameter in your
     * RespondToAuthChallenge request. In your function code in Lambda, you can
     * process the <code>clientMetadata</code> value to enhance your workflow
     * for your specific needs.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * > Customizing user pool Workflows with Lambda Triggers</a> in the
     * <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * When you use the ClientMetadata parameter, remember that Amazon Cognito
     * won't do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Store the ClientMetadata value. This data is available only to Lambda
     * triggers that are assigned to a user pool to support custom workflows. If
     * your user pool configuration doesn't include triggers, the ClientMetadata
     * parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Encrypt the ClientMetadata value. Don't use Amazon Cognito to provide
     * sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     */
    private java.util.Map<String, String> clientMetadata;

    /**
     * <p>
     * The app client ID.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[\w+]+<br/>
     *
     * @return <p>
     *         The app client ID.
     *         </p>
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * <p>
     * The app client ID.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[\w+]+<br/>
     *
     * @param clientId <p>
     *            The app client ID.
     *            </p>
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * <p>
     * The app client ID.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     * <b>Pattern: </b>[\w+]+<br/>
     *
     * @param clientId <p>
     *            The app client ID.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     *
     * @return <p>
     *         The challenge name. For more information, see <a href=
     *         "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     *         >InitiateAuth</a>.
     *         </p>
     *         <p>
     *         <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     *         </p>
     * @see ChallengeNameType
     */
    public String getChallengeName() {
        return challengeName;
    }

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     *
     * @param challengeName <p>
     *            The challenge name. For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     *            >InitiateAuth</a>.
     *            </p>
     *            <p>
     *            <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     *            </p>
     * @see ChallengeNameType
     */
    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     *
     * @param challengeName <p>
     *            The challenge name. For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     *            >InitiateAuth</a>.
     *            </p>
     *            <p>
     *            <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see ChallengeNameType
     */
    public RespondToAuthChallengeRequest withChallengeName(String challengeName) {
        this.challengeName = challengeName;
        return this;
    }

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     *
     * @param challengeName <p>
     *            The challenge name. For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     *            >InitiateAuth</a>.
     *            </p>
     *            <p>
     *            <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     *            </p>
     * @see ChallengeNameType
     */
    public void setChallengeName(ChallengeNameType challengeName) {
        this.challengeName = challengeName.toString();
    }

    /**
     * <p>
     * The challenge name. For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     * >InitiateAuth</a>.
     * </p>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>SMS_MFA, SOFTWARE_TOKEN_MFA, SELECT_MFA_TYPE,
     * MFA_SETUP, PASSWORD_VERIFIER, CUSTOM_CHALLENGE, DEVICE_SRP_AUTH,
     * DEVICE_PASSWORD_VERIFIER, ADMIN_NO_SRP_AUTH, NEW_PASSWORD_REQUIRED
     *
     * @param challengeName <p>
     *            The challenge name. For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_InitiateAuth.html"
     *            >InitiateAuth</a>.
     *            </p>
     *            <p>
     *            <code>ADMIN_NO_SRP_AUTH</code> isn't a valid value.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     * @see ChallengeNameType
     */
    public RespondToAuthChallengeRequest withChallengeName(ChallengeNameType challengeName) {
        this.challengeName = challengeName.toString();
        return this;
    }

    /**
     * <p>
     * The session that should be passed both ways in challenge-response calls
     * to the service. If <code>InitiateAuth</code> or
     * <code>RespondToAuthChallenge</code> API call determines that the caller
     * must pass another challenge, they return a session with other challenge
     * parameters. This session should be passed as it is to the next
     * <code>RespondToAuthChallenge</code> API call.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>20 - 2048<br/>
     *
     * @return <p>
     *         The session that should be passed both ways in challenge-response
     *         calls to the service. If <code>InitiateAuth</code> or
     *         <code>RespondToAuthChallenge</code> API call determines that the
     *         caller must pass another challenge, they return a session with
     *         other challenge parameters. This session should be passed as it
     *         is to the next <code>RespondToAuthChallenge</code> API call.
     *         </p>
     */
    public String getSession() {
        return session;
    }

    /**
     * <p>
     * The session that should be passed both ways in challenge-response calls
     * to the service. If <code>InitiateAuth</code> or
     * <code>RespondToAuthChallenge</code> API call determines that the caller
     * must pass another challenge, they return a session with other challenge
     * parameters. This session should be passed as it is to the next
     * <code>RespondToAuthChallenge</code> API call.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>20 - 2048<br/>
     *
     * @param session <p>
     *            The session that should be passed both ways in
     *            challenge-response calls to the service. If
     *            <code>InitiateAuth</code> or
     *            <code>RespondToAuthChallenge</code> API call determines that
     *            the caller must pass another challenge, they return a session
     *            with other challenge parameters. This session should be passed
     *            as it is to the next <code>RespondToAuthChallenge</code> API
     *            call.
     *            </p>
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * <p>
     * The session that should be passed both ways in challenge-response calls
     * to the service. If <code>InitiateAuth</code> or
     * <code>RespondToAuthChallenge</code> API call determines that the caller
     * must pass another challenge, they return a session with other challenge
     * parameters. This session should be passed as it is to the next
     * <code>RespondToAuthChallenge</code> API call.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>20 - 2048<br/>
     *
     * @param session <p>
     *            The session that should be passed both ways in
     *            challenge-response calls to the service. If
     *            <code>InitiateAuth</code> or
     *            <code>RespondToAuthChallenge</code> API call determines that
     *            the caller must pass another challenge, they return a session
     *            with other challenge parameters. This session should be passed
     *            as it is to the next <code>RespondToAuthChallenge</code> API
     *            call.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withSession(String session) {
        this.session = session;
        return this;
    }

    /**
     * <p>
     * The challenge responses. These are inputs corresponding to the value of
     * <code>ChallengeName</code>, for example:
     * </p>
     * <note>
     * <p>
     * <code>SECRET_HASH</code> (if app client is configured with client secret)
     * applies to all of the inputs that follow (including
     * <code>SOFTWARE_TOKEN_MFA</code>).
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>, <code>USERNAME</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PASSWORD_VERIFIER</code>: <code>PASSWORD_CLAIM_SIGNATURE</code>,
     * <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     * <code>USERNAME</code>.
     * </p>
     * <note>
     * <p>
     * <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code> when you
     * sign in with a remembered device.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     * <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     * configured with client secret). To set any required attributes that
     * Amazon Cognito returned as <code>requiredAttributes</code> in the
     * <code>InitiateAuth</code> response, add a
     * <code>userAttributes.<i>attributename</i> </code> parameter. This
     * parameter can also set values for writable attributes that aren't
     * required by your user pool.
     * </p>
     * <note>
     * <p>
     * In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you can't
     * modify a required attribute that already has a value. In
     * <code>RespondToAuthChallenge</code>, set a value for any keys that Amazon
     * Cognito returned in the <code>requiredAttributes</code> parameter, then
     * use the <code>UpdateUserAttributes</code> API operation to modify the
     * value of any additional attributes.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     * <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     * <code>DEVICE_KEY</code>, <code>SRP_A</code> (and <code>SECRET_HASH</code>
     * ).
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     * <code>PASSWORD_VERIFIER</code> requires, plus <code>DEVICE_KEY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you must use
     * the session value returned by <code>VerifySoftwareToken</code> in the
     * <code>Session</code> parameter.
     * </p>
     * </li>
     * </ul>
     *
     * @return <p>
     *         The challenge responses. These are inputs corresponding to the
     *         value of <code>ChallengeName</code>, for example:
     *         </p>
     *         <note>
     *         <p>
     *         <code>SECRET_HASH</code> (if app client is configured with client
     *         secret) applies to all of the inputs that follow (including
     *         <code>SOFTWARE_TOKEN_MFA</code>).
     *         </p>
     *         </note>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>,
     *         <code>USERNAME</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>PASSWORD_VERIFIER</code>:
     *         <code>PASSWORD_CLAIM_SIGNATURE</code>,
     *         <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     *         <code>USERNAME</code>.
     *         </p>
     *         <note>
     *         <p>
     *         <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code>
     *         when you sign in with a remembered device.
     *         </p>
     *         </note></li>
     *         <li>
     *         <p>
     *         <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     *         <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     *         configured with client secret). To set any required attributes
     *         that Amazon Cognito returned as <code>requiredAttributes</code>
     *         in the <code>InitiateAuth</code> response, add a
     *         <code>userAttributes.<i>attributename</i> </code> parameter. This
     *         parameter can also set values for writable attributes that aren't
     *         required by your user pool.
     *         </p>
     *         <note>
     *         <p>
     *         In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you
     *         can't modify a required attribute that already has a value. In
     *         <code>RespondToAuthChallenge</code>, set a value for any keys
     *         that Amazon Cognito returned in the
     *         <code>requiredAttributes</code> parameter, then use the
     *         <code>UpdateUserAttributes</code> API operation to modify the
     *         value of any additional attributes.
     *         </p>
     *         </note></li>
     *         <li>
     *         <p>
     *         <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     *         <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     *         <code>DEVICE_KEY</code>, <code>SRP_A</code> (and
     *         <code>SECRET_HASH</code>).
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     *         <code>PASSWORD_VERIFIER</code> requires, plus
     *         <code>DEVICE_KEY</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you
     *         must use the session value returned by
     *         <code>VerifySoftwareToken</code> in the <code>Session</code>
     *         parameter.
     *         </p>
     *         </li>
     *         </ul>
     */
    public java.util.Map<String, String> getChallengeResponses() {
        return challengeResponses;
    }

    /**
     * <p>
     * The challenge responses. These are inputs corresponding to the value of
     * <code>ChallengeName</code>, for example:
     * </p>
     * <note>
     * <p>
     * <code>SECRET_HASH</code> (if app client is configured with client secret)
     * applies to all of the inputs that follow (including
     * <code>SOFTWARE_TOKEN_MFA</code>).
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>, <code>USERNAME</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PASSWORD_VERIFIER</code>: <code>PASSWORD_CLAIM_SIGNATURE</code>,
     * <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     * <code>USERNAME</code>.
     * </p>
     * <note>
     * <p>
     * <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code> when you
     * sign in with a remembered device.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     * <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     * configured with client secret). To set any required attributes that
     * Amazon Cognito returned as <code>requiredAttributes</code> in the
     * <code>InitiateAuth</code> response, add a
     * <code>userAttributes.<i>attributename</i> </code> parameter. This
     * parameter can also set values for writable attributes that aren't
     * required by your user pool.
     * </p>
     * <note>
     * <p>
     * In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you can't
     * modify a required attribute that already has a value. In
     * <code>RespondToAuthChallenge</code>, set a value for any keys that Amazon
     * Cognito returned in the <code>requiredAttributes</code> parameter, then
     * use the <code>UpdateUserAttributes</code> API operation to modify the
     * value of any additional attributes.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     * <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     * <code>DEVICE_KEY</code>, <code>SRP_A</code> (and <code>SECRET_HASH</code>
     * ).
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     * <code>PASSWORD_VERIFIER</code> requires, plus <code>DEVICE_KEY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you must use
     * the session value returned by <code>VerifySoftwareToken</code> in the
     * <code>Session</code> parameter.
     * </p>
     * </li>
     * </ul>
     *
     * @param challengeResponses <p>
     *            The challenge responses. These are inputs corresponding to the
     *            value of <code>ChallengeName</code>, for example:
     *            </p>
     *            <note>
     *            <p>
     *            <code>SECRET_HASH</code> (if app client is configured with
     *            client secret) applies to all of the inputs that follow
     *            (including <code>SOFTWARE_TOKEN_MFA</code>).
     *            </p>
     *            </note>
     *            <ul>
     *            <li>
     *            <p>
     *            <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>,
     *            <code>USERNAME</code>.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>PASSWORD_VERIFIER</code>:
     *            <code>PASSWORD_CLAIM_SIGNATURE</code>,
     *            <code>PASSWORD_CLAIM_SECRET_BLOCK</code>,
     *            <code>TIMESTAMP</code>, <code>USERNAME</code>.
     *            </p>
     *            <note>
     *            <p>
     *            <code>PASSWORD_VERIFIER</code> requires
     *            <code>DEVICE_KEY</code> when you sign in with a remembered
     *            device.
     *            </p>
     *            </note></li>
     *            <li>
     *            <p>
     *            <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     *            <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client
     *            is configured with client secret). To set any required
     *            attributes that Amazon Cognito returned as
     *            <code>requiredAttributes</code> in the
     *            <code>InitiateAuth</code> response, add a
     *            <code>userAttributes.<i>attributename</i> </code> parameter.
     *            This parameter can also set values for writable attributes
     *            that aren't required by your user pool.
     *            </p>
     *            <note>
     *            <p>
     *            In a <code>NEW_PASSWORD_REQUIRED</code> challenge response,
     *            you can't modify a required attribute that already has a
     *            value. In <code>RespondToAuthChallenge</code>, set a value for
     *            any keys that Amazon Cognito returned in the
     *            <code>requiredAttributes</code> parameter, then use the
     *            <code>UpdateUserAttributes</code> API operation to modify the
     *            value of any additional attributes.
     *            </p>
     *            </note></li>
     *            <li>
     *            <p>
     *            <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     *            <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     *            <code>DEVICE_KEY</code>, <code>SRP_A</code> (and
     *            <code>SECRET_HASH</code>).
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     *            <code>PASSWORD_VERIFIER</code> requires, plus
     *            <code>DEVICE_KEY</code>.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus
     *            you must use the session value returned by
     *            <code>VerifySoftwareToken</code> in the <code>Session</code>
     *            parameter.
     *            </p>
     *            </li>
     *            </ul>
     */
    public void setChallengeResponses(java.util.Map<String, String> challengeResponses) {
        this.challengeResponses = challengeResponses;
    }

    /**
     * <p>
     * The challenge responses. These are inputs corresponding to the value of
     * <code>ChallengeName</code>, for example:
     * </p>
     * <note>
     * <p>
     * <code>SECRET_HASH</code> (if app client is configured with client secret)
     * applies to all of the inputs that follow (including
     * <code>SOFTWARE_TOKEN_MFA</code>).
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>, <code>USERNAME</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PASSWORD_VERIFIER</code>: <code>PASSWORD_CLAIM_SIGNATURE</code>,
     * <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     * <code>USERNAME</code>.
     * </p>
     * <note>
     * <p>
     * <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code> when you
     * sign in with a remembered device.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     * <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     * configured with client secret). To set any required attributes that
     * Amazon Cognito returned as <code>requiredAttributes</code> in the
     * <code>InitiateAuth</code> response, add a
     * <code>userAttributes.<i>attributename</i> </code> parameter. This
     * parameter can also set values for writable attributes that aren't
     * required by your user pool.
     * </p>
     * <note>
     * <p>
     * In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you can't
     * modify a required attribute that already has a value. In
     * <code>RespondToAuthChallenge</code>, set a value for any keys that Amazon
     * Cognito returned in the <code>requiredAttributes</code> parameter, then
     * use the <code>UpdateUserAttributes</code> API operation to modify the
     * value of any additional attributes.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     * <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     * <code>DEVICE_KEY</code>, <code>SRP_A</code> (and <code>SECRET_HASH</code>
     * ).
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     * <code>PASSWORD_VERIFIER</code> requires, plus <code>DEVICE_KEY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you must use
     * the session value returned by <code>VerifySoftwareToken</code> in the
     * <code>Session</code> parameter.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param challengeResponses <p>
     *            The challenge responses. These are inputs corresponding to the
     *            value of <code>ChallengeName</code>, for example:
     *            </p>
     *            <note>
     *            <p>
     *            <code>SECRET_HASH</code> (if app client is configured with
     *            client secret) applies to all of the inputs that follow
     *            (including <code>SOFTWARE_TOKEN_MFA</code>).
     *            </p>
     *            </note>
     *            <ul>
     *            <li>
     *            <p>
     *            <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>,
     *            <code>USERNAME</code>.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>PASSWORD_VERIFIER</code>:
     *            <code>PASSWORD_CLAIM_SIGNATURE</code>,
     *            <code>PASSWORD_CLAIM_SECRET_BLOCK</code>,
     *            <code>TIMESTAMP</code>, <code>USERNAME</code>.
     *            </p>
     *            <note>
     *            <p>
     *            <code>PASSWORD_VERIFIER</code> requires
     *            <code>DEVICE_KEY</code> when you sign in with a remembered
     *            device.
     *            </p>
     *            </note></li>
     *            <li>
     *            <p>
     *            <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     *            <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client
     *            is configured with client secret). To set any required
     *            attributes that Amazon Cognito returned as
     *            <code>requiredAttributes</code> in the
     *            <code>InitiateAuth</code> response, add a
     *            <code>userAttributes.<i>attributename</i> </code> parameter.
     *            This parameter can also set values for writable attributes
     *            that aren't required by your user pool.
     *            </p>
     *            <note>
     *            <p>
     *            In a <code>NEW_PASSWORD_REQUIRED</code> challenge response,
     *            you can't modify a required attribute that already has a
     *            value. In <code>RespondToAuthChallenge</code>, set a value for
     *            any keys that Amazon Cognito returned in the
     *            <code>requiredAttributes</code> parameter, then use the
     *            <code>UpdateUserAttributes</code> API operation to modify the
     *            value of any additional attributes.
     *            </p>
     *            </note></li>
     *            <li>
     *            <p>
     *            <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     *            <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     *            <code>DEVICE_KEY</code>, <code>SRP_A</code> (and
     *            <code>SECRET_HASH</code>).
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     *            <code>PASSWORD_VERIFIER</code> requires, plus
     *            <code>DEVICE_KEY</code>.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus
     *            you must use the session value returned by
     *            <code>VerifySoftwareToken</code> in the <code>Session</code>
     *            parameter.
     *            </p>
     *            </li>
     *            </ul>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withChallengeResponses(
            java.util.Map<String, String> challengeResponses) {
        this.challengeResponses = challengeResponses;
        return this;
    }

    /**
     * <p>
     * The challenge responses. These are inputs corresponding to the value of
     * <code>ChallengeName</code>, for example:
     * </p>
     * <note>
     * <p>
     * <code>SECRET_HASH</code> (if app client is configured with client secret)
     * applies to all of the inputs that follow (including
     * <code>SOFTWARE_TOKEN_MFA</code>).
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>SMS_MFA</code>: <code>SMS_MFA_CODE</code>, <code>USERNAME</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PASSWORD_VERIFIER</code>: <code>PASSWORD_CLAIM_SIGNATURE</code>,
     * <code>PASSWORD_CLAIM_SECRET_BLOCK</code>, <code>TIMESTAMP</code>,
     * <code>USERNAME</code>.
     * </p>
     * <note>
     * <p>
     * <code>PASSWORD_VERIFIER</code> requires <code>DEVICE_KEY</code> when you
     * sign in with a remembered device.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>NEW_PASSWORD_REQUIRED</code>: <code>NEW_PASSWORD</code>,
     * <code>USERNAME</code>, <code>SECRET_HASH</code> (if app client is
     * configured with client secret). To set any required attributes that
     * Amazon Cognito returned as <code>requiredAttributes</code> in the
     * <code>InitiateAuth</code> response, add a
     * <code>userAttributes.<i>attributename</i> </code> parameter. This
     * parameter can also set values for writable attributes that aren't
     * required by your user pool.
     * </p>
     * <note>
     * <p>
     * In a <code>NEW_PASSWORD_REQUIRED</code> challenge response, you can't
     * modify a required attribute that already has a value. In
     * <code>RespondToAuthChallenge</code>, set a value for any keys that Amazon
     * Cognito returned in the <code>requiredAttributes</code> parameter, then
     * use the <code>UpdateUserAttributes</code> API operation to modify the
     * value of any additional attributes.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * <code>SOFTWARE_TOKEN_MFA</code>: <code>USERNAME</code> and
     * <code>SOFTWARE_TOKEN_MFA_CODE</code> are required attributes.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_SRP_AUTH</code> requires <code>USERNAME</code>,
     * <code>DEVICE_KEY</code>, <code>SRP_A</code> (and <code>SECRET_HASH</code>
     * ).
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DEVICE_PASSWORD_VERIFIER</code> requires everything that
     * <code>PASSWORD_VERIFIER</code> requires, plus <code>DEVICE_KEY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>MFA_SETUP</code> requires <code>USERNAME</code>, plus you must use
     * the session value returned by <code>VerifySoftwareToken</code> in the
     * <code>Session</code> parameter.
     * </p>
     * </li>
     * </ul>
     * <p>
     * The method adds a new key-value pair into ChallengeResponses parameter,
     * and returns a reference to this object so that method calls can be
     * chained together.
     *
     * @param key The key of the entry to be added into ChallengeResponses.
     * @param value The corresponding value of the entry to be added into
     *            ChallengeResponses.
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest addChallengeResponsesEntry(String key, String value) {
        if (null == this.challengeResponses) {
            this.challengeResponses = new java.util.HashMap<String, String>();
        }
        if (this.challengeResponses.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString()
                    + ") are provided.");
        this.challengeResponses.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ChallengeResponses.
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     */
    public RespondToAuthChallengeRequest clearChallengeResponsesEntries() {
        this.challengeResponses = null;
        return this;
    }

    /**
     * <p>
     * The Amazon Pinpoint analytics metadata that contributes to your metrics
     * for <code>RespondToAuthChallenge</code> calls.
     * </p>
     *
     * @return <p>
     *         The Amazon Pinpoint analytics metadata that contributes to your
     *         metrics for <code>RespondToAuthChallenge</code> calls.
     *         </p>
     */
    public AnalyticsMetadataType getAnalyticsMetadata() {
        return analyticsMetadata;
    }

    /**
     * <p>
     * The Amazon Pinpoint analytics metadata that contributes to your metrics
     * for <code>RespondToAuthChallenge</code> calls.
     * </p>
     *
     * @param analyticsMetadata <p>
     *            The Amazon Pinpoint analytics metadata that contributes to
     *            your metrics for <code>RespondToAuthChallenge</code> calls.
     *            </p>
     */
    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadata) {
        this.analyticsMetadata = analyticsMetadata;
    }

    /**
     * <p>
     * The Amazon Pinpoint analytics metadata that contributes to your metrics
     * for <code>RespondToAuthChallenge</code> calls.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param analyticsMetadata <p>
     *            The Amazon Pinpoint analytics metadata that contributes to
     *            your metrics for <code>RespondToAuthChallenge</code> calls.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withAnalyticsMetadata(
            AnalyticsMetadataType analyticsMetadata) {
        this.analyticsMetadata = analyticsMetadata;
        return this;
    }

    /**
     * <p>
     * Contextual data about your user session, such as the device fingerprint,
     * IP address, or location. Amazon Cognito advanced security evaluates the
     * risk of an authentication event based on the context that your app
     * generates and passes to Amazon Cognito when it makes API requests.
     * </p>
     *
     * @return <p>
     *         Contextual data about your user session, such as the device
     *         fingerprint, IP address, or location. Amazon Cognito advanced
     *         security evaluates the risk of an authentication event based on
     *         the context that your app generates and passes to Amazon Cognito
     *         when it makes API requests.
     *         </p>
     */
    public UserContextDataType getUserContextData() {
        return userContextData;
    }

    /**
     * <p>
     * Contextual data about your user session, such as the device fingerprint,
     * IP address, or location. Amazon Cognito advanced security evaluates the
     * risk of an authentication event based on the context that your app
     * generates and passes to Amazon Cognito when it makes API requests.
     * </p>
     *
     * @param userContextData <p>
     *            Contextual data about your user session, such as the device
     *            fingerprint, IP address, or location. Amazon Cognito advanced
     *            security evaluates the risk of an authentication event based
     *            on the context that your app generates and passes to Amazon
     *            Cognito when it makes API requests.
     *            </p>
     */
    public void setUserContextData(UserContextDataType userContextData) {
        this.userContextData = userContextData;
    }

    /**
     * <p>
     * Contextual data about your user session, such as the device fingerprint,
     * IP address, or location. Amazon Cognito advanced security evaluates the
     * risk of an authentication event based on the context that your app
     * generates and passes to Amazon Cognito when it makes API requests.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param userContextData <p>
     *            Contextual data about your user session, such as the device
     *            fingerprint, IP address, or location. Amazon Cognito advanced
     *            security evaluates the risk of an authentication event based
     *            on the context that your app generates and passes to Amazon
     *            Cognito when it makes API requests.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withUserContextData(UserContextDataType userContextData) {
        this.userContextData = userContextData;
        return this;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for any
     * custom workflows that this action triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning Lambda functions to user pool
     * triggers. When you use the RespondToAuthChallenge API action, Amazon
     * Cognito invokes any functions that are assigned to the following
     * triggers: <i>post authentication</i>, <i>pre token generation</i>,
     * <i>define auth challenge</i>, <i>create auth challenge</i>, and <i>verify
     * auth challenge</i>. When Amazon Cognito invokes any of these functions,
     * it passes a JSON payload, which the function receives as input. This
     * payload contains a <code>clientMetadata</code> attribute, which provides
     * the data that you assigned to the ClientMetadata parameter in your
     * RespondToAuthChallenge request. In your function code in Lambda, you can
     * process the <code>clientMetadata</code> value to enhance your workflow
     * for your specific needs.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * > Customizing user pool Workflows with Lambda Triggers</a> in the
     * <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * When you use the ClientMetadata parameter, remember that Amazon Cognito
     * won't do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Store the ClientMetadata value. This data is available only to Lambda
     * triggers that are assigned to a user pool to support custom workflows. If
     * your user pool configuration doesn't include triggers, the ClientMetadata
     * parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Encrypt the ClientMetadata value. Don't use Amazon Cognito to provide
     * sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     *
     * @return <p>
     *         A map of custom key-value pairs that you can provide as input for
     *         any custom workflows that this action triggers.
     *         </p>
     *         <p>
     *         You create custom workflows by assigning Lambda functions to user
     *         pool triggers. When you use the RespondToAuthChallenge API
     *         action, Amazon Cognito invokes any functions that are assigned to
     *         the following triggers: <i>post authentication</i>, <i>pre token
     *         generation</i>, <i>define auth challenge</i>, <i>create auth
     *         challenge</i>, and <i>verify auth challenge</i>. When Amazon
     *         Cognito invokes any of these functions, it passes a JSON payload,
     *         which the function receives as input. This payload contains a
     *         <code>clientMetadata</code> attribute, which provides the data
     *         that you assigned to the ClientMetadata parameter in your
     *         RespondToAuthChallenge request. In your function code in Lambda,
     *         you can process the <code>clientMetadata</code> value to enhance
     *         your workflow for your specific needs.
     *         </p>
     *         <p>
     *         For more information, see <a href=
     *         "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *         > Customizing user pool Workflows with Lambda Triggers</a> in the
     *         <i>Amazon Cognito Developer Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         When you use the ClientMetadata parameter, remember that Amazon
     *         Cognito won't do the following:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Store the ClientMetadata value. This data is available only to
     *         Lambda triggers that are assigned to a user pool to support
     *         custom workflows. If your user pool configuration doesn't include
     *         triggers, the ClientMetadata parameter serves no purpose.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Validate the ClientMetadata value.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Encrypt the ClientMetadata value. Don't use Amazon Cognito to
     *         provide sensitive information.
     *         </p>
     *         </li>
     *         </ul>
     *         </note>
     */
    public java.util.Map<String, String> getClientMetadata() {
        return clientMetadata;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for any
     * custom workflows that this action triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning Lambda functions to user pool
     * triggers. When you use the RespondToAuthChallenge API action, Amazon
     * Cognito invokes any functions that are assigned to the following
     * triggers: <i>post authentication</i>, <i>pre token generation</i>,
     * <i>define auth challenge</i>, <i>create auth challenge</i>, and <i>verify
     * auth challenge</i>. When Amazon Cognito invokes any of these functions,
     * it passes a JSON payload, which the function receives as input. This
     * payload contains a <code>clientMetadata</code> attribute, which provides
     * the data that you assigned to the ClientMetadata parameter in your
     * RespondToAuthChallenge request. In your function code in Lambda, you can
     * process the <code>clientMetadata</code> value to enhance your workflow
     * for your specific needs.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * > Customizing user pool Workflows with Lambda Triggers</a> in the
     * <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * When you use the ClientMetadata parameter, remember that Amazon Cognito
     * won't do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Store the ClientMetadata value. This data is available only to Lambda
     * triggers that are assigned to a user pool to support custom workflows. If
     * your user pool configuration doesn't include triggers, the ClientMetadata
     * parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Encrypt the ClientMetadata value. Don't use Amazon Cognito to provide
     * sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     *
     * @param clientMetadata <p>
     *            A map of custom key-value pairs that you can provide as input
     *            for any custom workflows that this action triggers.
     *            </p>
     *            <p>
     *            You create custom workflows by assigning Lambda functions to
     *            user pool triggers. When you use the RespondToAuthChallenge
     *            API action, Amazon Cognito invokes any functions that are
     *            assigned to the following triggers: <i>post
     *            authentication</i>, <i>pre token generation</i>, <i>define
     *            auth challenge</i>, <i>create auth challenge</i>, and
     *            <i>verify auth challenge</i>. When Amazon Cognito invokes any
     *            of these functions, it passes a JSON payload, which the
     *            function receives as input. This payload contains a
     *            <code>clientMetadata</code> attribute, which provides the data
     *            that you assigned to the ClientMetadata parameter in your
     *            RespondToAuthChallenge request. In your function code in
     *            Lambda, you can process the <code>clientMetadata</code> value
     *            to enhance your workflow for your specific needs.
     *            </p>
     *            <p>
     *            For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *            > Customizing user pool Workflows with Lambda Triggers</a> in
     *            the <i>Amazon Cognito Developer Guide</i>.
     *            </p>
     *            <note>
     *            <p>
     *            When you use the ClientMetadata parameter, remember that
     *            Amazon Cognito won't do the following:
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Store the ClientMetadata value. This data is available only to
     *            Lambda triggers that are assigned to a user pool to support
     *            custom workflows. If your user pool configuration doesn't
     *            include triggers, the ClientMetadata parameter serves no
     *            purpose.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Validate the ClientMetadata value.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Encrypt the ClientMetadata value. Don't use Amazon Cognito to
     *            provide sensitive information.
     *            </p>
     *            </li>
     *            </ul>
     *            </note>
     */
    public void setClientMetadata(java.util.Map<String, String> clientMetadata) {
        this.clientMetadata = clientMetadata;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for any
     * custom workflows that this action triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning Lambda functions to user pool
     * triggers. When you use the RespondToAuthChallenge API action, Amazon
     * Cognito invokes any functions that are assigned to the following
     * triggers: <i>post authentication</i>, <i>pre token generation</i>,
     * <i>define auth challenge</i>, <i>create auth challenge</i>, and <i>verify
     * auth challenge</i>. When Amazon Cognito invokes any of these functions,
     * it passes a JSON payload, which the function receives as input. This
     * payload contains a <code>clientMetadata</code> attribute, which provides
     * the data that you assigned to the ClientMetadata parameter in your
     * RespondToAuthChallenge request. In your function code in Lambda, you can
     * process the <code>clientMetadata</code> value to enhance your workflow
     * for your specific needs.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * > Customizing user pool Workflows with Lambda Triggers</a> in the
     * <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * When you use the ClientMetadata parameter, remember that Amazon Cognito
     * won't do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Store the ClientMetadata value. This data is available only to Lambda
     * triggers that are assigned to a user pool to support custom workflows. If
     * your user pool configuration doesn't include triggers, the ClientMetadata
     * parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Encrypt the ClientMetadata value. Don't use Amazon Cognito to provide
     * sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param clientMetadata <p>
     *            A map of custom key-value pairs that you can provide as input
     *            for any custom workflows that this action triggers.
     *            </p>
     *            <p>
     *            You create custom workflows by assigning Lambda functions to
     *            user pool triggers. When you use the RespondToAuthChallenge
     *            API action, Amazon Cognito invokes any functions that are
     *            assigned to the following triggers: <i>post
     *            authentication</i>, <i>pre token generation</i>, <i>define
     *            auth challenge</i>, <i>create auth challenge</i>, and
     *            <i>verify auth challenge</i>. When Amazon Cognito invokes any
     *            of these functions, it passes a JSON payload, which the
     *            function receives as input. This payload contains a
     *            <code>clientMetadata</code> attribute, which provides the data
     *            that you assigned to the ClientMetadata parameter in your
     *            RespondToAuthChallenge request. In your function code in
     *            Lambda, you can process the <code>clientMetadata</code> value
     *            to enhance your workflow for your specific needs.
     *            </p>
     *            <p>
     *            For more information, see <a href=
     *            "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *            > Customizing user pool Workflows with Lambda Triggers</a> in
     *            the <i>Amazon Cognito Developer Guide</i>.
     *            </p>
     *            <note>
     *            <p>
     *            When you use the ClientMetadata parameter, remember that
     *            Amazon Cognito won't do the following:
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Store the ClientMetadata value. This data is available only to
     *            Lambda triggers that are assigned to a user pool to support
     *            custom workflows. If your user pool configuration doesn't
     *            include triggers, the ClientMetadata parameter serves no
     *            purpose.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Validate the ClientMetadata value.
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Encrypt the ClientMetadata value. Don't use Amazon Cognito to
     *            provide sensitive information.
     *            </p>
     *            </li>
     *            </ul>
     *            </note>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest withClientMetadata(
            java.util.Map<String, String> clientMetadata) {
        this.clientMetadata = clientMetadata;
        return this;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for any
     * custom workflows that this action triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning Lambda functions to user pool
     * triggers. When you use the RespondToAuthChallenge API action, Amazon
     * Cognito invokes any functions that are assigned to the following
     * triggers: <i>post authentication</i>, <i>pre token generation</i>,
     * <i>define auth challenge</i>, <i>create auth challenge</i>, and <i>verify
     * auth challenge</i>. When Amazon Cognito invokes any of these functions,
     * it passes a JSON payload, which the function receives as input. This
     * payload contains a <code>clientMetadata</code> attribute, which provides
     * the data that you assigned to the ClientMetadata parameter in your
     * RespondToAuthChallenge request. In your function code in Lambda, you can
     * process the <code>clientMetadata</code> value to enhance your workflow
     * for your specific needs.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * > Customizing user pool Workflows with Lambda Triggers</a> in the
     * <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * When you use the ClientMetadata parameter, remember that Amazon Cognito
     * won't do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Store the ClientMetadata value. This data is available only to Lambda
     * triggers that are assigned to a user pool to support custom workflows. If
     * your user pool configuration doesn't include triggers, the ClientMetadata
     * parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Encrypt the ClientMetadata value. Don't use Amazon Cognito to provide
     * sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * The method adds a new key-value pair into ClientMetadata parameter, and
     * returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param key The key of the entry to be added into ClientMetadata.
     * @param value The corresponding value of the entry to be added into
     *            ClientMetadata.
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RespondToAuthChallengeRequest addClientMetadataEntry(String key, String value) {
        if (null == this.clientMetadata) {
            this.clientMetadata = new java.util.HashMap<String, String>();
        }
        if (this.clientMetadata.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString()
                    + ") are provided.");
        this.clientMetadata.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ClientMetadata.
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     */
    public RespondToAuthChallengeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
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
        if (getClientId() != null)
            sb.append("ClientId: " + getClientId() + ",");
        if (getChallengeName() != null)
            sb.append("ChallengeName: " + getChallengeName() + ",");
        if (getSession() != null)
            sb.append("Session: " + getSession() + ",");
        if (getChallengeResponses() != null)
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        if (getAnalyticsMetadata() != null)
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        if (getUserContextData() != null)
            sb.append("UserContextData: " + getUserContextData() + ",");
        if (getClientMetadata() != null)
            sb.append("ClientMetadata: " + getClientMetadata());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getClientId() == null) ? 0 : getClientId().hashCode());
        hashCode = prime * hashCode
                + ((getChallengeName() == null) ? 0 : getChallengeName().hashCode());
        hashCode = prime * hashCode + ((getSession() == null) ? 0 : getSession().hashCode());
        hashCode = prime * hashCode
                + ((getChallengeResponses() == null) ? 0 : getChallengeResponses().hashCode());
        hashCode = prime * hashCode
                + ((getAnalyticsMetadata() == null) ? 0 : getAnalyticsMetadata().hashCode());
        hashCode = prime * hashCode
                + ((getUserContextData() == null) ? 0 : getUserContextData().hashCode());
        hashCode = prime * hashCode
                + ((getClientMetadata() == null) ? 0 : getClientMetadata().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof RespondToAuthChallengeRequest == false)
            return false;
        RespondToAuthChallengeRequest other = (RespondToAuthChallengeRequest) obj;

        if (other.getClientId() == null ^ this.getClientId() == null)
            return false;
        if (other.getClientId() != null && other.getClientId().equals(this.getClientId()) == false)
            return false;
        if (other.getChallengeName() == null ^ this.getChallengeName() == null)
            return false;
        if (other.getChallengeName() != null
                && other.getChallengeName().equals(this.getChallengeName()) == false)
            return false;
        if (other.getSession() == null ^ this.getSession() == null)
            return false;
        if (other.getSession() != null && other.getSession().equals(this.getSession()) == false)
            return false;
        if (other.getChallengeResponses() == null ^ this.getChallengeResponses() == null)
            return false;
        if (other.getChallengeResponses() != null
                && other.getChallengeResponses().equals(this.getChallengeResponses()) == false)
            return false;
        if (other.getAnalyticsMetadata() == null ^ this.getAnalyticsMetadata() == null)
            return false;
        if (other.getAnalyticsMetadata() != null
                && other.getAnalyticsMetadata().equals(this.getAnalyticsMetadata()) == false)
            return false;
        if (other.getUserContextData() == null ^ this.getUserContextData() == null)
            return false;
        if (other.getUserContextData() != null
                && other.getUserContextData().equals(this.getUserContextData()) == false)
            return false;
        if (other.getClientMetadata() == null ^ this.getClientMetadata() == null)
            return false;
        if (other.getClientMetadata() != null
                && other.getClientMetadata().equals(this.getClientMetadata()) == false)
            return false;
        return true;
    }
}
