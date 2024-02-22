import constants.CalculatorType;
import service.CalculatorContext;
import service.impl.CalculatorRemove;
import service.impl.CalculatorReplace;

import java.util.List;

public class CharactersMainTest {

    public static void main(String[] args) {



        String removeData="";
        String replaceData="";
        if (args.length>1){
            removeData=args[0];
            replaceData=args[1];
        }
        else{
              removeData="aabcccbbad";
            replaceData="abcccbad";
        }
        //测试删除


        System.out.println("========测试删除=======");

        CalculatorContext context=new CalculatorContext(CalculatorType.Type_REMOVE);


        List<String> deleteResult=  context.execute(removeData);

        deleteResult.stream().forEach(System.out::println);


     System.out.println("========测试替换=======");
         context=new CalculatorContext(CalculatorType.Type_REPLACE);

        //测试删除
        String origdata="aabcccbbad";


        deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);

    }
}
