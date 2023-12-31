package org.obukhova.ssr.service;

import com.opencsv.CSVWriter;
import org.obukhova.ssr.model.entity.MessageEntity;
import org.obukhova.ssr.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
public class DownloaderService {

    private final Logger logger;
    private final MessageRepository repository;

    @Autowired
    public DownloaderService(MessageRepository repository) {
        this.repository = repository;
        logger = LoggerFactory.getLogger(MessageReceiverService.class);
    }

    public Path getCsv() throws IOException {
        List<MessageEntity> entities = repository.findAll();
        UUID uuid = UUID.randomUUID();
        Path path = Path.of("src/main/resources/csv_storage/" + uuid + ".csv");
        logger.info("File to path {}", path);

        CSVWriter writer = new CSVWriter(new FileWriter(path.toFile()));
        for (MessageEntity entity : entities) {
            String[] line = new String[]{entity.getId().toString(),
                    entity.getSenderId().toString(),
                    entity.getText()};
            writer.writeNext(line);
        }
        writer.close();

        return path;
    }
}
