/*
 * Copyright The Athenz Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.yahoo.athenz.msd;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import com.yahoo.rdl.Timestamp;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class TransportPolicyEgressRuleTest {

  @Test
  public void testTransportPolicyEgressRuleFields() {

    TransportPolicyPort tpp1 = new TransportPolicyPort().setProtocol(TransportPolicyProtocol.TCP).setPort(1).setEndPort(1024);
    List<TransportPolicyPort> tppList1 = Collections.singletonList(tpp1);
    TransportPolicySubject tps1 = new TransportPolicySubject().setDomainName("dom1").setServiceName("svc1");
    TransportPolicyCondition tpc1 = new TransportPolicyCondition().setEnforcementState(TransportPolicyEnforcementState.ENFORCE);
    tpc1.setInstances(Collections.singletonList("host1"));
    List<TransportPolicyCondition> tpcList1 = Collections.singletonList(tpc1);
    TransportPolicyMatch tpm1 = new TransportPolicyMatch().setAthenzService(tps1).setConditions(tpcList1);

    TransportPolicyEntitySelector tpes1 = new TransportPolicyEntitySelector().setPorts(tppList1).setMatch(tpm1);

    List<TransportPolicySubject> tpsList1 = Collections.singletonList(tps1);
    TransportPolicyPeer tppeer1 = new TransportPolicyPeer().setAthenzServices(tpsList1).setPorts(tppList1);

    TransportPolicyEgressRule tper1 = new TransportPolicyEgressRule().setEntitySelector(tpes1).setTo(tppeer1).setId(12345678L).setLastModified(
        Timestamp.fromMillis(123456789123L)).setIdentifier("outbound-1");

    assertEquals(tper1.getEntitySelector(), tpes1);
    assertEquals(tper1.getTo(), tppeer1);
    assertEquals(tper1.getIdentifier(), "outbound-1");
    assertEquals(tper1.getId(), 12345678L);
    assertEquals(tper1.getLastModified(), Timestamp.fromMillis(123456789123L));


    TransportPolicyPort tpp2 = new TransportPolicyPort().setProtocol(TransportPolicyProtocol.TCP).setPort(1).setEndPort(1024);
    List<TransportPolicyPort> tppList2 = Collections.singletonList(tpp2);
    TransportPolicySubject tps2 = new TransportPolicySubject().setDomainName("dom1").setServiceName("svc1");
    TransportPolicyCondition tpc2 = new TransportPolicyCondition().setEnforcementState(TransportPolicyEnforcementState.ENFORCE);
    tpc2.setInstances(Collections.singletonList("host1"));
    List<TransportPolicyCondition> tpcList2 = Collections.singletonList(tpc2);
    TransportPolicyMatch tpm2 = new TransportPolicyMatch().setAthenzService(tps2).setConditions(tpcList2);

    TransportPolicyEntitySelector tpes2 = new TransportPolicyEntitySelector().setPorts(tppList2).setMatch(tpm2);

    List<TransportPolicySubject> tpsList2 = Collections.singletonList(tps2);
    TransportPolicyPeer tppeer2 = new TransportPolicyPeer().setAthenzServices(tpsList2).setPorts(tppList2);

    TransportPolicyEgressRule tper2 = new TransportPolicyEgressRule().setEntitySelector(tpes2).setTo(tppeer2).setId(12345678L).setLastModified(
        Timestamp.fromMillis(123456789123L)).setIdentifier("outbound-1");

    assertEquals(tper1, tper1);
    assertEquals(tper1, tper2);

    tper2.setTo(null);
    assertNotEquals(tper1, tper2);

    tper2.setTo(tppeer2);
    tper2.setEntitySelector(null);
    assertNotEquals(tper1, tper2);

    tper2.setEntitySelector(tpes2);
    tper2.setId(234567L);
    assertNotEquals(tper1, tper2);

    tper2.setId(12345678L);
    tper2.setIdentifier("outbound-2");
    assertNotEquals(tper1, tper2);

    tper2.setId(12345678L);
    tper2.setIdentifier("outbound-1");
    tper2.setLastModified(null);
    assertNotEquals(tper1, tper2);

    assertFalse(tper1.equals("xyz"));
  }
}