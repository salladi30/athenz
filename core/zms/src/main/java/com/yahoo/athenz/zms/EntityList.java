//
// This file generated by rdl 1.4.8. Do not modify!
//

package com.yahoo.athenz.zms;
import java.util.List;
import com.yahoo.rdl.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//
// EntityList - The representation for an enumeration of entities in the
// namespace
//
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class EntityList {
    public List<String> names;

    public EntityList setNames(List<String> names) {
        this.names = names;
        return this;
    }
    public List<String> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != EntityList.class) {
                return false;
            }
            EntityList a = (EntityList) another;
            if (names == null ? a.names != null : !names.equals(a.names)) {
                return false;
            }
        }
        return true;
    }
}
