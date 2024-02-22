package service;

import domain.RequestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CharactersService {

    private CharactersBussinessSerive grantTypeSerive;
    private Map<String, Function<String, List<String>>> grantTypeMap=new HashMap<>();

    public void dispatcherInit(){
        grantTypeSerive=new CharactersBussinessSerive();
        grantTypeMap.put(Constants.Type_REMOVE, resourceId->grantTypeSerive.remove(resourceId));
        grantTypeMap.put(Constants.Type_REPLACE, resourceId->grantTypeSerive.replace(resourceId));
    }

    public  List<String> getResult(RequestData exeBean){

        String resourceType=exeBean.getType();
        Function<String, List<String>> result=grantTypeMap.get(resourceType);
        String resourceId=exeBean.getOrigdata();
            //传入resourceId 执行这段表达式获得String型的grantType
        List<String> resultList=new ArrayList<>();
        if(result!=null){
            //传入resourceId 执行这段表达式获得String型的grantType
          resultList=result.apply(resourceId);

        }
        return resultList;


    }
}