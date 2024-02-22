import constants.CalculatorType;
import org.apache.commons.lang3.RandomStringUtils;
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
    public void testRemove() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorType.Type_REMOVE);
        //测试删除
        String origdata="aabcccbbad";

        List<String> deleteResult=  context.execute(origdata);
        deleteResult.stream().forEach(System.out::println);


        Assert.assertTrue(deleteResult.size()>1);

        Assert.assertTrue(deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue(lastWord.equals("d"));



    }
    @Test
    public void testRandomStringRemove() throws Exception {


        String  testdata= "aaeeeeebcccbbddaswerad";

        CalculatorContext context=new CalculatorContext(CalculatorType.Type_REMOVE);
        //测试删除
        String origdata=testdata;

        List<String> deleteResult=  context.execute(origdata);
        deleteResult.stream().forEach(System.out::println);


    }

    @Test
    public void testReplace() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorType.Type_REPLACE);
        //测试删除
        String origdata="aabcccbbad";

        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);

        Assert.assertTrue(deleteResult.size()>1);

        Assert.assertTrue(deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue(lastWord.equals("d"));
    }
    @Test
    public void testReplaceRadom() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorType.Type_REPLACE);
        //测试删除
        String origdata="aabcccbbadwwwwerwerewyuifyuyu";

        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);
    }




}