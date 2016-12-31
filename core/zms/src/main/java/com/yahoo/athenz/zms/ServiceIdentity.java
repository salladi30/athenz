//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// ServiceIdentity - The representation of the service identity object.
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class ServiceIdentity {
    public String name;
    @RdlOptional
    public List<PublicKeyEntry> publicKeys;
    @RdlOptional
    public String providerEndpoint;
    @RdlOptional
    public Timestamp modified;
    @RdlOptional
    public String executable;
    @RdlOptional
    public List<String> hosts;
    @RdlOptional
    public String user;
    @RdlOptional
    public String group;

    public ServiceIdentity setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }
    public ServiceIdentity setPublicKeys(List<PublicKeyEntry> publicKeys) {
        this.publicKeys = publicKeys;
        return this;
    }
    public List<PublicKeyEntry> getPublicKeys() {
        return publicKeys;
    }
    public ServiceIdentity setProviderEndpoint(String providerEndpoint) {
        this.providerEndpoint = providerEndpoint;
        return this;
    }
    public String getProviderEndpoint() {
        return providerEndpoint;
    }
    public ServiceIdentity setModified(Timestamp modified) {
        this.modified = modified;
        return this;
    }
    public Timestamp getModified() {
        return modified;
    }
    public ServiceIdentity setExecutable(String executable) {
        this.executable = executable;
        return this;
    }
    public String getExecutable() {
        return executable;
    }
    public ServiceIdentity setHosts(List<String> hosts) {
        this.hosts = hosts;
        return this;
    }
    public List<String> getHosts() {
        return hosts;
    }
    public ServiceIdentity setUser(String user) {
        this.user = user;
        return this;
    }
    public String getUser() {
        return user;
    }
    public ServiceIdentity setGroup(String group) {
        this.group = group;
        return this;
    }
    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != ServiceIdentity.class) {
                return false;
            }
            ServiceIdentity a = (ServiceIdentity) another;
            if (name == null ? a.name != null : !name.equals(a.name)) {
                return false;
            }
            if (publicKeys == null ? a.publicKeys != null : !publicKeys.equals(a.publicKeys)) {
                return false;
            }
            if (providerEndpoint == null ? a.providerEndpoint != null : !providerEndpoint.equals(a.providerEndpoint)) {
                return false;
            }
            if (modified == null ? a.modified != null : !modified.equals(a.modified)) {
                return false;
            }
            if (executable == null ? a.executable != null : !executable.equals(a.executable)) {
                return false;
            }
            if (hosts == null ? a.hosts != null : !hosts.equals(a.hosts)) {
                return false;
            }
            if (user == null ? a.user != null : !user.equals(a.user)) {
                return false;
            }
            if (group == null ? a.group != null : !group.equals(a.group)) {
                return false;
            }
        }
        return true;
    }
}
