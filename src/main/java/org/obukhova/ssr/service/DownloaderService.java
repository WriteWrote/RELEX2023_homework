package org.obukhova.ssr.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.obukhova.ssr.model.entity.MessageEntity;
import org.obukhova.ssr.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class DownloaderService {
    private final MessageRepository repository;

    @Autowired
    public DownloaderService(MessageRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity getCsv() throws URISyntaxException {
        List<MessageEntity> entities = repository.findAll();

        Path path = Paths.get(
                ClassLoader.getSystemResource("resources/disposable/temp.csv").toURI()
        );

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path.toFile()));
            for (MessageEntity entity : entities) {
                String[] line = new String[]{entity.getId().toString(),
                        entity.getSender(),
                        entity.getText()};
                writer.writeNext(line);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .header("Server message", "Message parsing failed")
                    .build();
        }

        return ResponseEntity.ok()
                .header("Server message", "Message parsing succeded")
                .body(new File(path.toUri()));
    }
}
