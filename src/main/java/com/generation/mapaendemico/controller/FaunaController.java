package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.service.FaunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fauna")
public class FaunaController {
    @Autowired
    private FaunaService faunaService;
}