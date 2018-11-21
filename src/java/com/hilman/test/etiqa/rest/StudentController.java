/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.rest;

import com.hilman.test.etiqa.sql_module.service.SignService;
import com.hilman.test.etiqa.sql_module.service.StudentService;
import com.hilman.test.etiqa.sql_module.service.pojo.auth.Response;
import com.hilman.test.etiqa.sql_module.service.pojo.student.StudentClass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hilmananwarsah
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService mService;
    
    @Autowired
    SignService mSignService;

    @RequestMapping(value = {"/get_my_class/{start}/{end}"}, method = RequestMethod.GET)
    public @ResponseBody
    Response<List<StudentClass>> e( @PathVariable String start, @PathVariable String end,HttpServletRequest mrRequest) {
        long id = Long.parseLong(mSignService.parse(mrRequest).get("id").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh-mm");
        try {
            return mService.getAll(id, sdf.parse(start), sdf.parse(end));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return new Response<>(-1, "Invalid Data ", null);
        }
    }
}
