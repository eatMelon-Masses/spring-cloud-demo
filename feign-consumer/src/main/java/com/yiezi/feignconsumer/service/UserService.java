package com.yiezi.feignconsumer.service;

import com.yiezi.feignconsumer.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@FeignClient(value = "Server-Provider",fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("user/{id}")
    User get(@PathVariable("id") Long id);

    @GetMapping("user")
     List<User> get();

    @PostMapping("user")
     void add(@RequestBody User user);

    @PutMapping("user")
     void update(@RequestBody User user);

    @DeleteMapping("user/{id}")
     void delete(@PathVariable("id") Long id);

}
