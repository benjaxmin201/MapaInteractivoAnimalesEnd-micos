package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.service.ParqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/parques")
public class ParqueController {
    @Autowired
    private ParqueService parqueService;
}
