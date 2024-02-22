import org.junit.Test;


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
        exeBean.setType(RequestData.Type_REMOVE);
         exeBean.setOrigdata(origdata);

       queryGrantTypeService.getResult(exeBean);


    }
    @Test
    public void testReplace() throws Exception {
        CharactersService queryGrantTypeService=new CharactersService();
        queryGrantTypeService.dispatcherInit();
        //测试替换
        String origdata="abcccbad";
//        String origdata="aabccccbbaddd";
        RequestData exeBean=new RequestData();
        exeBean.setType(RequestData.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        queryGrantTypeService.getResult(exeBean);
    }




}