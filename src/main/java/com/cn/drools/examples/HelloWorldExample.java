package com.cn.drools.examples;

import com.cn.drools.pojo.Message;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.definition.rule.Rule;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import static com.cn.drools.pojo.Message.HELLO;

/**
 * @Author: helisen
 * @Date 2021/9/22 13:55
 * @Description:
 */
public class HelloWorldExample {
    //需要在META-INF文件夹下面添加kmodule.xml文件，并添加名为HelloWorldKS的KieSession
    public static void main(String[] args) {
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("HelloWorldKS");

        // Set up listeners.
        kieSession.addEventListener(new DebugAgendaEventListener());
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());

        // Set up a file-based audit logger.
//        KieRuntimeLogger fileLogger = KieServices.get().getLoggers().newFileLogger(kieSession, "./target/helloword");
        // Set up a ThreadedFileLogger so that the audit view reflects events while debugging.
//        KieRuntimeLogger threadedFileLogger = ks.getLoggers().newThreadedFileLogger(kieSession, "./target/helloworld", 1000);

        // Insert facts into the KIE session.
        final Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(HELLO);
        kieSession.insert(message);

        // Fire the rules.
        kieSession.fireAllRules();

//        fileLogger.close();
//        threadedFileLogger.close();

        kieSession.dispose();
    }
}
