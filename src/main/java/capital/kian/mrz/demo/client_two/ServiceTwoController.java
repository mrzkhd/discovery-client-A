package capital.kian.mrz.demo.client_two;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTwoController {

//    @Autowired
//    private ServiceOne serviceOne;

    @Value("${second}")
    private String second;

    @Value("${status}")
    private String status;//getting common config from application.yaml from config server

    @GetMapping("/call_service_one")
    public String instanceName() {
        return "service one response: ";
    }

   @GetMapping("/geturls")
    public String serviceUrls() {
        return serviceUrl();
    }

    @GetMapping("/config_values")
    public String configValues() {
        return "client TWO instance: "+ status;
    }

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("service_one", false);
        return instance.getHomePageUrl();
    }
}
