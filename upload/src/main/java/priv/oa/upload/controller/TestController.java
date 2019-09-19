package priv.oa.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.oa.upload.client.FeignClientApi;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private FeignClientApi client;

    @GetMapping("test")
    public Object test() {
        Map<String, String> map = new HashMap<>(4);
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        String hello = client.hello();
        return hello;
    }

    @GetMapping("test1")
    public Object test1() {
        return client.hello1();
    }

}
