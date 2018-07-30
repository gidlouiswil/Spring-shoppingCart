package com.gidlouiswil.shoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class AjaxController
{
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public @ResponseBody
    String getRandomNumber()
    {

        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "" + r;
        return result;
    }
}
