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
package com.yahoo.athenz.auth.impl;

import com.yahoo.athenz.auth.Authority;
import com.yahoo.athenz.auth.Principal;
import com.yahoo.athenz.auth.impl.PrincipalAuthority;
import com.yahoo.athenz.auth.impl.SimpleServiceIdentityProvider;
import com.yahoo.athenz.auth.token.PrincipalToken;
import com.yahoo.athenz.auth.util.Crypto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleServiceIdentityProviderTest {

    private String servicePublicKeyStringK0 = null;
    private String servicePublicKeyStringK1 = null;
    private String servicePrivateKeyStringK1 = null;
    private File k0File = null;
    private Authority authority = null;
    
    @BeforeTest
    private void loadKeys() throws IOException {
        Path path = Paths.get("./src/test/resources/fantasy_public_k0.key");
        servicePublicKeyStringK0 = new String(Files.readAllBytes(path));

        path = Paths.get("./src/test/resources/fantasy_private_k0.key");
        k0File = path.toFile();
        
        path = Paths.get("./src/test/resources/fantasy_public_k1.key");
        servicePublicKeyStringK1 = new String(Files.readAllBytes(path));

        path = Paths.get("./src/test/resources/fantasy_private_k1.key");
        servicePrivateKeyStringK1 = new String(Files.readAllBytes(path));
        
        authority = new PrincipalAuthority();
    }

    @Test
    public void testSimpleIdentityDefaultV0() {
        
        SimpleServiceIdentityProvider provider = new SimpleServiceIdentityProvider(authority, k0File);
        Principal user = provider.getIdentity("coretech", "athenz");
        assertNotNull(user);
        assertTrue(user.getIssueTime() != 0);
        
        String token = user.getCredentials();
        PrincipalToken prToken = new PrincipalToken(token);
        assertTrue(prToken.validate(servicePublicKeyStringK0, 0));
        assertEquals(prToken.getKeyId(), "0");
    }

    @Test
    public void testSimpleIdentityDefaultV1() {
        
        PrivateKey key = Crypto.loadPrivateKey(servicePrivateKeyStringK1);
        SimpleServiceIdentityProvider provider = new SimpleServiceIdentityProvider(authority, key, "1", 3600);
        Principal user = provider.getIdentity("coretech", "athenz");
        assertNotNull(user);
        assertTrue(user.getIssueTime() != 0);
        
        String token = user.getCredentials();
        PrincipalToken prToken = new PrincipalToken(token);
        assertTrue(prToken.validate(servicePublicKeyStringK1, 0));
        assertEquals(prToken.getKeyId(), "1");
    }

    @Test
    public void testSimpleIdentityPrivateKey() {

        PrivateKey privateKey = Crypto.loadPrivateKey(k0File);

        SimpleServiceIdentityProvider provider = new SimpleServiceIdentityProvider(authority, privateKey);
        Principal user = provider.getIdentity("coretech", "athenz");
        assertNotNull(user);
        assertTrue(user.getIssueTime() != 0);

        String token = user.getCredentials();
        PrincipalToken prToken = new PrincipalToken(token);
        assertTrue(prToken.validate(servicePublicKeyStringK0, 0));
        assertEquals(prToken.getKeyId(), "0");

        provider = new SimpleServiceIdentityProvider(authority, privateKey, 3600);
        user = provider.getIdentity("coretech", "athenz");
        assertNotNull(user);
        assertTrue(user.getIssueTime() != 0);

        token = user.getCredentials();
        prToken = new PrincipalToken(token);
        assertTrue(prToken.validate(servicePublicKeyStringK0, 0));
        assertEquals(prToken.getKeyId(), "0");
    }

    @Test
    public void testGetHost() {
        PrivateKey privateKey = Crypto.loadPrivateKey(k0File);

        SimpleServiceIdentityProvider provider = new SimpleServiceIdentityProvider(authority, privateKey);

        String name = provider.getHost();
        assertNotNull(name);
    }

    @Test
    public void testSimpleIdentityString() {
        SimpleServiceIdentityProvider provider = new SimpleServiceIdentityProvider(authority, "aaaaaaaa");
        assertNotNull(provider);
    }
}
