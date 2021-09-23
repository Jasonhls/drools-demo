package com.cn.drools;

import com.cn.drools.pojo.Cat;
import com.cn.drools.pojo.People;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DroolsDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private KieSession kieSession;
    @Autowired
    private KieBase kieBase;

    @Test
    public void people() {
        People people = new People();
        people.setName("金");
        people.setSex(1);
        people.setDrlType("people");
        kieSession.insert(people);
        kieSession.fireAllRules();
    }

    @Test
    public void cat() {
        Cat cat = new Cat();
        cat.setName("金");
        cat.setSex(1);
        kieSession.insert(cat);
        kieSession.fireAllRules();
    }

    @Test
    public void girl2() {
        People people = new People();
        people.setName("哈哈");
        people.setSex(0);
        people.setDrlType("people");
        kieSession.insert(people);
        //过滤出满足条件的规则并执行
        kieSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                Rule rule = match.getRule();
                return rule.getName().equals("girl2");
            }
        });
    }

    @Test
    public void girl3() {
        People people = new People();
        people.setSex(0);
        kieSession.insert(people);
        Cat cat = new Cat();
        cat.setSex(0);
        kieSession.insert(cat);
        //过滤出满足条件的规则并执行
        kieSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                Rule rule = match.getRule();
                return rule.getName().equals("girl3");
            }
        });
    }


    @AfterEach
    public void runDispose() {
        kieSession.dispose();
    }


}
