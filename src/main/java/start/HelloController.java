package start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import start.queryType.QueryGrantTypeService;

import java.util.HashMap;
import java.util.Map;

@RestController
 public class HelloController {

    @Autowired
    QueryGrantTypeService queryGrantTypeService;
    @Autowired

    @GetMapping  ("/testRemove")
    public String testRemove(String origdata) {
//        String origdata="aabcccbbad";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REMOVE);
        exeBean.setOrigdata(origdata);

        queryGrantTypeService.getResult(exeBean);

          return "testRemove sucess";
    }
    @GetMapping("/testReplace")
    public String testReplace(String origdata) {
//        String origdata="abcccbad";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        queryGrantTypeService.getResult(exeBean);
        return "testReplace sucess";

    }

}

