import org.junit.Assert;
import service.*;
import org.junit.Test;
import service.impl.CalculatorRemove;
import service.impl.CalculatorReplace;
import utils.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


/**

 **/
public class TaskTest {

    //实际处理不同逻辑实现类
    @Test
    public void testAll() throws Exception {
       testRemove();
       testReplace();
    }
    @Test
    public void testRemove() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REMOVE);
        //测试删除
        String origdata="aabcccbbad";

        List<String> deleteResult=  context.execute(origdata);
        deleteResult.stream().forEach(System.out::println);


        Assert.assertTrue("Determine whether all final results have been deleted\n" +
                "\n判断最后结果是否全部删除",deleteResult.size()>1);

        Assert.assertTrue("Determine if the final result is printed 4 times\n" +
                "\n 判断最后结果是否4次打印",deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue("Determine if the last printed character is d\n" +
                "\n判断最后打印字符是d",lastWord.equals("d"));



    }
    @Test
    public void testRandomStringRemove() throws Exception {


        String  testdata= "aaeeeeebcccbbddaswerad";

        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REMOVE);
        //测试删除
        String origdata=testdata;

        List<String> deleteResult=  context.execute(origdata);
        deleteResult.stream().forEach(System.out::println);


    }

    @Test
    public void testReplace() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REPLACE);
        //测试删除
        String origdata="aabcccbbad";

        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);



        Assert.assertTrue("Determine whether all final results have been deleted\n" +
                "\n判断最后结果是否全部删除",deleteResult.size()>1);

        Assert.assertTrue("Determine if the final result is printed 4 times\n" +
                "\n 判断最后结果是否4次打印",deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue("Determine if the last printed character is d\n" +
                "\n判断最后打印字符是d",lastWord.equals("d"));


    }
    @Test
    public void testReplaceRadom() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REPLACE);
        //测试删除
        String origdata="aabcccbbadwwwwerwerewyuifyuyu";

        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);
    }




}