package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ola")
public class OlaController {


    @RequestMapping(value="/mundo", method=RequestMethod.GET)
    public String mundo(){
        return "Olá Mundo";
    }


}
