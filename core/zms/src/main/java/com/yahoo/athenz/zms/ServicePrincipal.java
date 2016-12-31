//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zms;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// ServicePrincipal - A service principal object identifying a given service.
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ServicePrincipal {
    public String domain;
    public String service;
    public String token;

    public ServicePrincipal setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getDomain() {
        return domain;
    }
    public ServicePrincipal setService(String service) {
        this.service = service;
        return this;
    }
    public String getService() {
        return service;
    }
    public ServicePrincipal setToken(String token) {
        this.token = token;
        return this;
    }
    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ServicePrincipal.class) {
                return false;
            }
            ServicePrincipal a = (ServicePrincipal) another;
            if (domain == null ? a.domain != null : !domain.equals(a.domain)) {
                return false;
            }
            if (service == null ? a.service != null : !service.equals(a.service)) {
                return false;
            }
            if (token == null ? a.token != null : !token.equals(a.token)) {
                return false;
            }
        }
        return true;
    }
}
