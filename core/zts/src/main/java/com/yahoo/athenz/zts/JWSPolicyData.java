//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import com.yahoo.rdl.*;

//
// JWSPolicyData - SignedPolicyData using flattened JWS JSON Serialization
// syntax. https://tools.ietf.org/html/rfc7515#section-7.2.2
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class JWSPolicyData {
    public String payload;
    @com.fasterxml.jackson.annotation.JsonProperty("protected")
    public String protectedHeader;
    public Map<String, String> header;
    public String signature;

    public JWSPolicyData setPayload(String payload) {
        this.payload = payload;
        return this;
    }
    public String getPayload() {
        return payload;
    }
    public JWSPolicyData setProtectedHeader(String protectedHeader) {
        this.protectedHeader = protectedHeader;
        return this;
    }
    public String getProtectedHeader() {
        return protectedHeader;
    }
    public JWSPolicyData setHeader(Map<String, String> header) {
        this.header = header;
        return this;
    }
    public Map<String, String> getHeader() {
        return header;
    }
    public JWSPolicyData setSignature(String signature) {
        this.signature = signature;
        return this;
    }
    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != JWSPolicyData.class) {
                return false;
            }
            JWSPolicyData a = (JWSPolicyData) another;
            if (payload == null ? a.payload != null : !payload.equals(a.payload)) {
                return false;
            }
            if (protectedHeader == null ? a.protectedHeader != null : !protectedHeader.equals(a.protectedHeader)) {
                return false;
            }
            if (header == null ? a.header != null : !header.equals(a.header)) {
                return false;
            }
            if (signature == null ? a.signature != null : !signature.equals(a.signature)) {
                return false;
            }
        }
        return true;
    }
}
