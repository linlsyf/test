package utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplikeyCheckUtils {
     String tempkey="";
      int tempcount=0;
    public  void resetTemp()  {
        tempcount=0;
        tempkey="";
    }

        //筛选出重复的字符 如连续出现两次a 则加入集合
    public  List<String> checkDuplikey(List<String>  datanew)  {
        List<String> list =  datanew.stream()
                .collect(Collectors.toMap(Function.identity(), s -> {
                    int count=0;
                    if (tempkey.equals(s)){
                        if (tempcount==0){
                            count=2;
                        }else{
                            count=1;
                        }
                        tempcount=tempcount+1;
                    }else{
                        tempcount=0;
                    }
                    tempkey=s;
                    return count;
                }, Integer::sum))
                // map 转 entrySet
                .entrySet()
                // 继续转流
                .stream()
                // 筛选出现超过3次的元素
                .filter(entry -> entry.getValue()>2)
                // 获取key
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return list;
    }

}
