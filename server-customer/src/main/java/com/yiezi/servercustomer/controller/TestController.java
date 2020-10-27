package com.yiezi.servercustomer.controller;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.yiezi.servercustomer.entity.User;
import com.yiezi.servercustomer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;
    @GetMapping("/info")
    public String getInfo() {
        return this.restTemplate.getForEntity("http://Server-Provider/info", String.class).getBody();
    }


    @GetMapping("user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);

    }

    @GetMapping("user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("user/add")
    public String addUser() {
        return userService.addUser();
    }

    @GetMapping("user/update")
    public void updateUser() {
        userService.updateUser();
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("testCache")
    public void testCache(){
        userService.getUser(1L);
        userService.getUser(1L);
        userService.getUser(1L);
    }

}