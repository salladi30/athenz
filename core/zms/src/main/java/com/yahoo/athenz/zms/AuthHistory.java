//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yahoo.rdl.*;

//
// AuthHistory -
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthHistory {
    public String uriDomain;
    public String principalDomain;
    public String principalName;
    public Timestamp timestamp;
    public String endpoint;
    public long ttl;

    public AuthHistory setUriDomain(String uriDomain) {
        this.uriDomain = uriDomain;
        return this;
    }
    public String getUriDomain() {
        return uriDomain;
    }
    public AuthHistory setPrincipalDomain(String principalDomain) {
        this.principalDomain = principalDomain;
        return this;
    }
    public String getPrincipalDomain() {
        return principalDomain;
    }
    public AuthHistory setPrincipalName(String principalName) {
        this.principalName = principalName;
        return this;
    }
    public String getPrincipalName() {
        return principalName;
    }
    public AuthHistory setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public AuthHistory setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public AuthHistory setTtl(long ttl) {
        this.ttl = ttl;
        return this;
    }
    public long getTtl() {
        return ttl;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != AuthHistory.class) {
                return false;
            }
            AuthHistory a = (AuthHistory) another;
            if (uriDomain == null ? a.uriDomain != null : !uriDomain.equals(a.uriDomain)) {
                return false;
            }
            if (principalDomain == null ? a.principalDomain != null : !principalDomain.equals(a.principalDomain)) {
                return false;
            }
            if (principalName == null ? a.principalName != null : !principalName.equals(a.principalName)) {
                return false;
            }
            if (timestamp == null ? a.timestamp != null : !timestamp.equals(a.timestamp)) {
                return false;
            }
            if (endpoint == null ? a.endpoint != null : !endpoint.equals(a.endpoint)) {
                return false;
            }
            if (ttl != a.ttl) {
                return false;
            }
        }
        return true;
    }
}