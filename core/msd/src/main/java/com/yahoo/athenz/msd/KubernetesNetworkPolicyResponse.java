//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.msd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import com.yahoo.rdl.*;

//
// KubernetesNetworkPolicyResponse - Response object containing Kubernetes
// network policy
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesNetworkPolicyResponse {
    public String apiVersion;
    public String kind;
    public Map<String, String> metadata;
    public KubernetesNetworkPolicySpec spec;

    public KubernetesNetworkPolicyResponse setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }
    public String getApiVersion() {
        return apiVersion;
    }
    public KubernetesNetworkPolicyResponse setKind(String kind) {
        this.kind = kind;
        return this;
    }
    public String getKind() {
        return kind;
    }
    public KubernetesNetworkPolicyResponse setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }
    public Map<String, String> getMetadata() {
        return metadata;
    }
    public KubernetesNetworkPolicyResponse setSpec(KubernetesNetworkPolicySpec spec) {
        this.spec = spec;
        return this;
    }
    public KubernetesNetworkPolicySpec getSpec() {
        return spec;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != KubernetesNetworkPolicyResponse.class) {
                return false;
            }
            KubernetesNetworkPolicyResponse a = (KubernetesNetworkPolicyResponse) another;
            if (apiVersion == null ? a.apiVersion != null : !apiVersion.equals(a.apiVersion)) {
                return false;
            }
            if (kind == null ? a.kind != null : !kind.equals(a.kind)) {
                return false;
            }
            if (metadata == null ? a.metadata != null : !metadata.equals(a.metadata)) {
                return false;
            }
            if (spec == null ? a.spec != null : !spec.equals(a.spec)) {
                return false;
            }
        }
        return true;
    }
}
