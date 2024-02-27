import org.junit.Assert;
import org.junit.Test;
import utils.StringUtils;

import java.util.List;

public class StringUtilsTest {

    @Test
    public void execute() throws Exception {
        List<String> chartall= StringUtils.getPronoc();

        Assert.assertTrue("The test obtained 26 letters",chartall.size()==26);
        Assert.assertTrue("The first letter of the test is a",chartall.get(0).equals("a"));
        Assert.assertTrue("The last letter of the test is z",chartall.get(chartall.size()-1).equals("z"));

    }
}
