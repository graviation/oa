package priv.oa.workflow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hellow")
public class HellowController {

    @RequestMapping("msg")
    public String msg() {
        return "hello spring cloud123";
    }


    @RequestMapping("msg1")
    public String msg1() {return "1 hello word 1";}

}
