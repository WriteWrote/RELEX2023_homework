package org.obukhova.ssr.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.obukhova.ssr.model.entity.MessageEntity;
import org.obukhova.ssr.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class DownloaderService {

    private final Logger logger;
    private final MessageRepository repository;

    @Autowired
    public DownloaderService(MessageRepository repository) {
        this.repository = repository;
        logger = LoggerFactory.getLogger(MessageReceiverService.class);
    }

    public Path getCsv() throws URISyntaxException, IOException {
        List<MessageEntity> entities = repository.findAll();
        UUID uuid = UUID.randomUUID();
        Path path = Path.of("src/main/resources/disposable/" + uuid + "temp.csv");
        logger.info("File to path {}", path);

        CSVWriter writer = new CSVWriter(new FileWriter(path.toFile()));
        for (MessageEntity entity : entities) {
            String[] line = new String[]{entity.getId().toString(),
                    entity.getSender(),
                    entity.getText()};
            writer.writeNext(line);
        }
        writer.close();

        return path;
    }

    public Path getXlsx(){
        List<MessageEntity> entities = repository.findAll();
        UUID uuid = UUID.randomUUID();
        Path path = Path.of("src/main/resources/disposable/" + uuid + "temp.csv");
        logger.info("File to path {}", path);



        return path;
    }
}
