package cn.touale.cula.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Touale
 * @description RemoteUserService
 * @date 2021/12/31 15:47
 */

@FeignClient(contextId = "RemoteUserService", value = "NEWSSERVICE-8001")
@RequestMapping("/user")
public interface RemoteUserService {
    @PostMapping("/doLogin")
    public Boolean doLogin(@RequestParam(name = "user") String user,
                           @RequestParam(name = "pwd") String pwd);
}
