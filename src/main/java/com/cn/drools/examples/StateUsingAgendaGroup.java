package com.cn.drools.examples;

import com.cn.drools.pojo.State;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author: helisen
 * @Date 2021/9/22 15:57
 * @Description:
 */
public class StateUsingAgendaGroup {
    public static void main(String[] args) {
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("StateUsingAgendaGroup");

        final State a = new State("A");
        final State b = new State("B");
        final State c = new State("C");
        final State d = new State("D");

        kieSession.insert(a);
        kieSession.insert(b);
        kieSession.insert(c);
        kieSession.insert(d);

        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
