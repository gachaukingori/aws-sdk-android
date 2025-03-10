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

package com.amazonaws.services.iot;

import java.util.*;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.iot.model.*;
import com.amazonaws.services.iot.model.transform.*;

/**
 * Client for accessing AWS IoT. All service calls made using this client are
 * blocking, and will not return until the service call completes.
 * <p>
 * <fullname>IoT</fullname>
 * <p>
 * IoT provides secure, bi-directional communication between Internet-connected
 * devices (such as sensors, actuators, embedded devices, or smart appliances)
 * and the Amazon Web Services cloud. You can discover your custom IoT-Data
 * endpoint to communicate with, configure rules for data processing and
 * integration with other services, organize resources associated with each
 * device (Registry), configure logging, and create and manage policies and
 * credentials to authenticate devices.
 * </p>
 * <p>
 * The service endpoints that expose this API are listed in <a
 * href="https://docs.aws.amazon.com/general/latest/gr/iot-core.html">Amazon Web
 * Services IoT Core Endpoints and Quotas</a>. You must use the endpoint for the
 * region that has the resources you want to access.
 * </p>
 * <p>
 * The service name used by <a href=
 * "https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html"
 * >Amazon Web Services Signature Version 4</a> to sign the request is:
 * <i>execute-api</i>.
 * </p>
 * <p>
 * For more information about how IoT works, see the <a href=
 * "https://docs.aws.amazon.com/iot/latest/developerguide/aws-iot-how-it-works.html"
 * >Developer Guide</a>.
 * </p>
 * <p>
 * For information about how to use the credentials provider for IoT, see <a
 * href=
 * "https://docs.aws.amazon.com/iot/latest/developerguide/authorizing-direct-aws.html"
 * >Authorizing Direct Calls to Amazon Web Services Services</a>.
 * </p>
 */
public class AWSIotClient extends AmazonWebServiceClient implements AWSIot {
    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AWS IoT exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on AWSIot. A
     * credentials provider chain will be used that searches for credentials in
     * this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AWSIotClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot. A
     * credentials provider chain will be used that searches for credentials in
     * this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to AWSIot (ex: proxy settings, retry
     *            counts, etc.).
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AWSIotClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials.
     * <p>
     * The client requests are authenticated using the {@link AWSCredentials}
     * provided in this constructor. Static AWSCredentials can be passed for
     * quick testing. However, it is strongly recommended to use Amazon Cognito
     * vended temporary credentials for use in production. This can be achieved
     * by using {@link AWSMobileClient}. Please see
     * https://aws-amplify.github.io/docs/android/authentication for
     * instructions on how to enable {@link AWSMobileClient}.
     *
     * <pre>
     * AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback&lt;UserStateDetails&gt;() {
     *     &#064;Override
     *     public void onResult(final UserStateDetails details) {
     *         AWSIotClient client = new AWSIotClient(AWSMobileClient.getInstance());
     *     }
     * 
     *     &#064;Override
     *     public void onError(final Exception e) {
     *         e.printStackTrace();
     *     }
     * });
     * </pre>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key)
     *            to use when authenticating with AWS services.
     */
    public AWSIotClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials and client configuration options.
     * <p>
     * The client requests are authenticated using the {@link AWSCredentials}
     * provided in this constructor. Static AWSCredentials can be passed for
     * quick testing. However, it is strongly recommended to use Amazon Cognito
     * vended temporary credentials for use in production. This can be achieved
     * by using {@link AWSMobileClient}. Please see
     * https://aws-amplify.github.io/docs/android/authentication for
     * instructions on how to enable {@link AWSMobileClient}.
     *
     * <pre>
     * AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback&lt;UserStateDetails&gt;() {
     *     &#064;Override
     *     public void onResult(final UserStateDetails details) {
     *         AWSIotClient client = new AWSIotClient(AWSMobileClient.getInstance());
     *     }
     * 
     *     &#064;Override
     *     public void onError(final Exception e) {
     *         e.printStackTrace();
     *     }
     * });
     * </pre>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key)
     *            to use when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to AWSIot (ex: proxy settings, retry
     *            counts, etc.).
     */
    public AWSIotClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(awsCredentials), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials provider.
     * <p>
     * The client requests are authenticated using the {@link AWSCredentials}
     * provided by the {@link AWSCredentialsProvider}. Static AWSCredentials can
     * be passed for quick testing. However, it is strongly recommended to use
     * Amazon Cognito vended temporary credentials for use in production. This
     * can be achieved by using {@link AWSMobileClient}. Please see
     * https://aws-amplify.github.io/docs/android/authentication for
     * instructions on how to enable {@link AWSMobileClient}.
     *
     * <pre>
     * AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback&lt;UserStateDetails&gt;() {
     *     &#064;Override
     *     public void onResult(final UserStateDetails details) {
     *         AWSIotClient client = new AWSIotClient(AWSMobileClient.getInstance());
     *     }
     * 
     *     &#064;Override
     *     public void onError(final Exception e) {
     *         e.printStackTrace();
     *     }
     * });
     * </pre>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     */
    public AWSIotClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials provider and client configuration
     * options.
     * <p>
     * The client requests are authenticated using the {@link AWSCredentials}
     * provided by the {@link AWSCredentialsProvider}. Static AWSCredentials can
     * be passed for quick testing. However, it is strongly recommended to use
     * Amazon Cognito vended temporary credentials for use in production. This
     * can be achieved by using {@link AWSMobileClient}. Please see
     * https://aws-amplify.github.io/docs/android/authentication for
     * instructions on how to enable {@link AWSMobileClient}.
     *
     * <pre>
     * AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback&lt;UserStateDetails&gt;() {
     *     &#064;Override
     *     public void onResult(final UserStateDetails details) {
     *         AWSIotClient client = new AWSIotClient(AWSMobileClient.getInstance());
     *     }
     * 
     *     &#064;Override
     *     public void onError(final Exception e) {
     *         e.printStackTrace();
     *     }
     * });
     * </pre>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to AWSIot (ex: proxy settings, retry
     *            counts, etc.).
     */
    public AWSIotClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials provider, client configuration options
     * and request metric collector.
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to AWSIot (ex: proxy settings, retry
     *            counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    @Deprecated
    public AWSIotClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);

        this.awsCredentialsProvider = awsCredentialsProvider;

        init();
    }

    /**
     * Constructs a new client to invoke service methods on AWSIot using the
     * specified AWS account credentials provider, client configuration options
     * and request metric collector.
     * <p>
     * The client requests are authenticated using the {@link AWSCredentials}
     * provided by the {@link AWSCredentialsProvider}. Static AWSCredentials can
     * be passed for quick testing. However, it is strongly recommended to use
     * Amazon Cognito vended temporary credentials for use in production. This
     * can be achieved by using {@link AWSMobileClient}. Please see
     * https://aws-amplify.github.io/docs/android/authentication for
     * instructions on how to enable {@link AWSMobileClient}.
     *
     * <pre>
     * AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback&lt;UserStateDetails&gt;() {
     *     &#064;Override
     *     public void onResult(final UserStateDetails details) {
     *         AWSIotClient client = new AWSIotClient(AWSMobileClient.getInstance());
     *     }
     * 
     *     &#064;Override
     *     public void onError(final Exception e) {
     *         e.printStackTrace();
     *     }
     * });
     * </pre>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to AWSIot (ex: proxy settings, retry
     *            counts, etc.).
     * @param httpClient A http client
     */
    public AWSIotClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);

        this.awsCredentialsProvider = awsCredentialsProvider;

        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new CertificateConflictExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new CertificateStateExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new CertificateValidationExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ConflictExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ConflictingResourceUpdateExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new DeleteConflictExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new IndexNotReadyExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InternalExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InternalFailureExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InternalServerExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidAggregationExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidQueryExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidRequestExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidResponseExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidStateTransitionExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new MalformedPolicyExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new NotConfiguredExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new RegistrationCodeValidationExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceAlreadyExistsExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceRegistrationFailureExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ServiceUnavailableExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new SqlParseExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TaskAlreadyExistsExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ThrottlingExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TransferAlreadyCompletedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TransferConflictExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new UnauthorizedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new VersionConflictExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new VersionsLimitExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());

        // calling this.setEndPoint(...) will also modify the signer accordingly
        setServiceNameIntern("execute-api");
        this.setEndpoint("iot.us-east-1.amazonaws.com");
        this.endpointPrefix = "iot";

        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/iot/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/iot/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;

        return config;
    }

    /**
     * <p>
     * Accepts a pending certificate transfer. The default state of the
     * certificate is INACTIVE.
     * </p>
     * <p>
     * To check for pending certificate transfers, call <a>ListCertificates</a>
     * to enumerate your certificates.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AcceptCertificateTransfer</a> action.
     * </p>
     * 
     * @param acceptCertificateTransferRequest <p>
     *            The input for the AcceptCertificateTransfer operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws TransferAlreadyCompletedException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void acceptCertificateTransfer(
            AcceptCertificateTransferRequest acceptCertificateTransferRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(acceptCertificateTransferRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AcceptCertificateTransferRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AcceptCertificateTransferRequestMarshaller()
                        .marshall(acceptCertificateTransferRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds a thing to a billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AddThingToBillingGroup</a> action.
     * </p>
     * 
     * @param addThingToBillingGroupRequest
     * @return addThingToBillingGroupResult The response from the
     *         AddThingToBillingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public AddThingToBillingGroupResult addThingToBillingGroup(
            AddThingToBillingGroupRequest addThingToBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(addThingToBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddThingToBillingGroupRequest> request = null;
        Response<AddThingToBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddThingToBillingGroupRequestMarshaller()
                        .marshall(addThingToBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<AddThingToBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new AddThingToBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<AddThingToBillingGroupResult> responseHandler = new JsonResponseHandler<AddThingToBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds a thing to a thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AddThingToThingGroup</a> action.
     * </p>
     * 
     * @param addThingToThingGroupRequest
     * @return addThingToThingGroupResult The response from the
     *         AddThingToThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public AddThingToThingGroupResult addThingToThingGroup(
            AddThingToThingGroupRequest addThingToThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(addThingToThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddThingToThingGroupRequest> request = null;
        Response<AddThingToThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddThingToThingGroupRequestMarshaller()
                        .marshall(addThingToThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<AddThingToThingGroupResult, JsonUnmarshallerContext> unmarshaller = new AddThingToThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<AddThingToThingGroupResult> responseHandler = new JsonResponseHandler<AddThingToThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Associates a group with a continuous job. The following criteria must be
     * met:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The job must have been created with the <code>targetSelection</code>
     * field set to "CONTINUOUS".
     * </p>
     * </li>
     * <li>
     * <p>
     * The job status must currently be "IN_PROGRESS".
     * </p>
     * </li>
     * <li>
     * <p>
     * The total number of targets associated with a job must not exceed 100.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AssociateTargetsWithJob</a> action.
     * </p>
     * 
     * @param associateTargetsWithJobRequest
     * @return associateTargetsWithJobResult The response from the
     *         AssociateTargetsWithJob service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public AssociateTargetsWithJobResult associateTargetsWithJob(
            AssociateTargetsWithJobRequest associateTargetsWithJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(associateTargetsWithJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateTargetsWithJobRequest> request = null;
        Response<AssociateTargetsWithJobResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateTargetsWithJobRequestMarshaller()
                        .marshall(associateTargetsWithJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<AssociateTargetsWithJobResult, JsonUnmarshallerContext> unmarshaller = new AssociateTargetsWithJobResultJsonUnmarshaller();
            JsonResponseHandler<AssociateTargetsWithJobResult> responseHandler = new JsonResponseHandler<AssociateTargetsWithJobResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Attaches the specified policy to the specified principal (certificate or
     * other credential).
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AttachPolicy</a> action.
     * </p>
     * 
     * @param attachPolicyRequest
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void attachPolicy(AttachPolicyRequest attachPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(attachPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachPolicyRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachPolicyRequestMarshaller().marshall(attachPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Attaches the specified policy to the specified principal (certificate or
     * other credential).
     * </p>
     * <p>
     * <b>Note:</b> This action is deprecated. Please use <a>AttachPolicy</a>
     * instead.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AttachPrincipalPolicy</a> action.
     * </p>
     * 
     * @param attachPrincipalPolicyRequest <p>
     *            The input for the AttachPrincipalPolicy operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    @Deprecated
    public void attachPrincipalPolicy(AttachPrincipalPolicyRequest attachPrincipalPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(attachPrincipalPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachPrincipalPolicyRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachPrincipalPolicyRequestMarshaller()
                        .marshall(attachPrincipalPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Associates a Device Defender security profile with a thing group or this
     * account. Each thing group or account can have up to five security
     * profiles associated with it.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AttachSecurityProfile</a> action.
     * </p>
     * 
     * @param attachSecurityProfileRequest
     * @return attachSecurityProfileResult The response from the
     *         AttachSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public AttachSecurityProfileResult attachSecurityProfile(
            AttachSecurityProfileRequest attachSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(attachSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachSecurityProfileRequest> request = null;
        Response<AttachSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachSecurityProfileRequestMarshaller()
                        .marshall(attachSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<AttachSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new AttachSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<AttachSecurityProfileResult> responseHandler = new JsonResponseHandler<AttachSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Attaches the specified principal to the specified thing. A principal can
     * be X.509 certificates, IAM users, groups, and roles, Amazon Cognito
     * identities or federated identities.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >AttachThingPrincipal</a> action.
     * </p>
     * 
     * @param attachThingPrincipalRequest <p>
     *            The input for the AttachThingPrincipal operation.
     *            </p>
     * @return attachThingPrincipalResult The response from the
     *         AttachThingPrincipal service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public AttachThingPrincipalResult attachThingPrincipal(
            AttachThingPrincipalRequest attachThingPrincipalRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(attachThingPrincipalRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachThingPrincipalRequest> request = null;
        Response<AttachThingPrincipalResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachThingPrincipalRequestMarshaller()
                        .marshall(attachThingPrincipalRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<AttachThingPrincipalResult, JsonUnmarshallerContext> unmarshaller = new AttachThingPrincipalResultJsonUnmarshaller();
            JsonResponseHandler<AttachThingPrincipalResult> responseHandler = new JsonResponseHandler<AttachThingPrincipalResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels a mitigation action task that is in progress. If the task is not
     * in progress, an InvalidRequestException occurs.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelAuditMitigationActionsTask</a> action.
     * </p>
     * 
     * @param cancelAuditMitigationActionsTaskRequest
     * @return cancelAuditMitigationActionsTaskResult The response from the
     *         CancelAuditMitigationActionsTask service method, as returned by
     *         AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CancelAuditMitigationActionsTaskResult cancelAuditMitigationActionsTask(
            CancelAuditMitigationActionsTaskRequest cancelAuditMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelAuditMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelAuditMitigationActionsTaskRequest> request = null;
        Response<CancelAuditMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelAuditMitigationActionsTaskRequestMarshaller()
                        .marshall(cancelAuditMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CancelAuditMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new CancelAuditMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<CancelAuditMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<CancelAuditMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels an audit that is in progress. The audit can be either scheduled
     * or on demand. If the audit isn't in progress, an
     * "InvalidRequestException" occurs.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelAuditTask</a> action.
     * </p>
     * 
     * @param cancelAuditTaskRequest
     * @return cancelAuditTaskResult The response from the CancelAuditTask
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CancelAuditTaskResult cancelAuditTask(CancelAuditTaskRequest cancelAuditTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelAuditTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelAuditTaskRequest> request = null;
        Response<CancelAuditTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelAuditTaskRequestMarshaller().marshall(cancelAuditTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CancelAuditTaskResult, JsonUnmarshallerContext> unmarshaller = new CancelAuditTaskResultJsonUnmarshaller();
            JsonResponseHandler<CancelAuditTaskResult> responseHandler = new JsonResponseHandler<CancelAuditTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels a pending transfer for the specified certificate.
     * </p>
     * <p>
     * <b>Note</b> Only the transfer source account can use this operation to
     * cancel a transfer. (Transfer destinations can use
     * <a>RejectCertificateTransfer</a> instead.) After transfer, IoT returns
     * the certificate to the source account in the INACTIVE state. After the
     * destination account has accepted the transfer, the transfer cannot be
     * cancelled.
     * </p>
     * <p>
     * After a certificate transfer is cancelled, the status of the certificate
     * changes from PENDING_TRANSFER to INACTIVE.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelCertificateTransfer</a> action.
     * </p>
     * 
     * @param cancelCertificateTransferRequest <p>
     *            The input for the CancelCertificateTransfer operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws TransferAlreadyCompletedException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void cancelCertificateTransfer(
            CancelCertificateTransferRequest cancelCertificateTransferRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelCertificateTransferRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelCertificateTransferRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelCertificateTransferRequestMarshaller()
                        .marshall(cancelCertificateTransferRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels a Device Defender ML Detect mitigation action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelDetectMitigationActionsTask</a> action.
     * </p>
     * 
     * @param cancelDetectMitigationActionsTaskRequest
     * @return cancelDetectMitigationActionsTaskResult The response from the
     *         CancelDetectMitigationActionsTask service method, as returned by
     *         AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CancelDetectMitigationActionsTaskResult cancelDetectMitigationActionsTask(
            CancelDetectMitigationActionsTaskRequest cancelDetectMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelDetectMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelDetectMitigationActionsTaskRequest> request = null;
        Response<CancelDetectMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelDetectMitigationActionsTaskRequestMarshaller()
                        .marshall(cancelDetectMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CancelDetectMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new CancelDetectMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<CancelDetectMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<CancelDetectMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels a job.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelJob</a> action.
     * </p>
     * 
     * @param cancelJobRequest
     * @return cancelJobResult The response from the CancelJob service method,
     *         as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CancelJobResult cancelJob(CancelJobRequest cancelJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelJobRequest> request = null;
        Response<CancelJobResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelJobRequestMarshaller().marshall(cancelJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CancelJobResult, JsonUnmarshallerContext> unmarshaller = new CancelJobResultJsonUnmarshaller();
            JsonResponseHandler<CancelJobResult> responseHandler = new JsonResponseHandler<CancelJobResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels the execution of a job for a given thing.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CancelJobExecution</a> action.
     * </p>
     * 
     * @param cancelJobExecutionRequest
     * @throws InvalidRequestException
     * @throws InvalidStateTransitionException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws VersionConflictException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void cancelJobExecution(CancelJobExecutionRequest cancelJobExecutionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(cancelJobExecutionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelJobExecutionRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelJobExecutionRequestMarshaller()
                        .marshall(cancelJobExecutionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Clears the default authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ClearDefaultAuthorizer</a> action.
     * </p>
     * 
     * @param clearDefaultAuthorizerRequest
     * @return clearDefaultAuthorizerResult The response from the
     *         ClearDefaultAuthorizer service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ClearDefaultAuthorizerResult clearDefaultAuthorizer(
            ClearDefaultAuthorizerRequest clearDefaultAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(clearDefaultAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ClearDefaultAuthorizerRequest> request = null;
        Response<ClearDefaultAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ClearDefaultAuthorizerRequestMarshaller()
                        .marshall(clearDefaultAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ClearDefaultAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new ClearDefaultAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<ClearDefaultAuthorizerResult> responseHandler = new JsonResponseHandler<ClearDefaultAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Confirms a topic rule destination. When you create a rule requiring a
     * destination, IoT sends a confirmation message to the endpoint or base
     * address you specify. The message includes a token which you pass back
     * when calling <code>ConfirmTopicRuleDestination</code> to confirm that you
     * own or have access to the endpoint.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ConfirmTopicRuleDestination</a> action.
     * </p>
     * 
     * @param confirmTopicRuleDestinationRequest
     * @return confirmTopicRuleDestinationResult The response from the
     *         ConfirmTopicRuleDestination service method, as returned by AWS
     *         IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ConfirmTopicRuleDestinationResult confirmTopicRuleDestination(
            ConfirmTopicRuleDestinationRequest confirmTopicRuleDestinationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(confirmTopicRuleDestinationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ConfirmTopicRuleDestinationRequest> request = null;
        Response<ConfirmTopicRuleDestinationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ConfirmTopicRuleDestinationRequestMarshaller()
                        .marshall(confirmTopicRuleDestinationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ConfirmTopicRuleDestinationResult, JsonUnmarshallerContext> unmarshaller = new ConfirmTopicRuleDestinationResultJsonUnmarshaller();
            JsonResponseHandler<ConfirmTopicRuleDestinationResult> responseHandler = new JsonResponseHandler<ConfirmTopicRuleDestinationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a Device Defender audit suppression.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateAuditSuppression</a> action.
     * </p>
     * 
     * @param createAuditSuppressionRequest
     * @return createAuditSuppressionResult The response from the
     *         CreateAuditSuppression service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateAuditSuppressionResult createAuditSuppression(
            CreateAuditSuppressionRequest createAuditSuppressionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createAuditSuppressionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateAuditSuppressionRequest> request = null;
        Response<CreateAuditSuppressionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateAuditSuppressionRequestMarshaller()
                        .marshall(createAuditSuppressionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateAuditSuppressionResult, JsonUnmarshallerContext> unmarshaller = new CreateAuditSuppressionResultJsonUnmarshaller();
            JsonResponseHandler<CreateAuditSuppressionResult> responseHandler = new JsonResponseHandler<CreateAuditSuppressionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates an authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateAuthorizer</a> action.
     * </p>
     * 
     * @param createAuthorizerRequest
     * @return createAuthorizerResult The response from the CreateAuthorizer
     *         service method, as returned by AWS IoT.
     * @throws ResourceAlreadyExistsException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateAuthorizerResult createAuthorizer(CreateAuthorizerRequest createAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateAuthorizerRequest> request = null;
        Response<CreateAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateAuthorizerRequestMarshaller().marshall(createAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new CreateAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<CreateAuthorizerResult> responseHandler = new JsonResponseHandler<CreateAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateBillingGroup</a> action.
     * </p>
     * 
     * @param createBillingGroupRequest
     * @return createBillingGroupResult The response from the CreateBillingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateBillingGroupResult createBillingGroup(
            CreateBillingGroupRequest createBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateBillingGroupRequest> request = null;
        Response<CreateBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateBillingGroupRequestMarshaller()
                        .marshall(createBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new CreateBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<CreateBillingGroupResult> responseHandler = new JsonResponseHandler<CreateBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates an X.509 certificate using the specified certificate signing
     * request.
     * </p>
     * <p>
     * <b>Note:</b> The CSR must include a public key that is either an RSA key
     * with a length of at least 2048 bits or an ECC key from NIST P-256, NIST
     * P-384, or NIST P-512 curves. For supported certificates, consult <a href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/x509-client-certs.html#x509-cert-algorithms"
     * > Certificate signing algorithms supported by IoT</a>.
     * </p>
     * <p>
     * <b>Note:</b> Reusing the same certificate signing request (CSR) results
     * in a distinct certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateCertificateFromCsr</a> action.
     * </p>
     * <p>
     * You can create multiple certificates in a batch by creating a directory,
     * copying multiple .csr files into that directory, and then specifying that
     * directory on the command line. The following commands show how to create
     * a batch of certificates given a batch of CSRs.
     * </p>
     * <p>
     * Assuming a set of CSRs are located inside of the directory
     * my-csr-directory:
     * </p>
     * <p>
     * On Linux and OS X, the command is:
     * </p>
     * <p>
     * $ ls my-csr-directory/ | xargs -I {} aws iot create-certificate-from-csr
     * --certificate-signing-request file://my-csr-directory/{}
     * </p>
     * <p>
     * This command lists all of the CSRs in my-csr-directory and pipes each CSR
     * file name to the aws iot create-certificate-from-csr Amazon Web Services
     * CLI command to create a certificate for the corresponding CSR.
     * </p>
     * <p>
     * The aws iot create-certificate-from-csr part of the command can also be
     * run in parallel to speed up the certificate creation process:
     * </p>
     * <p>
     * $ ls my-csr-directory/ | xargs -P 10 -I {} aws iot
     * create-certificate-from-csr --certificate-signing-request
     * file://my-csr-directory/{}
     * </p>
     * <p>
     * On Windows PowerShell, the command to create certificates for all CSRs in
     * my-csr-directory is:
     * </p>
     * <p>
     * &gt; ls -Name my-csr-directory | %{aws iot create-certificate-from-csr
     * --certificate-signing-request file://my-csr-directory/$_}
     * </p>
     * <p>
     * On a Windows command prompt, the command to create certificates for all
     * CSRs in my-csr-directory is:
     * </p>
     * <p>
     * &gt; forfiles /p my-csr-directory /c
     * "cmd /c aws iot create-certificate-from-csr --certificate-signing-request file://@path"
     * </p>
     * 
     * @param createCertificateFromCsrRequest <p>
     *            The input for the CreateCertificateFromCsr operation.
     *            </p>
     * @return createCertificateFromCsrResult The response from the
     *         CreateCertificateFromCsr service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateCertificateFromCsrResult createCertificateFromCsr(
            CreateCertificateFromCsrRequest createCertificateFromCsrRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createCertificateFromCsrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCertificateFromCsrRequest> request = null;
        Response<CreateCertificateFromCsrResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCertificateFromCsrRequestMarshaller()
                        .marshall(createCertificateFromCsrRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateCertificateFromCsrResult, JsonUnmarshallerContext> unmarshaller = new CreateCertificateFromCsrResultJsonUnmarshaller();
            JsonResponseHandler<CreateCertificateFromCsrResult> responseHandler = new JsonResponseHandler<CreateCertificateFromCsrResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Use this API to define a Custom Metric published by your devices to
     * Device Defender.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateCustomMetric</a> action.
     * </p>
     * 
     * @param createCustomMetricRequest
     * @return createCustomMetricResult The response from the CreateCustomMetric
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateCustomMetricResult createCustomMetric(
            CreateCustomMetricRequest createCustomMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createCustomMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCustomMetricRequest> request = null;
        Response<CreateCustomMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCustomMetricRequestMarshaller()
                        .marshall(createCustomMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateCustomMetricResult, JsonUnmarshallerContext> unmarshaller = new CreateCustomMetricResultJsonUnmarshaller();
            JsonResponseHandler<CreateCustomMetricResult> responseHandler = new JsonResponseHandler<CreateCustomMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Create a dimension that you can use to limit the scope of a metric used
     * in a security profile for IoT Device Defender. For example, using a
     * <code>TOPIC_FILTER</code> dimension, you can narrow down the scope of the
     * metric only to MQTT topics whose name match the pattern specified in the
     * dimension.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateDimension</a> action.
     * </p>
     * 
     * @param createDimensionRequest
     * @return createDimensionResult The response from the CreateDimension
     *         service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateDimensionResult createDimension(CreateDimensionRequest createDimensionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createDimensionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDimensionRequest> request = null;
        Response<CreateDimensionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDimensionRequestMarshaller().marshall(createDimensionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateDimensionResult, JsonUnmarshallerContext> unmarshaller = new CreateDimensionResultJsonUnmarshaller();
            JsonResponseHandler<CreateDimensionResult> responseHandler = new JsonResponseHandler<CreateDimensionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a domain configuration.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateDomainConfiguration</a> action.
     * </p>
     * 
     * @param createDomainConfigurationRequest
     * @return createDomainConfigurationResult The response from the
     *         CreateDomainConfiguration service method, as returned by AWS IoT.
     * @throws LimitExceededException
     * @throws CertificateValidationException
     * @throws ResourceAlreadyExistsException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws UnauthorizedException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateDomainConfigurationResult createDomainConfiguration(
            CreateDomainConfigurationRequest createDomainConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createDomainConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDomainConfigurationRequest> request = null;
        Response<CreateDomainConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDomainConfigurationRequestMarshaller()
                        .marshall(createDomainConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateDomainConfigurationResult, JsonUnmarshallerContext> unmarshaller = new CreateDomainConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<CreateDomainConfigurationResult> responseHandler = new JsonResponseHandler<CreateDomainConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a dynamic thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateDynamicThingGroup</a> action.
     * </p>
     * 
     * @param createDynamicThingGroupRequest
     * @return createDynamicThingGroupResult The response from the
     *         CreateDynamicThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws InvalidQueryException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateDynamicThingGroupResult createDynamicThingGroup(
            CreateDynamicThingGroupRequest createDynamicThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createDynamicThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDynamicThingGroupRequest> request = null;
        Response<CreateDynamicThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDynamicThingGroupRequestMarshaller()
                        .marshall(createDynamicThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateDynamicThingGroupResult, JsonUnmarshallerContext> unmarshaller = new CreateDynamicThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<CreateDynamicThingGroupResult> responseHandler = new JsonResponseHandler<CreateDynamicThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a fleet metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateFleetMetric</a> action.
     * </p>
     * 
     * @param createFleetMetricRequest
     * @return createFleetMetricResult The response from the CreateFleetMetric
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws ResourceAlreadyExistsException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateFleetMetricResult createFleetMetric(
            CreateFleetMetricRequest createFleetMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createFleetMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFleetMetricRequest> request = null;
        Response<CreateFleetMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFleetMetricRequestMarshaller()
                        .marshall(createFleetMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateFleetMetricResult, JsonUnmarshallerContext> unmarshaller = new CreateFleetMetricResultJsonUnmarshaller();
            JsonResponseHandler<CreateFleetMetricResult> responseHandler = new JsonResponseHandler<CreateFleetMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a job.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateJob</a> action.
     * </p>
     * 
     * @param createJobRequest
     * @return createJobResult The response from the CreateJob service method,
     *         as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ResourceAlreadyExistsException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateJobResult createJob(CreateJobRequest createJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateJobRequest> request = null;
        Response<CreateJobResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateJobRequestMarshaller().marshall(createJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateJobResult, JsonUnmarshallerContext> unmarshaller = new CreateJobResultJsonUnmarshaller();
            JsonResponseHandler<CreateJobResult> responseHandler = new JsonResponseHandler<CreateJobResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a job template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateJobTemplate</a> action.
     * </p>
     * 
     * @param createJobTemplateRequest
     * @return createJobTemplateResult The response from the CreateJobTemplate
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ConflictException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateJobTemplateResult createJobTemplate(
            CreateJobTemplateRequest createJobTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createJobTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateJobTemplateRequest> request = null;
        Response<CreateJobTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateJobTemplateRequestMarshaller()
                        .marshall(createJobTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateJobTemplateResult, JsonUnmarshallerContext> unmarshaller = new CreateJobTemplateResultJsonUnmarshaller();
            JsonResponseHandler<CreateJobTemplateResult> responseHandler = new JsonResponseHandler<CreateJobTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a 2048-bit RSA key pair and issues an X.509 certificate using the
     * issued public key. You can also call
     * <code>CreateKeysAndCertificate</code> over MQTT from a device, for more
     * information, see <a href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/provision-wo-cert.html#provision-mqtt-api"
     * >Provisioning MQTT API</a>.
     * </p>
     * <p>
     * <b>Note</b> This is the only time IoT issues the private key for this
     * certificate, so it is important to keep it in a secure location.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateKeysAndCertificate</a> action.
     * </p>
     * 
     * @param createKeysAndCertificateRequest <p>
     *            The input for the CreateKeysAndCertificate operation.
     *            </p>
     *            <p>
     *            Requires permission to access the <a href=
     *            "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     *            >CreateKeysAndCertificateRequest</a> action.
     *            </p>
     * @return createKeysAndCertificateResult The response from the
     *         CreateKeysAndCertificate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateKeysAndCertificateResult createKeysAndCertificate(
            CreateKeysAndCertificateRequest createKeysAndCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createKeysAndCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateKeysAndCertificateRequest> request = null;
        Response<CreateKeysAndCertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateKeysAndCertificateRequestMarshaller()
                        .marshall(createKeysAndCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateKeysAndCertificateResult, JsonUnmarshallerContext> unmarshaller = new CreateKeysAndCertificateResultJsonUnmarshaller();
            JsonResponseHandler<CreateKeysAndCertificateResult> responseHandler = new JsonResponseHandler<CreateKeysAndCertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Defines an action that can be applied to audit findings by using
     * StartAuditMitigationActionsTask. Only certain types of mitigation actions
     * can be applied to specific check names. For more information, see <a
     * href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/device-defender-mitigation-actions.html"
     * >Mitigation actions</a>. Each mitigation action can apply only one type
     * of change.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateMitigationAction</a> action.
     * </p>
     * 
     * @param createMitigationActionRequest
     * @return createMitigationActionResult The response from the
     *         CreateMitigationAction service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateMitigationActionResult createMitigationAction(
            CreateMitigationActionRequest createMitigationActionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createMitigationActionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateMitigationActionRequest> request = null;
        Response<CreateMitigationActionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateMitigationActionRequestMarshaller()
                        .marshall(createMitigationActionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateMitigationActionResult, JsonUnmarshallerContext> unmarshaller = new CreateMitigationActionResultJsonUnmarshaller();
            JsonResponseHandler<CreateMitigationActionResult> responseHandler = new JsonResponseHandler<CreateMitigationActionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates an IoT OTA update on a target group of things or groups.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateOTAUpdate</a> action.
     * </p>
     * 
     * @param createOTAUpdateRequest
     * @return createOTAUpdateResult The response from the CreateOTAUpdate
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateOTAUpdateResult createOTAUpdate(CreateOTAUpdateRequest createOTAUpdateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createOTAUpdateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateOTAUpdateRequest> request = null;
        Response<CreateOTAUpdateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateOTAUpdateRequestMarshaller().marshall(createOTAUpdateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateOTAUpdateResult, JsonUnmarshallerContext> unmarshaller = new CreateOTAUpdateResultJsonUnmarshaller();
            JsonResponseHandler<CreateOTAUpdateResult> responseHandler = new JsonResponseHandler<CreateOTAUpdateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates an IoT policy.
     * </p>
     * <p>
     * The created policy is the default version for the policy. This operation
     * creates a policy version with a version identifier of <b>1</b> and sets
     * <b>1</b> as the policy's default version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreatePolicy</a> action.
     * </p>
     * 
     * @param createPolicyRequest <p>
     *            The input for the CreatePolicy operation.
     *            </p>
     * @return createPolicyResult The response from the CreatePolicy service
     *         method, as returned by AWS IoT.
     * @throws ResourceAlreadyExistsException
     * @throws MalformedPolicyException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreatePolicyResult createPolicy(CreatePolicyRequest createPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePolicyRequest> request = null;
        Response<CreatePolicyResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePolicyRequestMarshaller().marshall(createPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreatePolicyResult, JsonUnmarshallerContext> unmarshaller = new CreatePolicyResultJsonUnmarshaller();
            JsonResponseHandler<CreatePolicyResult> responseHandler = new JsonResponseHandler<CreatePolicyResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a new version of the specified IoT policy. To update a policy,
     * create a new policy version. A managed policy can have up to five
     * versions. If the policy has five versions, you must use
     * <a>DeletePolicyVersion</a> to delete an existing version before you
     * create a new one.
     * </p>
     * <p>
     * Optionally, you can set the new version as the policy's default version.
     * The default version is the operative version (that is, the version that
     * is in effect for the certificates to which the policy is attached).
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreatePolicyVersion</a> action.
     * </p>
     * 
     * @param createPolicyVersionRequest <p>
     *            The input for the CreatePolicyVersion operation.
     *            </p>
     * @return createPolicyVersionResult The response from the
     *         CreatePolicyVersion service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws MalformedPolicyException
     * @throws VersionsLimitExceededException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreatePolicyVersionResult createPolicyVersion(
            CreatePolicyVersionRequest createPolicyVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createPolicyVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePolicyVersionRequest> request = null;
        Response<CreatePolicyVersionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePolicyVersionRequestMarshaller()
                        .marshall(createPolicyVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreatePolicyVersionResult, JsonUnmarshallerContext> unmarshaller = new CreatePolicyVersionResultJsonUnmarshaller();
            JsonResponseHandler<CreatePolicyVersionResult> responseHandler = new JsonResponseHandler<CreatePolicyVersionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a provisioning claim.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateProvisioningClaim</a> action.
     * </p>
     * 
     * @param createProvisioningClaimRequest
     * @return createProvisioningClaimResult The response from the
     *         CreateProvisioningClaim service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateProvisioningClaimResult createProvisioningClaim(
            CreateProvisioningClaimRequest createProvisioningClaimRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createProvisioningClaimRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateProvisioningClaimRequest> request = null;
        Response<CreateProvisioningClaimResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateProvisioningClaimRequestMarshaller()
                        .marshall(createProvisioningClaimRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateProvisioningClaimResult, JsonUnmarshallerContext> unmarshaller = new CreateProvisioningClaimResultJsonUnmarshaller();
            JsonResponseHandler<CreateProvisioningClaimResult> responseHandler = new JsonResponseHandler<CreateProvisioningClaimResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a fleet provisioning template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateProvisioningTemplate</a> action.
     * </p>
     * 
     * @param createProvisioningTemplateRequest
     * @return createProvisioningTemplateResult The response from the
     *         CreateProvisioningTemplate service method, as returned by AWS
     *         IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ResourceAlreadyExistsException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateProvisioningTemplateResult createProvisioningTemplate(
            CreateProvisioningTemplateRequest createProvisioningTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createProvisioningTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateProvisioningTemplateRequest> request = null;
        Response<CreateProvisioningTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateProvisioningTemplateRequestMarshaller()
                        .marshall(createProvisioningTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateProvisioningTemplateResult, JsonUnmarshallerContext> unmarshaller = new CreateProvisioningTemplateResultJsonUnmarshaller();
            JsonResponseHandler<CreateProvisioningTemplateResult> responseHandler = new JsonResponseHandler<CreateProvisioningTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a new version of a fleet provisioning template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateProvisioningTemplateVersion</a> action.
     * </p>
     * 
     * @param createProvisioningTemplateVersionRequest
     * @return createProvisioningTemplateVersionResult The response from the
     *         CreateProvisioningTemplateVersion service method, as returned by
     *         AWS IoT.
     * @throws VersionsLimitExceededException
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateProvisioningTemplateVersionResult createProvisioningTemplateVersion(
            CreateProvisioningTemplateVersionRequest createProvisioningTemplateVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createProvisioningTemplateVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateProvisioningTemplateVersionRequest> request = null;
        Response<CreateProvisioningTemplateVersionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateProvisioningTemplateVersionRequestMarshaller()
                        .marshall(createProvisioningTemplateVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateProvisioningTemplateVersionResult, JsonUnmarshallerContext> unmarshaller = new CreateProvisioningTemplateVersionResultJsonUnmarshaller();
            JsonResponseHandler<CreateProvisioningTemplateVersionResult> responseHandler = new JsonResponseHandler<CreateProvisioningTemplateVersionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a role alias.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateRoleAlias</a> action.
     * </p>
     * 
     * @param createRoleAliasRequest
     * @return createRoleAliasResult The response from the CreateRoleAlias
     *         service method, as returned by AWS IoT.
     * @throws ResourceAlreadyExistsException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateRoleAliasResult createRoleAlias(CreateRoleAliasRequest createRoleAliasRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createRoleAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateRoleAliasRequest> request = null;
        Response<CreateRoleAliasResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateRoleAliasRequestMarshaller().marshall(createRoleAliasRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateRoleAliasResult, JsonUnmarshallerContext> unmarshaller = new CreateRoleAliasResultJsonUnmarshaller();
            JsonResponseHandler<CreateRoleAliasResult> responseHandler = new JsonResponseHandler<CreateRoleAliasResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a scheduled audit that is run at a specified time interval.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateScheduledAudit</a> action.
     * </p>
     * 
     * @param createScheduledAuditRequest
     * @return createScheduledAuditResult The response from the
     *         CreateScheduledAudit service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateScheduledAuditResult createScheduledAudit(
            CreateScheduledAuditRequest createScheduledAuditRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createScheduledAuditRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateScheduledAuditRequest> request = null;
        Response<CreateScheduledAuditResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateScheduledAuditRequestMarshaller()
                        .marshall(createScheduledAuditRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateScheduledAuditResult, JsonUnmarshallerContext> unmarshaller = new CreateScheduledAuditResultJsonUnmarshaller();
            JsonResponseHandler<CreateScheduledAuditResult> responseHandler = new JsonResponseHandler<CreateScheduledAuditResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a Device Defender security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateSecurityProfile</a> action.
     * </p>
     * 
     * @param createSecurityProfileRequest
     * @return createSecurityProfileResult The response from the
     *         CreateSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateSecurityProfileResult createSecurityProfile(
            CreateSecurityProfileRequest createSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSecurityProfileRequest> request = null;
        Response<CreateSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSecurityProfileRequestMarshaller()
                        .marshall(createSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new CreateSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<CreateSecurityProfileResult> responseHandler = new JsonResponseHandler<CreateSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a stream for delivering one or more large files in chunks over
     * MQTT. A stream transports data bytes in chunks or blocks packaged as MQTT
     * messages from a source like S3. You can have one or more files associated
     * with a stream.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateStream</a> action.
     * </p>
     * 
     * @param createStreamRequest
     * @return createStreamResult The response from the CreateStream service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateStreamResult createStream(CreateStreamRequest createStreamRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateStreamRequest> request = null;
        Response<CreateStreamResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateStreamRequestMarshaller().marshall(createStreamRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateStreamResult, JsonUnmarshallerContext> unmarshaller = new CreateStreamResultJsonUnmarshaller();
            JsonResponseHandler<CreateStreamResult> responseHandler = new JsonResponseHandler<CreateStreamResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a thing record in the registry. If this call is made multiple
     * times using the same thing name and configuration, the call will succeed.
     * If this call is made with the same thing name but different configuration
     * a <code>ResourceAlreadyExistsException</code> is thrown.
     * </p>
     * <note>
     * <p>
     * This is a control plane operation. See <a href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/iot-authorization.html"
     * >Authorization</a> for information about authorizing control plane
     * actions.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateThing</a> action.
     * </p>
     * 
     * @param createThingRequest <p>
     *            The input for the CreateThing operation.
     *            </p>
     * @return createThingResult The response from the CreateThing service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceAlreadyExistsException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateThingResult createThing(CreateThingRequest createThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateThingRequest> request = null;
        Response<CreateThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateThingRequestMarshaller().marshall(createThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateThingResult, JsonUnmarshallerContext> unmarshaller = new CreateThingResultJsonUnmarshaller();
            JsonResponseHandler<CreateThingResult> responseHandler = new JsonResponseHandler<CreateThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Create a thing group.
     * </p>
     * <note>
     * <p>
     * This is a control plane operation. See <a href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/iot-authorization.html"
     * >Authorization</a> for information about authorizing control plane
     * actions.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateThingGroup</a> action.
     * </p>
     * 
     * @param createThingGroupRequest
     * @return createThingGroupResult The response from the CreateThingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateThingGroupResult createThingGroup(CreateThingGroupRequest createThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateThingGroupRequest> request = null;
        Response<CreateThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateThingGroupRequestMarshaller().marshall(createThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateThingGroupResult, JsonUnmarshallerContext> unmarshaller = new CreateThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<CreateThingGroupResult> responseHandler = new JsonResponseHandler<CreateThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a new thing type.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateThingType</a> action.
     * </p>
     * 
     * @param createThingTypeRequest <p>
     *            The input for the CreateThingType operation.
     *            </p>
     * @return createThingTypeResult The response from the CreateThingType
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceAlreadyExistsException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateThingTypeResult createThingType(CreateThingTypeRequest createThingTypeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createThingTypeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateThingTypeRequest> request = null;
        Response<CreateThingTypeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateThingTypeRequestMarshaller().marshall(createThingTypeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateThingTypeResult, JsonUnmarshallerContext> unmarshaller = new CreateThingTypeResultJsonUnmarshaller();
            JsonResponseHandler<CreateThingTypeResult> responseHandler = new JsonResponseHandler<CreateThingTypeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a rule. Creating rules is an administrator-level action. Any user
     * who has permission to create rules will be able to access data processed
     * by the rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateTopicRule</a> action.
     * </p>
     * 
     * @param createTopicRuleRequest <p>
     *            The input for the CreateTopicRule operation.
     *            </p>
     * @throws SqlParseException
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ServiceUnavailableException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void createTopicRule(CreateTopicRuleRequest createTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTopicRuleRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTopicRuleRequestMarshaller().marshall(createTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a topic rule destination. The destination must be confirmed prior
     * to use.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >CreateTopicRuleDestination</a> action.
     * </p>
     * 
     * @param createTopicRuleDestinationRequest
     * @return createTopicRuleDestinationResult The response from the
     *         CreateTopicRuleDestination service method, as returned by AWS
     *         IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ResourceAlreadyExistsException
     * @throws ServiceUnavailableException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public CreateTopicRuleDestinationResult createTopicRuleDestination(
            CreateTopicRuleDestinationRequest createTopicRuleDestinationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(createTopicRuleDestinationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTopicRuleDestinationRequest> request = null;
        Response<CreateTopicRuleDestinationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTopicRuleDestinationRequestMarshaller()
                        .marshall(createTopicRuleDestinationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<CreateTopicRuleDestinationResult, JsonUnmarshallerContext> unmarshaller = new CreateTopicRuleDestinationResultJsonUnmarshaller();
            JsonResponseHandler<CreateTopicRuleDestinationResult> responseHandler = new JsonResponseHandler<CreateTopicRuleDestinationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Restores the default settings for Device Defender audits for this
     * account. Any configuration data you entered is deleted and all audit
     * checks are reset to disabled.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteAccountAuditConfiguration</a> action.
     * </p>
     * 
     * @param deleteAccountAuditConfigurationRequest
     * @return deleteAccountAuditConfigurationResult The response from the
     *         DeleteAccountAuditConfiguration service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteAccountAuditConfigurationResult deleteAccountAuditConfiguration(
            DeleteAccountAuditConfigurationRequest deleteAccountAuditConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteAccountAuditConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteAccountAuditConfigurationRequest> request = null;
        Response<DeleteAccountAuditConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteAccountAuditConfigurationRequestMarshaller()
                        .marshall(deleteAccountAuditConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteAccountAuditConfigurationResult, JsonUnmarshallerContext> unmarshaller = new DeleteAccountAuditConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<DeleteAccountAuditConfigurationResult> responseHandler = new JsonResponseHandler<DeleteAccountAuditConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a Device Defender audit suppression.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteAuditSuppression</a> action.
     * </p>
     * 
     * @param deleteAuditSuppressionRequest
     * @return deleteAuditSuppressionResult The response from the
     *         DeleteAuditSuppression service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteAuditSuppressionResult deleteAuditSuppression(
            DeleteAuditSuppressionRequest deleteAuditSuppressionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteAuditSuppressionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteAuditSuppressionRequest> request = null;
        Response<DeleteAuditSuppressionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteAuditSuppressionRequestMarshaller()
                        .marshall(deleteAuditSuppressionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteAuditSuppressionResult, JsonUnmarshallerContext> unmarshaller = new DeleteAuditSuppressionResultJsonUnmarshaller();
            JsonResponseHandler<DeleteAuditSuppressionResult> responseHandler = new JsonResponseHandler<DeleteAuditSuppressionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes an authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteAuthorizer</a> action.
     * </p>
     * 
     * @param deleteAuthorizerRequest
     * @return deleteAuthorizerResult The response from the DeleteAuthorizer
     *         service method, as returned by AWS IoT.
     * @throws DeleteConflictException
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteAuthorizerResult deleteAuthorizer(DeleteAuthorizerRequest deleteAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteAuthorizerRequest> request = null;
        Response<DeleteAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteAuthorizerRequestMarshaller().marshall(deleteAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new DeleteAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<DeleteAuthorizerResult> responseHandler = new JsonResponseHandler<DeleteAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteBillingGroup</a> action.
     * </p>
     * 
     * @param deleteBillingGroupRequest
     * @return deleteBillingGroupResult The response from the DeleteBillingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteBillingGroupResult deleteBillingGroup(
            DeleteBillingGroupRequest deleteBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteBillingGroupRequest> request = null;
        Response<DeleteBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteBillingGroupRequestMarshaller()
                        .marshall(deleteBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new DeleteBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<DeleteBillingGroupResult> responseHandler = new JsonResponseHandler<DeleteBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a registered CA certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteCACertificate</a> action.
     * </p>
     * 
     * @param deleteCACertificateRequest <p>
     *            Input for the DeleteCACertificate operation.
     *            </p>
     * @return deleteCACertificateResult The response from the
     *         DeleteCACertificate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws CertificateStateException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteCACertificateResult deleteCACertificate(
            DeleteCACertificateRequest deleteCACertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteCACertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCACertificateRequest> request = null;
        Response<DeleteCACertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCACertificateRequestMarshaller()
                        .marshall(deleteCACertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteCACertificateResult, JsonUnmarshallerContext> unmarshaller = new DeleteCACertificateResultJsonUnmarshaller();
            JsonResponseHandler<DeleteCACertificateResult> responseHandler = new JsonResponseHandler<DeleteCACertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified certificate.
     * </p>
     * <p>
     * A certificate cannot be deleted if it has a policy or IoT thing attached
     * to it or if its status is set to ACTIVE. To delete a certificate, first
     * use the <a>DetachPolicy</a> action to detach all policies. Next, use the
     * <a>UpdateCertificate</a> action to set the certificate to the INACTIVE
     * status.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteCertificate</a> action.
     * </p>
     * 
     * @param deleteCertificateRequest <p>
     *            The input for the DeleteCertificate operation.
     *            </p>
     * @throws CertificateStateException
     * @throws DeleteConflictException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteCertificate(DeleteCertificateRequest deleteCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCertificateRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCertificateRequestMarshaller()
                        .marshall(deleteCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a Device Defender detect custom metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteCustomMetric</a> action.
     * </p>
     * <note>
     * <p>
     * Before you can delete a custom metric, you must first remove the custom
     * metric from all security profiles it's a part of. The security profile
     * associated with the custom metric can be found using the <a href=
     * "https://docs.aws.amazon.com/iot/latest/apireference/API_ListSecurityProfiles.html"
     * >ListSecurityProfiles</a> API with <code>metricName</code> set to your
     * custom metric name.
     * </p>
     * </note>
     * 
     * @param deleteCustomMetricRequest
     * @return deleteCustomMetricResult The response from the DeleteCustomMetric
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteCustomMetricResult deleteCustomMetric(
            DeleteCustomMetricRequest deleteCustomMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteCustomMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCustomMetricRequest> request = null;
        Response<DeleteCustomMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCustomMetricRequestMarshaller()
                        .marshall(deleteCustomMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteCustomMetricResult, JsonUnmarshallerContext> unmarshaller = new DeleteCustomMetricResultJsonUnmarshaller();
            JsonResponseHandler<DeleteCustomMetricResult> responseHandler = new JsonResponseHandler<DeleteCustomMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes the specified dimension from your Amazon Web Services accounts.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteDimension</a> action.
     * </p>
     * 
     * @param deleteDimensionRequest
     * @return deleteDimensionResult The response from the DeleteDimension
     *         service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteDimensionResult deleteDimension(DeleteDimensionRequest deleteDimensionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteDimensionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteDimensionRequest> request = null;
        Response<DeleteDimensionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDimensionRequestMarshaller().marshall(deleteDimensionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteDimensionResult, JsonUnmarshallerContext> unmarshaller = new DeleteDimensionResultJsonUnmarshaller();
            JsonResponseHandler<DeleteDimensionResult> responseHandler = new JsonResponseHandler<DeleteDimensionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified domain configuration.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteDomainConfiguration</a> action.
     * </p>
     * 
     * @param deleteDomainConfigurationRequest
     * @return deleteDomainConfigurationResult The response from the
     *         DeleteDomainConfiguration service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteDomainConfigurationResult deleteDomainConfiguration(
            DeleteDomainConfigurationRequest deleteDomainConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteDomainConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteDomainConfigurationRequest> request = null;
        Response<DeleteDomainConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDomainConfigurationRequestMarshaller()
                        .marshall(deleteDomainConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteDomainConfigurationResult, JsonUnmarshallerContext> unmarshaller = new DeleteDomainConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<DeleteDomainConfigurationResult> responseHandler = new JsonResponseHandler<DeleteDomainConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a dynamic thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteDynamicThingGroup</a> action.
     * </p>
     * 
     * @param deleteDynamicThingGroupRequest
     * @return deleteDynamicThingGroupResult The response from the
     *         DeleteDynamicThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteDynamicThingGroupResult deleteDynamicThingGroup(
            DeleteDynamicThingGroupRequest deleteDynamicThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteDynamicThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteDynamicThingGroupRequest> request = null;
        Response<DeleteDynamicThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDynamicThingGroupRequestMarshaller()
                        .marshall(deleteDynamicThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteDynamicThingGroupResult, JsonUnmarshallerContext> unmarshaller = new DeleteDynamicThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<DeleteDynamicThingGroupResult> responseHandler = new JsonResponseHandler<DeleteDynamicThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified fleet metric. Returns successfully with no error if
     * the deletion is successful or you specify a fleet metric that doesn't
     * exist.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteFleetMetric</a> action.
     * </p>
     * 
     * @param deleteFleetMetricRequest
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws VersionConflictException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteFleetMetric(DeleteFleetMetricRequest deleteFleetMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteFleetMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteFleetMetricRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteFleetMetricRequestMarshaller()
                        .marshall(deleteFleetMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a job and its related job executions.
     * </p>
     * <p>
     * Deleting a job may take time, depending on the number of job executions
     * created for the job and various other factors. While the job is being
     * deleted, the status of the job will be shown as "DELETION_IN_PROGRESS".
     * Attempting to delete or cancel a job whose status is already
     * "DELETION_IN_PROGRESS" will result in an error.
     * </p>
     * <p>
     * Only 10 jobs may have status "DELETION_IN_PROGRESS" at the same time, or
     * a LimitExceededException will occur.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteJob</a> action.
     * </p>
     * 
     * @param deleteJobRequest
     * @throws InvalidRequestException
     * @throws InvalidStateTransitionException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteJob(DeleteJobRequest deleteJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteJobRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteJobRequestMarshaller().marshall(deleteJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a job execution.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteJobExecution</a> action.
     * </p>
     * 
     * @param deleteJobExecutionRequest
     * @throws InvalidRequestException
     * @throws InvalidStateTransitionException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteJobExecution(DeleteJobExecutionRequest deleteJobExecutionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteJobExecutionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteJobExecutionRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteJobExecutionRequestMarshaller()
                        .marshall(deleteJobExecutionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified job template.
     * </p>
     * 
     * @param deleteJobTemplateRequest
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteJobTemplate(DeleteJobTemplateRequest deleteJobTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteJobTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteJobTemplateRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteJobTemplateRequestMarshaller()
                        .marshall(deleteJobTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a defined mitigation action from your Amazon Web Services
     * accounts.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteMitigationAction</a> action.
     * </p>
     * 
     * @param deleteMitigationActionRequest
     * @return deleteMitigationActionResult The response from the
     *         DeleteMitigationAction service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteMitigationActionResult deleteMitigationAction(
            DeleteMitigationActionRequest deleteMitigationActionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteMitigationActionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteMitigationActionRequest> request = null;
        Response<DeleteMitigationActionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteMitigationActionRequestMarshaller()
                        .marshall(deleteMitigationActionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteMitigationActionResult, JsonUnmarshallerContext> unmarshaller = new DeleteMitigationActionResultJsonUnmarshaller();
            JsonResponseHandler<DeleteMitigationActionResult> responseHandler = new JsonResponseHandler<DeleteMitigationActionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Delete an OTA update.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteOTAUpdate</a> action.
     * </p>
     * 
     * @param deleteOTAUpdateRequest
     * @return deleteOTAUpdateResult The response from the DeleteOTAUpdate
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ServiceUnavailableException
     * @throws VersionConflictException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteOTAUpdateResult deleteOTAUpdate(DeleteOTAUpdateRequest deleteOTAUpdateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteOTAUpdateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteOTAUpdateRequest> request = null;
        Response<DeleteOTAUpdateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteOTAUpdateRequestMarshaller().marshall(deleteOTAUpdateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteOTAUpdateResult, JsonUnmarshallerContext> unmarshaller = new DeleteOTAUpdateResultJsonUnmarshaller();
            JsonResponseHandler<DeleteOTAUpdateResult> responseHandler = new JsonResponseHandler<DeleteOTAUpdateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified policy.
     * </p>
     * <p>
     * A policy cannot be deleted if it has non-default versions or it is
     * attached to any certificate.
     * </p>
     * <p>
     * To delete a policy, use the <a>DeletePolicyVersion</a> action to delete
     * all non-default versions of the policy; use the <a>DetachPolicy</a>
     * action to detach the policy from any certificate; and then use the
     * DeletePolicy action to delete the policy.
     * </p>
     * <p>
     * When a policy is deleted using DeletePolicy, its default version is
     * deleted with it.
     * </p>
     * <note>
     * <p>
     * Because of the distributed nature of Amazon Web Services, it can take up
     * to five minutes after a policy is detached before it's ready to be
     * deleted.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeletePolicy</a> action.
     * </p>
     * 
     * @param deletePolicyRequest <p>
     *            The input for the DeletePolicy operation.
     *            </p>
     * @throws DeleteConflictException
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deletePolicy(DeletePolicyRequest deletePolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deletePolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeletePolicyRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeletePolicyRequestMarshaller().marshall(deletePolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified version of the specified policy. You cannot delete
     * the default version of a policy using this action. To delete the default
     * version of a policy, use <a>DeletePolicy</a>. To find out which version
     * of a policy is marked as the default version, use ListPolicyVersions.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeletePolicyVersion</a> action.
     * </p>
     * 
     * @param deletePolicyVersionRequest <p>
     *            The input for the DeletePolicyVersion operation.
     *            </p>
     * @throws DeleteConflictException
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deletePolicyVersion(DeletePolicyVersionRequest deletePolicyVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deletePolicyVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeletePolicyVersionRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeletePolicyVersionRequestMarshaller()
                        .marshall(deletePolicyVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a fleet provisioning template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteProvisioningTemplate</a> action.
     * </p>
     * 
     * @param deleteProvisioningTemplateRequest
     * @return deleteProvisioningTemplateResult The response from the
     *         DeleteProvisioningTemplate service method, as returned by AWS
     *         IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws DeleteConflictException
     * @throws ThrottlingException
     * @throws ConflictingResourceUpdateException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteProvisioningTemplateResult deleteProvisioningTemplate(
            DeleteProvisioningTemplateRequest deleteProvisioningTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteProvisioningTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteProvisioningTemplateRequest> request = null;
        Response<DeleteProvisioningTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteProvisioningTemplateRequestMarshaller()
                        .marshall(deleteProvisioningTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteProvisioningTemplateResult, JsonUnmarshallerContext> unmarshaller = new DeleteProvisioningTemplateResultJsonUnmarshaller();
            JsonResponseHandler<DeleteProvisioningTemplateResult> responseHandler = new JsonResponseHandler<DeleteProvisioningTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a fleet provisioning template version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteProvisioningTemplateVersion</a> action.
     * </p>
     * 
     * @param deleteProvisioningTemplateVersionRequest
     * @return deleteProvisioningTemplateVersionResult The response from the
     *         DeleteProvisioningTemplateVersion service method, as returned by
     *         AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws DeleteConflictException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteProvisioningTemplateVersionResult deleteProvisioningTemplateVersion(
            DeleteProvisioningTemplateVersionRequest deleteProvisioningTemplateVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteProvisioningTemplateVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteProvisioningTemplateVersionRequest> request = null;
        Response<DeleteProvisioningTemplateVersionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteProvisioningTemplateVersionRequestMarshaller()
                        .marshall(deleteProvisioningTemplateVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteProvisioningTemplateVersionResult, JsonUnmarshallerContext> unmarshaller = new DeleteProvisioningTemplateVersionResultJsonUnmarshaller();
            JsonResponseHandler<DeleteProvisioningTemplateVersionResult> responseHandler = new JsonResponseHandler<DeleteProvisioningTemplateVersionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a CA certificate registration code.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteRegistrationCode</a> action.
     * </p>
     * 
     * @param deleteRegistrationCodeRequest <p>
     *            The input for the DeleteRegistrationCode operation.
     *            </p>
     * @return deleteRegistrationCodeResult The response from the
     *         DeleteRegistrationCode service method, as returned by AWS IoT.
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteRegistrationCodeResult deleteRegistrationCode(
            DeleteRegistrationCodeRequest deleteRegistrationCodeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteRegistrationCodeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteRegistrationCodeRequest> request = null;
        Response<DeleteRegistrationCodeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteRegistrationCodeRequestMarshaller()
                        .marshall(deleteRegistrationCodeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteRegistrationCodeResult, JsonUnmarshallerContext> unmarshaller = new DeleteRegistrationCodeResultJsonUnmarshaller();
            JsonResponseHandler<DeleteRegistrationCodeResult> responseHandler = new JsonResponseHandler<DeleteRegistrationCodeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a role alias
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteRoleAlias</a> action.
     * </p>
     * 
     * @param deleteRoleAliasRequest
     * @return deleteRoleAliasResult The response from the DeleteRoleAlias
     *         service method, as returned by AWS IoT.
     * @throws DeleteConflictException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteRoleAliasResult deleteRoleAlias(DeleteRoleAliasRequest deleteRoleAliasRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteRoleAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteRoleAliasRequest> request = null;
        Response<DeleteRoleAliasResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteRoleAliasRequestMarshaller().marshall(deleteRoleAliasRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteRoleAliasResult, JsonUnmarshallerContext> unmarshaller = new DeleteRoleAliasResultJsonUnmarshaller();
            JsonResponseHandler<DeleteRoleAliasResult> responseHandler = new JsonResponseHandler<DeleteRoleAliasResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a scheduled audit.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteScheduledAudit</a> action.
     * </p>
     * 
     * @param deleteScheduledAuditRequest
     * @return deleteScheduledAuditResult The response from the
     *         DeleteScheduledAudit service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteScheduledAuditResult deleteScheduledAudit(
            DeleteScheduledAuditRequest deleteScheduledAuditRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteScheduledAuditRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteScheduledAuditRequest> request = null;
        Response<DeleteScheduledAuditResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteScheduledAuditRequestMarshaller()
                        .marshall(deleteScheduledAuditRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteScheduledAuditResult, JsonUnmarshallerContext> unmarshaller = new DeleteScheduledAuditResultJsonUnmarshaller();
            JsonResponseHandler<DeleteScheduledAuditResult> responseHandler = new JsonResponseHandler<DeleteScheduledAuditResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a Device Defender security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteSecurityProfile</a> action.
     * </p>
     * 
     * @param deleteSecurityProfileRequest
     * @return deleteSecurityProfileResult The response from the
     *         DeleteSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws VersionConflictException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteSecurityProfileResult deleteSecurityProfile(
            DeleteSecurityProfileRequest deleteSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSecurityProfileRequest> request = null;
        Response<DeleteSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSecurityProfileRequestMarshaller()
                        .marshall(deleteSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new DeleteSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<DeleteSecurityProfileResult> responseHandler = new JsonResponseHandler<DeleteSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a stream.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteStream</a> action.
     * </p>
     * 
     * @param deleteStreamRequest
     * @return deleteStreamResult The response from the DeleteStream service
     *         method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws DeleteConflictException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteStreamResult deleteStream(DeleteStreamRequest deleteStreamRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteStreamRequest> request = null;
        Response<DeleteStreamResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteStreamRequestMarshaller().marshall(deleteStreamRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteStreamResult, JsonUnmarshallerContext> unmarshaller = new DeleteStreamResultJsonUnmarshaller();
            JsonResponseHandler<DeleteStreamResult> responseHandler = new JsonResponseHandler<DeleteStreamResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified thing. Returns successfully with no error if the
     * deletion is successful or you specify a thing that doesn't exist.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteThing</a> action.
     * </p>
     * 
     * @param deleteThingRequest <p>
     *            The input for the DeleteThing operation.
     *            </p>
     * @return deleteThingResult The response from the DeleteThing service
     *         method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws VersionConflictException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteThingResult deleteThing(DeleteThingRequest deleteThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteThingRequest> request = null;
        Response<DeleteThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteThingRequestMarshaller().marshall(deleteThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteThingResult, JsonUnmarshallerContext> unmarshaller = new DeleteThingResultJsonUnmarshaller();
            JsonResponseHandler<DeleteThingResult> responseHandler = new JsonResponseHandler<DeleteThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteThingGroup</a> action.
     * </p>
     * 
     * @param deleteThingGroupRequest
     * @return deleteThingGroupResult The response from the DeleteThingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteThingGroupResult deleteThingGroup(DeleteThingGroupRequest deleteThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteThingGroupRequest> request = null;
        Response<DeleteThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteThingGroupRequestMarshaller().marshall(deleteThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteThingGroupResult, JsonUnmarshallerContext> unmarshaller = new DeleteThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<DeleteThingGroupResult> responseHandler = new JsonResponseHandler<DeleteThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the specified thing type. You cannot delete a thing type if it
     * has things associated with it. To delete a thing type, first mark it as
     * deprecated by calling <a>DeprecateThingType</a>, then remove any
     * associated things by calling <a>UpdateThing</a> to change the thing type
     * on any associated thing, and finally use <a>DeleteThingType</a> to delete
     * the thing type.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteThingType</a> action.
     * </p>
     * 
     * @param deleteThingTypeRequest <p>
     *            The input for the DeleteThingType operation.
     *            </p>
     * @return deleteThingTypeResult The response from the DeleteThingType
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteThingTypeResult deleteThingType(DeleteThingTypeRequest deleteThingTypeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteThingTypeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteThingTypeRequest> request = null;
        Response<DeleteThingTypeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteThingTypeRequestMarshaller().marshall(deleteThingTypeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteThingTypeResult, JsonUnmarshallerContext> unmarshaller = new DeleteThingTypeResultJsonUnmarshaller();
            JsonResponseHandler<DeleteThingTypeResult> responseHandler = new JsonResponseHandler<DeleteThingTypeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes the rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteTopicRule</a> action.
     * </p>
     * 
     * @param deleteTopicRuleRequest <p>
     *            The input for the DeleteTopicRule operation.
     *            </p>
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteTopicRule(DeleteTopicRuleRequest deleteTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTopicRuleRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTopicRuleRequestMarshaller().marshall(deleteTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a topic rule destination.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteTopicRuleDestination</a> action.
     * </p>
     * 
     * @param deleteTopicRuleDestinationRequest
     * @return deleteTopicRuleDestinationResult The response from the
     *         DeleteTopicRuleDestination service method, as returned by AWS
     *         IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeleteTopicRuleDestinationResult deleteTopicRuleDestination(
            DeleteTopicRuleDestinationRequest deleteTopicRuleDestinationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteTopicRuleDestinationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTopicRuleDestinationRequest> request = null;
        Response<DeleteTopicRuleDestinationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTopicRuleDestinationRequestMarshaller()
                        .marshall(deleteTopicRuleDestinationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeleteTopicRuleDestinationResult, JsonUnmarshallerContext> unmarshaller = new DeleteTopicRuleDestinationResultJsonUnmarshaller();
            JsonResponseHandler<DeleteTopicRuleDestinationResult> responseHandler = new JsonResponseHandler<DeleteTopicRuleDestinationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a logging level.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeleteV2LoggingLevel</a> action.
     * </p>
     * 
     * @param deleteV2LoggingLevelRequest
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void deleteV2LoggingLevel(DeleteV2LoggingLevelRequest deleteV2LoggingLevelRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deleteV2LoggingLevelRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteV2LoggingLevelRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteV2LoggingLevelRequestMarshaller()
                        .marshall(deleteV2LoggingLevelRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deprecates a thing type. You can not associate new things with deprecated
     * thing type.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DeprecateThingType</a> action.
     * </p>
     * 
     * @param deprecateThingTypeRequest <p>
     *            The input for the DeprecateThingType operation.
     *            </p>
     * @return deprecateThingTypeResult The response from the DeprecateThingType
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DeprecateThingTypeResult deprecateThingType(
            DeprecateThingTypeRequest deprecateThingTypeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(deprecateThingTypeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeprecateThingTypeRequest> request = null;
        Response<DeprecateThingTypeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeprecateThingTypeRequestMarshaller()
                        .marshall(deprecateThingTypeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DeprecateThingTypeResult, JsonUnmarshallerContext> unmarshaller = new DeprecateThingTypeResultJsonUnmarshaller();
            JsonResponseHandler<DeprecateThingTypeResult> responseHandler = new JsonResponseHandler<DeprecateThingTypeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the Device Defender audit settings for this
     * account. Settings include how audit notifications are sent and which
     * audit checks are enabled or disabled.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeAccountAuditConfiguration</a> action.
     * </p>
     * 
     * @param describeAccountAuditConfigurationRequest
     * @return describeAccountAuditConfigurationResult The response from the
     *         DescribeAccountAuditConfiguration service method, as returned by
     *         AWS IoT.
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAccountAuditConfigurationResult describeAccountAuditConfiguration(
            DescribeAccountAuditConfigurationRequest describeAccountAuditConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAccountAuditConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAccountAuditConfigurationRequest> request = null;
        Response<DescribeAccountAuditConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAccountAuditConfigurationRequestMarshaller()
                        .marshall(describeAccountAuditConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAccountAuditConfigurationResult, JsonUnmarshallerContext> unmarshaller = new DescribeAccountAuditConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAccountAuditConfigurationResult> responseHandler = new JsonResponseHandler<DescribeAccountAuditConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a single audit finding. Properties include the
     * reason for noncompliance, the severity of the issue, and the start time
     * when the audit that returned the finding.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeAuditFinding</a> action.
     * </p>
     * 
     * @param describeAuditFindingRequest
     * @return describeAuditFindingResult The response from the
     *         DescribeAuditFinding service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAuditFindingResult describeAuditFinding(
            DescribeAuditFindingRequest describeAuditFindingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAuditFindingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAuditFindingRequest> request = null;
        Response<DescribeAuditFindingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAuditFindingRequestMarshaller()
                        .marshall(describeAuditFindingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAuditFindingResult, JsonUnmarshallerContext> unmarshaller = new DescribeAuditFindingResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAuditFindingResult> responseHandler = new JsonResponseHandler<DescribeAuditFindingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about an audit mitigation task that is used to apply
     * mitigation actions to a set of audit findings. Properties include the
     * actions being applied, the audit checks to which they're being applied,
     * the task status, and aggregated task statistics.
     * </p>
     * 
     * @param describeAuditMitigationActionsTaskRequest
     * @return describeAuditMitigationActionsTaskResult The response from the
     *         DescribeAuditMitigationActionsTask service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAuditMitigationActionsTaskResult describeAuditMitigationActionsTask(
            DescribeAuditMitigationActionsTaskRequest describeAuditMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAuditMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAuditMitigationActionsTaskRequest> request = null;
        Response<DescribeAuditMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAuditMitigationActionsTaskRequestMarshaller()
                        .marshall(describeAuditMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAuditMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new DescribeAuditMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAuditMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<DescribeAuditMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a Device Defender audit suppression.
     * </p>
     * 
     * @param describeAuditSuppressionRequest
     * @return describeAuditSuppressionResult The response from the
     *         DescribeAuditSuppression service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAuditSuppressionResult describeAuditSuppression(
            DescribeAuditSuppressionRequest describeAuditSuppressionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAuditSuppressionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAuditSuppressionRequest> request = null;
        Response<DescribeAuditSuppressionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAuditSuppressionRequestMarshaller()
                        .marshall(describeAuditSuppressionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAuditSuppressionResult, JsonUnmarshallerContext> unmarshaller = new DescribeAuditSuppressionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAuditSuppressionResult> responseHandler = new JsonResponseHandler<DescribeAuditSuppressionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a Device Defender audit.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeAuditTask</a> action.
     * </p>
     * 
     * @param describeAuditTaskRequest
     * @return describeAuditTaskResult The response from the DescribeAuditTask
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAuditTaskResult describeAuditTask(
            DescribeAuditTaskRequest describeAuditTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAuditTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAuditTaskRequest> request = null;
        Response<DescribeAuditTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAuditTaskRequestMarshaller()
                        .marshall(describeAuditTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAuditTaskResult, JsonUnmarshallerContext> unmarshaller = new DescribeAuditTaskResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAuditTaskResult> responseHandler = new JsonResponseHandler<DescribeAuditTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes an authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeAuthorizer</a> action.
     * </p>
     * 
     * @param describeAuthorizerRequest
     * @return describeAuthorizerResult The response from the DescribeAuthorizer
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeAuthorizerResult describeAuthorizer(
            DescribeAuthorizerRequest describeAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAuthorizerRequest> request = null;
        Response<DescribeAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAuthorizerRequestMarshaller()
                        .marshall(describeAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new DescribeAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<DescribeAuthorizerResult> responseHandler = new JsonResponseHandler<DescribeAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns information about a billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeBillingGroup</a> action.
     * </p>
     * 
     * @param describeBillingGroupRequest
     * @return describeBillingGroupResult The response from the
     *         DescribeBillingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeBillingGroupResult describeBillingGroup(
            DescribeBillingGroupRequest describeBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeBillingGroupRequest> request = null;
        Response<DescribeBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeBillingGroupRequestMarshaller()
                        .marshall(describeBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new DescribeBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<DescribeBillingGroupResult> responseHandler = new JsonResponseHandler<DescribeBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a registered CA certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeCACertificate</a> action.
     * </p>
     * 
     * @param describeCACertificateRequest <p>
     *            The input for the DescribeCACertificate operation.
     *            </p>
     * @return describeCACertificateResult The response from the
     *         DescribeCACertificate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeCACertificateResult describeCACertificate(
            DescribeCACertificateRequest describeCACertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeCACertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCACertificateRequest> request = null;
        Response<DescribeCACertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCACertificateRequestMarshaller()
                        .marshall(describeCACertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeCACertificateResult, JsonUnmarshallerContext> unmarshaller = new DescribeCACertificateResultJsonUnmarshaller();
            JsonResponseHandler<DescribeCACertificateResult> responseHandler = new JsonResponseHandler<DescribeCACertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeCertificate</a> action.
     * </p>
     * 
     * @param describeCertificateRequest <p>
     *            The input for the DescribeCertificate operation.
     *            </p>
     * @return describeCertificateResult The response from the
     *         DescribeCertificate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeCertificateResult describeCertificate(
            DescribeCertificateRequest describeCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCertificateRequest> request = null;
        Response<DescribeCertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCertificateRequestMarshaller()
                        .marshall(describeCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeCertificateResult, JsonUnmarshallerContext> unmarshaller = new DescribeCertificateResultJsonUnmarshaller();
            JsonResponseHandler<DescribeCertificateResult> responseHandler = new JsonResponseHandler<DescribeCertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a Device Defender detect custom metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeCustomMetric</a> action.
     * </p>
     * 
     * @param describeCustomMetricRequest
     * @return describeCustomMetricResult The response from the
     *         DescribeCustomMetric service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeCustomMetricResult describeCustomMetric(
            DescribeCustomMetricRequest describeCustomMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeCustomMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCustomMetricRequest> request = null;
        Response<DescribeCustomMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCustomMetricRequestMarshaller()
                        .marshall(describeCustomMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeCustomMetricResult, JsonUnmarshallerContext> unmarshaller = new DescribeCustomMetricResultJsonUnmarshaller();
            JsonResponseHandler<DescribeCustomMetricResult> responseHandler = new JsonResponseHandler<DescribeCustomMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes the default authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeDefaultAuthorizer</a> action.
     * </p>
     * 
     * @param describeDefaultAuthorizerRequest
     * @return describeDefaultAuthorizerResult The response from the
     *         DescribeDefaultAuthorizer service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeDefaultAuthorizerResult describeDefaultAuthorizer(
            DescribeDefaultAuthorizerRequest describeDefaultAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeDefaultAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeDefaultAuthorizerRequest> request = null;
        Response<DescribeDefaultAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeDefaultAuthorizerRequestMarshaller()
                        .marshall(describeDefaultAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeDefaultAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new DescribeDefaultAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<DescribeDefaultAuthorizerResult> responseHandler = new JsonResponseHandler<DescribeDefaultAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a Device Defender ML Detect mitigation action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeDetectMitigationActionsTask</a> action.
     * </p>
     * 
     * @param describeDetectMitigationActionsTaskRequest
     * @return describeDetectMitigationActionsTaskResult The response from the
     *         DescribeDetectMitigationActionsTask service method, as returned
     *         by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeDetectMitigationActionsTaskResult describeDetectMitigationActionsTask(
            DescribeDetectMitigationActionsTaskRequest describeDetectMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeDetectMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeDetectMitigationActionsTaskRequest> request = null;
        Response<DescribeDetectMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeDetectMitigationActionsTaskRequestMarshaller()
                        .marshall(describeDetectMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeDetectMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new DescribeDetectMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<DescribeDetectMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<DescribeDetectMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Provides details about a dimension that is defined in your Amazon Web
     * Services accounts.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeDimension</a> action.
     * </p>
     * 
     * @param describeDimensionRequest
     * @return describeDimensionResult The response from the DescribeDimension
     *         service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeDimensionResult describeDimension(
            DescribeDimensionRequest describeDimensionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeDimensionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeDimensionRequest> request = null;
        Response<DescribeDimensionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeDimensionRequestMarshaller()
                        .marshall(describeDimensionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeDimensionResult, JsonUnmarshallerContext> unmarshaller = new DescribeDimensionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeDimensionResult> responseHandler = new JsonResponseHandler<DescribeDimensionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets summary information about a domain configuration.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeDomainConfiguration</a> action.
     * </p>
     * 
     * @param describeDomainConfigurationRequest
     * @return describeDomainConfigurationResult The response from the
     *         DescribeDomainConfiguration service method, as returned by AWS
     *         IoT.
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InvalidRequestException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeDomainConfigurationResult describeDomainConfiguration(
            DescribeDomainConfigurationRequest describeDomainConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeDomainConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeDomainConfigurationRequest> request = null;
        Response<DescribeDomainConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeDomainConfigurationRequestMarshaller()
                        .marshall(describeDomainConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeDomainConfigurationResult, JsonUnmarshallerContext> unmarshaller = new DescribeDomainConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<DescribeDomainConfigurationResult> responseHandler = new JsonResponseHandler<DescribeDomainConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a unique endpoint specific to the Amazon Web Services account
     * making the call.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeEndpoint</a> action.
     * </p>
     * 
     * @param describeEndpointRequest <p>
     *            The input for the DescribeEndpoint operation.
     *            </p>
     * @return describeEndpointResult The response from the DescribeEndpoint
     *         service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws UnauthorizedException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeEndpointResult describeEndpoint(DescribeEndpointRequest describeEndpointRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeEndpointRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeEndpointRequest> request = null;
        Response<DescribeEndpointResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeEndpointRequestMarshaller().marshall(describeEndpointRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeEndpointResult, JsonUnmarshallerContext> unmarshaller = new DescribeEndpointResultJsonUnmarshaller();
            JsonResponseHandler<DescribeEndpointResult> responseHandler = new JsonResponseHandler<DescribeEndpointResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes event configurations.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeEventConfigurations</a> action.
     * </p>
     * 
     * @param describeEventConfigurationsRequest
     * @return describeEventConfigurationsResult The response from the
     *         DescribeEventConfigurations service method, as returned by AWS
     *         IoT.
     * @throws InternalFailureException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeEventConfigurationsResult describeEventConfigurations(
            DescribeEventConfigurationsRequest describeEventConfigurationsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeEventConfigurationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeEventConfigurationsRequest> request = null;
        Response<DescribeEventConfigurationsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeEventConfigurationsRequestMarshaller()
                        .marshall(describeEventConfigurationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeEventConfigurationsResult, JsonUnmarshallerContext> unmarshaller = new DescribeEventConfigurationsResultJsonUnmarshaller();
            JsonResponseHandler<DescribeEventConfigurationsResult> responseHandler = new JsonResponseHandler<DescribeEventConfigurationsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified fleet metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeFleetMetric</a> action.
     * </p>
     * 
     * @param describeFleetMetricRequest
     * @return describeFleetMetricResult The response from the
     *         DescribeFleetMetric service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeFleetMetricResult describeFleetMetric(
            DescribeFleetMetricRequest describeFleetMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeFleetMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFleetMetricRequest> request = null;
        Response<DescribeFleetMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFleetMetricRequestMarshaller()
                        .marshall(describeFleetMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeFleetMetricResult, JsonUnmarshallerContext> unmarshaller = new DescribeFleetMetricResultJsonUnmarshaller();
            JsonResponseHandler<DescribeFleetMetricResult> responseHandler = new JsonResponseHandler<DescribeFleetMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a search index.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeIndex</a> action.
     * </p>
     * 
     * @param describeIndexRequest
     * @return describeIndexResult The response from the DescribeIndex service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeIndexResult describeIndex(DescribeIndexRequest describeIndexRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeIndexRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeIndexRequest> request = null;
        Response<DescribeIndexResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeIndexRequestMarshaller().marshall(describeIndexRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeIndexResult, JsonUnmarshallerContext> unmarshaller = new DescribeIndexResultJsonUnmarshaller();
            JsonResponseHandler<DescribeIndexResult> responseHandler = new JsonResponseHandler<DescribeIndexResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a job.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeJob</a> action.
     * </p>
     * 
     * @param describeJobRequest
     * @return describeJobResult The response from the DescribeJob service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeJobResult describeJob(DescribeJobRequest describeJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeJobRequest> request = null;
        Response<DescribeJobResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeJobRequestMarshaller().marshall(describeJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeJobResult, JsonUnmarshallerContext> unmarshaller = new DescribeJobResultJsonUnmarshaller();
            JsonResponseHandler<DescribeJobResult> responseHandler = new JsonResponseHandler<DescribeJobResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a job execution.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeJobExecution</a> action.
     * </p>
     * 
     * @param describeJobExecutionRequest
     * @return describeJobExecutionResult The response from the
     *         DescribeJobExecution service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeJobExecutionResult describeJobExecution(
            DescribeJobExecutionRequest describeJobExecutionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeJobExecutionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeJobExecutionRequest> request = null;
        Response<DescribeJobExecutionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeJobExecutionRequestMarshaller()
                        .marshall(describeJobExecutionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeJobExecutionResult, JsonUnmarshallerContext> unmarshaller = new DescribeJobExecutionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeJobExecutionResult> responseHandler = new JsonResponseHandler<DescribeJobExecutionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns information about a job template.
     * </p>
     * 
     * @param describeJobTemplateRequest
     * @return describeJobTemplateResult The response from the
     *         DescribeJobTemplate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeJobTemplateResult describeJobTemplate(
            DescribeJobTemplateRequest describeJobTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeJobTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeJobTemplateRequest> request = null;
        Response<DescribeJobTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeJobTemplateRequestMarshaller()
                        .marshall(describeJobTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeJobTemplateResult, JsonUnmarshallerContext> unmarshaller = new DescribeJobTemplateResultJsonUnmarshaller();
            JsonResponseHandler<DescribeJobTemplateResult> responseHandler = new JsonResponseHandler<DescribeJobTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * View details of a managed job template.
     * </p>
     * 
     * @param describeManagedJobTemplateRequest
     * @return describeManagedJobTemplateResult The response from the
     *         DescribeManagedJobTemplate service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServerException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeManagedJobTemplateResult describeManagedJobTemplate(
            DescribeManagedJobTemplateRequest describeManagedJobTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeManagedJobTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeManagedJobTemplateRequest> request = null;
        Response<DescribeManagedJobTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeManagedJobTemplateRequestMarshaller()
                        .marshall(describeManagedJobTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeManagedJobTemplateResult, JsonUnmarshallerContext> unmarshaller = new DescribeManagedJobTemplateResultJsonUnmarshaller();
            JsonResponseHandler<DescribeManagedJobTemplateResult> responseHandler = new JsonResponseHandler<DescribeManagedJobTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a mitigation action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeMitigationAction</a> action.
     * </p>
     * 
     * @param describeMitigationActionRequest
     * @return describeMitigationActionResult The response from the
     *         DescribeMitigationAction service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeMitigationActionResult describeMitigationAction(
            DescribeMitigationActionRequest describeMitigationActionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeMitigationActionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeMitigationActionRequest> request = null;
        Response<DescribeMitigationActionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeMitigationActionRequestMarshaller()
                        .marshall(describeMitigationActionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeMitigationActionResult, JsonUnmarshallerContext> unmarshaller = new DescribeMitigationActionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeMitigationActionResult> responseHandler = new JsonResponseHandler<DescribeMitigationActionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns information about a fleet provisioning template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeProvisioningTemplate</a> action.
     * </p>
     * 
     * @param describeProvisioningTemplateRequest
     * @return describeProvisioningTemplateResult The response from the
     *         DescribeProvisioningTemplate service method, as returned by AWS
     *         IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeProvisioningTemplateResult describeProvisioningTemplate(
            DescribeProvisioningTemplateRequest describeProvisioningTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeProvisioningTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeProvisioningTemplateRequest> request = null;
        Response<DescribeProvisioningTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeProvisioningTemplateRequestMarshaller()
                        .marshall(describeProvisioningTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeProvisioningTemplateResult, JsonUnmarshallerContext> unmarshaller = new DescribeProvisioningTemplateResultJsonUnmarshaller();
            JsonResponseHandler<DescribeProvisioningTemplateResult> responseHandler = new JsonResponseHandler<DescribeProvisioningTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns information about a fleet provisioning template version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeProvisioningTemplateVersion</a> action.
     * </p>
     * 
     * @param describeProvisioningTemplateVersionRequest
     * @return describeProvisioningTemplateVersionResult The response from the
     *         DescribeProvisioningTemplateVersion service method, as returned
     *         by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeProvisioningTemplateVersionResult describeProvisioningTemplateVersion(
            DescribeProvisioningTemplateVersionRequest describeProvisioningTemplateVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeProvisioningTemplateVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeProvisioningTemplateVersionRequest> request = null;
        Response<DescribeProvisioningTemplateVersionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeProvisioningTemplateVersionRequestMarshaller()
                        .marshall(describeProvisioningTemplateVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeProvisioningTemplateVersionResult, JsonUnmarshallerContext> unmarshaller = new DescribeProvisioningTemplateVersionResultJsonUnmarshaller();
            JsonResponseHandler<DescribeProvisioningTemplateVersionResult> responseHandler = new JsonResponseHandler<DescribeProvisioningTemplateVersionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a role alias.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeRoleAlias</a> action.
     * </p>
     * 
     * @param describeRoleAliasRequest
     * @return describeRoleAliasResult The response from the DescribeRoleAlias
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeRoleAliasResult describeRoleAlias(
            DescribeRoleAliasRequest describeRoleAliasRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeRoleAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeRoleAliasRequest> request = null;
        Response<DescribeRoleAliasResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeRoleAliasRequestMarshaller()
                        .marshall(describeRoleAliasRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeRoleAliasResult, JsonUnmarshallerContext> unmarshaller = new DescribeRoleAliasResultJsonUnmarshaller();
            JsonResponseHandler<DescribeRoleAliasResult> responseHandler = new JsonResponseHandler<DescribeRoleAliasResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a scheduled audit.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeScheduledAudit</a> action.
     * </p>
     * 
     * @param describeScheduledAuditRequest
     * @return describeScheduledAuditResult The response from the
     *         DescribeScheduledAudit service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeScheduledAuditResult describeScheduledAudit(
            DescribeScheduledAuditRequest describeScheduledAuditRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeScheduledAuditRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScheduledAuditRequest> request = null;
        Response<DescribeScheduledAuditResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScheduledAuditRequestMarshaller()
                        .marshall(describeScheduledAuditRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeScheduledAuditResult, JsonUnmarshallerContext> unmarshaller = new DescribeScheduledAuditResultJsonUnmarshaller();
            JsonResponseHandler<DescribeScheduledAuditResult> responseHandler = new JsonResponseHandler<DescribeScheduledAuditResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a Device Defender security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeSecurityProfile</a> action.
     * </p>
     * 
     * @param describeSecurityProfileRequest
     * @return describeSecurityProfileResult The response from the
     *         DescribeSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeSecurityProfileResult describeSecurityProfile(
            DescribeSecurityProfileRequest describeSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSecurityProfileRequest> request = null;
        Response<DescribeSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSecurityProfileRequestMarshaller()
                        .marshall(describeSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new DescribeSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<DescribeSecurityProfileResult> responseHandler = new JsonResponseHandler<DescribeSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a stream.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeStream</a> action.
     * </p>
     * 
     * @param describeStreamRequest
     * @return describeStreamResult The response from the DescribeStream service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeStreamResult describeStream(DescribeStreamRequest describeStreamRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeStreamRequest> request = null;
        Response<DescribeStreamResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeStreamRequestMarshaller().marshall(describeStreamRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeStreamResult, JsonUnmarshallerContext> unmarshaller = new DescribeStreamResultJsonUnmarshaller();
            JsonResponseHandler<DescribeStreamResult> responseHandler = new JsonResponseHandler<DescribeStreamResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified thing.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeThing</a> action.
     * </p>
     * 
     * @param describeThingRequest <p>
     *            The input for the DescribeThing operation.
     *            </p>
     * @return describeThingResult The response from the DescribeThing service
     *         method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeThingResult describeThing(DescribeThingRequest describeThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeThingRequest> request = null;
        Response<DescribeThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeThingRequestMarshaller().marshall(describeThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeThingResult, JsonUnmarshallerContext> unmarshaller = new DescribeThingResultJsonUnmarshaller();
            JsonResponseHandler<DescribeThingResult> responseHandler = new JsonResponseHandler<DescribeThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describe a thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeThingGroup</a> action.
     * </p>
     * 
     * @param describeThingGroupRequest
     * @return describeThingGroupResult The response from the DescribeThingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeThingGroupResult describeThingGroup(
            DescribeThingGroupRequest describeThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeThingGroupRequest> request = null;
        Response<DescribeThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeThingGroupRequestMarshaller()
                        .marshall(describeThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeThingGroupResult, JsonUnmarshallerContext> unmarshaller = new DescribeThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<DescribeThingGroupResult> responseHandler = new JsonResponseHandler<DescribeThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes a bulk thing provisioning task.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeThingRegistrationTask</a> action.
     * </p>
     * 
     * @param describeThingRegistrationTaskRequest
     * @return describeThingRegistrationTaskResult The response from the
     *         DescribeThingRegistrationTask service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeThingRegistrationTaskResult describeThingRegistrationTask(
            DescribeThingRegistrationTaskRequest describeThingRegistrationTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeThingRegistrationTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeThingRegistrationTaskRequest> request = null;
        Response<DescribeThingRegistrationTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeThingRegistrationTaskRequestMarshaller()
                        .marshall(describeThingRegistrationTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeThingRegistrationTaskResult, JsonUnmarshallerContext> unmarshaller = new DescribeThingRegistrationTaskResultJsonUnmarshaller();
            JsonResponseHandler<DescribeThingRegistrationTaskResult> responseHandler = new JsonResponseHandler<DescribeThingRegistrationTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified thing type.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DescribeThingType</a> action.
     * </p>
     * 
     * @param describeThingTypeRequest <p>
     *            The input for the DescribeThingType operation.
     *            </p>
     * @return describeThingTypeResult The response from the DescribeThingType
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DescribeThingTypeResult describeThingType(
            DescribeThingTypeRequest describeThingTypeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(describeThingTypeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeThingTypeRequest> request = null;
        Response<DescribeThingTypeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeThingTypeRequestMarshaller()
                        .marshall(describeThingTypeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DescribeThingTypeResult, JsonUnmarshallerContext> unmarshaller = new DescribeThingTypeResultJsonUnmarshaller();
            JsonResponseHandler<DescribeThingTypeResult> responseHandler = new JsonResponseHandler<DescribeThingTypeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Detaches a policy from the specified target.
     * </p>
     * <note>
     * <p>
     * Because of the distributed nature of Amazon Web Services, it can take up
     * to five minutes after a policy is detached before it's ready to be
     * deleted.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DetachPolicy</a> action.
     * </p>
     * 
     * @param detachPolicyRequest
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void detachPolicy(DetachPolicyRequest detachPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(detachPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachPolicyRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachPolicyRequestMarshaller().marshall(detachPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes the specified policy from the specified certificate.
     * </p>
     * <note>
     * <p>
     * This action is deprecated. Please use <a>DetachPolicy</a> instead.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DetachPrincipalPolicy</a> action.
     * </p>
     * 
     * @param detachPrincipalPolicyRequest <p>
     *            The input for the DetachPrincipalPolicy operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    @Deprecated
    public void detachPrincipalPolicy(DetachPrincipalPolicyRequest detachPrincipalPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(detachPrincipalPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachPrincipalPolicyRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachPrincipalPolicyRequestMarshaller()
                        .marshall(detachPrincipalPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Disassociates a Device Defender security profile from a thing group or
     * from this account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DetachSecurityProfile</a> action.
     * </p>
     * 
     * @param detachSecurityProfileRequest
     * @return detachSecurityProfileResult The response from the
     *         DetachSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DetachSecurityProfileResult detachSecurityProfile(
            DetachSecurityProfileRequest detachSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(detachSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachSecurityProfileRequest> request = null;
        Response<DetachSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachSecurityProfileRequestMarshaller()
                        .marshall(detachSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DetachSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new DetachSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<DetachSecurityProfileResult> responseHandler = new JsonResponseHandler<DetachSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Detaches the specified principal from the specified thing. A principal
     * can be X.509 certificates, IAM users, groups, and roles, Amazon Cognito
     * identities or federated identities.
     * </p>
     * <note>
     * <p>
     * This call is asynchronous. It might take several seconds for the
     * detachment to propagate.
     * </p>
     * </note>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DetachThingPrincipal</a> action.
     * </p>
     * 
     * @param detachThingPrincipalRequest <p>
     *            The input for the DetachThingPrincipal operation.
     *            </p>
     * @return detachThingPrincipalResult The response from the
     *         DetachThingPrincipal service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public DetachThingPrincipalResult detachThingPrincipal(
            DetachThingPrincipalRequest detachThingPrincipalRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(detachThingPrincipalRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachThingPrincipalRequest> request = null;
        Response<DetachThingPrincipalResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachThingPrincipalRequestMarshaller()
                        .marshall(detachThingPrincipalRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<DetachThingPrincipalResult, JsonUnmarshallerContext> unmarshaller = new DetachThingPrincipalResultJsonUnmarshaller();
            JsonResponseHandler<DetachThingPrincipalResult> responseHandler = new JsonResponseHandler<DetachThingPrincipalResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Disables the rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >DisableTopicRule</a> action.
     * </p>
     * 
     * @param disableTopicRuleRequest <p>
     *            The input for the DisableTopicRuleRequest operation.
     *            </p>
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void disableTopicRule(DisableTopicRuleRequest disableTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(disableTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisableTopicRuleRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisableTopicRuleRequestMarshaller().marshall(disableTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Enables the rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >EnableTopicRule</a> action.
     * </p>
     * 
     * @param enableTopicRuleRequest <p>
     *            The input for the EnableTopicRuleRequest operation.
     *            </p>
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void enableTopicRule(EnableTopicRuleRequest enableTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(enableTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableTopicRuleRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableTopicRuleRequestMarshaller().marshall(enableTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a Device Defender's ML Detect Security Profile training model's
     * status.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetBehaviorModelTrainingSummaries</a> action.
     * </p>
     * 
     * @param getBehaviorModelTrainingSummariesRequest
     * @return getBehaviorModelTrainingSummariesResult The response from the
     *         GetBehaviorModelTrainingSummaries service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetBehaviorModelTrainingSummariesResult getBehaviorModelTrainingSummaries(
            GetBehaviorModelTrainingSummariesRequest getBehaviorModelTrainingSummariesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getBehaviorModelTrainingSummariesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetBehaviorModelTrainingSummariesRequest> request = null;
        Response<GetBehaviorModelTrainingSummariesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetBehaviorModelTrainingSummariesRequestMarshaller()
                        .marshall(getBehaviorModelTrainingSummariesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetBehaviorModelTrainingSummariesResult, JsonUnmarshallerContext> unmarshaller = new GetBehaviorModelTrainingSummariesResultJsonUnmarshaller();
            JsonResponseHandler<GetBehaviorModelTrainingSummariesResult> responseHandler = new JsonResponseHandler<GetBehaviorModelTrainingSummariesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Aggregates on indexed data with search queries pertaining to particular
     * fields.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetBucketsAggregation</a> action.
     * </p>
     * 
     * @param getBucketsAggregationRequest
     * @return getBucketsAggregationResult The response from the
     *         GetBucketsAggregation service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetBucketsAggregationResult getBucketsAggregation(
            GetBucketsAggregationRequest getBucketsAggregationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getBucketsAggregationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetBucketsAggregationRequest> request = null;
        Response<GetBucketsAggregationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetBucketsAggregationRequestMarshaller()
                        .marshall(getBucketsAggregationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetBucketsAggregationResult, JsonUnmarshallerContext> unmarshaller = new GetBucketsAggregationResultJsonUnmarshaller();
            JsonResponseHandler<GetBucketsAggregationResult> responseHandler = new JsonResponseHandler<GetBucketsAggregationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns the approximate count of unique values that match the query.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetCardinality</a> action.
     * </p>
     * 
     * @param getCardinalityRequest
     * @return getCardinalityResult The response from the GetCardinality service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetCardinalityResult getCardinality(GetCardinalityRequest getCardinalityRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getCardinalityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCardinalityRequest> request = null;
        Response<GetCardinalityResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCardinalityRequestMarshaller().marshall(getCardinalityRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetCardinalityResult, JsonUnmarshallerContext> unmarshaller = new GetCardinalityResultJsonUnmarshaller();
            JsonResponseHandler<GetCardinalityResult> responseHandler = new JsonResponseHandler<GetCardinalityResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a list of the policies that have an effect on the authorization
     * behavior of the specified device when it connects to the IoT device
     * gateway.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetEffectivePolicies</a> action.
     * </p>
     * 
     * @param getEffectivePoliciesRequest
     * @return getEffectivePoliciesResult The response from the
     *         GetEffectivePolicies service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetEffectivePoliciesResult getEffectivePolicies(
            GetEffectivePoliciesRequest getEffectivePoliciesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getEffectivePoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetEffectivePoliciesRequest> request = null;
        Response<GetEffectivePoliciesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetEffectivePoliciesRequestMarshaller()
                        .marshall(getEffectivePoliciesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetEffectivePoliciesResult, JsonUnmarshallerContext> unmarshaller = new GetEffectivePoliciesResultJsonUnmarshaller();
            JsonResponseHandler<GetEffectivePoliciesResult> responseHandler = new JsonResponseHandler<GetEffectivePoliciesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the indexing configuration.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetIndexingConfiguration</a> action.
     * </p>
     * 
     * @param getIndexingConfigurationRequest
     * @return getIndexingConfigurationResult The response from the
     *         GetIndexingConfiguration service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetIndexingConfigurationResult getIndexingConfiguration(
            GetIndexingConfigurationRequest getIndexingConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getIndexingConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetIndexingConfigurationRequest> request = null;
        Response<GetIndexingConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetIndexingConfigurationRequestMarshaller()
                        .marshall(getIndexingConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetIndexingConfigurationResult, JsonUnmarshallerContext> unmarshaller = new GetIndexingConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<GetIndexingConfigurationResult> responseHandler = new JsonResponseHandler<GetIndexingConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a job document.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetJobDocument</a> action.
     * </p>
     * 
     * @param getJobDocumentRequest
     * @return getJobDocumentResult The response from the GetJobDocument service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetJobDocumentResult getJobDocument(GetJobDocumentRequest getJobDocumentRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getJobDocumentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetJobDocumentRequest> request = null;
        Response<GetJobDocumentResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetJobDocumentRequestMarshaller().marshall(getJobDocumentRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetJobDocumentResult, JsonUnmarshallerContext> unmarshaller = new GetJobDocumentResultJsonUnmarshaller();
            JsonResponseHandler<GetJobDocumentResult> responseHandler = new JsonResponseHandler<GetJobDocumentResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the logging options.
     * </p>
     * <p>
     * NOTE: use of this command is not recommended. Use
     * <code>GetV2LoggingOptions</code> instead.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetLoggingOptions</a> action.
     * </p>
     * 
     * @param getLoggingOptionsRequest <p>
     *            The input for the GetLoggingOptions operation.
     *            </p>
     * @return getLoggingOptionsResult The response from the GetLoggingOptions
     *         service method, as returned by AWS IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetLoggingOptionsResult getLoggingOptions(
            GetLoggingOptionsRequest getLoggingOptionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getLoggingOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetLoggingOptionsRequest> request = null;
        Response<GetLoggingOptionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetLoggingOptionsRequestMarshaller()
                        .marshall(getLoggingOptionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetLoggingOptionsResult, JsonUnmarshallerContext> unmarshaller = new GetLoggingOptionsResultJsonUnmarshaller();
            JsonResponseHandler<GetLoggingOptionsResult> responseHandler = new JsonResponseHandler<GetLoggingOptionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets an OTA update.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetOTAUpdate</a> action.
     * </p>
     * 
     * @param getOTAUpdateRequest
     * @return getOTAUpdateResult The response from the GetOTAUpdate service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ServiceUnavailableException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetOTAUpdateResult getOTAUpdate(GetOTAUpdateRequest getOTAUpdateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getOTAUpdateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetOTAUpdateRequest> request = null;
        Response<GetOTAUpdateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetOTAUpdateRequestMarshaller().marshall(getOTAUpdateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetOTAUpdateResult, JsonUnmarshallerContext> unmarshaller = new GetOTAUpdateResultJsonUnmarshaller();
            JsonResponseHandler<GetOTAUpdateResult> responseHandler = new JsonResponseHandler<GetOTAUpdateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Groups the aggregated values that match the query into percentile
     * groupings. The default percentile groupings are: 1,5,25,50,75,95,99,
     * although you can specify your own when you call
     * <code>GetPercentiles</code>. This function returns a value for each
     * percentile group specified (or the default percentile groupings). The
     * percentile group "1" contains the aggregated field value that occurs in
     * approximately one percent of the values that match the query. The
     * percentile group "5" contains the aggregated field value that occurs in
     * approximately five percent of the values that match the query, and so on.
     * The result is an approximation, the more values that match the query, the
     * more accurate the percentile values.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetPercentiles</a> action.
     * </p>
     * 
     * @param getPercentilesRequest
     * @return getPercentilesResult The response from the GetPercentiles service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetPercentilesResult getPercentiles(GetPercentilesRequest getPercentilesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getPercentilesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetPercentilesRequest> request = null;
        Response<GetPercentilesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetPercentilesRequestMarshaller().marshall(getPercentilesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetPercentilesResult, JsonUnmarshallerContext> unmarshaller = new GetPercentilesResultJsonUnmarshaller();
            JsonResponseHandler<GetPercentilesResult> responseHandler = new JsonResponseHandler<GetPercentilesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified policy with the policy document of
     * the default version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetPolicy</a> action.
     * </p>
     * 
     * @param getPolicyRequest <p>
     *            The input for the GetPolicy operation.
     *            </p>
     * @return getPolicyResult The response from the GetPolicy service method,
     *         as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetPolicyResult getPolicy(GetPolicyRequest getPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetPolicyRequest> request = null;
        Response<GetPolicyResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetPolicyRequestMarshaller().marshall(getPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetPolicyResult, JsonUnmarshallerContext> unmarshaller = new GetPolicyResultJsonUnmarshaller();
            JsonResponseHandler<GetPolicyResult> responseHandler = new JsonResponseHandler<GetPolicyResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the specified policy version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetPolicyVersion</a> action.
     * </p>
     * 
     * @param getPolicyVersionRequest <p>
     *            The input for the GetPolicyVersion operation.
     *            </p>
     * @return getPolicyVersionResult The response from the GetPolicyVersion
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetPolicyVersionResult getPolicyVersion(GetPolicyVersionRequest getPolicyVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getPolicyVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetPolicyVersionRequest> request = null;
        Response<GetPolicyVersionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetPolicyVersionRequestMarshaller().marshall(getPolicyVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetPolicyVersionResult, JsonUnmarshallerContext> unmarshaller = new GetPolicyVersionResultJsonUnmarshaller();
            JsonResponseHandler<GetPolicyVersionResult> responseHandler = new JsonResponseHandler<GetPolicyVersionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a registration code used to register a CA certificate with IoT.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetRegistrationCode</a> action.
     * </p>
     * 
     * @param getRegistrationCodeRequest <p>
     *            The input to the GetRegistrationCode operation.
     *            </p>
     * @return getRegistrationCodeResult The response from the
     *         GetRegistrationCode service method, as returned by AWS IoT.
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetRegistrationCodeResult getRegistrationCode(
            GetRegistrationCodeRequest getRegistrationCodeRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getRegistrationCodeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetRegistrationCodeRequest> request = null;
        Response<GetRegistrationCodeResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetRegistrationCodeRequestMarshaller()
                        .marshall(getRegistrationCodeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetRegistrationCodeResult, JsonUnmarshallerContext> unmarshaller = new GetRegistrationCodeResultJsonUnmarshaller();
            JsonResponseHandler<GetRegistrationCodeResult> responseHandler = new JsonResponseHandler<GetRegistrationCodeResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns the count, average, sum, minimum, maximum, sum of squares,
     * variance, and standard deviation for the specified aggregated field. If
     * the aggregation field is of type <code>String</code>, only the count
     * statistic is returned.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetStatistics</a> action.
     * </p>
     * 
     * @param getStatisticsRequest
     * @return getStatisticsResult The response from the GetStatistics service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetStatisticsResult getStatistics(GetStatisticsRequest getStatisticsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getStatisticsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetStatisticsRequest> request = null;
        Response<GetStatisticsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetStatisticsRequestMarshaller().marshall(getStatisticsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetStatisticsResult, JsonUnmarshallerContext> unmarshaller = new GetStatisticsResultJsonUnmarshaller();
            JsonResponseHandler<GetStatisticsResult> responseHandler = new JsonResponseHandler<GetStatisticsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about the rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetTopicRule</a> action.
     * </p>
     * 
     * @param getTopicRuleRequest <p>
     *            The input for the GetTopicRule operation.
     *            </p>
     * @return getTopicRuleResult The response from the GetTopicRule service
     *         method, as returned by AWS IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetTopicRuleResult getTopicRule(GetTopicRuleRequest getTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTopicRuleRequest> request = null;
        Response<GetTopicRuleResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTopicRuleRequestMarshaller().marshall(getTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetTopicRuleResult, JsonUnmarshallerContext> unmarshaller = new GetTopicRuleResultJsonUnmarshaller();
            JsonResponseHandler<GetTopicRuleResult> responseHandler = new JsonResponseHandler<GetTopicRuleResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets information about a topic rule destination.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetTopicRuleDestination</a> action.
     * </p>
     * 
     * @param getTopicRuleDestinationRequest
     * @return getTopicRuleDestinationResult The response from the
     *         GetTopicRuleDestination service method, as returned by AWS IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetTopicRuleDestinationResult getTopicRuleDestination(
            GetTopicRuleDestinationRequest getTopicRuleDestinationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getTopicRuleDestinationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTopicRuleDestinationRequest> request = null;
        Response<GetTopicRuleDestinationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTopicRuleDestinationRequestMarshaller()
                        .marshall(getTopicRuleDestinationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetTopicRuleDestinationResult, JsonUnmarshallerContext> unmarshaller = new GetTopicRuleDestinationResultJsonUnmarshaller();
            JsonResponseHandler<GetTopicRuleDestinationResult> responseHandler = new JsonResponseHandler<GetTopicRuleDestinationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the fine grained logging options.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >GetV2LoggingOptions</a> action.
     * </p>
     * 
     * @param getV2LoggingOptionsRequest
     * @return getV2LoggingOptionsResult The response from the
     *         GetV2LoggingOptions service method, as returned by AWS IoT.
     * @throws InternalException
     * @throws NotConfiguredException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public GetV2LoggingOptionsResult getV2LoggingOptions(
            GetV2LoggingOptionsRequest getV2LoggingOptionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(getV2LoggingOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetV2LoggingOptionsRequest> request = null;
        Response<GetV2LoggingOptionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetV2LoggingOptionsRequestMarshaller()
                        .marshall(getV2LoggingOptionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<GetV2LoggingOptionsResult, JsonUnmarshallerContext> unmarshaller = new GetV2LoggingOptionsResultJsonUnmarshaller();
            JsonResponseHandler<GetV2LoggingOptionsResult> responseHandler = new JsonResponseHandler<GetV2LoggingOptionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the active violations for a given Device Defender security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListActiveViolations</a> action.
     * </p>
     * 
     * @param listActiveViolationsRequest
     * @return listActiveViolationsResult The response from the
     *         ListActiveViolations service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListActiveViolationsResult listActiveViolations(
            ListActiveViolationsRequest listActiveViolationsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listActiveViolationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListActiveViolationsRequest> request = null;
        Response<ListActiveViolationsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListActiveViolationsRequestMarshaller()
                        .marshall(listActiveViolationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListActiveViolationsResult, JsonUnmarshallerContext> unmarshaller = new ListActiveViolationsResultJsonUnmarshaller();
            JsonResponseHandler<ListActiveViolationsResult> responseHandler = new JsonResponseHandler<ListActiveViolationsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the policies attached to the specified thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAttachedPolicies</a> action.
     * </p>
     * 
     * @param listAttachedPoliciesRequest
     * @return listAttachedPoliciesResult The response from the
     *         ListAttachedPolicies service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAttachedPoliciesResult listAttachedPolicies(
            ListAttachedPoliciesRequest listAttachedPoliciesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAttachedPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAttachedPoliciesRequest> request = null;
        Response<ListAttachedPoliciesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAttachedPoliciesRequestMarshaller()
                        .marshall(listAttachedPoliciesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAttachedPoliciesResult, JsonUnmarshallerContext> unmarshaller = new ListAttachedPoliciesResultJsonUnmarshaller();
            JsonResponseHandler<ListAttachedPoliciesResult> responseHandler = new JsonResponseHandler<ListAttachedPoliciesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the findings (results) of a Device Defender audit or of the audits
     * performed during a specified time period. (Findings are retained for 90
     * days.)
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuditFindings</a> action.
     * </p>
     * 
     * @param listAuditFindingsRequest
     * @return listAuditFindingsResult The response from the ListAuditFindings
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuditFindingsResult listAuditFindings(
            ListAuditFindingsRequest listAuditFindingsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuditFindingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuditFindingsRequest> request = null;
        Response<ListAuditFindingsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuditFindingsRequestMarshaller()
                        .marshall(listAuditFindingsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuditFindingsResult, JsonUnmarshallerContext> unmarshaller = new ListAuditFindingsResultJsonUnmarshaller();
            JsonResponseHandler<ListAuditFindingsResult> responseHandler = new JsonResponseHandler<ListAuditFindingsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets the status of audit mitigation action tasks that were executed.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuditMitigationActionsExecutions</a> action.
     * </p>
     * 
     * @param listAuditMitigationActionsExecutionsRequest
     * @return listAuditMitigationActionsExecutionsResult The response from the
     *         ListAuditMitigationActionsExecutions service method, as returned
     *         by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuditMitigationActionsExecutionsResult listAuditMitigationActionsExecutions(
            ListAuditMitigationActionsExecutionsRequest listAuditMitigationActionsExecutionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuditMitigationActionsExecutionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuditMitigationActionsExecutionsRequest> request = null;
        Response<ListAuditMitigationActionsExecutionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuditMitigationActionsExecutionsRequestMarshaller()
                        .marshall(listAuditMitigationActionsExecutionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuditMitigationActionsExecutionsResult, JsonUnmarshallerContext> unmarshaller = new ListAuditMitigationActionsExecutionsResultJsonUnmarshaller();
            JsonResponseHandler<ListAuditMitigationActionsExecutionsResult> responseHandler = new JsonResponseHandler<ListAuditMitigationActionsExecutionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a list of audit mitigation action tasks that match the specified
     * filters.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuditMitigationActionsTasks</a> action.
     * </p>
     * 
     * @param listAuditMitigationActionsTasksRequest
     * @return listAuditMitigationActionsTasksResult The response from the
     *         ListAuditMitigationActionsTasks service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuditMitigationActionsTasksResult listAuditMitigationActionsTasks(
            ListAuditMitigationActionsTasksRequest listAuditMitigationActionsTasksRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuditMitigationActionsTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuditMitigationActionsTasksRequest> request = null;
        Response<ListAuditMitigationActionsTasksResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuditMitigationActionsTasksRequestMarshaller()
                        .marshall(listAuditMitigationActionsTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuditMitigationActionsTasksResult, JsonUnmarshallerContext> unmarshaller = new ListAuditMitigationActionsTasksResultJsonUnmarshaller();
            JsonResponseHandler<ListAuditMitigationActionsTasksResult> responseHandler = new JsonResponseHandler<ListAuditMitigationActionsTasksResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists your Device Defender audit listings.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuditSuppressions</a> action.
     * </p>
     * 
     * @param listAuditSuppressionsRequest
     * @return listAuditSuppressionsResult The response from the
     *         ListAuditSuppressions service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuditSuppressionsResult listAuditSuppressions(
            ListAuditSuppressionsRequest listAuditSuppressionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuditSuppressionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuditSuppressionsRequest> request = null;
        Response<ListAuditSuppressionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuditSuppressionsRequestMarshaller()
                        .marshall(listAuditSuppressionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuditSuppressionsResult, JsonUnmarshallerContext> unmarshaller = new ListAuditSuppressionsResultJsonUnmarshaller();
            JsonResponseHandler<ListAuditSuppressionsResult> responseHandler = new JsonResponseHandler<ListAuditSuppressionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the Device Defender audits that have been performed during a given
     * time period.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuditTasks</a> action.
     * </p>
     * 
     * @param listAuditTasksRequest
     * @return listAuditTasksResult The response from the ListAuditTasks service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuditTasksResult listAuditTasks(ListAuditTasksRequest listAuditTasksRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuditTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuditTasksRequest> request = null;
        Response<ListAuditTasksResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuditTasksRequestMarshaller().marshall(listAuditTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuditTasksResult, JsonUnmarshallerContext> unmarshaller = new ListAuditTasksResultJsonUnmarshaller();
            JsonResponseHandler<ListAuditTasksResult> responseHandler = new JsonResponseHandler<ListAuditTasksResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the authorizers registered in your account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListAuthorizers</a> action.
     * </p>
     * 
     * @param listAuthorizersRequest
     * @return listAuthorizersResult The response from the ListAuthorizers
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListAuthorizersResult listAuthorizers(ListAuthorizersRequest listAuthorizersRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listAuthorizersRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListAuthorizersRequest> request = null;
        Response<ListAuthorizersResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListAuthorizersRequestMarshaller().marshall(listAuthorizersRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListAuthorizersResult, JsonUnmarshallerContext> unmarshaller = new ListAuthorizersResultJsonUnmarshaller();
            JsonResponseHandler<ListAuthorizersResult> responseHandler = new JsonResponseHandler<ListAuthorizersResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the billing groups you have created.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListBillingGroups</a> action.
     * </p>
     * 
     * @param listBillingGroupsRequest
     * @return listBillingGroupsResult The response from the ListBillingGroups
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListBillingGroupsResult listBillingGroups(
            ListBillingGroupsRequest listBillingGroupsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listBillingGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListBillingGroupsRequest> request = null;
        Response<ListBillingGroupsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListBillingGroupsRequestMarshaller()
                        .marshall(listBillingGroupsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListBillingGroupsResult, JsonUnmarshallerContext> unmarshaller = new ListBillingGroupsResultJsonUnmarshaller();
            JsonResponseHandler<ListBillingGroupsResult> responseHandler = new JsonResponseHandler<ListBillingGroupsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the CA certificates registered for your Amazon Web Services
     * account.
     * </p>
     * <p>
     * The results are paginated with a default page size of 25. You can use the
     * returned marker to retrieve additional results.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListCACertificates</a> action.
     * </p>
     * 
     * @param listCACertificatesRequest <p>
     *            Input for the ListCACertificates operation.
     *            </p>
     * @return listCACertificatesResult The response from the ListCACertificates
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListCACertificatesResult listCACertificates(
            ListCACertificatesRequest listCACertificatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listCACertificatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCACertificatesRequest> request = null;
        Response<ListCACertificatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCACertificatesRequestMarshaller()
                        .marshall(listCACertificatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListCACertificatesResult, JsonUnmarshallerContext> unmarshaller = new ListCACertificatesResultJsonUnmarshaller();
            JsonResponseHandler<ListCACertificatesResult> responseHandler = new JsonResponseHandler<ListCACertificatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the certificates registered in your Amazon Web Services account.
     * </p>
     * <p>
     * The results are paginated with a default page size of 25. You can use the
     * returned marker to retrieve additional results.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListCertificates</a> action.
     * </p>
     * 
     * @param listCertificatesRequest <p>
     *            The input for the ListCertificates operation.
     *            </p>
     * @return listCertificatesResult The response from the ListCertificates
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListCertificatesResult listCertificates(ListCertificatesRequest listCertificatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listCertificatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCertificatesRequest> request = null;
        Response<ListCertificatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCertificatesRequestMarshaller().marshall(listCertificatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListCertificatesResult, JsonUnmarshallerContext> unmarshaller = new ListCertificatesResultJsonUnmarshaller();
            JsonResponseHandler<ListCertificatesResult> responseHandler = new JsonResponseHandler<ListCertificatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List the device certificates signed by the specified CA certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListCertificatesByCA</a> action.
     * </p>
     * 
     * @param listCertificatesByCARequest <p>
     *            The input to the ListCertificatesByCA operation.
     *            </p>
     * @return listCertificatesByCAResult The response from the
     *         ListCertificatesByCA service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListCertificatesByCAResult listCertificatesByCA(
            ListCertificatesByCARequest listCertificatesByCARequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listCertificatesByCARequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCertificatesByCARequest> request = null;
        Response<ListCertificatesByCAResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCertificatesByCARequestMarshaller()
                        .marshall(listCertificatesByCARequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListCertificatesByCAResult, JsonUnmarshallerContext> unmarshaller = new ListCertificatesByCAResultJsonUnmarshaller();
            JsonResponseHandler<ListCertificatesByCAResult> responseHandler = new JsonResponseHandler<ListCertificatesByCAResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists your Device Defender detect custom metrics.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListCustomMetrics</a> action.
     * </p>
     * 
     * @param listCustomMetricsRequest
     * @return listCustomMetricsResult The response from the ListCustomMetrics
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListCustomMetricsResult listCustomMetrics(
            ListCustomMetricsRequest listCustomMetricsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listCustomMetricsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListCustomMetricsRequest> request = null;
        Response<ListCustomMetricsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListCustomMetricsRequestMarshaller()
                        .marshall(listCustomMetricsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListCustomMetricsResult, JsonUnmarshallerContext> unmarshaller = new ListCustomMetricsResultJsonUnmarshaller();
            JsonResponseHandler<ListCustomMetricsResult> responseHandler = new JsonResponseHandler<ListCustomMetricsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists mitigation actions executions for a Device Defender ML Detect
     * Security Profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListDetectMitigationActionsExecutions</a> action.
     * </p>
     * 
     * @param listDetectMitigationActionsExecutionsRequest
     * @return listDetectMitigationActionsExecutionsResult The response from the
     *         ListDetectMitigationActionsExecutions service method, as returned
     *         by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListDetectMitigationActionsExecutionsResult listDetectMitigationActionsExecutions(
            ListDetectMitigationActionsExecutionsRequest listDetectMitigationActionsExecutionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listDetectMitigationActionsExecutionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDetectMitigationActionsExecutionsRequest> request = null;
        Response<ListDetectMitigationActionsExecutionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDetectMitigationActionsExecutionsRequestMarshaller()
                        .marshall(listDetectMitigationActionsExecutionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListDetectMitigationActionsExecutionsResult, JsonUnmarshallerContext> unmarshaller = new ListDetectMitigationActionsExecutionsResultJsonUnmarshaller();
            JsonResponseHandler<ListDetectMitigationActionsExecutionsResult> responseHandler = new JsonResponseHandler<ListDetectMitigationActionsExecutionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List of Device Defender ML Detect mitigation actions tasks.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListDetectMitigationActionsTasks</a> action.
     * </p>
     * 
     * @param listDetectMitigationActionsTasksRequest
     * @return listDetectMitigationActionsTasksResult The response from the
     *         ListDetectMitigationActionsTasks service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListDetectMitigationActionsTasksResult listDetectMitigationActionsTasks(
            ListDetectMitigationActionsTasksRequest listDetectMitigationActionsTasksRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listDetectMitigationActionsTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDetectMitigationActionsTasksRequest> request = null;
        Response<ListDetectMitigationActionsTasksResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDetectMitigationActionsTasksRequestMarshaller()
                        .marshall(listDetectMitigationActionsTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListDetectMitigationActionsTasksResult, JsonUnmarshallerContext> unmarshaller = new ListDetectMitigationActionsTasksResultJsonUnmarshaller();
            JsonResponseHandler<ListDetectMitigationActionsTasksResult> responseHandler = new JsonResponseHandler<ListDetectMitigationActionsTasksResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List the set of dimensions that are defined for your Amazon Web Services
     * accounts.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListDimensions</a> action.
     * </p>
     * 
     * @param listDimensionsRequest
     * @return listDimensionsResult The response from the ListDimensions service
     *         method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListDimensionsResult listDimensions(ListDimensionsRequest listDimensionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listDimensionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDimensionsRequest> request = null;
        Response<ListDimensionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDimensionsRequestMarshaller().marshall(listDimensionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListDimensionsResult, JsonUnmarshallerContext> unmarshaller = new ListDimensionsResultJsonUnmarshaller();
            JsonResponseHandler<ListDimensionsResult> responseHandler = new JsonResponseHandler<ListDimensionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a list of domain configurations for the user. This list is sorted
     * alphabetically by domain configuration name.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListDomainConfigurations</a> action.
     * </p>
     * 
     * @param listDomainConfigurationsRequest
     * @return listDomainConfigurationsResult The response from the
     *         ListDomainConfigurations service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListDomainConfigurationsResult listDomainConfigurations(
            ListDomainConfigurationsRequest listDomainConfigurationsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listDomainConfigurationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListDomainConfigurationsRequest> request = null;
        Response<ListDomainConfigurationsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListDomainConfigurationsRequestMarshaller()
                        .marshall(listDomainConfigurationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListDomainConfigurationsResult, JsonUnmarshallerContext> unmarshaller = new ListDomainConfigurationsResultJsonUnmarshaller();
            JsonResponseHandler<ListDomainConfigurationsResult> responseHandler = new JsonResponseHandler<ListDomainConfigurationsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists all your fleet metrics.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListFleetMetrics</a> action.
     * </p>
     * 
     * @param listFleetMetricsRequest
     * @return listFleetMetricsResult The response from the ListFleetMetrics
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListFleetMetricsResult listFleetMetrics(ListFleetMetricsRequest listFleetMetricsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listFleetMetricsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListFleetMetricsRequest> request = null;
        Response<ListFleetMetricsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListFleetMetricsRequestMarshaller().marshall(listFleetMetricsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListFleetMetricsResult, JsonUnmarshallerContext> unmarshaller = new ListFleetMetricsResultJsonUnmarshaller();
            JsonResponseHandler<ListFleetMetricsResult> responseHandler = new JsonResponseHandler<ListFleetMetricsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the search indices.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListIndices</a> action.
     * </p>
     * 
     * @param listIndicesRequest
     * @return listIndicesResult The response from the ListIndices service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListIndicesResult listIndices(ListIndicesRequest listIndicesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listIndicesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListIndicesRequest> request = null;
        Response<ListIndicesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListIndicesRequestMarshaller().marshall(listIndicesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListIndicesResult, JsonUnmarshallerContext> unmarshaller = new ListIndicesResultJsonUnmarshaller();
            JsonResponseHandler<ListIndicesResult> responseHandler = new JsonResponseHandler<ListIndicesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the job executions for a job.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListJobExecutionsForJob</a> action.
     * </p>
     * 
     * @param listJobExecutionsForJobRequest
     * @return listJobExecutionsForJobResult The response from the
     *         ListJobExecutionsForJob service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListJobExecutionsForJobResult listJobExecutionsForJob(
            ListJobExecutionsForJobRequest listJobExecutionsForJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listJobExecutionsForJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListJobExecutionsForJobRequest> request = null;
        Response<ListJobExecutionsForJobResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListJobExecutionsForJobRequestMarshaller()
                        .marshall(listJobExecutionsForJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListJobExecutionsForJobResult, JsonUnmarshallerContext> unmarshaller = new ListJobExecutionsForJobResultJsonUnmarshaller();
            JsonResponseHandler<ListJobExecutionsForJobResult> responseHandler = new JsonResponseHandler<ListJobExecutionsForJobResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the job executions for the specified thing.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListJobExecutionsForThing</a> action.
     * </p>
     * 
     * @param listJobExecutionsForThingRequest
     * @return listJobExecutionsForThingResult The response from the
     *         ListJobExecutionsForThing service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListJobExecutionsForThingResult listJobExecutionsForThing(
            ListJobExecutionsForThingRequest listJobExecutionsForThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listJobExecutionsForThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListJobExecutionsForThingRequest> request = null;
        Response<ListJobExecutionsForThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListJobExecutionsForThingRequestMarshaller()
                        .marshall(listJobExecutionsForThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListJobExecutionsForThingResult, JsonUnmarshallerContext> unmarshaller = new ListJobExecutionsForThingResultJsonUnmarshaller();
            JsonResponseHandler<ListJobExecutionsForThingResult> responseHandler = new JsonResponseHandler<ListJobExecutionsForThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of job templates.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListJobTemplates</a> action.
     * </p>
     * 
     * @param listJobTemplatesRequest
     * @return listJobTemplatesResult The response from the ListJobTemplates
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListJobTemplatesResult listJobTemplates(ListJobTemplatesRequest listJobTemplatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listJobTemplatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListJobTemplatesRequest> request = null;
        Response<ListJobTemplatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListJobTemplatesRequestMarshaller().marshall(listJobTemplatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListJobTemplatesResult, JsonUnmarshallerContext> unmarshaller = new ListJobTemplatesResultJsonUnmarshaller();
            JsonResponseHandler<ListJobTemplatesResult> responseHandler = new JsonResponseHandler<ListJobTemplatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists jobs.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListJobs</a> action.
     * </p>
     * 
     * @param listJobsRequest
     * @return listJobsResult The response from the ListJobs service method, as
     *         returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListJobsResult listJobs(ListJobsRequest listJobsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listJobsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListJobsRequest> request = null;
        Response<ListJobsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListJobsRequestMarshaller().marshall(listJobsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListJobsResult, JsonUnmarshallerContext> unmarshaller = new ListJobsResultJsonUnmarshaller();
            JsonResponseHandler<ListJobsResult> responseHandler = new JsonResponseHandler<ListJobsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a list of managed job templates.
     * </p>
     * 
     * @param listManagedJobTemplatesRequest
     * @return listManagedJobTemplatesResult The response from the
     *         ListManagedJobTemplates service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServerException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListManagedJobTemplatesResult listManagedJobTemplates(
            ListManagedJobTemplatesRequest listManagedJobTemplatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listManagedJobTemplatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListManagedJobTemplatesRequest> request = null;
        Response<ListManagedJobTemplatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListManagedJobTemplatesRequestMarshaller()
                        .marshall(listManagedJobTemplatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListManagedJobTemplatesResult, JsonUnmarshallerContext> unmarshaller = new ListManagedJobTemplatesResultJsonUnmarshaller();
            JsonResponseHandler<ListManagedJobTemplatesResult> responseHandler = new JsonResponseHandler<ListManagedJobTemplatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the values reported for an IoT Device Defender metric (device-side
     * metric, cloud-side metric, or custom metric) by the given thing during
     * the specified time period.
     * </p>
     * 
     * @param listMetricValuesRequest
     * @return listMetricValuesResult The response from the ListMetricValues
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListMetricValuesResult listMetricValues(ListMetricValuesRequest listMetricValuesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listMetricValuesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListMetricValuesRequest> request = null;
        Response<ListMetricValuesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListMetricValuesRequestMarshaller().marshall(listMetricValuesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListMetricValuesResult, JsonUnmarshallerContext> unmarshaller = new ListMetricValuesResultJsonUnmarshaller();
            JsonResponseHandler<ListMetricValuesResult> responseHandler = new JsonResponseHandler<ListMetricValuesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a list of all mitigation actions that match the specified filter
     * criteria.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListMitigationActions</a> action.
     * </p>
     * 
     * @param listMitigationActionsRequest
     * @return listMitigationActionsResult The response from the
     *         ListMitigationActions service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListMitigationActionsResult listMitigationActions(
            ListMitigationActionsRequest listMitigationActionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listMitigationActionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListMitigationActionsRequest> request = null;
        Response<ListMitigationActionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListMitigationActionsRequestMarshaller()
                        .marshall(listMitigationActionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListMitigationActionsResult, JsonUnmarshallerContext> unmarshaller = new ListMitigationActionsResultJsonUnmarshaller();
            JsonResponseHandler<ListMitigationActionsResult> responseHandler = new JsonResponseHandler<ListMitigationActionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists OTA updates.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListOTAUpdates</a> action.
     * </p>
     * 
     * @param listOTAUpdatesRequest
     * @return listOTAUpdatesResult The response from the ListOTAUpdates service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListOTAUpdatesResult listOTAUpdates(ListOTAUpdatesRequest listOTAUpdatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listOTAUpdatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListOTAUpdatesRequest> request = null;
        Response<ListOTAUpdatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListOTAUpdatesRequestMarshaller().marshall(listOTAUpdatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListOTAUpdatesResult, JsonUnmarshallerContext> unmarshaller = new ListOTAUpdatesResultJsonUnmarshaller();
            JsonResponseHandler<ListOTAUpdatesResult> responseHandler = new JsonResponseHandler<ListOTAUpdatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists certificates that are being transferred but not yet accepted.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListOutgoingCertificates</a> action.
     * </p>
     * 
     * @param listOutgoingCertificatesRequest <p>
     *            The input to the ListOutgoingCertificates operation.
     *            </p>
     * @return listOutgoingCertificatesResult The response from the
     *         ListOutgoingCertificates service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListOutgoingCertificatesResult listOutgoingCertificates(
            ListOutgoingCertificatesRequest listOutgoingCertificatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listOutgoingCertificatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListOutgoingCertificatesRequest> request = null;
        Response<ListOutgoingCertificatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListOutgoingCertificatesRequestMarshaller()
                        .marshall(listOutgoingCertificatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListOutgoingCertificatesResult, JsonUnmarshallerContext> unmarshaller = new ListOutgoingCertificatesResultJsonUnmarshaller();
            JsonResponseHandler<ListOutgoingCertificatesResult> responseHandler = new JsonResponseHandler<ListOutgoingCertificatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists your policies.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListPolicies</a> action.
     * </p>
     * 
     * @param listPoliciesRequest <p>
     *            The input for the ListPolicies operation.
     *            </p>
     * @return listPoliciesResult The response from the ListPolicies service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListPoliciesResult listPolicies(ListPoliciesRequest listPoliciesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPoliciesRequest> request = null;
        Response<ListPoliciesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPoliciesRequestMarshaller().marshall(listPoliciesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListPoliciesResult, JsonUnmarshallerContext> unmarshaller = new ListPoliciesResultJsonUnmarshaller();
            JsonResponseHandler<ListPoliciesResult> responseHandler = new JsonResponseHandler<ListPoliciesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the principals associated with the specified policy.
     * </p>
     * <p>
     * <b>Note:</b> This action is deprecated. Please use
     * <a>ListTargetsForPolicy</a> instead.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListPolicyPrincipals</a> action.
     * </p>
     * 
     * @param listPolicyPrincipalsRequest <p>
     *            The input for the ListPolicyPrincipals operation.
     *            </p>
     * @return listPolicyPrincipalsResult The response from the
     *         ListPolicyPrincipals service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    @Deprecated
    public ListPolicyPrincipalsResult listPolicyPrincipals(
            ListPolicyPrincipalsRequest listPolicyPrincipalsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listPolicyPrincipalsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPolicyPrincipalsRequest> request = null;
        Response<ListPolicyPrincipalsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPolicyPrincipalsRequestMarshaller()
                        .marshall(listPolicyPrincipalsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListPolicyPrincipalsResult, JsonUnmarshallerContext> unmarshaller = new ListPolicyPrincipalsResultJsonUnmarshaller();
            JsonResponseHandler<ListPolicyPrincipalsResult> responseHandler = new JsonResponseHandler<ListPolicyPrincipalsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the versions of the specified policy and identifies the default
     * version.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListPolicyVersions</a> action.
     * </p>
     * 
     * @param listPolicyVersionsRequest <p>
     *            The input for the ListPolicyVersions operation.
     *            </p>
     * @return listPolicyVersionsResult The response from the ListPolicyVersions
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListPolicyVersionsResult listPolicyVersions(
            ListPolicyVersionsRequest listPolicyVersionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listPolicyVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPolicyVersionsRequest> request = null;
        Response<ListPolicyVersionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPolicyVersionsRequestMarshaller()
                        .marshall(listPolicyVersionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListPolicyVersionsResult, JsonUnmarshallerContext> unmarshaller = new ListPolicyVersionsResultJsonUnmarshaller();
            JsonResponseHandler<ListPolicyVersionsResult> responseHandler = new JsonResponseHandler<ListPolicyVersionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the policies attached to the specified principal. If you use an
     * Cognito identity, the ID must be in <a href=
     * "https://docs.aws.amazon.com/cognitoidentity/latest/APIReference/API_GetCredentialsForIdentity.html#API_GetCredentialsForIdentity_RequestSyntax"
     * >AmazonCognito Identity format</a>.
     * </p>
     * <p>
     * <b>Note:</b> This action is deprecated. Please use
     * <a>ListAttachedPolicies</a> instead.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListPrincipalPolicies</a> action.
     * </p>
     * 
     * @param listPrincipalPoliciesRequest <p>
     *            The input for the ListPrincipalPolicies operation.
     *            </p>
     * @return listPrincipalPoliciesResult The response from the
     *         ListPrincipalPolicies service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    @Deprecated
    public ListPrincipalPoliciesResult listPrincipalPolicies(
            ListPrincipalPoliciesRequest listPrincipalPoliciesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listPrincipalPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPrincipalPoliciesRequest> request = null;
        Response<ListPrincipalPoliciesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPrincipalPoliciesRequestMarshaller()
                        .marshall(listPrincipalPoliciesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListPrincipalPoliciesResult, JsonUnmarshallerContext> unmarshaller = new ListPrincipalPoliciesResultJsonUnmarshaller();
            JsonResponseHandler<ListPrincipalPoliciesResult> responseHandler = new JsonResponseHandler<ListPrincipalPoliciesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the things associated with the specified principal. A principal can
     * be X.509 certificates, IAM users, groups, and roles, Amazon Cognito
     * identities or federated identities.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListPrincipalThings</a> action.
     * </p>
     * 
     * @param listPrincipalThingsRequest <p>
     *            The input for the ListPrincipalThings operation.
     *            </p>
     * @return listPrincipalThingsResult The response from the
     *         ListPrincipalThings service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListPrincipalThingsResult listPrincipalThings(
            ListPrincipalThingsRequest listPrincipalThingsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listPrincipalThingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPrincipalThingsRequest> request = null;
        Response<ListPrincipalThingsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPrincipalThingsRequestMarshaller()
                        .marshall(listPrincipalThingsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListPrincipalThingsResult, JsonUnmarshallerContext> unmarshaller = new ListPrincipalThingsResultJsonUnmarshaller();
            JsonResponseHandler<ListPrincipalThingsResult> responseHandler = new JsonResponseHandler<ListPrincipalThingsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * A list of fleet provisioning template versions.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListProvisioningTemplateVersions</a> action.
     * </p>
     * 
     * @param listProvisioningTemplateVersionsRequest
     * @return listProvisioningTemplateVersionsResult The response from the
     *         ListProvisioningTemplateVersions service method, as returned by
     *         AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListProvisioningTemplateVersionsResult listProvisioningTemplateVersions(
            ListProvisioningTemplateVersionsRequest listProvisioningTemplateVersionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listProvisioningTemplateVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListProvisioningTemplateVersionsRequest> request = null;
        Response<ListProvisioningTemplateVersionsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListProvisioningTemplateVersionsRequestMarshaller()
                        .marshall(listProvisioningTemplateVersionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListProvisioningTemplateVersionsResult, JsonUnmarshallerContext> unmarshaller = new ListProvisioningTemplateVersionsResultJsonUnmarshaller();
            JsonResponseHandler<ListProvisioningTemplateVersionsResult> responseHandler = new JsonResponseHandler<ListProvisioningTemplateVersionsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the fleet provisioning templates in your Amazon Web Services
     * account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListProvisioningTemplates</a> action.
     * </p>
     * 
     * @param listProvisioningTemplatesRequest
     * @return listProvisioningTemplatesResult The response from the
     *         ListProvisioningTemplates service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListProvisioningTemplatesResult listProvisioningTemplates(
            ListProvisioningTemplatesRequest listProvisioningTemplatesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listProvisioningTemplatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListProvisioningTemplatesRequest> request = null;
        Response<ListProvisioningTemplatesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListProvisioningTemplatesRequestMarshaller()
                        .marshall(listProvisioningTemplatesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListProvisioningTemplatesResult, JsonUnmarshallerContext> unmarshaller = new ListProvisioningTemplatesResultJsonUnmarshaller();
            JsonResponseHandler<ListProvisioningTemplatesResult> responseHandler = new JsonResponseHandler<ListProvisioningTemplatesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the role aliases registered in your account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListRoleAliases</a> action.
     * </p>
     * 
     * @param listRoleAliasesRequest
     * @return listRoleAliasesResult The response from the ListRoleAliases
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListRoleAliasesResult listRoleAliases(ListRoleAliasesRequest listRoleAliasesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listRoleAliasesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListRoleAliasesRequest> request = null;
        Response<ListRoleAliasesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListRoleAliasesRequestMarshaller().marshall(listRoleAliasesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListRoleAliasesResult, JsonUnmarshallerContext> unmarshaller = new ListRoleAliasesResultJsonUnmarshaller();
            JsonResponseHandler<ListRoleAliasesResult> responseHandler = new JsonResponseHandler<ListRoleAliasesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists all of your scheduled audits.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListScheduledAudits</a> action.
     * </p>
     * 
     * @param listScheduledAuditsRequest
     * @return listScheduledAuditsResult The response from the
     *         ListScheduledAudits service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListScheduledAuditsResult listScheduledAudits(
            ListScheduledAuditsRequest listScheduledAuditsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listScheduledAuditsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListScheduledAuditsRequest> request = null;
        Response<ListScheduledAuditsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListScheduledAuditsRequestMarshaller()
                        .marshall(listScheduledAuditsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListScheduledAuditsResult, JsonUnmarshallerContext> unmarshaller = new ListScheduledAuditsResultJsonUnmarshaller();
            JsonResponseHandler<ListScheduledAuditsResult> responseHandler = new JsonResponseHandler<ListScheduledAuditsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the Device Defender security profiles you've created. You can
     * filter security profiles by dimension or custom metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListSecurityProfiles</a> action.
     * </p>
     * <note>
     * <p>
     * <code>dimensionName</code> and <code>metricName</code> cannot be used in
     * the same request.
     * </p>
     * </note>
     * 
     * @param listSecurityProfilesRequest
     * @return listSecurityProfilesResult The response from the
     *         ListSecurityProfiles service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListSecurityProfilesResult listSecurityProfiles(
            ListSecurityProfilesRequest listSecurityProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listSecurityProfilesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListSecurityProfilesRequest> request = null;
        Response<ListSecurityProfilesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListSecurityProfilesRequestMarshaller()
                        .marshall(listSecurityProfilesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListSecurityProfilesResult, JsonUnmarshallerContext> unmarshaller = new ListSecurityProfilesResultJsonUnmarshaller();
            JsonResponseHandler<ListSecurityProfilesResult> responseHandler = new JsonResponseHandler<ListSecurityProfilesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the Device Defender security profiles attached to a target (thing
     * group).
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListSecurityProfilesForTarget</a> action.
     * </p>
     * 
     * @param listSecurityProfilesForTargetRequest
     * @return listSecurityProfilesForTargetResult The response from the
     *         ListSecurityProfilesForTarget service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListSecurityProfilesForTargetResult listSecurityProfilesForTarget(
            ListSecurityProfilesForTargetRequest listSecurityProfilesForTargetRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listSecurityProfilesForTargetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListSecurityProfilesForTargetRequest> request = null;
        Response<ListSecurityProfilesForTargetResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListSecurityProfilesForTargetRequestMarshaller()
                        .marshall(listSecurityProfilesForTargetRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListSecurityProfilesForTargetResult, JsonUnmarshallerContext> unmarshaller = new ListSecurityProfilesForTargetResultJsonUnmarshaller();
            JsonResponseHandler<ListSecurityProfilesForTargetResult> responseHandler = new JsonResponseHandler<ListSecurityProfilesForTargetResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists all of the streams in your Amazon Web Services account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListStreams</a> action.
     * </p>
     * 
     * @param listStreamsRequest
     * @return listStreamsResult The response from the ListStreams service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListStreamsResult listStreams(ListStreamsRequest listStreamsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listStreamsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListStreamsRequest> request = null;
        Response<ListStreamsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListStreamsRequestMarshaller().marshall(listStreamsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListStreamsResult, JsonUnmarshallerContext> unmarshaller = new ListStreamsResultJsonUnmarshaller();
            JsonResponseHandler<ListStreamsResult> responseHandler = new JsonResponseHandler<ListStreamsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the tags (metadata) you have assigned to the resource.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListTagsForResource</a> action.
     * </p>
     * 
     * @param listTagsForResourceRequest
     * @return listTagsForResourceResult The response from the
     *         ListTagsForResource service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListTagsForResourceResult listTagsForResource(
            ListTagsForResourceRequest listTagsForResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForResourceRequest> request = null;
        Response<ListTagsForResourceResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForResourceRequestMarshaller()
                        .marshall(listTagsForResourceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTagsForResourceResult, JsonUnmarshallerContext> unmarshaller = new ListTagsForResourceResultJsonUnmarshaller();
            JsonResponseHandler<ListTagsForResourceResult> responseHandler = new JsonResponseHandler<ListTagsForResourceResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List targets for the specified policy.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListTargetsForPolicy</a> action.
     * </p>
     * 
     * @param listTargetsForPolicyRequest
     * @return listTargetsForPolicyResult The response from the
     *         ListTargetsForPolicy service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListTargetsForPolicyResult listTargetsForPolicy(
            ListTargetsForPolicyRequest listTargetsForPolicyRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listTargetsForPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTargetsForPolicyRequest> request = null;
        Response<ListTargetsForPolicyResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTargetsForPolicyRequestMarshaller()
                        .marshall(listTargetsForPolicyRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTargetsForPolicyResult, JsonUnmarshallerContext> unmarshaller = new ListTargetsForPolicyResultJsonUnmarshaller();
            JsonResponseHandler<ListTargetsForPolicyResult> responseHandler = new JsonResponseHandler<ListTargetsForPolicyResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the targets (thing groups) associated with a given Device Defender
     * security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListTargetsForSecurityProfile</a> action.
     * </p>
     * 
     * @param listTargetsForSecurityProfileRequest
     * @return listTargetsForSecurityProfileResult The response from the
     *         ListTargetsForSecurityProfile service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListTargetsForSecurityProfileResult listTargetsForSecurityProfile(
            ListTargetsForSecurityProfileRequest listTargetsForSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listTargetsForSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTargetsForSecurityProfileRequest> request = null;
        Response<ListTargetsForSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTargetsForSecurityProfileRequestMarshaller()
                        .marshall(listTargetsForSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTargetsForSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new ListTargetsForSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<ListTargetsForSecurityProfileResult> responseHandler = new JsonResponseHandler<ListTargetsForSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List the thing groups in your account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingGroups</a> action.
     * </p>
     * 
     * @param listThingGroupsRequest
     * @return listThingGroupsResult The response from the ListThingGroups
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingGroupsResult listThingGroups(ListThingGroupsRequest listThingGroupsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingGroupsRequest> request = null;
        Response<ListThingGroupsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingGroupsRequestMarshaller().marshall(listThingGroupsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingGroupsResult, JsonUnmarshallerContext> unmarshaller = new ListThingGroupsResultJsonUnmarshaller();
            JsonResponseHandler<ListThingGroupsResult> responseHandler = new JsonResponseHandler<ListThingGroupsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List the thing groups to which the specified thing belongs.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingGroupsForThing</a> action.
     * </p>
     * 
     * @param listThingGroupsForThingRequest
     * @return listThingGroupsForThingResult The response from the
     *         ListThingGroupsForThing service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingGroupsForThingResult listThingGroupsForThing(
            ListThingGroupsForThingRequest listThingGroupsForThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingGroupsForThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingGroupsForThingRequest> request = null;
        Response<ListThingGroupsForThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingGroupsForThingRequestMarshaller()
                        .marshall(listThingGroupsForThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingGroupsForThingResult, JsonUnmarshallerContext> unmarshaller = new ListThingGroupsForThingResultJsonUnmarshaller();
            JsonResponseHandler<ListThingGroupsForThingResult> responseHandler = new JsonResponseHandler<ListThingGroupsForThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the principals associated with the specified thing. A principal can
     * be X.509 certificates, IAM users, groups, and roles, Amazon Cognito
     * identities or federated identities.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingPrincipals</a> action.
     * </p>
     * 
     * @param listThingPrincipalsRequest <p>
     *            The input for the ListThingPrincipal operation.
     *            </p>
     * @return listThingPrincipalsResult The response from the
     *         ListThingPrincipals service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingPrincipalsResult listThingPrincipals(
            ListThingPrincipalsRequest listThingPrincipalsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingPrincipalsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingPrincipalsRequest> request = null;
        Response<ListThingPrincipalsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingPrincipalsRequestMarshaller()
                        .marshall(listThingPrincipalsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingPrincipalsResult, JsonUnmarshallerContext> unmarshaller = new ListThingPrincipalsResultJsonUnmarshaller();
            JsonResponseHandler<ListThingPrincipalsResult> responseHandler = new JsonResponseHandler<ListThingPrincipalsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Information about the thing registration tasks.
     * </p>
     * 
     * @param listThingRegistrationTaskReportsRequest
     * @return listThingRegistrationTaskReportsResult The response from the
     *         ListThingRegistrationTaskReports service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingRegistrationTaskReportsResult listThingRegistrationTaskReports(
            ListThingRegistrationTaskReportsRequest listThingRegistrationTaskReportsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingRegistrationTaskReportsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingRegistrationTaskReportsRequest> request = null;
        Response<ListThingRegistrationTaskReportsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingRegistrationTaskReportsRequestMarshaller()
                        .marshall(listThingRegistrationTaskReportsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingRegistrationTaskReportsResult, JsonUnmarshallerContext> unmarshaller = new ListThingRegistrationTaskReportsResultJsonUnmarshaller();
            JsonResponseHandler<ListThingRegistrationTaskReportsResult> responseHandler = new JsonResponseHandler<ListThingRegistrationTaskReportsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * List bulk thing provisioning tasks.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingRegistrationTasks</a> action.
     * </p>
     * 
     * @param listThingRegistrationTasksRequest
     * @return listThingRegistrationTasksResult The response from the
     *         ListThingRegistrationTasks service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingRegistrationTasksResult listThingRegistrationTasks(
            ListThingRegistrationTasksRequest listThingRegistrationTasksRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingRegistrationTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingRegistrationTasksRequest> request = null;
        Response<ListThingRegistrationTasksResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingRegistrationTasksRequestMarshaller()
                        .marshall(listThingRegistrationTasksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingRegistrationTasksResult, JsonUnmarshallerContext> unmarshaller = new ListThingRegistrationTasksResultJsonUnmarshaller();
            JsonResponseHandler<ListThingRegistrationTasksResult> responseHandler = new JsonResponseHandler<ListThingRegistrationTasksResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the existing thing types.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingTypes</a> action.
     * </p>
     * 
     * @param listThingTypesRequest <p>
     *            The input for the ListThingTypes operation.
     *            </p>
     * @return listThingTypesResult The response from the ListThingTypes service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingTypesResult listThingTypes(ListThingTypesRequest listThingTypesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingTypesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingTypesRequest> request = null;
        Response<ListThingTypesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingTypesRequestMarshaller().marshall(listThingTypesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingTypesResult, JsonUnmarshallerContext> unmarshaller = new ListThingTypesResultJsonUnmarshaller();
            JsonResponseHandler<ListThingTypesResult> responseHandler = new JsonResponseHandler<ListThingTypesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists your things. Use the <b>attributeName</b> and <b>attributeValue</b>
     * parameters to filter your things. For example, calling
     * <code>ListThings</code> with attributeName=Color and attributeValue=Red
     * retrieves all things in the registry that contain an attribute
     * <b>Color</b> with the value <b>Red</b>.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThings</a> action.
     * </p>
     * <note>
     * <p>
     * You will not be charged for calling this API if an
     * <code>Access denied</code> error is returned. You will also not be
     * charged if no attributes or pagination token was provided in request and
     * no pagination token and no results were returned.
     * </p>
     * </note>
     * 
     * @param listThingsRequest <p>
     *            The input for the ListThings operation.
     *            </p>
     * @return listThingsResult The response from the ListThings service method,
     *         as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingsResult listThings(ListThingsRequest listThingsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingsRequest> request = null;
        Response<ListThingsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingsRequestMarshaller().marshall(listThingsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingsResult, JsonUnmarshallerContext> unmarshaller = new ListThingsResultJsonUnmarshaller();
            JsonResponseHandler<ListThingsResult> responseHandler = new JsonResponseHandler<ListThingsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the things you have added to the given billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingsInBillingGroup</a> action.
     * </p>
     * 
     * @param listThingsInBillingGroupRequest
     * @return listThingsInBillingGroupResult The response from the
     *         ListThingsInBillingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingsInBillingGroupResult listThingsInBillingGroup(
            ListThingsInBillingGroupRequest listThingsInBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingsInBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingsInBillingGroupRequest> request = null;
        Response<ListThingsInBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingsInBillingGroupRequestMarshaller()
                        .marshall(listThingsInBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingsInBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new ListThingsInBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<ListThingsInBillingGroupResult> responseHandler = new JsonResponseHandler<ListThingsInBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the things in the specified group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListThingsInThingGroup</a> action.
     * </p>
     * 
     * @param listThingsInThingGroupRequest
     * @return listThingsInThingGroupResult The response from the
     *         ListThingsInThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListThingsInThingGroupResult listThingsInThingGroup(
            ListThingsInThingGroupRequest listThingsInThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listThingsInThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListThingsInThingGroupRequest> request = null;
        Response<ListThingsInThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListThingsInThingGroupRequestMarshaller()
                        .marshall(listThingsInThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListThingsInThingGroupResult, JsonUnmarshallerContext> unmarshaller = new ListThingsInThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<ListThingsInThingGroupResult> responseHandler = new JsonResponseHandler<ListThingsInThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists all the topic rule destinations in your Amazon Web Services
     * account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListTopicRuleDestinations</a> action.
     * </p>
     * 
     * @param listTopicRuleDestinationsRequest
     * @return listTopicRuleDestinationsResult The response from the
     *         ListTopicRuleDestinations service method, as returned by AWS IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListTopicRuleDestinationsResult listTopicRuleDestinations(
            ListTopicRuleDestinationsRequest listTopicRuleDestinationsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listTopicRuleDestinationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTopicRuleDestinationsRequest> request = null;
        Response<ListTopicRuleDestinationsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTopicRuleDestinationsRequestMarshaller()
                        .marshall(listTopicRuleDestinationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTopicRuleDestinationsResult, JsonUnmarshallerContext> unmarshaller = new ListTopicRuleDestinationsResultJsonUnmarshaller();
            JsonResponseHandler<ListTopicRuleDestinationsResult> responseHandler = new JsonResponseHandler<ListTopicRuleDestinationsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the rules for the specific topic.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListTopicRules</a> action.
     * </p>
     * 
     * @param listTopicRulesRequest <p>
     *            The input for the ListTopicRules operation.
     *            </p>
     * @return listTopicRulesResult The response from the ListTopicRules service
     *         method, as returned by AWS IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListTopicRulesResult listTopicRules(ListTopicRulesRequest listTopicRulesRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listTopicRulesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTopicRulesRequest> request = null;
        Response<ListTopicRulesResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTopicRulesRequestMarshaller().marshall(listTopicRulesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListTopicRulesResult, JsonUnmarshallerContext> unmarshaller = new ListTopicRulesResultJsonUnmarshaller();
            JsonResponseHandler<ListTopicRulesResult> responseHandler = new JsonResponseHandler<ListTopicRulesResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists logging levels.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListV2LoggingLevels</a> action.
     * </p>
     * 
     * @param listV2LoggingLevelsRequest
     * @return listV2LoggingLevelsResult The response from the
     *         ListV2LoggingLevels service method, as returned by AWS IoT.
     * @throws InternalException
     * @throws NotConfiguredException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListV2LoggingLevelsResult listV2LoggingLevels(
            ListV2LoggingLevelsRequest listV2LoggingLevelsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listV2LoggingLevelsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListV2LoggingLevelsRequest> request = null;
        Response<ListV2LoggingLevelsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListV2LoggingLevelsRequestMarshaller()
                        .marshall(listV2LoggingLevelsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListV2LoggingLevelsResult, JsonUnmarshallerContext> unmarshaller = new ListV2LoggingLevelsResultJsonUnmarshaller();
            JsonResponseHandler<ListV2LoggingLevelsResult> responseHandler = new JsonResponseHandler<ListV2LoggingLevelsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the Device Defender security profile violations discovered during
     * the given time period. You can use filters to limit the results to those
     * alerts issued for a particular security profile, behavior, or thing
     * (device).
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ListViolationEvents</a> action.
     * </p>
     * 
     * @param listViolationEventsRequest
     * @return listViolationEventsResult The response from the
     *         ListViolationEvents service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ListViolationEventsResult listViolationEvents(
            ListViolationEventsRequest listViolationEventsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(listViolationEventsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListViolationEventsRequest> request = null;
        Response<ListViolationEventsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListViolationEventsRequestMarshaller()
                        .marshall(listViolationEventsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ListViolationEventsResult, JsonUnmarshallerContext> unmarshaller = new ListViolationEventsResultJsonUnmarshaller();
            JsonResponseHandler<ListViolationEventsResult> responseHandler = new JsonResponseHandler<ListViolationEventsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Set a verification state and provide a description of that verification
     * state on a violation (detect alarm).
     * </p>
     * 
     * @param putVerificationStateOnViolationRequest
     * @return putVerificationStateOnViolationResult The response from the
     *         PutVerificationStateOnViolation service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public PutVerificationStateOnViolationResult putVerificationStateOnViolation(
            PutVerificationStateOnViolationRequest putVerificationStateOnViolationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(putVerificationStateOnViolationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutVerificationStateOnViolationRequest> request = null;
        Response<PutVerificationStateOnViolationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutVerificationStateOnViolationRequestMarshaller()
                        .marshall(putVerificationStateOnViolationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<PutVerificationStateOnViolationResult, JsonUnmarshallerContext> unmarshaller = new PutVerificationStateOnViolationResultJsonUnmarshaller();
            JsonResponseHandler<PutVerificationStateOnViolationResult> responseHandler = new JsonResponseHandler<PutVerificationStateOnViolationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Registers a CA certificate with IoT. This CA certificate can then be used
     * to sign device certificates, which can be then registered with IoT. You
     * can register up to 10 CA certificates per Amazon Web Services account
     * that have the same subject field. This enables you to have up to 10
     * certificate authorities sign your device certificates. If you have more
     * than one CA certificate registered, make sure you pass the CA certificate
     * when you register your device certificates with the
     * <a>RegisterCertificate</a> action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RegisterCACertificate</a> action.
     * </p>
     * 
     * @param registerCACertificateRequest <p>
     *            The input to the RegisterCACertificate operation.
     *            </p>
     * @return registerCACertificateResult The response from the
     *         RegisterCACertificate service method, as returned by AWS IoT.
     * @throws ResourceAlreadyExistsException
     * @throws RegistrationCodeValidationException
     * @throws InvalidRequestException
     * @throws CertificateValidationException
     * @throws ThrottlingException
     * @throws LimitExceededException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RegisterCACertificateResult registerCACertificate(
            RegisterCACertificateRequest registerCACertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(registerCACertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterCACertificateRequest> request = null;
        Response<RegisterCACertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterCACertificateRequestMarshaller()
                        .marshall(registerCACertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterCACertificateResult, JsonUnmarshallerContext> unmarshaller = new RegisterCACertificateResultJsonUnmarshaller();
            JsonResponseHandler<RegisterCACertificateResult> responseHandler = new JsonResponseHandler<RegisterCACertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Registers a device certificate with IoT. If you have more than one CA
     * certificate that has the same subject field, you must specify the CA
     * certificate that was used to sign the device certificate being
     * registered.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RegisterCertificate</a> action.
     * </p>
     * 
     * @param registerCertificateRequest <p>
     *            The input to the RegisterCertificate operation.
     *            </p>
     * @return registerCertificateResult The response from the
     *         RegisterCertificate service method, as returned by AWS IoT.
     * @throws ResourceAlreadyExistsException
     * @throws InvalidRequestException
     * @throws CertificateValidationException
     * @throws CertificateStateException
     * @throws CertificateConflictException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RegisterCertificateResult registerCertificate(
            RegisterCertificateRequest registerCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(registerCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterCertificateRequest> request = null;
        Response<RegisterCertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterCertificateRequestMarshaller()
                        .marshall(registerCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterCertificateResult, JsonUnmarshallerContext> unmarshaller = new RegisterCertificateResultJsonUnmarshaller();
            JsonResponseHandler<RegisterCertificateResult> responseHandler = new JsonResponseHandler<RegisterCertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Register a certificate that does not have a certificate authority (CA).
     * For supported certificates, consult <a href=
     * "https://docs.aws.amazon.com/iot/latest/developerguide/x509-client-certs.html#x509-cert-algorithms"
     * > Certificate signing algorithms supported by IoT</a>.
     * </p>
     * 
     * @param registerCertificateWithoutCARequest
     * @return registerCertificateWithoutCAResult The response from the
     *         RegisterCertificateWithoutCA service method, as returned by AWS
     *         IoT.
     * @throws ResourceAlreadyExistsException
     * @throws InvalidRequestException
     * @throws CertificateStateException
     * @throws CertificateValidationException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RegisterCertificateWithoutCAResult registerCertificateWithoutCA(
            RegisterCertificateWithoutCARequest registerCertificateWithoutCARequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(registerCertificateWithoutCARequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterCertificateWithoutCARequest> request = null;
        Response<RegisterCertificateWithoutCAResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterCertificateWithoutCARequestMarshaller()
                        .marshall(registerCertificateWithoutCARequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterCertificateWithoutCAResult, JsonUnmarshallerContext> unmarshaller = new RegisterCertificateWithoutCAResultJsonUnmarshaller();
            JsonResponseHandler<RegisterCertificateWithoutCAResult> responseHandler = new JsonResponseHandler<RegisterCertificateWithoutCAResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Provisions a thing in the device registry. RegisterThing calls other IoT
     * control plane APIs. These calls might exceed your account level <a href=
     * "https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html#limits_iot"
     * > IoT Throttling Limits</a> and cause throttle errors. Please contact <a
     * href="https://console.aws.amazon.com/support/home">Amazon Web Services
     * Customer Support</a> to raise your throttling limits if necessary.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RegisterThing</a> action.
     * </p>
     * 
     * @param registerThingRequest
     * @return registerThingResult The response from the RegisterThing service
     *         method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws ServiceUnavailableException
     * @throws InvalidRequestException
     * @throws UnauthorizedException
     * @throws ThrottlingException
     * @throws ConflictingResourceUpdateException
     * @throws ResourceRegistrationFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RegisterThingResult registerThing(RegisterThingRequest registerThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(registerThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterThingRequest> request = null;
        Response<RegisterThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterThingRequestMarshaller().marshall(registerThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RegisterThingResult, JsonUnmarshallerContext> unmarshaller = new RegisterThingResultJsonUnmarshaller();
            JsonResponseHandler<RegisterThingResult> responseHandler = new JsonResponseHandler<RegisterThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Rejects a pending certificate transfer. After IoT rejects a certificate
     * transfer, the certificate status changes from <b>PENDING_TRANSFER</b> to
     * <b>INACTIVE</b>.
     * </p>
     * <p>
     * To check for pending certificate transfers, call <a>ListCertificates</a>
     * to enumerate your certificates.
     * </p>
     * <p>
     * This operation can only be called by the transfer destination. After it
     * is called, the certificate will be returned to the source's account in
     * the INACTIVE state.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RejectCertificateTransfer</a> action.
     * </p>
     * 
     * @param rejectCertificateTransferRequest <p>
     *            The input for the RejectCertificateTransfer operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws TransferAlreadyCompletedException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void rejectCertificateTransfer(
            RejectCertificateTransferRequest rejectCertificateTransferRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(rejectCertificateTransferRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RejectCertificateTransferRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RejectCertificateTransferRequestMarshaller()
                        .marshall(rejectCertificateTransferRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes the given thing from the billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RemoveThingFromBillingGroup</a> action.
     * </p>
     * <note>
     * <p>
     * This call is asynchronous. It might take several seconds for the
     * detachment to propagate.
     * </p>
     * </note>
     * 
     * @param removeThingFromBillingGroupRequest
     * @return removeThingFromBillingGroupResult The response from the
     *         RemoveThingFromBillingGroup service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RemoveThingFromBillingGroupResult removeThingFromBillingGroup(
            RemoveThingFromBillingGroupRequest removeThingFromBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(removeThingFromBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveThingFromBillingGroupRequest> request = null;
        Response<RemoveThingFromBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveThingFromBillingGroupRequestMarshaller()
                        .marshall(removeThingFromBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RemoveThingFromBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new RemoveThingFromBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<RemoveThingFromBillingGroupResult> responseHandler = new JsonResponseHandler<RemoveThingFromBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Remove the specified thing from the specified group.
     * </p>
     * <p>
     * You must specify either a <code>thingGroupArn</code> or a
     * <code>thingGroupName</code> to identify the thing group and either a
     * <code>thingArn</code> or a <code>thingName</code> to identify the thing
     * to remove from the thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >RemoveThingFromThingGroup</a> action.
     * </p>
     * 
     * @param removeThingFromThingGroupRequest
     * @return removeThingFromThingGroupResult The response from the
     *         RemoveThingFromThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public RemoveThingFromThingGroupResult removeThingFromThingGroup(
            RemoveThingFromThingGroupRequest removeThingFromThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(removeThingFromThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveThingFromThingGroupRequest> request = null;
        Response<RemoveThingFromThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveThingFromThingGroupRequestMarshaller()
                        .marshall(removeThingFromThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<RemoveThingFromThingGroupResult, JsonUnmarshallerContext> unmarshaller = new RemoveThingFromThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<RemoveThingFromThingGroupResult> responseHandler = new JsonResponseHandler<RemoveThingFromThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Replaces the rule. You must specify all parameters for the new rule.
     * Creating rules is an administrator-level action. Any user who has
     * permission to create rules will be able to access data processed by the
     * rule.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ReplaceTopicRule</a> action.
     * </p>
     * 
     * @param replaceTopicRuleRequest <p>
     *            The input for the ReplaceTopicRule operation.
     *            </p>
     * @throws SqlParseException
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void replaceTopicRule(ReplaceTopicRuleRequest replaceTopicRuleRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(replaceTopicRuleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceTopicRuleRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceTopicRuleRequestMarshaller().marshall(replaceTopicRuleRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * The query search index.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SearchIndex</a> action.
     * </p>
     * 
     * @param searchIndexRequest
     * @return searchIndexResult The response from the SearchIndex service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public SearchIndexResult searchIndex(SearchIndexRequest searchIndexRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(searchIndexRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SearchIndexRequest> request = null;
        Response<SearchIndexResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SearchIndexRequestMarshaller().marshall(searchIndexRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<SearchIndexResult, JsonUnmarshallerContext> unmarshaller = new SearchIndexResultJsonUnmarshaller();
            JsonResponseHandler<SearchIndexResult> responseHandler = new JsonResponseHandler<SearchIndexResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Sets the default authorizer. This will be used if a websocket connection
     * is made without specifying an authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SetDefaultAuthorizer</a> action.
     * </p>
     * 
     * @param setDefaultAuthorizerRequest
     * @return setDefaultAuthorizerResult The response from the
     *         SetDefaultAuthorizer service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceAlreadyExistsException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public SetDefaultAuthorizerResult setDefaultAuthorizer(
            SetDefaultAuthorizerRequest setDefaultAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(setDefaultAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetDefaultAuthorizerRequest> request = null;
        Response<SetDefaultAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetDefaultAuthorizerRequestMarshaller()
                        .marshall(setDefaultAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<SetDefaultAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new SetDefaultAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<SetDefaultAuthorizerResult> responseHandler = new JsonResponseHandler<SetDefaultAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Sets the specified version of the specified policy as the policy's
     * default (operative) version. This action affects all certificates to
     * which the policy is attached. To list the principals the policy is
     * attached to, use the <a>ListPrincipalPolicies</a> action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SetDefaultPolicyVersion</a> action.
     * </p>
     * 
     * @param setDefaultPolicyVersionRequest <p>
     *            The input for the SetDefaultPolicyVersion operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void setDefaultPolicyVersion(
            SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(setDefaultPolicyVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetDefaultPolicyVersionRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetDefaultPolicyVersionRequestMarshaller()
                        .marshall(setDefaultPolicyVersionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Sets the logging options.
     * </p>
     * <p>
     * NOTE: use of this command is not recommended. Use
     * <code>SetV2LoggingOptions</code> instead.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SetLoggingOptions</a> action.
     * </p>
     * 
     * @param setLoggingOptionsRequest <p>
     *            The input for the SetLoggingOptions operation.
     *            </p>
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void setLoggingOptions(SetLoggingOptionsRequest setLoggingOptionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(setLoggingOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetLoggingOptionsRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetLoggingOptionsRequestMarshaller()
                        .marshall(setLoggingOptionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Sets the logging level.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SetV2LoggingLevel</a> action.
     * </p>
     * 
     * @param setV2LoggingLevelRequest
     * @throws InternalException
     * @throws NotConfiguredException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void setV2LoggingLevel(SetV2LoggingLevelRequest setV2LoggingLevelRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(setV2LoggingLevelRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetV2LoggingLevelRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetV2LoggingLevelRequestMarshaller()
                        .marshall(setV2LoggingLevelRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Sets the logging options for the V2 logging service.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >SetV2LoggingOptions</a> action.
     * </p>
     * 
     * @param setV2LoggingOptionsRequest
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void setV2LoggingOptions(SetV2LoggingOptionsRequest setV2LoggingOptionsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(setV2LoggingOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetV2LoggingOptionsRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetV2LoggingOptionsRequestMarshaller()
                        .marshall(setV2LoggingOptionsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Starts a task that applies a set of mitigation actions to the specified
     * target.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >StartAuditMitigationActionsTask</a> action.
     * </p>
     * 
     * @param startAuditMitigationActionsTaskRequest
     * @return startAuditMitigationActionsTaskResult The response from the
     *         StartAuditMitigationActionsTask service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws TaskAlreadyExistsException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public StartAuditMitigationActionsTaskResult startAuditMitigationActionsTask(
            StartAuditMitigationActionsTaskRequest startAuditMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(startAuditMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartAuditMitigationActionsTaskRequest> request = null;
        Response<StartAuditMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartAuditMitigationActionsTaskRequestMarshaller()
                        .marshall(startAuditMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StartAuditMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new StartAuditMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<StartAuditMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<StartAuditMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Starts a Device Defender ML Detect mitigation actions task.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >StartDetectMitigationActionsTask</a> action.
     * </p>
     * 
     * @param startDetectMitigationActionsTaskRequest
     * @return startDetectMitigationActionsTaskResult The response from the
     *         StartDetectMitigationActionsTask service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws TaskAlreadyExistsException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public StartDetectMitigationActionsTaskResult startDetectMitigationActionsTask(
            StartDetectMitigationActionsTaskRequest startDetectMitigationActionsTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(startDetectMitigationActionsTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartDetectMitigationActionsTaskRequest> request = null;
        Response<StartDetectMitigationActionsTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartDetectMitigationActionsTaskRequestMarshaller()
                        .marshall(startDetectMitigationActionsTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StartDetectMitigationActionsTaskResult, JsonUnmarshallerContext> unmarshaller = new StartDetectMitigationActionsTaskResultJsonUnmarshaller();
            JsonResponseHandler<StartDetectMitigationActionsTaskResult> responseHandler = new JsonResponseHandler<StartDetectMitigationActionsTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Starts an on-demand Device Defender audit.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >StartOnDemandAuditTask</a> action.
     * </p>
     * 
     * @param startOnDemandAuditTaskRequest
     * @return startOnDemandAuditTaskResult The response from the
     *         StartOnDemandAuditTask service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public StartOnDemandAuditTaskResult startOnDemandAuditTask(
            StartOnDemandAuditTaskRequest startOnDemandAuditTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(startOnDemandAuditTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartOnDemandAuditTaskRequest> request = null;
        Response<StartOnDemandAuditTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartOnDemandAuditTaskRequestMarshaller()
                        .marshall(startOnDemandAuditTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StartOnDemandAuditTaskResult, JsonUnmarshallerContext> unmarshaller = new StartOnDemandAuditTaskResultJsonUnmarshaller();
            JsonResponseHandler<StartOnDemandAuditTaskResult> responseHandler = new JsonResponseHandler<StartOnDemandAuditTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a bulk thing provisioning task.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >StartThingRegistrationTask</a> action.
     * </p>
     * 
     * @param startThingRegistrationTaskRequest
     * @return startThingRegistrationTaskResult The response from the
     *         StartThingRegistrationTask service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public StartThingRegistrationTaskResult startThingRegistrationTask(
            StartThingRegistrationTaskRequest startThingRegistrationTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(startThingRegistrationTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartThingRegistrationTaskRequest> request = null;
        Response<StartThingRegistrationTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartThingRegistrationTaskRequestMarshaller()
                        .marshall(startThingRegistrationTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StartThingRegistrationTaskResult, JsonUnmarshallerContext> unmarshaller = new StartThingRegistrationTaskResultJsonUnmarshaller();
            JsonResponseHandler<StartThingRegistrationTaskResult> responseHandler = new JsonResponseHandler<StartThingRegistrationTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Cancels a bulk thing provisioning task.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >StopThingRegistrationTask</a> action.
     * </p>
     * 
     * @param stopThingRegistrationTaskRequest
     * @return stopThingRegistrationTaskResult The response from the
     *         StopThingRegistrationTask service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public StopThingRegistrationTaskResult stopThingRegistrationTask(
            StopThingRegistrationTaskRequest stopThingRegistrationTaskRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(stopThingRegistrationTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StopThingRegistrationTaskRequest> request = null;
        Response<StopThingRegistrationTaskResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StopThingRegistrationTaskRequestMarshaller()
                        .marshall(stopThingRegistrationTaskRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<StopThingRegistrationTaskResult, JsonUnmarshallerContext> unmarshaller = new StopThingRegistrationTaskResultJsonUnmarshaller();
            JsonResponseHandler<StopThingRegistrationTaskResult> responseHandler = new JsonResponseHandler<StopThingRegistrationTaskResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds to or modifies the tags of the given resource. Tags are metadata
     * which can be used to manage a resource.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >TagResource</a> action.
     * </p>
     * 
     * @param tagResourceRequest
     * @return tagResourceResult The response from the TagResource service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public TagResourceResult tagResource(TagResourceRequest tagResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TagResourceRequest> request = null;
        Response<TagResourceResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TagResourceRequestMarshaller().marshall(tagResourceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<TagResourceResult, JsonUnmarshallerContext> unmarshaller = new TagResourceResultJsonUnmarshaller();
            JsonResponseHandler<TagResourceResult> responseHandler = new JsonResponseHandler<TagResourceResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Tests if a specified principal is authorized to perform an IoT action on
     * a specified resource. Use this to test and debug the authorization
     * behavior of devices that connect to the IoT device gateway.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >TestAuthorization</a> action.
     * </p>
     * 
     * @param testAuthorizationRequest
     * @return testAuthorizationResult The response from the TestAuthorization
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public TestAuthorizationResult testAuthorization(
            TestAuthorizationRequest testAuthorizationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(testAuthorizationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TestAuthorizationRequest> request = null;
        Response<TestAuthorizationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TestAuthorizationRequestMarshaller()
                        .marshall(testAuthorizationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<TestAuthorizationResult, JsonUnmarshallerContext> unmarshaller = new TestAuthorizationResultJsonUnmarshaller();
            JsonResponseHandler<TestAuthorizationResult> responseHandler = new JsonResponseHandler<TestAuthorizationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Tests a custom authorization behavior by invoking a specified custom
     * authorizer. Use this to test and debug the custom authorization behavior
     * of devices that connect to the IoT device gateway.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >TestInvokeAuthorizer</a> action.
     * </p>
     * 
     * @param testInvokeAuthorizerRequest
     * @return testInvokeAuthorizerResult The response from the
     *         TestInvokeAuthorizer service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws InvalidResponseException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public TestInvokeAuthorizerResult testInvokeAuthorizer(
            TestInvokeAuthorizerRequest testInvokeAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(testInvokeAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TestInvokeAuthorizerRequest> request = null;
        Response<TestInvokeAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TestInvokeAuthorizerRequestMarshaller()
                        .marshall(testInvokeAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<TestInvokeAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new TestInvokeAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<TestInvokeAuthorizerResult> responseHandler = new JsonResponseHandler<TestInvokeAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Transfers the specified certificate to the specified Amazon Web Services
     * account.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >TransferCertificate</a> action.
     * </p>
     * <p>
     * You can cancel the transfer until it is acknowledged by the recipient.
     * </p>
     * <p>
     * No notification is sent to the transfer destination's account. It is up
     * to the caller to notify the transfer target.
     * </p>
     * <p>
     * The certificate being transferred must not be in the ACTIVE state. You
     * can use the <a>UpdateCertificate</a> action to deactivate it.
     * </p>
     * <p>
     * The certificate must not have any policies attached to it. You can use
     * the <a>DetachPolicy</a> action to detach them.
     * </p>
     * 
     * @param transferCertificateRequest <p>
     *            The input for the TransferCertificate operation.
     *            </p>
     * @return transferCertificateResult The response from the
     *         TransferCertificate service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws CertificateStateException
     * @throws TransferConflictException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public TransferCertificateResult transferCertificate(
            TransferCertificateRequest transferCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(transferCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TransferCertificateRequest> request = null;
        Response<TransferCertificateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TransferCertificateRequestMarshaller()
                        .marshall(transferCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<TransferCertificateResult, JsonUnmarshallerContext> unmarshaller = new TransferCertificateResultJsonUnmarshaller();
            JsonResponseHandler<TransferCertificateResult> responseHandler = new JsonResponseHandler<TransferCertificateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes the given tags (metadata) from the resource.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UntagResource</a> action.
     * </p>
     * 
     * @param untagResourceRequest
     * @return untagResourceResult The response from the UntagResource service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UntagResourceResult untagResource(UntagResourceRequest untagResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(untagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UntagResourceRequest> request = null;
        Response<UntagResourceResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UntagResourceRequestMarshaller().marshall(untagResourceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UntagResourceResult, JsonUnmarshallerContext> unmarshaller = new UntagResourceResultJsonUnmarshaller();
            JsonResponseHandler<UntagResourceResult> responseHandler = new JsonResponseHandler<UntagResourceResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Configures or reconfigures the Device Defender audit settings for this
     * account. Settings include how audit notifications are sent and which
     * audit checks are enabled or disabled.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateAccountAuditConfiguration</a> action.
     * </p>
     * 
     * @param updateAccountAuditConfigurationRequest
     * @return updateAccountAuditConfigurationResult The response from the
     *         UpdateAccountAuditConfiguration service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateAccountAuditConfigurationResult updateAccountAuditConfiguration(
            UpdateAccountAuditConfigurationRequest updateAccountAuditConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateAccountAuditConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateAccountAuditConfigurationRequest> request = null;
        Response<UpdateAccountAuditConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateAccountAuditConfigurationRequestMarshaller()
                        .marshall(updateAccountAuditConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateAccountAuditConfigurationResult, JsonUnmarshallerContext> unmarshaller = new UpdateAccountAuditConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<UpdateAccountAuditConfigurationResult> responseHandler = new JsonResponseHandler<UpdateAccountAuditConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a Device Defender audit suppression.
     * </p>
     * 
     * @param updateAuditSuppressionRequest
     * @return updateAuditSuppressionResult The response from the
     *         UpdateAuditSuppression service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateAuditSuppressionResult updateAuditSuppression(
            UpdateAuditSuppressionRequest updateAuditSuppressionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateAuditSuppressionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateAuditSuppressionRequest> request = null;
        Response<UpdateAuditSuppressionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateAuditSuppressionRequestMarshaller()
                        .marshall(updateAuditSuppressionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateAuditSuppressionResult, JsonUnmarshallerContext> unmarshaller = new UpdateAuditSuppressionResultJsonUnmarshaller();
            JsonResponseHandler<UpdateAuditSuppressionResult> responseHandler = new JsonResponseHandler<UpdateAuditSuppressionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates an authorizer.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateAuthorizer</a> action.
     * </p>
     * 
     * @param updateAuthorizerRequest
     * @return updateAuthorizerResult The response from the UpdateAuthorizer
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateAuthorizerResult updateAuthorizer(UpdateAuthorizerRequest updateAuthorizerRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateAuthorizerRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateAuthorizerRequest> request = null;
        Response<UpdateAuthorizerResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateAuthorizerRequestMarshaller().marshall(updateAuthorizerRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateAuthorizerResult, JsonUnmarshallerContext> unmarshaller = new UpdateAuthorizerResultJsonUnmarshaller();
            JsonResponseHandler<UpdateAuthorizerResult> responseHandler = new JsonResponseHandler<UpdateAuthorizerResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates information about the billing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateBillingGroup</a> action.
     * </p>
     * 
     * @param updateBillingGroupRequest
     * @return updateBillingGroupResult The response from the UpdateBillingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateBillingGroupResult updateBillingGroup(
            UpdateBillingGroupRequest updateBillingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateBillingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateBillingGroupRequest> request = null;
        Response<UpdateBillingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateBillingGroupRequestMarshaller()
                        .marshall(updateBillingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateBillingGroupResult, JsonUnmarshallerContext> unmarshaller = new UpdateBillingGroupResultJsonUnmarshaller();
            JsonResponseHandler<UpdateBillingGroupResult> responseHandler = new JsonResponseHandler<UpdateBillingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a registered CA certificate.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateCACertificate</a> action.
     * </p>
     * 
     * @param updateCACertificateRequest <p>
     *            The input to the UpdateCACertificate operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void updateCACertificate(UpdateCACertificateRequest updateCACertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateCACertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCACertificateRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCACertificateRequestMarshaller()
                        .marshall(updateCACertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the status of the specified certificate. This operation is
     * idempotent.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateCertificate</a> action.
     * </p>
     * <p>
     * Certificates must be in the ACTIVE state to authenticate devices that use
     * a certificate to connect to IoT.
     * </p>
     * <p>
     * Within a few minutes of updating a certificate from the ACTIVE state to
     * any other state, IoT disconnects all devices that used that certificate
     * to connect. Devices cannot use a certificate that is not in the ACTIVE
     * state to reconnect.
     * </p>
     * 
     * @param updateCertificateRequest <p>
     *            The input for the UpdateCertificate operation.
     *            </p>
     * @throws ResourceNotFoundException
     * @throws CertificateStateException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void updateCertificate(UpdateCertificateRequest updateCertificateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateCertificateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCertificateRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCertificateRequestMarshaller()
                        .marshall(updateCertificateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a Device Defender detect custom metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateCustomMetric</a> action.
     * </p>
     * 
     * @param updateCustomMetricRequest
     * @return updateCustomMetricResult The response from the UpdateCustomMetric
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateCustomMetricResult updateCustomMetric(
            UpdateCustomMetricRequest updateCustomMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateCustomMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateCustomMetricRequest> request = null;
        Response<UpdateCustomMetricResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateCustomMetricRequestMarshaller()
                        .marshall(updateCustomMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateCustomMetricResult, JsonUnmarshallerContext> unmarshaller = new UpdateCustomMetricResultJsonUnmarshaller();
            JsonResponseHandler<UpdateCustomMetricResult> responseHandler = new JsonResponseHandler<UpdateCustomMetricResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the definition for a dimension. You cannot change the type of a
     * dimension after it is created (you can delete it and recreate it).
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateDimension</a> action.
     * </p>
     * 
     * @param updateDimensionRequest
     * @return updateDimensionResult The response from the UpdateDimension
     *         service method, as returned by AWS IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateDimensionResult updateDimension(UpdateDimensionRequest updateDimensionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateDimensionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateDimensionRequest> request = null;
        Response<UpdateDimensionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateDimensionRequestMarshaller().marshall(updateDimensionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateDimensionResult, JsonUnmarshallerContext> unmarshaller = new UpdateDimensionResultJsonUnmarshaller();
            JsonResponseHandler<UpdateDimensionResult> responseHandler = new JsonResponseHandler<UpdateDimensionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates values stored in the domain configuration. Domain configurations
     * for default endpoints can't be updated.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateDomainConfiguration</a> action.
     * </p>
     * 
     * @param updateDomainConfigurationRequest
     * @return updateDomainConfigurationResult The response from the
     *         UpdateDomainConfiguration service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws CertificateValidationException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateDomainConfigurationResult updateDomainConfiguration(
            UpdateDomainConfigurationRequest updateDomainConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateDomainConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateDomainConfigurationRequest> request = null;
        Response<UpdateDomainConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateDomainConfigurationRequestMarshaller()
                        .marshall(updateDomainConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateDomainConfigurationResult, JsonUnmarshallerContext> unmarshaller = new UpdateDomainConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<UpdateDomainConfigurationResult> responseHandler = new JsonResponseHandler<UpdateDomainConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a dynamic thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateDynamicThingGroup</a> action.
     * </p>
     * 
     * @param updateDynamicThingGroupRequest
     * @return updateDynamicThingGroupResult The response from the
     *         UpdateDynamicThingGroup service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateDynamicThingGroupResult updateDynamicThingGroup(
            UpdateDynamicThingGroupRequest updateDynamicThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateDynamicThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateDynamicThingGroupRequest> request = null;
        Response<UpdateDynamicThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateDynamicThingGroupRequestMarshaller()
                        .marshall(updateDynamicThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateDynamicThingGroupResult, JsonUnmarshallerContext> unmarshaller = new UpdateDynamicThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<UpdateDynamicThingGroupResult> responseHandler = new JsonResponseHandler<UpdateDynamicThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the event configurations.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateEventConfigurations</a> action.
     * </p>
     * 
     * @param updateEventConfigurationsRequest
     * @return updateEventConfigurationsResult The response from the
     *         UpdateEventConfigurations service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws InternalFailureException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateEventConfigurationsResult updateEventConfigurations(
            UpdateEventConfigurationsRequest updateEventConfigurationsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateEventConfigurationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateEventConfigurationsRequest> request = null;
        Response<UpdateEventConfigurationsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateEventConfigurationsRequestMarshaller()
                        .marshall(updateEventConfigurationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateEventConfigurationsResult, JsonUnmarshallerContext> unmarshaller = new UpdateEventConfigurationsResultJsonUnmarshaller();
            JsonResponseHandler<UpdateEventConfigurationsResult> responseHandler = new JsonResponseHandler<UpdateEventConfigurationsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the data for a fleet metric.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateFleetMetric</a> action.
     * </p>
     * 
     * @param updateFleetMetricRequest
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws InvalidQueryException
     * @throws InvalidAggregationException
     * @throws VersionConflictException
     * @throws IndexNotReadyException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void updateFleetMetric(UpdateFleetMetricRequest updateFleetMetricRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateFleetMetricRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateFleetMetricRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateFleetMetricRequestMarshaller()
                        .marshall(updateFleetMetricRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the search configuration.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateIndexingConfiguration</a> action.
     * </p>
     * 
     * @param updateIndexingConfigurationRequest
     * @return updateIndexingConfigurationResult The response from the
     *         UpdateIndexingConfiguration service method, as returned by AWS
     *         IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateIndexingConfigurationResult updateIndexingConfiguration(
            UpdateIndexingConfigurationRequest updateIndexingConfigurationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateIndexingConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateIndexingConfigurationRequest> request = null;
        Response<UpdateIndexingConfigurationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateIndexingConfigurationRequestMarshaller()
                        .marshall(updateIndexingConfigurationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateIndexingConfigurationResult, JsonUnmarshallerContext> unmarshaller = new UpdateIndexingConfigurationResultJsonUnmarshaller();
            JsonResponseHandler<UpdateIndexingConfigurationResult> responseHandler = new JsonResponseHandler<UpdateIndexingConfigurationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates supported fields of the specified job.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateJob</a> action.
     * </p>
     * 
     * @param updateJobRequest
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceUnavailableException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public void updateJob(UpdateJobRequest updateJobRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateJobRequest> request = null;
        Response<Void> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateJobRequestMarshaller().marshall(updateJobRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the definition for the specified mitigation action.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateMitigationAction</a> action.
     * </p>
     * 
     * @param updateMitigationActionRequest
     * @return updateMitigationActionResult The response from the
     *         UpdateMitigationAction service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateMitigationActionResult updateMitigationAction(
            UpdateMitigationActionRequest updateMitigationActionRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateMitigationActionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateMitigationActionRequest> request = null;
        Response<UpdateMitigationActionResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateMitigationActionRequestMarshaller()
                        .marshall(updateMitigationActionRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateMitigationActionResult, JsonUnmarshallerContext> unmarshaller = new UpdateMitigationActionResultJsonUnmarshaller();
            JsonResponseHandler<UpdateMitigationActionResult> responseHandler = new JsonResponseHandler<UpdateMitigationActionResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a fleet provisioning template.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateProvisioningTemplate</a> action.
     * </p>
     * 
     * @param updateProvisioningTemplateRequest
     * @return updateProvisioningTemplateResult The response from the
     *         UpdateProvisioningTemplate service method, as returned by AWS
     *         IoT.
     * @throws InternalFailureException
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateProvisioningTemplateResult updateProvisioningTemplate(
            UpdateProvisioningTemplateRequest updateProvisioningTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateProvisioningTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateProvisioningTemplateRequest> request = null;
        Response<UpdateProvisioningTemplateResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateProvisioningTemplateRequestMarshaller()
                        .marshall(updateProvisioningTemplateRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateProvisioningTemplateResult, JsonUnmarshallerContext> unmarshaller = new UpdateProvisioningTemplateResultJsonUnmarshaller();
            JsonResponseHandler<UpdateProvisioningTemplateResult> responseHandler = new JsonResponseHandler<UpdateProvisioningTemplateResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a role alias.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateRoleAlias</a> action.
     * </p>
     * 
     * @param updateRoleAliasRequest
     * @return updateRoleAliasResult The response from the UpdateRoleAlias
     *         service method, as returned by AWS IoT.
     * @throws ResourceNotFoundException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateRoleAliasResult updateRoleAlias(UpdateRoleAliasRequest updateRoleAliasRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateRoleAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateRoleAliasRequest> request = null;
        Response<UpdateRoleAliasResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateRoleAliasRequestMarshaller().marshall(updateRoleAliasRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateRoleAliasResult, JsonUnmarshallerContext> unmarshaller = new UpdateRoleAliasResultJsonUnmarshaller();
            JsonResponseHandler<UpdateRoleAliasResult> responseHandler = new JsonResponseHandler<UpdateRoleAliasResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a scheduled audit, including which checks are performed and how
     * often the audit takes place.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateScheduledAudit</a> action.
     * </p>
     * 
     * @param updateScheduledAuditRequest
     * @return updateScheduledAuditResult The response from the
     *         UpdateScheduledAudit service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateScheduledAuditResult updateScheduledAudit(
            UpdateScheduledAuditRequest updateScheduledAuditRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateScheduledAuditRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateScheduledAuditRequest> request = null;
        Response<UpdateScheduledAuditResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateScheduledAuditRequestMarshaller()
                        .marshall(updateScheduledAuditRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateScheduledAuditResult, JsonUnmarshallerContext> unmarshaller = new UpdateScheduledAuditResultJsonUnmarshaller();
            JsonResponseHandler<UpdateScheduledAuditResult> responseHandler = new JsonResponseHandler<UpdateScheduledAuditResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a Device Defender security profile.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateSecurityProfile</a> action.
     * </p>
     * 
     * @param updateSecurityProfileRequest
     * @return updateSecurityProfileResult The response from the
     *         UpdateSecurityProfile service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateSecurityProfileResult updateSecurityProfile(
            UpdateSecurityProfileRequest updateSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateSecurityProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateSecurityProfileRequest> request = null;
        Response<UpdateSecurityProfileResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateSecurityProfileRequestMarshaller()
                        .marshall(updateSecurityProfileRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateSecurityProfileResult, JsonUnmarshallerContext> unmarshaller = new UpdateSecurityProfileResultJsonUnmarshaller();
            JsonResponseHandler<UpdateSecurityProfileResult> responseHandler = new JsonResponseHandler<UpdateSecurityProfileResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates an existing stream. The stream version will be incremented by
     * one.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateStream</a> action.
     * </p>
     * 
     * @param updateStreamRequest
     * @return updateStreamResult The response from the UpdateStream service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateStreamResult updateStream(UpdateStreamRequest updateStreamRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateStreamRequest> request = null;
        Response<UpdateStreamResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateStreamRequestMarshaller().marshall(updateStreamRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateStreamResult, JsonUnmarshallerContext> unmarshaller = new UpdateStreamResultJsonUnmarshaller();
            JsonResponseHandler<UpdateStreamResult> responseHandler = new JsonResponseHandler<UpdateStreamResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the data for a thing.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateThing</a> action.
     * </p>
     * 
     * @param updateThingRequest <p>
     *            The input for the UpdateThing operation.
     *            </p>
     * @return updateThingResult The response from the UpdateThing service
     *         method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws UnauthorizedException
     * @throws ServiceUnavailableException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateThingResult updateThing(UpdateThingRequest updateThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateThingRequest> request = null;
        Response<UpdateThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateThingRequestMarshaller().marshall(updateThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateThingResult, JsonUnmarshallerContext> unmarshaller = new UpdateThingResultJsonUnmarshaller();
            JsonResponseHandler<UpdateThingResult> responseHandler = new JsonResponseHandler<UpdateThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Update a thing group.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateThingGroup</a> action.
     * </p>
     * 
     * @param updateThingGroupRequest
     * @return updateThingGroupResult The response from the UpdateThingGroup
     *         service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws VersionConflictException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateThingGroupResult updateThingGroup(UpdateThingGroupRequest updateThingGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateThingGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateThingGroupRequest> request = null;
        Response<UpdateThingGroupResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateThingGroupRequestMarshaller().marshall(updateThingGroupRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateThingGroupResult, JsonUnmarshallerContext> unmarshaller = new UpdateThingGroupResultJsonUnmarshaller();
            JsonResponseHandler<UpdateThingGroupResult> responseHandler = new JsonResponseHandler<UpdateThingGroupResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the groups to which the thing belongs.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateThingGroupsForThing</a> action.
     * </p>
     * 
     * @param updateThingGroupsForThingRequest
     * @return updateThingGroupsForThingResult The response from the
     *         UpdateThingGroupsForThing service method, as returned by AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateThingGroupsForThingResult updateThingGroupsForThing(
            UpdateThingGroupsForThingRequest updateThingGroupsForThingRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateThingGroupsForThingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateThingGroupsForThingRequest> request = null;
        Response<UpdateThingGroupsForThingResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateThingGroupsForThingRequestMarshaller()
                        .marshall(updateThingGroupsForThingRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateThingGroupsForThingResult, JsonUnmarshallerContext> unmarshaller = new UpdateThingGroupsForThingResultJsonUnmarshaller();
            JsonResponseHandler<UpdateThingGroupsForThingResult> responseHandler = new JsonResponseHandler<UpdateThingGroupsForThingResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates a topic rule destination. You use this to change the status,
     * endpoint URL, or confirmation URL of the destination.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >UpdateTopicRuleDestination</a> action.
     * </p>
     * 
     * @param updateTopicRuleDestinationRequest
     * @return updateTopicRuleDestinationResult The response from the
     *         UpdateTopicRuleDestination service method, as returned by AWS
     *         IoT.
     * @throws InternalException
     * @throws InvalidRequestException
     * @throws ServiceUnavailableException
     * @throws UnauthorizedException
     * @throws ConflictingResourceUpdateException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public UpdateTopicRuleDestinationResult updateTopicRuleDestination(
            UpdateTopicRuleDestinationRequest updateTopicRuleDestinationRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(updateTopicRuleDestinationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateTopicRuleDestinationRequest> request = null;
        Response<UpdateTopicRuleDestinationResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateTopicRuleDestinationRequestMarshaller()
                        .marshall(updateTopicRuleDestinationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<UpdateTopicRuleDestinationResult, JsonUnmarshallerContext> unmarshaller = new UpdateTopicRuleDestinationResultJsonUnmarshaller();
            JsonResponseHandler<UpdateTopicRuleDestinationResult> responseHandler = new JsonResponseHandler<UpdateTopicRuleDestinationResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Validates a Device Defender security profile behaviors specification.
     * </p>
     * <p>
     * Requires permission to access the <a href=
     * "https://docs.aws.amazon.com/service-authorization/latest/reference/list_awsiot.html#awsiot-actions-as-permissions"
     * >ValidateSecurityProfileBehaviors</a> action.
     * </p>
     * 
     * @param validateSecurityProfileBehaviorsRequest
     * @return validateSecurityProfileBehaviorsResult The response from the
     *         ValidateSecurityProfileBehaviors service method, as returned by
     *         AWS IoT.
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws InternalFailureException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by AWS
     *             IoT indicating either a problem with the data in the request,
     *             or a server side issue.
     */
    public ValidateSecurityProfileBehaviorsResult validateSecurityProfileBehaviors(
            ValidateSecurityProfileBehaviorsRequest validateSecurityProfileBehaviorsRequest)
            throws AmazonServiceException, AmazonClientException {
        ExecutionContext executionContext = createExecutionContext(validateSecurityProfileBehaviorsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ValidateSecurityProfileBehaviorsRequest> request = null;
        Response<ValidateSecurityProfileBehaviorsResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ValidateSecurityProfileBehaviorsRequestMarshaller()
                        .marshall(validateSecurityProfileBehaviorsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<ValidateSecurityProfileBehaviorsResult, JsonUnmarshallerContext> unmarshaller = new ValidateSecurityProfileBehaviorsResultJsonUnmarshaller();
            JsonResponseHandler<ValidateSecurityProfileBehaviorsResult> responseHandler = new JsonResponseHandler<ValidateSecurityProfileBehaviorsResult>(
                    unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            awsRequestMetrics.endEvent(Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful,
     * request, typically used for debugging issues where a service isn't acting
     * as expected. This data isn't considered part of the result data returned
     * by an operation, so it's available through this separate, diagnostic
     * interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you
     * need to access this extra diagnostic information for an executed request,
     * you should use this method to retrieve it as soon as possible after
     * executing the request.
     *
     * @param request The originally executed request
     * @return The response metadata for the specified request, or null if none
     *         is available.
     * @deprecated ResponseMetadata cache can hold up to 50 requests and
     *             responses in memory and will cause memory issue. This method
     *             now always returns null.
     */
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSCredentials credentials;
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime);
        try {
            credentials = awsCredentialsProvider.getCredentials();
        } finally {
            awsRequestMetrics.endEvent(Field.CredentialsRequestTime);
        }

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(
                jsonErrorUnmarshallers);
        Response<X> result = client.execute(request, responseHandler,
                errorResponseHandler, executionContext);
        return result;
    }
}
