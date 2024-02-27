package service.impl;

import service.CalculateStrategy;
import utils.DuplikeyCheckUtils;
import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CalculatorReplace implements CalculateStrategy {
    /**The result after replacement*/
    List<String>   replaceData=new ArrayList<String>();
    DuplikeyCheckUtils duplikey=new DuplikeyCheckUtils();

    @Override
    public List<String> doOperation(String requestData) {
        replaceData=new ArrayList<String>();
        replaceData.add(requestData);

        List<String> chartall= StringUtils.getPronoc();

        String[] datanew= requestData.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= duplikey.checkDuplikey(checkList);
        replacedata(checkList,fllterdata,chartall);

        return replaceData;
    }

    public     void replacedata( List<String> datanew,List<String> dupliList, List<String> chartall){

        Map hasChange=new HashMap();
        List<String>  newdatas=  datanew.stream()
                .map(str ->
                        {
                            //Non duplicate data 不重复的数据
                            if (!dupliList.contains(str + "")) {
                                return str;
                            } else {
                                int index =chartall.indexOf(str);
                                if (index>0&&!hasChange.containsKey(str)){
                                    //If the duplicate value is not a and is the first one, replace it with the previous letter
                                    hasChange.put(str,str);
                                    return chartall.get(index-1);
                                }else{
                                    return "";
                                }
                            }
                        }
                )
                .filter(s-> {
                    if ("".equals(s)) {
                        //Filter out A and non first duplicate values
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());

        replaceData.add(newdatas.stream().map(Object::toString)
                .collect(Collectors.joining()));
        duplikey.resetTemp();
        //Check for more than 3 duplicate values
        List<String>  duplikeyList=duplikey.checkDuplikey(newdatas);
        if (duplikeyList.size()>0){
            replacedata( newdatas,duplikeyList,chartall);
        }

    }


}
