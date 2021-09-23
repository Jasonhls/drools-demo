package com.javakf.test;

import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: helisen
 * @Date 2021/9/23 14:55
 * @Description:
 */
public class TestDemo {
    /**
     * 暂时还没成功
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //通过此URL可以访问到maven仓库中的jar包
        //URL地址构成： http://ip地址：Tomcat端口号/workBench工程名/maven2/坐标/版本号/xxx.jar
        String url = "http://localhost:8080/kie-wb/maven2/com/javakf/test/1.0.0-SNAPSHOT/test-1.0.0-SNAPSHOT.jar";

        KieServices ks = KieServices.Factory.get();
        UrlResource urlResource = (UrlResource)ks.getResources().newUrlResource(url);
        urlResource.setUsername("kieserver");
        urlResource.setPassword("kieserver1!");
        urlResource.setBasicAuthentication("enabled");

        //将资源转换为输入流，通过此输入流可以读取jar包数据
        InputStream inputStream = urlResource.getInputStream();
        //创建仓库对象，仓库对象中保存drools的规则信息
        KieRepository repository = ks.getRepository();

        //通过输入流读取maven仓库中的jar包数据，包装成KieModule模块添加到仓库中
        KieModule kieModule = repository.addKieModule(ks.getResources().newInputStreamResource(inputStream));

        //基于KieModule模块创建容器对象，从容器中可以获取session会话
        KieContainer kieContainer = ks.newKieContainer(kieModule.getReleaseId());

        KieSession kieSession = kieContainer.newKieSession();

        Student student = new Student();
        student.setAge(5);
        student.setName("小明");
        kieSession.insert(student);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
