package utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplikeyCheckUtils {
    /**Record the previous character to determine if it is duplicated*/
    String tempkey="";
    /**Record the number of repetitions of the previous character*/
      int tempcount=0;
    public  void resetTemp()  {
        tempcount=0;
        tempkey="";
    }
        //Filter out duplicate characters. If a appears twice in a row, add it to the set
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
                .entrySet()
                .stream()
                // Filter elements that appear more than 3 times
                .filter(entry -> entry.getValue()>2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return list;
    }

}
