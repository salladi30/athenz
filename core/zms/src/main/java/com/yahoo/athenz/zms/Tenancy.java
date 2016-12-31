//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// Tenancy - A representation of tenant.
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class Tenancy {
    public String domain;
    public String service;
    @RdlOptional
    public List<String> resourceGroups;

    public Tenancy setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getDomain() {
        return domain;
    }
    public Tenancy setService(String service) {
        this.service = service;
        return this;
    }
    public String getService() {
        return service;
    }
    public Tenancy setResourceGroups(List<String> resourceGroups) {
        this.resourceGroups = resourceGroups;
        return this;
    }
    public List<String> getResourceGroups() {
        return resourceGroups;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Tenancy.class) {
                return false;
            }
            Tenancy a = (Tenancy) another;
            if (domain == null ? a.domain != null : !domain.equals(a.domain)) {
                return false;
            }
            if (service == null ? a.service != null : !service.equals(a.service)) {
                return false;
            }
            if (resourceGroups == null ? a.resourceGroups != null : !resourceGroups.equals(a.resourceGroups)) {
                return false;
            }
        }
        return true;
    }
}
