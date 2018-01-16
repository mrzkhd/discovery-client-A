package capital.kian.mrz.demo.configclient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigParamsController {

    @GetMapping("/serviceName")
    public String instanceName() {
        return "Discovery client ONE instance";
    }
}
