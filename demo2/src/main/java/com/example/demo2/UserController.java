package com.example.demo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/demo2User")
@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository ;


    @PostMapping("/add")
    @ResponseBody
    public String addUser(
            @RequestParam("name") String name ,
            @RequestParam("email") String email

    ){
        userRepository.save(new User(name, email));

        return "add Done !";
    }

    @GetMapping("/allUsers")
    @ResponseBody
    public Iterable<User> allUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteUser(
            @RequestBody User user){
        userRepository.delete(user);

        return "Delete Done !";
    }


}
