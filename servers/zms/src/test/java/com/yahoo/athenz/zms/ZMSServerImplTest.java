/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.athenz.zms;

import com.yahoo.athenz.auth.Authority;
import com.yahoo.athenz.common.metrics.MetricFactory;
import com.yahoo.athenz.common.server.log.AuditLogFactory;
import com.yahoo.athenz.zms.ZMSServerImpl;
import com.yahoo.athenz.zms.pkey.PrivateKeyStoreFactory;
import com.yahoo.athenz.zms.pkey.file.FilePrivateKeyStoreFactory;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZMSServerImplTest {
    
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty(ZMSConsts.ZMS_PROP_PRIVATE_KEY_STORE_CLASS, "com.yahoo.athenz.zms.pkey.file.FilePrivateKeyStoreFactory");
        System.setProperty(ZMSConsts.ZMS_PROP_PRIVATE_KEY, "src/test/resources/zms_private.pem");
        System.setProperty(ZMSConsts.ZMS_PROP_PUBLIC_KEY, "src/test/resources/zms_public.pem");
        System.setProperty(ZMSConsts.ZMS_PROP_DOMAIN_ADMIN, "user.testadminuser");
    }
    
    @Test
    public void testDebugAuthorities() throws Exception {
        
        Authority principalAuthority = new com.yahoo.athenz.common.server.debug.DebugPrincipalAuthority();
        principalAuthority.initialize();
        
        Authority roleAuthority = new com.yahoo.athenz.common.server.debug.DebugRoleAuthority();
        roleAuthority.initialize();

        com.yahoo.athenz.common.server.rest.Http.AuthorityList authList = new com.yahoo.athenz.common.server.rest.Http.AuthorityList();
        authList.add(principalAuthority);
        authList.add(roleAuthority);

        String policyStoreContext = ".";

        MetricFactory debugMetricFactory = new com.yahoo.athenz.common.metrics.impl.NoOpMetricFactory();
        PrivateKeyStoreFactory privateKeyFactory = new FilePrivateKeyStoreFactory();
        ZMSServerImpl core = new ZMSServerImpl("localhost", policyStoreContext,
                privateKeyFactory, debugMetricFactory, AuditLogFactory.getLogger(),
                null, authList);
        assertNotNull(core);
        
        assertNotNull(core.getAuthorizer());
        assertNotNull(core.getInstance());
    }

    @Test
    public void testRealAuthorities() throws Exception {

        Authority principalAuthority = new com.yahoo.athenz.auth.impl.PrincipalAuthority();
        Authority roleAuthority = new com.yahoo.athenz.auth.impl.RoleAuthority();

        String policyStoreContext = ".";

        com.yahoo.athenz.common.server.rest.Http.AuthorityList authList = new com.yahoo.athenz.common.server.rest.Http.AuthorityList();
        authList.add(principalAuthority);
        authList.add(roleAuthority);

        MetricFactory debugMetricFactory = new com.yahoo.athenz.common.metrics.impl.NoOpMetricFactory();
        PrivateKeyStoreFactory privateKeyFactory = new FilePrivateKeyStoreFactory();
        ZMSServerImpl core = new ZMSServerImpl("localhost", policyStoreContext,
                privateKeyFactory, debugMetricFactory, AuditLogFactory.getLogger(),
                null, authList);
        assertNotNull(core);
        
        assertNotNull(core.getAuthorizer());
        assertNotNull(core.getInstance());
    }
    
    @Test
    public void testNullContext() throws Exception {
        
        Authority principalAuthority = new com.yahoo.athenz.auth.impl.PrincipalAuthority();
        Authority roleAuthority = new com.yahoo.athenz.auth.impl.RoleAuthority();

        String policyStoreContext = null;

        com.yahoo.athenz.common.server.rest.Http.AuthorityList authList = new com.yahoo.athenz.common.server.rest.Http.AuthorityList();
        authList.add(principalAuthority);
        authList.add(roleAuthority);

        MetricFactory debugMetricFactory = new com.yahoo.athenz.common.metrics.impl.NoOpMetricFactory();
        PrivateKeyStoreFactory privateKeyFactory = new FilePrivateKeyStoreFactory();
        ZMSServerImpl core = new ZMSServerImpl("localhost", policyStoreContext,
                privateKeyFactory, debugMetricFactory, AuditLogFactory.getLogger(),
                null, authList);
        assertNotNull(core);
        
        assertNotNull(core.getAuthorizer());
        assertNotNull(core.getInstance());
    }
}

