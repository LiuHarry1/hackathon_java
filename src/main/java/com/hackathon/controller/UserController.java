package com.hackathon.controller;
import com.hackathon.bean.User;
import com.hackathon.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private int counter;
 
    @ResponseBody
    @RequestMapping("/user/add")
    public Object add() {
        User user = new User();
        user.setName("name" + ++counter);
        userRepository.save(user);
        return user;
    }
 
    @ResponseBody
    @RequestMapping("/user/update/{id}")
    public Object update(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        user.setName("name" + ++counter);
        userRepository.save(user);
        return user;
    }
 
    @ResponseBody
    @RequestMapping("/user/delete/{id}")
    public Object delete(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return user;
    }
    
}