package com.cn.drools.example;

import com.cn.drools.pojo.PointDomain;

/**
 * @Author: helisen
 * @Date 2021/9/17 15:26
 * @Description: 积分规则接口
 */
public interface PointRuleEngine {

    /**
     * 初始化规则引擎
     */
    void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    void refreshEngineRule();

    /**
     * 执行规则引擎
     * @param pointDomain
     */
    void executeRuleEngine(PointDomain pointDomain);
}
