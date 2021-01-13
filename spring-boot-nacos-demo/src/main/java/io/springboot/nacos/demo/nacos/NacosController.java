package io.springboot.nacos.demo.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author Wilson
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class NacosController {
    //@Value("${swagger.docket.base-package}")
    //private String basePackage;
    @Value("${author.name}")
    private String name;

    @PostConstruct
    public void init() {
        System.err.println("name:" + name);
    }

    /*@NacosValue("${swagger.docket.base-package}")
    private String basePackage;*/

/*    @GetMapping(value = "/instances")
    @ResponseBody
    public List<Instance> instances(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }*/

    /*@GetMapping(value = "/configs")
    @ResponseBody
    public String instances() {
        return configService.getServerStatus();
    }
*/
/*    @GetMapping(value = "/basePackage")
    @ResponseBody
    public String basePackage() {
        return basePackage;
    }*/


   /* @Value("${atuhor}")
    private String atuhor;
    @GetMapping(value = "/atuhor")
    @ResponseBody
    public String atuhor() {
        return atuhor;
    }*/
}
