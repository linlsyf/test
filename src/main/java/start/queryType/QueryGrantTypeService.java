package start.queryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.ExeBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class QueryGrantTypeService {

    @Autowired
    private GrantTypeSerive grantTypeSerive;
    private Map<String, Function<String, List<String>>> grantTypeMap=new HashMap<>();

    @PostConstruct
    public void dispatcherInit(){
        grantTypeMap.put(ExeBean.Type_REMOVE,resourceId->grantTypeSerive.remove(resourceId));
        grantTypeMap.put(ExeBean.Type_REPLACE,resourceId->grantTypeSerive.replace(resourceId));
    }

    public  List<String> getResult(ExeBean exeBean){

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