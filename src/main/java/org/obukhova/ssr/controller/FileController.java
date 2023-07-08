package org.obukhova.ssr.controller;

import org.obukhova.ssr.service.DownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController()
@RequestMapping("/download")
public class FileController {
    private final DownloaderService service;

    @Autowired

    public FileController(DownloaderService service) {
        this.service = service;
    }

    @GetMapping(value = "/csv", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<ByteArrayResource> downloadCsv() {
        try {
            Path path = service.getXlsx();
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
            return ResponseEntity.ok()
                    .header("Server message", "Message parsing succeded")
                    .body(resource);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .header("Server message", "Message parsing failed")
                    .build();
        }
    }

    @GetMapping(value = "/xlsx", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<ByteArrayResource> downloadXlsx(){
        try {
            Path path = service.getCsv();
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
            return ResponseEntity.ok()
                    .header("Server message", "Message parsing succeded")
                    .body(resource);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .header("Server message", "Message parsing failed")
                    .build();
        }
    }

    //todo: validation
    //todo docker
    // todo microservices
    //todo: proper readme
}
