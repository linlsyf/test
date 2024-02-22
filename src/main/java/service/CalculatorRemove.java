package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorRemove implements CalculateStrategy{

    List<String>   removeData=new ArrayList<String>();

    DuplikeyCheck duplikey=new DuplikeyCheck();
    @Override
    public List<String> doOperation(String requestData) {
        removeData=new ArrayList<String>();
        removeData.add(requestData);

        String[] datanew= requestData.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= DuplikeyCheck.checkDuplikey(checkList);

        deleteData(checkList,fllterdata);

        return removeData;
    }

    //保留筛选过后的
    public   void   deleteData(List<String>  datanew, List<String> list){
        List<String>  newdatas=  datanew.stream()
                .filter(s -> {
                            if (!list.contains(s)){
                                return true;
                            }else{
                                return false;
                            }

                        }
                ).collect(Collectors.toList())
                ;


//        System.out.println("");
//        newdatas.stream() .forEach(System.out::print);

        removeData.add(newdatas.stream().map(Object::toString) // 将每个数字转换为字符串类型
                .collect(Collectors.joining()));
        duplikey.resetTemp();
        //不重复的值
        List<String>  duplikeyList=      duplikey.checkDuplikey(newdatas);

        if (duplikeyList.size()>0){
            deleteData( newdatas,duplikeyList);

        }


    }

}
