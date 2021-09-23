package com.cn.drools.examples;

import com.cn.drools.pojo.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author: helisen
 * @Date 2021/9/22 16:26
 * @Description:
 */
public class ProductRuleTest {
    public static void main(String[] args) {
//        productRuleKS
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("productRuleKS");

        Product p = new Product();
        p.setType(Product.GOLD);

        kieSession.insert(p);
        int count = kieSession.fireAllRules();
        System.out.println("命中了" + count + "条规则");
        System.out.println("商品" + p.getType() + "的商品折扣为" + p.getDiscount());
    }
}
