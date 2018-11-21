/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.rest;

import com.hilman.test.etiqa.sql_module.service.AuthService;
import com.hilman.test.etiqa.sql_module.service.StudentService;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.LoginRequest;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hilmananwarsah
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    AuthService mAuthService;

    @Autowired
    StudentService mService;
    

    @RequestMapping(value = {"/student/login"}, method = RequestMethod.POST)
    public @ResponseBody
    Response e(@RequestBody LoginRequest mLoginRequest) {
        Response w = mAuthService.login(mLoginRequest);

        return w;
    }
    
    @RequestMapping(value = {"/admin/login"}, method = RequestMethod.POST)
    public @ResponseBody
    Response ad(@RequestBody LoginRequest mLoginRequest) {
        Response w = mAuthService.loginAdmin(mLoginRequest);
        return w;
    }
    
    @RequestMapping(value = {"/teacher/login"}, method = RequestMethod.POST)
    public @ResponseBody
    Response exx(@RequestBody LoginRequest mLoginRequest) {
        Response w = mAuthService.loginTeacher(mLoginRequest);
        return w;
    }

    

}
