public class CharactersMainTest {

    public static void main(String[] args) {


        CharactersService queryGrantTypeService=new CharactersService();
        queryGrantTypeService.dispatcherInit();
        String removeData="";
        String replaceData="";
        if (args.length>1){
            removeData=args[0];
            replaceData=args[1];

        }
        else{
              removeData="aabcccbbad";
            replaceData="abcccbad";
        }
        //测试删除
//        String origdata="aabccccbbaddd";
        RequestData exeBean=new RequestData();
        exeBean.setType(RequestData.Type_REMOVE);
        exeBean.setOrigdata(removeData);
        System.out.println("");

        System.out.println("========测试删除=======");

        queryGrantTypeService.getResult(exeBean);


     System.out.println("========测试替换=======");
//        String origdata="aabccccbbaddd";
         exeBean=new RequestData();
        exeBean.setType(RequestData.Type_REPLACE);
        exeBean.setOrigdata(replaceData);
        queryGrantTypeService.getResult(exeBean);
    }
}
