package org.fssle.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap) {
        modelMap.put("message", "There is default message.");
        return "homepage";
    }
}
