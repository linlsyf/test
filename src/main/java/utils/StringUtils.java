package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringUtils {

    //Obtain 26 English letters for replacement
    // 获取26个英文字母 用于替换
    public  static List<String> getPronoc()  {
        List<String> result=new ArrayList();
        for(int i = 1;i<=26;i++){
            String name = String.valueOf((char)(96+i)).toLowerCase();
            result.add(name);
        }
        return   result;

    }


}
