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

    @GetMapping("/testRemove")
    public void testRemove() {

        String origdata="aabcccbbad";
//        String origdata="aabccccbbaddd";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REMOVE);
        exeBean.setOrigdata(origdata);

        queryGrantTypeService.getResult(exeBean);

    }
    @GetMapping("/testReplace")
    public void testReplace() {
        String origdata="abcccbad";
//        String origdata="aabccccbbaddd";
        ExeBean  exeBean=new ExeBean();
        exeBean.setType(ExeBean.Type_REPLACE);
        exeBean.setOrigdata(origdata);
        queryGrantTypeService.getResult(exeBean);
    }

}

