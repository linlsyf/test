package start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import start.queryType.QueryGrantTypeService;


/**

 **/
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class TaskTest {

    //实际处理不同逻辑实现类
    @Autowired
    QueryGrantTypeService queryGrantTypeService;

    @Test
    public void testRemove() throws Exception {
        //测试删除
        String origdata="aabcccbbad";
//        String origdata="aabccccbbaddd";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REMOVE);
         exeBean.setOrigdata(origdata);

       queryGrantTypeService.getResult(exeBean);


    }
    @Test
    public void testReplace() throws Exception {
        //测试替换
        String origdata="abcccbad";
//        String origdata="aabccccbbaddd";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REPLACE);
        exeBean.setOrigdata(origdata);

        queryGrantTypeService.getResult(exeBean);
    }




}