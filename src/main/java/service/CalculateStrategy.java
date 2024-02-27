package service;

import java.util.List;

public interface CalculateStrategy {
    /**Handle different businesses for different types
    */
    List<String> doOperation(String requestData);

}
