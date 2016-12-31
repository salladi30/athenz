//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// RoleToken - A representation of a signed RoleToken
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class RoleToken {
    public String token;
    public long expiryTime;

    public RoleToken setToken(String token) {
        this.token = token;
        return this;
    }
    public String getToken() {
        return token;
    }
    public RoleToken setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }
    public long getExpiryTime() {
        return expiryTime;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != RoleToken.class) {
                return false;
            }
            RoleToken a = (RoleToken) another;
            if (token == null ? a.token != null : !token.equals(a.token)) {
                return false;
            }
            if (expiryTime != a.expiryTime) {
                return false;
            }
        }
        return true;
    }
}
