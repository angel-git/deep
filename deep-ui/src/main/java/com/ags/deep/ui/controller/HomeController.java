package com.ags.deep.ui.controller;

import com.ags.deep.ui.thymeleaf.annotation.Layout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gavalda on 12/13/2014.
 */
@Controller
@Layout("layouts/index")
public class HomeController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "intro";
    }
}
