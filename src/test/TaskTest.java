import service.Constants;
import domain.RequestData;
import org.junit.Test;
import service.CharactersService;

import java.util.List;


/**

 **/
public class TaskTest {

    //实际处理不同逻辑实现类
    @Test
    public void testRemove() throws Exception {
        CharactersService queryGrantTypeService=new CharactersService();
        queryGrantTypeService.dispatcherInit();

        //测试删除
        String origdata="aabcccbbad";
//        String origdata="aabccccbbaddd";
        RequestData exeBean=new RequestData();
        exeBean.setType(Constants.Type_REMOVE);
         exeBean.setOrigdata(origdata);

        List<String> deleteResult= queryGrantTypeService.getResult(exeBean);

        deleteResult.stream().forEach(System.out::println);


     System.out.println("====测试第二个数据");

        origdata="aadddeeefffzzzuuu";
        exeBean.setOrigdata(origdata);
//
        deleteResult= queryGrantTypeService.getResult(exeBean);

        deleteResult.stream().forEach(System.out::println);


    }
    @Test
    public void testReplace() throws Exception {
        CharactersService queryGrantTypeService=new CharactersService();
        queryGrantTypeService.dispatcherInit();
        //测试替换
        String origdata="abcccbad";
//        String origdata="aabccccbbaddd";
        RequestData exeBean=new RequestData();
        exeBean.setType(Constants.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        List<String> deleteResult= queryGrantTypeService.getResult(exeBean);

        deleteResult.stream().forEach(System.out::println);
    }




}