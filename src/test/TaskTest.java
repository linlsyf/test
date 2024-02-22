import service.*;
import domain.RequestData;
import org.junit.Test;

import java.util.List;


/**

 **/
public class TaskTest {

    //实际处理不同逻辑实现类
    @Test
    public void testRemove() throws Exception {
        CalculatorContext context=new CalculatorContext(new CalculatorRemove());


        //测试删除
        String origdata="aabcccbbad";


        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);


//     System.out.println("====测试第二个数据");
//
//        origdata="aadddeeefffzzzuuu";
//        exeBean.setOrigdata(origdata);
////
//        deleteResult= queryGrantTypeService.getResultByType(exeBean);
//
//        deleteResult.stream().forEach(System.out::println);


    }

    @Test
    public void testReplace() throws Exception {
        CalculatorContext context=new CalculatorContext(new CalculatorReplace());

        //测试删除
        String origdata="aabcccbbad";


        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);
    }




}