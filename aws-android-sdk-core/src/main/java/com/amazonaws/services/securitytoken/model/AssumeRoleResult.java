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

package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/**
 * <p>
 * Contains the response to a successful <a>AssumeRole</a> request, including
 * temporary Amazon Web Services credentials that can be used to make Amazon Web
 * Services requests.
 * </p>
 */
public class AssumeRoleResult implements Serializable {
    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not
     * fixed. We strongly recommend that you make no assumptions about the
     * maximum size.
     * </p>
     * </note>
     */
    private Credentials credentials;

    /**
     * <p>
     * The Amazon Resource Name (ARN) and the assumed role ID, which are
     * identifiers that you can use to refer to the resulting temporary security
     * credentials. For example, you can reference these credentials as a
     * principal in a resource-based policy by using the ARN or assumed role ID.
     * The ARN and ID include the <code>RoleSessionName</code> that you
     * specified when you called <code>AssumeRole</code>.
     * </p>
     */
    private AssumedRoleUser assumedRoleUser;

    /**
     * <p>
     * A percentage value that indicates the packed size of the session policies
     * and session tags combined passed in the request. The request fails if the
     * packed size is greater than 100 percent, which means the policies and
     * tags exceeded the allowed space.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - <br/>
     */
    private Integer packedPolicySize;

    /**
     * <p>
     * The source identity specified by the principal that is calling the
     * <code>AssumeRole</code> operation.
     * </p>
     * <p>
     * You can require users to specify a source identity when they assume a
     * role. You do this by using the <code>sts:SourceIdentity</code> condition
     * key in a role trust policy. You can use source identity information in
     * CloudTrail logs to determine who took actions with a role. You can use
     * the <code>aws:SourceIdentity</code> condition key to further control
     * access to Amazon Web Services resources based on the value of source
     * identity. For more information about using source identity, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     * >Monitor and control actions taken with assumed roles</a> in the <i>IAM
     * User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters
     * consisting of upper- and lower-case alphanumeric characters with no
     * spaces. You can also include underscores or any of the following
     * characters: =,.@-
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 64<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     */
    private String sourceIdentity;

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not
     * fixed. We strongly recommend that you make no assumptions about the
     * maximum size.
     * </p>
     * </note>
     *
     * @return <p>
     *         The temporary security credentials, which include an access key
     *         ID, a secret access key, and a security (or session) token.
     *         </p>
     *         <note>
     *         <p>
     *         The size of the security token that STS API operations return is
     *         not fixed. We strongly recommend that you make no assumptions
     *         about the maximum size.
     *         </p>
     *         </note>
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not
     * fixed. We strongly recommend that you make no assumptions about the
     * maximum size.
     * </p>
     * </note>
     *
     * @param credentials <p>
     *            The temporary security credentials, which include an access
     *            key ID, a secret access key, and a security (or session)
     *            token.
     *            </p>
     *            <note>
     *            <p>
     *            The size of the security token that STS API operations return
     *            is not fixed. We strongly recommend that you make no
     *            assumptions about the maximum size.
     *            </p>
     *            </note>
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a
     * secret access key, and a security (or session) token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not
     * fixed. We strongly recommend that you make no assumptions about the
     * maximum size.
     * </p>
     * </note>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param credentials <p>
     *            The temporary security credentials, which include an access
     *            key ID, a secret access key, and a security (or session)
     *            token.
     *            </p>
     *            <note>
     *            <p>
     *            The size of the security token that STS API operations return
     *            is not fixed. We strongly recommend that you make no
     *            assumptions about the maximum size.
     *            </p>
     *            </note>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public AssumeRoleResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) and the assumed role ID, which are
     * identifiers that you can use to refer to the resulting temporary security
     * credentials. For example, you can reference these credentials as a
     * principal in a resource-based policy by using the ARN or assumed role ID.
     * The ARN and ID include the <code>RoleSessionName</code> that you
     * specified when you called <code>AssumeRole</code>.
     * </p>
     *
     * @return <p>
     *         The Amazon Resource Name (ARN) and the assumed role ID, which are
     *         identifiers that you can use to refer to the resulting temporary
     *         security credentials. For example, you can reference these
     *         credentials as a principal in a resource-based policy by using
     *         the ARN or assumed role ID. The ARN and ID include the
     *         <code>RoleSessionName</code> that you specified when you called
     *         <code>AssumeRole</code>.
     *         </p>
     */
    public AssumedRoleUser getAssumedRoleUser() {
        return assumedRoleUser;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) and the assumed role ID, which are
     * identifiers that you can use to refer to the resulting temporary security
     * credentials. For example, you can reference these credentials as a
     * principal in a resource-based policy by using the ARN or assumed role ID.
     * The ARN and ID include the <code>RoleSessionName</code> that you
     * specified when you called <code>AssumeRole</code>.
     * </p>
     *
     * @param assumedRoleUser <p>
     *            The Amazon Resource Name (ARN) and the assumed role ID, which
     *            are identifiers that you can use to refer to the resulting
     *            temporary security credentials. For example, you can reference
     *            these credentials as a principal in a resource-based policy by
     *            using the ARN or assumed role ID. The ARN and ID include the
     *            <code>RoleSessionName</code> that you specified when you
     *            called <code>AssumeRole</code>.
     *            </p>
     */
    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) and the assumed role ID, which are
     * identifiers that you can use to refer to the resulting temporary security
     * credentials. For example, you can reference these credentials as a
     * principal in a resource-based policy by using the ARN or assumed role ID.
     * The ARN and ID include the <code>RoleSessionName</code> that you
     * specified when you called <code>AssumeRole</code>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param assumedRoleUser <p>
     *            The Amazon Resource Name (ARN) and the assumed role ID, which
     *            are identifiers that you can use to refer to the resulting
     *            temporary security credentials. For example, you can reference
     *            these credentials as a principal in a resource-based policy by
     *            using the ARN or assumed role ID. The ARN and ID include the
     *            <code>RoleSessionName</code> that you specified when you
     *            called <code>AssumeRole</code>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public AssumeRoleResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
        return this;
    }

    /**
     * <p>
     * A percentage value that indicates the packed size of the session policies
     * and session tags combined passed in the request. The request fails if the
     * packed size is greater than 100 percent, which means the policies and
     * tags exceeded the allowed space.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - <br/>
     *
     * @return <p>
     *         A percentage value that indicates the packed size of the session
     *         policies and session tags combined passed in the request. The
     *         request fails if the packed size is greater than 100 percent,
     *         which means the policies and tags exceeded the allowed space.
     *         </p>
     */
    public Integer getPackedPolicySize() {
        return packedPolicySize;
    }

    /**
     * <p>
     * A percentage value that indicates the packed size of the session policies
     * and session tags combined passed in the request. The request fails if the
     * packed size is greater than 100 percent, which means the policies and
     * tags exceeded the allowed space.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - <br/>
     *
     * @param packedPolicySize <p>
     *            A percentage value that indicates the packed size of the
     *            session policies and session tags combined passed in the
     *            request. The request fails if the packed size is greater than
     *            100 percent, which means the policies and tags exceeded the
     *            allowed space.
     *            </p>
     */
    public void setPackedPolicySize(Integer packedPolicySize) {
        this.packedPolicySize = packedPolicySize;
    }

    /**
     * <p>
     * A percentage value that indicates the packed size of the session policies
     * and session tags combined passed in the request. The request fails if the
     * packed size is greater than 100 percent, which means the policies and
     * tags exceeded the allowed space.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - <br/>
     *
     * @param packedPolicySize <p>
     *            A percentage value that indicates the packed size of the
     *            session policies and session tags combined passed in the
     *            request. The request fails if the packed size is greater than
     *            100 percent, which means the policies and tags exceeded the
     *            allowed space.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public AssumeRoleResult withPackedPolicySize(Integer packedPolicySize) {
        this.packedPolicySize = packedPolicySize;
        return this;
    }

    /**
     * <p>
     * The source identity specified by the principal that is calling the
     * <code>AssumeRole</code> operation.
     * </p>
     * <p>
     * You can require users to specify a source identity when they assume a
     * role. You do this by using the <code>sts:SourceIdentity</code> condition
     * key in a role trust policy. You can use source identity information in
     * CloudTrail logs to determine who took actions with a role. You can use
     * the <code>aws:SourceIdentity</code> condition key to further control
     * access to Amazon Web Services resources based on the value of source
     * identity. For more information about using source identity, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     * >Monitor and control actions taken with assumed roles</a> in the <i>IAM
     * User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters
     * consisting of upper- and lower-case alphanumeric characters with no
     * spaces. You can also include underscores or any of the following
     * characters: =,.@-
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 64<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @return <p>
     *         The source identity specified by the principal that is calling
     *         the <code>AssumeRole</code> operation.
     *         </p>
     *         <p>
     *         You can require users to specify a source identity when they
     *         assume a role. You do this by using the
     *         <code>sts:SourceIdentity</code> condition key in a role trust
     *         policy. You can use source identity information in CloudTrail
     *         logs to determine who took actions with a role. You can use the
     *         <code>aws:SourceIdentity</code> condition key to further control
     *         access to Amazon Web Services resources based on the value of
     *         source identity. For more information about using source
     *         identity, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *         >Monitor and control actions taken with assumed roles</a> in the
     *         <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The regex used to validate this parameter is a string of
     *         characters consisting of upper- and lower-case alphanumeric
     *         characters with no spaces. You can also include underscores or
     *         any of the following characters: =,.@-
     *         </p>
     */
    public String getSourceIdentity() {
        return sourceIdentity;
    }

    /**
     * <p>
     * The source identity specified by the principal that is calling the
     * <code>AssumeRole</code> operation.
     * </p>
     * <p>
     * You can require users to specify a source identity when they assume a
     * role. You do this by using the <code>sts:SourceIdentity</code> condition
     * key in a role trust policy. You can use source identity information in
     * CloudTrail logs to determine who took actions with a role. You can use
     * the <code>aws:SourceIdentity</code> condition key to further control
     * access to Amazon Web Services resources based on the value of source
     * identity. For more information about using source identity, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     * >Monitor and control actions taken with assumed roles</a> in the <i>IAM
     * User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters
     * consisting of upper- and lower-case alphanumeric characters with no
     * spaces. You can also include underscores or any of the following
     * characters: =,.@-
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 64<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @param sourceIdentity <p>
     *            The source identity specified by the principal that is calling
     *            the <code>AssumeRole</code> operation.
     *            </p>
     *            <p>
     *            You can require users to specify a source identity when they
     *            assume a role. You do this by using the
     *            <code>sts:SourceIdentity</code> condition key in a role trust
     *            policy. You can use source identity information in CloudTrail
     *            logs to determine who took actions with a role. You can use
     *            the <code>aws:SourceIdentity</code> condition key to further
     *            control access to Amazon Web Services resources based on the
     *            value of source identity. For more information about using
     *            source identity, see <a href=
     *            "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *            >Monitor and control actions taken with assumed roles</a> in
     *            the <i>IAM User Guide</i>.
     *            </p>
     *            <p>
     *            The regex used to validate this parameter is a string of
     *            characters consisting of upper- and lower-case alphanumeric
     *            characters with no spaces. You can also include underscores or
     *            any of the following characters: =,.@-
     *            </p>
     */
    public void setSourceIdentity(String sourceIdentity) {
        this.sourceIdentity = sourceIdentity;
    }

    /**
     * <p>
     * The source identity specified by the principal that is calling the
     * <code>AssumeRole</code> operation.
     * </p>
     * <p>
     * You can require users to specify a source identity when they assume a
     * role. You do this by using the <code>sts:SourceIdentity</code> condition
     * key in a role trust policy. You can use source identity information in
     * CloudTrail logs to determine who took actions with a role. You can use
     * the <code>aws:SourceIdentity</code> condition key to further control
     * access to Amazon Web Services resources based on the value of source
     * identity. For more information about using source identity, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     * >Monitor and control actions taken with assumed roles</a> in the <i>IAM
     * User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters
     * consisting of upper- and lower-case alphanumeric characters with no
     * spaces. You can also include underscores or any of the following
     * characters: =,.@-
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 64<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @param sourceIdentity <p>
     *            The source identity specified by the principal that is calling
     *            the <code>AssumeRole</code> operation.
     *            </p>
     *            <p>
     *            You can require users to specify a source identity when they
     *            assume a role. You do this by using the
     *            <code>sts:SourceIdentity</code> condition key in a role trust
     *            policy. You can use source identity information in CloudTrail
     *            logs to determine who took actions with a role. You can use
     *            the <code>aws:SourceIdentity</code> condition key to further
     *            control access to Amazon Web Services resources based on the
     *            value of source identity. For more information about using
     *            source identity, see <a href=
     *            "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *            >Monitor and control actions taken with assumed roles</a> in
     *            the <i>IAM User Guide</i>.
     *            </p>
     *            <p>
     *            The regex used to validate this parameter is a string of
     *            characters consisting of upper- and lower-case alphanumeric
     *            characters with no spaces. You can also include underscores or
     *            any of the following characters: =,.@-
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public AssumeRoleResult withSourceIdentity(String sourceIdentity) {
        this.sourceIdentity = sourceIdentity;
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
        if (getCredentials() != null)
            sb.append("Credentials: " + getCredentials() + ",");
        if (getAssumedRoleUser() != null)
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        if (getPackedPolicySize() != null)
            sb.append("PackedPolicySize: " + getPackedPolicySize() + ",");
        if (getSourceIdentity() != null)
            sb.append("SourceIdentity: " + getSourceIdentity());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getCredentials() == null) ? 0 : getCredentials().hashCode());
        hashCode = prime * hashCode
                + ((getAssumedRoleUser() == null) ? 0 : getAssumedRoleUser().hashCode());
        hashCode = prime * hashCode
                + ((getPackedPolicySize() == null) ? 0 : getPackedPolicySize().hashCode());
        hashCode = prime * hashCode
                + ((getSourceIdentity() == null) ? 0 : getSourceIdentity().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof AssumeRoleResult == false)
            return false;
        AssumeRoleResult other = (AssumeRoleResult) obj;

        if (other.getCredentials() == null ^ this.getCredentials() == null)
            return false;
        if (other.getCredentials() != null
                && other.getCredentials().equals(this.getCredentials()) == false)
            return false;
        if (other.getAssumedRoleUser() == null ^ this.getAssumedRoleUser() == null)
            return false;
        if (other.getAssumedRoleUser() != null
                && other.getAssumedRoleUser().equals(this.getAssumedRoleUser()) == false)
            return false;
        if (other.getPackedPolicySize() == null ^ this.getPackedPolicySize() == null)
            return false;
        if (other.getPackedPolicySize() != null
                && other.getPackedPolicySize().equals(this.getPackedPolicySize()) == false)
            return false;
        if (other.getSourceIdentity() == null ^ this.getSourceIdentity() == null)
            return false;
        if (other.getSourceIdentity() != null
                && other.getSourceIdentity().equals(this.getSourceIdentity()) == false)
            return false;
        return true;
    }
}
