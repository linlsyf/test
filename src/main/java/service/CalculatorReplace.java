package service;

import java.util.*;
import java.util.stream.Collectors;

public class CalculatorReplace implements CalculateStrategy{
    List<String>   replaceData=new ArrayList<String>();
    DuplikeyCheck duplikey=new DuplikeyCheck();

    @Override
    public List<String> doOperation(String requestData) {
        replaceData=new ArrayList<String>();
        replaceData.add(requestData);

        List<String> chartall=getPronoc();

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
                            //不重复的数据
                            if (!dupliList.contains(str + "")) {
                                return str;
                            } else {
                                int index =chartall.indexOf(str);
                                if (index>0&&!hasChange.containsKey(str)){
                                    //重复值如果是非a 且为第一个 替换为上一个字母
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
                        //筛选掉A和非第一个重复值
                        return false;
                    }

                    return true;
                })
                .collect(Collectors.toList());


//        System.out.println("");
//        newdatas.stream() .forEach(System.out::print);

        replaceData.add(newdatas.stream().map(Object::toString) // 将每个数字转换为字符串类型
                .collect(Collectors.joining()));
        duplikey.resetTemp();
        //检测有没有超过3个的重复值
        List<String>  duplikeyList=duplikey.checkDuplikey(newdatas);

        if (duplikeyList.size()>0){
            replacedata( newdatas,duplikeyList,chartall);
        }


    }

    public    List<String>  getPronoc()  {
        List<String> result=new ArrayList();
        for(int i = 1;i<=26;i++){
            String name = String.valueOf((char)(96+i)).toLowerCase();
            result.add(name);
        }
        return   result;

    }
}
