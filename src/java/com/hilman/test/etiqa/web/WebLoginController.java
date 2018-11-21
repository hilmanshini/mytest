/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hilmananwarsah
 */
@Controller
@RequestMapping("/student")
public class WebLoginController {
    
    @RequestMapping("/index")
    public String login(HttpServletResponse mResponse){
        return "dashboard";
    }
    @RequestMapping("/login")
    public String loegin(HttpServletResponse mResponse){
        return "dashboard.login";
    }
    
    @RequestMapping("/ajax_login")
    public String loginajax(HttpServletResponse mResponse){
        return "ajax.dashboard.login";
    }
    @RequestMapping("/dashboard")
    public String das(HttpServletResponse mResponse){
        return "dashboard.dashboard";
    }
    
}
