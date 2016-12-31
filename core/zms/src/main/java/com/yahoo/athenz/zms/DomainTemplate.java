//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// DomainTemplate - solution template(s) to be applied to a domain
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class DomainTemplate {
    public List<String> templateNames;

    public DomainTemplate setTemplateNames(List<String> templateNames) {
        this.templateNames = templateNames;
        return this;
    }
    public List<String> getTemplateNames() {
        return templateNames;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != DomainTemplate.class) {
                return false;
            }
            DomainTemplate a = (DomainTemplate) another;
            if (templateNames == null ? a.templateNames != null : !templateNames.equals(a.templateNames)) {
                return false;
            }
        }
        return true;
    }
}
