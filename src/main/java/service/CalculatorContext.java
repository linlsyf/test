package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//策略处理不同类型需求
public class CalculatorContext {

    private CalculateStrategy strategy;

//    private Map<String, CalculatorRemove> grantTypeMap=new HashMap<>();
//
//    //初始化处理类型
//    public void initType(){
//        grantTypeMap.put(Constants.Type_REMOVE, resourceId->grantTypeSerive.remove(resourceId));
//        grantTypeMap.put(Constants.Type_REPLACE, resourceId->grantTypeSerive.replace(resourceId));
//    }
    public CalculatorContext(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> execute(String requestData) {
        return strategy.doOperation(requestData);
    }
}
