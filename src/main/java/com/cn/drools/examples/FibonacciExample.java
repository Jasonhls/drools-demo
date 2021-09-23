package com.cn.drools.examples;

import com.cn.drools.pojo.Fibonacci;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author: helisen
 * @Date 2021/9/22 16:00
 * @Description:
 */
public class FibonacciExample {
    public static void main(String[] args) {
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("fibonacciKS");

        kieSession.insert(new Fibonacci(50));

        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
