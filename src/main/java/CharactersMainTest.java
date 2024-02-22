import service.CalculatorContext;
import service.CalculatorRemove;
import service.CalculatorReplace;
import service.Constants;
import domain.RequestData;

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

        CalculatorContext context=new CalculatorContext(new CalculatorRemove());


        List<String> deleteResult=  context.execute(removeData);

        deleteResult.stream().forEach(System.out::println);


     System.out.println("========测试替换=======");
         context=new CalculatorContext(new CalculatorReplace());

        //测试删除
        String origdata="aabcccbbad";


        deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);

    }
}
