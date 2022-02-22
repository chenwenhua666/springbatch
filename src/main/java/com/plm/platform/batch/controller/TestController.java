package com.plm.platform.batch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author crystal
 */
@RestController
public class TestController {

    @GetMapping("/test/{param}")
    public String test(@PathVariable String param) {
        return param;
    }
}
