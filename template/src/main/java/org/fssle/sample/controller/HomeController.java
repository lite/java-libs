package org.fssle.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index(ModelMap modelMap) {
        List<String> products = new ArrayList<String>();
        products.add("Ruby");
        products.add("Perl");
        products.add("Python");
        modelMap.put("products", products);
        modelMap.put("message", "There is something languages.");

        return "homepage.ftl";
    }
}
