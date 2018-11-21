/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilman.test.etiqa.rest.interceptor;

import com.hilman.test.etiqa.sql_module.service.SignService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author hilmananwarsah
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    SignService mService;
    
    
    private String roleNeeded;

    public String getRoleNeeded() {
        return roleNeeded;
    }

    public void setRoleNeeded(String roleNeeded) {
        this.roleNeeded = roleNeeded;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MREQ");
        String auth = request.getHeader("Auhtentication");
        if (auth == null) {
            sendResponse(-100, "no token provided", response);
            return false;
        } else {
            try {
                Map<String, Object> d = mService.parse(auth);
                String role = (String) d.get("role");
                if (role.equals(roleNeeded)) {
                    return true;
                } else {
                    sendResponse(-105, "invalid role", response);
                    return false;
                }
            } catch (Exception e) {
                sendResponse(-106, "error auth", response);
                return false;
            }

        }
    }

    private void sendResponse(int status, String message, HttpServletResponse response) throws IOException {
        JSONObject o = new JSONObject();
        o.put("status", status);
        o.put("message", message);
        o.put("data", "");
        response.getWriter().write(o.toString());
    }

}
