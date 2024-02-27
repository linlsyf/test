import org.junit.Assert;
import service.*;
import org.junit.Test;
import java.util.List;

/**

 **/
public class TaskTest {

    @Test
    public void test() throws Exception {



//       testRemove();
//       testReplace();
    }
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


        Assert.assertTrue("Determine whether all final results have been deleted",deleteResult.size()>1);

        Assert.assertTrue("Determine if the final result is printed 4 times",deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue("Determine if the last printed character is d",lastWord.equals("d"));



    }
    @Test
    public void testRandomStringRemove() throws Exception {


        String  testdata= "aaeeeeebcccbbddaswerad";

        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REMOVE);
        String origdata=testdata;

        List<String> deleteResult=  context.execute(origdata);
        deleteResult.stream().forEach(System.out::println);


    }

    @Test
    public void testReplace() throws Exception {
        CalculatorContext context=new CalculatorContext(CalculatorContext.Type_REPLACE);
        String origdata="aabcccbbad";

        List<String> deleteResult=  context.execute(origdata);

        deleteResult.stream().forEach(System.out::println);



        Assert.assertTrue("Determine whether all final results have been deleted",deleteResult.size()>1);

        Assert.assertTrue("Determine if the final result is printed 4 times",deleteResult.size()==4);

        String lastWord=deleteResult.get(deleteResult.size()-1);
        Assert.assertTrue("Determine if the last printed character is d",lastWord.equals("d"));


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