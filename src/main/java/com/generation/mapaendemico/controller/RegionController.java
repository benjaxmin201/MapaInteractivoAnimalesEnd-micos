package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;
}
