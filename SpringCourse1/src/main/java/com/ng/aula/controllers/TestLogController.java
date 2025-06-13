package com.ng.aula.controllers;

import com.ng.aula.services.PersonServices;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("This is a debug message.");
        logger.info("This is a INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("This is a error message.");
        return "Logs generated successfully";
    }
}
