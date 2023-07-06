package org.obukhova.ssr.controller;

import org.obukhova.ssr.service.DownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/download")
public class FileController {
    private final DownloaderService service;

    @Autowired

    public FileController(DownloaderService service) {
        this.service = service;
    }

    @GetMapping("/csv")
    public ResponseEntity downloadCsv(){
        try {
            return service.getCsv();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .header("Server message", "Downloading messages in csv failed")
                    .build();
        }
    }
}
