package bip.leitorvenda.com.br.gateway.listener;

import com.google.gson.Gson;

import bip.leitorvenda.com.br.gateway.json.FileUUIDJson;
import bip.leitorvenda.com.br.service.ReaderFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReadInputVendaListener {

    @Autowired
    private ReaderFileService readerFileService;

    @KafkaListener(topics = "${kafka.topictopics1}", groupId = "${kafka.consumergroup}")
    public void execute(String message) throws IOException {
        FileUUIDJson fileUUIDJson = new Gson().fromJson(message, FileUUIDJson.class);
        readerFileService.execute(fileUUIDJson);
    }

}
