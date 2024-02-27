import org.junit.Assert;
import org.junit.Test;
import utils.DuplikeyCheckUtils;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class DuplikeyCheckUtilsTest {

    @Test
    public void execute() throws Exception {
        DuplikeyCheckUtils duplikeyCheckUtils =new DuplikeyCheckUtils();

        String requestData="aabcccbbaddwerw";


        String[] datanew= requestData.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= duplikeyCheckUtils.checkDuplikey(checkList);

     Assert.assertTrue("Check if the length of the detection set is greater than 0",fllterdata.size()>0);
     Assert.assertFalse("The first duplicate value is d", fllterdata.get(0).equals("d"));
     Assert.assertTrue("The first duplicate value is c", fllterdata.get(0).equals("c"));


    }
    @Test
    public void testManyletters() throws Exception {
        DuplikeyCheckUtils duplikeyCheckUtils =new DuplikeyCheckUtils();

        String requestData="aabcccbbaddwerwweoiepweopdfksdfkpowepsdlskdlflsdkjlssklsdlsjdfeoiwerwweiowesdflknfweowejoskdsldjlfsdfkhsdfsdf";

        String[] datanew= requestData.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= duplikeyCheckUtils.checkDuplikey(checkList);

     Assert.assertTrue("test Many letters No errors",fllterdata.size()>0);


    }
    @Test
    public void testEmptyletters() throws Exception {
        DuplikeyCheckUtils duplikeyCheckUtils =new DuplikeyCheckUtils();

        String requestData="";

        String[] datanew= requestData.split("");

        List<String>   checkList=  Arrays.asList(datanew);

        List<String> fllterdata= duplikeyCheckUtils.checkDuplikey(checkList);

     Assert.assertTrue("test Many letters No errors",fllterdata.size()==0);


    }
}
