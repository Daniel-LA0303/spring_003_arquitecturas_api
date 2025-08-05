package com.la.chat.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {

    @GetMapping("/memory")
    public String checkMemory() {
        Runtime runtime = Runtime.getRuntime();
        long usedMB = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024;
        long maxMB = runtime.maxMemory() / 1024 / 1024;
        return "Memoria usada: " + usedMB + " MB / Máxima: " + maxMB + " MB";
    }
}