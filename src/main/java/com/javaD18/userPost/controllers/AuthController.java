package com.javaD18.userPost.controllers;

import com.javaD18.userPost.models.SiteUserClass;
import com.javaD18.userPost.repos.SiteUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.mindrot.jbcrypt.BCrypt;

@Controller
public class AuthController {

    @Autowired
    SiteUserRepository siteUserRepository;

    @GetMapping("/")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, String userName, String password) {

        // Confirm that password is correct for given user
        // 1. Find the corresponding user
        SiteUserClass siteUser = siteUserRepository.findSiteUserClassByUserName(userName);

        if (siteUser == null) {
            return new RedirectView("/");
        }

//         2. Check if stored password matches
        if (!BCrypt.checkpw(password, siteUser.getUserPassword())) {
            return new RedirectView("/");
        }

        // store in session
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);

        return new RedirectView("/posts");
    }

    @PostMapping("/signup")
    public RedirectView signup(String userName, String password) {

       String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        SiteUserClass newUser = new SiteUserClass(userName, hashedPassword);
       siteUserRepository.save(newUser);

        return new RedirectView("/");
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new RedirectView("/");
    }
}
