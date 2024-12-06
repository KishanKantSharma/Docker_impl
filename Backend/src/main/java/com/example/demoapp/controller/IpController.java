package com.example.demoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class IpController {

    private static final Logger logger = LoggerFactory.getLogger(IpController.class);
    
    @GetMapping("/ipaddress")
    public String getIpAddress(HttpServletRequest request){
        String clientIp = "";

        if(request != null){
            clientIp = request.getHeader("X-FORWARDED-FOR");

            logger.debug("X-FORWARDED-FOR: {}", clientIp);

            if(clientIp == null || clientIp.isEmpty()) {
                clientIp = request.getRemoteAddr();
            }

            if(clientIp.equals("0:0:0:0:0:0:0:1")){
                clientIp = "127.0.0.1";
            }
        }
        
        return clientIp;
    }

}
