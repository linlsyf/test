package service;

import constants.CalculatorType;
import service.impl.CalculatorRemove;
import service.impl.CalculatorReplace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//策略处理不同类型需求
public class CalculatorContext {
    private CalculateStrategy strategy;

    private Map<String, CalculateStrategy> grantTypeMap=new HashMap<>();
//
//    //初始化处理类型
    public void init(){
        grantTypeMap.put(CalculatorType.Type_REMOVE, new CalculatorRemove());
        grantTypeMap.put(CalculatorType.Type_REPLACE, new CalculatorReplace());
    }
//    public CalculatorContext(CalculateStrategy strategy) {
//        this.strategy = strategy;
//    }
    public CalculatorContext(String type) {
        init();
        this.strategy = grantTypeMap.get(type);
    }

    public List<String> execute(String requestData) {
        return strategy.doOperation(requestData);
    }
}
