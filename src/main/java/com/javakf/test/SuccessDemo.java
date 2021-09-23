package com.javakf.test;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author: helisen
 * @Date 2021/9/23 16:12
 * @Description:
 */
public class SuccessDemo {
    /**
     * 成功的案例
     * @param args
     */
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId( "com.javakf", "test", "1.0.0-SNAPSHOT" );
        KieContainer kc = ks.newKieContainer(releaseId);
        //这里默认创建的是stateful类型的KieSession，因此在drools workbench的项目中，
        KieSession kieSession = kc.newKieSession("myKsession");

        Student student = new Student();
        student.setAge(12);
        student.setName("小明");
        kieSession.insert(student);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
