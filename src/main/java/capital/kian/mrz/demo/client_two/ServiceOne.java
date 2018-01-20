package capital.kian.mrz.demo.client_two;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service_one")
public interface ServiceOne {

    @RequestMapping("/whoami")
    String whoAmI();

}
