/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.rest;

import com.hilman.test.etiqa.sql_module.service.AuthService;
import com.hilman.test.etiqa.sql_module.service.SignService;
import com.hilman.test.etiqa.sql_module.service.TeacherService;
import com.hilman.test.etiqa.sql_module.service.pojo.teacher.AddClassRequest;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.LoginRequest;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hilmananwarsah
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    AuthService mAuthService;

    @Autowired
    TeacherService mTeacherService;

    @Autowired
    SignService mSignService;

    

    @RequestMapping(value = {"/assign_class"}, method = RequestMethod.POST)
    public @ResponseBody
    Response q(@RequestBody AddClassRequest mAddClassRequest, @RequestHeader("Authentication") String token) {
        long id = Long.parseLong(mSignService.parse(token).get("id").toString());
        return mTeacherService.addClass(mAddClassRequest, id);
    }

}
