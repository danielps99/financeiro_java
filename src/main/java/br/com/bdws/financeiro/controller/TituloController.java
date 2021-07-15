package br.com.bdws.financeiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TituloController {

    @GetMapping("/ola")
    @ResponseBody
    public String ola() {
        return "Olá";
    }
}
