public class CharactersMainTest {

    public static void main(String[] args) {


        CharactersService queryGrantTypeService=new CharactersService();
        queryGrantTypeService.dispatcherInit();

        //测试删除
        String origdata="aabcccbbad";
//        String origdata="aabccccbbaddd";
        RequestData exeBean=new RequestData();
        exeBean.setType(RequestData.Type_REMOVE);
        exeBean.setOrigdata(origdata);
        System.out.println("");

        System.out.println("========测试删除=======");

        queryGrantTypeService.getResult(exeBean);


     System.out.println("========测试替换=======");
         origdata="abcccbad";
//        String origdata="aabccccbbaddd";
         exeBean=new RequestData();
        exeBean.setType(RequestData.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        queryGrantTypeService.getResult(exeBean);
    }
}
