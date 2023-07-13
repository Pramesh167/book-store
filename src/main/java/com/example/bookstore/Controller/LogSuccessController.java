package com.example.bookstore.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("log-success")
public class LogSuccessController {

    @GetMapping
    public String redirectPage(Authentication authentication){
        List<String> authorities=new ArrayList<>();
        authentication.getAuthorities().stream().forEach(i->{
            System.out.println(i);
            authorities.add(i.toString());
        });
       if(authorities.contains("admin")){
           return "redirect:/admin/viewallproduct";
       }
       return "redirect:/user/homepage";
    }
}
