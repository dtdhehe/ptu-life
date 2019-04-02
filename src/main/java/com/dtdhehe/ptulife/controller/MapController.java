package com.dtdhehe.ptulife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By Xie_东
 * on 2019/4/2 14:45
 * @author Xie_东
 */
@Controller
@RequestMapping("/map/mapController")
public class MapController {

    @RequestMapping("/getMap")
    public String getMap(){

        return "map/map";
    }

}
