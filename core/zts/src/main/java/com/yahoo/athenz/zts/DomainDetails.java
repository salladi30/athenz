//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// DomainDetails -
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainDetails {
    public String name;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String awsAccount;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String azureSubscription;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String azureTenant;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String azureClient;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String gcpProjectId;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String gcpProjectNumber;

    public DomainDetails setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public DomainDetails setAwsAccount(String awsAccount) {
        this.awsAccount = awsAccount;
        return this;
    }
    public String getAwsAccount() {
        return awsAccount;
    }
    public DomainDetails setAzureSubscription(String azureSubscription) {
        this.azureSubscription = azureSubscription;
        return this;
    }
    public String getAzureSubscription() {
        return azureSubscription;
    }
    public DomainDetails setAzureTenant(String azureTenant) {
        this.azureTenant = azureTenant;
        return this;
    }
    public String getAzureTenant() {
        return azureTenant;
    }
    public DomainDetails setAzureClient(String azureClient) {
        this.azureClient = azureClient;
        return this;
    }
    public String getAzureClient() {
        return azureClient;
    }
    public DomainDetails setGcpProjectId(String gcpProjectId) {
        this.gcpProjectId = gcpProjectId;
        return this;
    }
    public String getGcpProjectId() {
        return gcpProjectId;
    }
    public DomainDetails setGcpProjectNumber(String gcpProjectNumber) {
        this.gcpProjectNumber = gcpProjectNumber;
        return this;
    }
    public String getGcpProjectNumber() {
        return gcpProjectNumber;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != DomainDetails.class) {
                return false;
            }
            DomainDetails a = (DomainDetails) another;
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (awsAccount == null ? a.awsAccount != null : !awsAccount.equals(a.awsAccount)) {
                return false;
            }
            if (azureSubscription == null ? a.azureSubscription != null : !azureSubscription.equals(a.azureSubscription)) {
                return false;
            }
            if (azureTenant == null ? a.azureTenant != null : !azureTenant.equals(a.azureTenant)) {
                return false;
            }
            if (azureClient == null ? a.azureClient != null : !azureClient.equals(a.azureClient)) {
                return false;
            }
            if (gcpProjectId == null ? a.gcpProjectId != null : !gcpProjectId.equals(a.gcpProjectId)) {
                return false;
            }
            if (gcpProjectNumber == null ? a.gcpProjectNumber != null : !gcpProjectNumber.equals(a.gcpProjectNumber)) {
                return false;
            }
        }
        return true;
    }
}
