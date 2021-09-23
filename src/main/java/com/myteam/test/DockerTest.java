package com.myteam.test;

import com.alibaba.fastjson.JSONObject;
import com.javakf.test.Student;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: helisen
 * @Date 2021/9/22 17:12
 * @Description:
 */
public class DockerTest {
    public static final String SERVER_URL = "http://localhost:8080/kie-server/services/rest/server";
    public static final String USERNAME = "kieserver";
    public static final String PASSWORD = "kieserver1!";
    public static final String KIE_CONTAINER_ID = "com.javakf:test:1.0.0-SNAPSHOT";

    public static void main(String[] args) {
        //kieService配置信息设置
        KieServicesConfiguration kieServicesConfiguration = KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 10000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

        //创建规则服务客户端
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        //规则输入条件
        /*Product p = new Product();
        p.setType(Product.GOLD);*/
        Student student = new Student();
        student.setAge(5);
        student.setName("小明");

        //命令定义，包含插入数据，执行规则
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<>();
        commands.add(kieCommands.newInsert(student, "student"));
        commands.add(kieCommands.newFireAllRules());
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID, kieCommands.newBatchExecution(commands, "myKsession"));

        //返回值读取
        Product product = (Product) results.getResult().getValue("student");
        System.out.println(JSONObject.toJSON(product).toString());

    }
}
