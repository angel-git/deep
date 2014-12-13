package com.ags.deep.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gavalda on 12/13/2014.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }
}
