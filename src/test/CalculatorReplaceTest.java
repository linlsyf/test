import org.junit.Assert;
import org.junit.Test;
import service.impl.CalculatorRemove;
import service.impl.CalculatorReplace;

import java.util.List;

public class CalculatorReplaceTest {

    @Test
    public void execute() throws Exception {
        //test replace
        String origdata="aaeeeeebcccbbddaswerad";

        CalculatorReplace replace=new CalculatorReplace();
        List<String> resultList=replace.doOperation(origdata);
        resultList.stream().forEach(System.out::println);
        Assert.assertTrue("Check if the length of the detection set is greater than 0",resultList.size()>0);

    }
    @Test
    public void testEmple() throws Exception {
        // Testing has special symbols like  [  > a
        String origdata="";
        CalculatorReplace   calculatorReplace=new CalculatorReplace();
        List<String>   resultList=calculatorReplace.doOperation(origdata);
        resultList.stream().forEach(System.out::println);

        Assert.assertTrue("Test string is empty",resultList.size()==0);


        origdata=null;
        calculatorReplace=new CalculatorReplace();
        resultList=calculatorReplace.doOperation(origdata);
        //resultList.stream().forEach(System.out::println);
        Assert.assertTrue("Test string is empty",resultList.size()==0);

    }
    @Test
    public void testSpecial() throws Exception {
        // Testing has special symbols like  [  > a
        String origdata="aab[cccbbaddwerw>a!jlkweoi`中文한국어";

        CalculatorReplace   calculatorReplace=new CalculatorReplace();
        List<String>   resultList=calculatorReplace.doOperation(origdata);
        resultList.stream().forEach(System.out::println);

        Assert.assertTrue("Check if the length of the detection set is greater than 0",resultList.size()>0);

        Assert.assertTrue("Testing has special symbols, such as[  > a Not deleted",resultList.get(0).contains("["));
        Assert.assertTrue("Testing has special symbols, such as 한국어 Not deleted",resultList.get(0).contains("한국어"));


    }
}
