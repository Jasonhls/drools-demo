package com.cn.drools;

import com.cn.drools.pojo.Person;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: helisen
 * @Date 2021/9/17 14:20
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DroolsDemoApplicationTests2 {

    @Autowired
    private KieSession kieSession;

    @AfterEach
    public void dispose() {
        kieSession.dispose();
    }

    @Test
    public void matches1() {
        Person person = new Person();
        person.setCountry("USA");
        kieSession.insert(person);
        kieSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                Rule rule = match.getRule();
                return rule.getName().equals("matches1");
            }
        });
    }
}
