package service;

import java.util.List;

public interface CalculateStrategy {
    //针对不同类型处理不同业务
    List<String> doOperation(String requestData);

}
