package com.microservices.login.controller;

import com.microservices.login.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigController {

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("/property")
    public String getProperty() {
        return configProperties.getProperty();
    }
}
