package start.queryType;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GrantTypeSerive {

     String tempkey="";
     int tempcount=0;

    List<String>   resultData;

    //删除连续重复超过3次字母
    public    List<String> remove(String origdata){

        String[] datanew= origdata.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= consum(checkList);

        List<String>   resultData=filterdata(checkList,fllterdata);


         return resultData;
    }

    //替换连续重复超过3次字母
    public   List<String>  replace(String origdata){

        List<String> chartall=getPronoc();

        String[] datanew= origdata.split("");


        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= consum(checkList);

        List<String>   data=replacedata(checkList,fllterdata,chartall);

        return data;

    }

//获取26个字母
    public    List<String>  getPronoc()  {

        List<String> result=new ArrayList();
        for(int i = 1;i<=26;i++){
            String name = String.valueOf((char)(96+i)).toLowerCase();
            result.add(name);
        }

        return   result;

    }
    //筛选出重复的字符 如连续出现两次a 则加入集合
    public     List<String>  consum(    List<String>  datanew)  {

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
                // 筛选出现不超过3次的元素
                .filter(entry -> entry.getValue()>2)
                // 获取key
                .map(Map.Entry::getKey)
                // 统计只出现一次的元素
                .collect(Collectors.toList());
        return list;

    }


    public     List<String> replacedata( List<String> datanew,List<String> dupliList, List<String> chartall){

        Map  hasChange=new HashMap();
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


        System.out.println("");
        newdatas.stream() .forEach(System.out::print);
        tempcount=0;
        tempkey="";
        //检测有没有超过3个的重复值
        List<String>  duplikeyList=      consum(newdatas);

        if (duplikeyList.size()>0){
            newdatas= replacedata( newdatas,duplikeyList,chartall);
        }

        return newdatas;

    }

    //保留筛选过后的
    public    List<String>    filterdata( List<String>  datanew,List<String> list){
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

        System.out.println("");
        newdatas.stream() .forEach(System.out::print);

        tempcount=0;
        tempkey="";
        //不重复的值
        List<String>  duplikeyList=      consum(newdatas);

           if (duplikeyList.size()>0){
               newdatas= filterdata( newdatas,duplikeyList);
           }
        return newdatas;

//                .forEach(System.out::print);
    }

}