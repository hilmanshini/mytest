/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.rest;

import com.hilman.test.etiqa.sql_module.service.AdminService;
import com.hilman.test.etiqa.sql_module.service.AuthService;
import com.hilman.test.etiqa.sql_module.service.pojo.admin.AddUserRequest;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.LoginRequest;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.Response;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.ValueOnlyRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AuthService mAuthService;

    @Autowired
    AdminService mAdminService;

    

    @RequestMapping(value = {"/add_teacher"}, method = RequestMethod.POST)
    public @ResponseBody
    Response eeee(@RequestBody AddUserRequest mAddUserRequest) {
        Response w = mAdminService.addTeacher(mAddUserRequest);
        return w;
    }

    @RequestMapping(value = {"/add_student"}, method = RequestMethod.POST)
    public @ResponseBody
    Response eee(@RequestBody AddUserRequest mAddUserRequest) {
        Response w = mAdminService.addStudent(mAddUserRequest);
        return w;
    }

    @RequestMapping(value = {"/add_class"}, method = RequestMethod.POST)
    public @ResponseBody
    Response eee(@RequestBody ValueOnlyRequest mValueOnlyRequest) {
        Response w = mAdminService.addClass(mValueOnlyRequest);
        return w;
    }

    @RequestMapping(value = {"/get_all_teacher/{page}"}, method = RequestMethod.GET)
    public @ResponseBody
    Response eee(@PathVariable int page) {
        Response w = mAdminService.listTeacher(page);
        return w;
    }

    @RequestMapping(value = {"/get_all_student/{page}"}, method = RequestMethod.GET)
    public @ResponseBody
    Response eeee(@PathVariable int page) {
        Response w = mAdminService.listTeacher(page);
        return w;
    }

    @RequestMapping(value = {"/get_all_class/{id}"}, method = RequestMethod.GET)
    public @ResponseBody
    Response eeeeee(@PathVariable int id) {
        Response w = mAdminService.listClass(id);
        return w;
    }

    @RequestMapping(value = {"/delete_teacher/{id}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    Response x(@PathVariable long id) {
        Response w = mAdminService.deleteTeacher(new ValueOnlyRequest<>(id));
        return w;
    }

    @RequestMapping(value = {"/delete_student/{id}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    Response eexee(@PathVariable long id) {
        Response w = mAdminService.deleteStudent(new ValueOnlyRequest<>(id));
        return w;
    }

    @RequestMapping(value = {"/delete_class/{id}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    Response eexeeee(@PathVariable long id) {
        Response w = mAdminService.deleteClass(new ValueOnlyRequest<>(id));
        return w;
    }

}
