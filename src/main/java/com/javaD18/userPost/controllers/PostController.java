package com.javaD18.userPost.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {

        @GetMapping("/posts")
        public String getPostClass (HttpServletRequest request, Model model){

        HttpSession session = request.getSession();

        Object userNameAttribute = session.getAttribute("userName");

        if (userNameAttribute == null) {
            // special string to redirect
            return "redirect:/";
        }

        String userName = userNameAttribute.toString();

        model.addAttribute("userName", userName);

        // probably want to add the recipe list here...

        return "posts.html";
    }
}
