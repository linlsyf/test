package service;

import service.impl.CalculatorRemove;
import service.impl.CalculatorReplace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//策略处理不同类型需求
public class CalculatorContext {

    /**删除超过连续重复三次以上的
     *  Delete items that repeat more than three consecutive times
     */
    public static final String Type_REMOVE="remove";
    /**替换超过连续重复三次以上的
     * Replace with more than three consecutive repetitions*/
    public static final String Type_REPLACE="replace";

    private CalculateStrategy strategy;
    private Map<String, CalculateStrategy> grantTypeMap=new HashMap<>();
//  Initialize processing type
//  初始化处理类型
    public void init(){
        grantTypeMap.put(Type_REMOVE, new CalculatorRemove());
        grantTypeMap.put(Type_REPLACE, new CalculatorReplace());
    }

    public CalculatorContext(String type) {
        init();
        this.strategy = grantTypeMap.get(type);
    }

    public List<String> execute(String requestData) {
        return strategy.doOperation(requestData);
    }

}
