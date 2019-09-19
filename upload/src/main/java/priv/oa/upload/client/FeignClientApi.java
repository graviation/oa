package priv.oa.upload.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("workflow")
public interface FeignClientApi {

    @RequestMapping("hellow/msg")
    String hello();

    @RequestMapping("hellow/msg1")
    String hello1();

}
