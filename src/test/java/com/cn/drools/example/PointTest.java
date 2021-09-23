package com.cn.drools.example;

import com.cn.drools.pojo.PointDomain;
import com.cn.drools.pojo.Product;
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
 * @Date 2021/9/17 15:39
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PointTest {

    @Autowired
    private KieSession kieSession;

    @AfterEach
    public void dispose() {
        kieSession.dispose();
    }

    @Test
    public void test() {
        PointDomain p = new PointDomain();
        p.setUserName("hello kitty");
        p.setBackMoney(100d);
        p.setBuyMoney(500d);
        p.setBackNums(1);
        p.setBuyNums(5);
        p.setBillThisMonth(5);
        p.setBirthDay(true);
        p.setPoint(0);
        kieSession.insert(p);
        kieSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                Rule rule = match.getRule();
                return rule.getName().contains("point");
            }
        });
    }

    @Test
    public void test2() {
        Product p = new Product();
        p.setType("DIAMOND");
        kieSession.insert(p);
        kieSession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                Rule rule = match.getRule();
                return rule.getName().startsWith("Offer4");
            }
        });
    }
}
