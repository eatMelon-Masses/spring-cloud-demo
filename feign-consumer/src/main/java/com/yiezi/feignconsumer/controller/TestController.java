package com.yiezi.feignconsumer.controller;

import com.yiezi.feignconsumer.entity.User;
import com.yiezi.feignconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserService userService;



    @GetMapping("user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        return userService.get(id);

    }

    @GetMapping("user")
    public List<User> getUsers() {
        return userService.get();
    }

    @GetMapping("user/add")
    public void addUser() {
        User mrbird = new User(1L, "mrbird", "123456");

        userService.add(mrbird);
    }

    @GetMapping("user/update")
    public void updateUser() {
        User mrbird = new User(1L, "mrbird", "123456");

        userService.update(mrbird);
    }

    @GetMapping("user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("testCache")
    public void testCache(){
        userService.get(1L);
        userService.get(1L);
        userService.get(1L);
    }

}