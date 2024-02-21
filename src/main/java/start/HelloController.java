package start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import start.queryType.QueryGrantTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
 public class HelloController {

    @Autowired
    QueryGrantTypeService queryGrantTypeService;

    @GetMapping  ("/testRemove")
    public List<String> testRemove(String origdata) {
//        String origdata="aabcccbbad";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REMOVE);
        exeBean.setOrigdata(origdata);
        List<String> result= queryGrantTypeService.getResult(exeBean);

          return result;
    }
    @GetMapping("/testReplace")
    public  List<String> testReplace(String origdata) {
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        List<String> result= queryGrantTypeService.getResult(exeBean);

        return result;
    }

}

