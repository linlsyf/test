package service.impl;

import service.CalculateStrategy;
import utils.DuplikeyCheckUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorRemove implements CalculateStrategy {
    /**The result after removal*/
    List<String>   removeData=new ArrayList<String>();
    DuplikeyCheckUtils duplikeyCheckUtils =new DuplikeyCheckUtils();
    @Override
    public List<String> doOperation(String requestData) {
        removeData=new ArrayList<String>();
        removeData.add(requestData);
        String[] datanew= requestData.split("");
        List<String>   checkList=  Arrays.asList(datanew);
        List<String> fllterdata= duplikeyCheckUtils.checkDuplikey(checkList);
        //Execute deletion
        deleteData(checkList,fllterdata);
        return removeData;
    }

    //Keep filtered
    public   void   deleteData(List<String>  datanew, List<String> list){
        List<String>  newdatas=  datanew.stream()
                .filter(s -> {
                            if (!list.contains(s)){
                                return true;
                            }else{
                                return false;
                            }
                        }
                ).collect(Collectors.toList()) ;

        removeData.add(newdatas.stream().map(Object::toString)
                .collect(Collectors.joining()));
        duplikeyCheckUtils.resetTemp();
        // Non repeating values
        List<String>  duplikeyList=      duplikeyCheckUtils.checkDuplikey(newdatas);
        if (duplikeyList.size()>0){
            deleteData( newdatas,duplikeyList);
        }

    }

}
