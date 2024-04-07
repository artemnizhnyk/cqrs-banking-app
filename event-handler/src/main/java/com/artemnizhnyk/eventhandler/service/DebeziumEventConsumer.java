package com.artemnizhnyk.eventhandler.service;

import com.artemnizhnyk.eventhandler.handler.EventHandler;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class DebeziumEventConsumer implements CDCEventConsumer {

    private final Map<String, EventHandler> handlers;

    @KafkaListener(topics = "events")
    @Override
    public void process(final String payload, final Acknowledgment acknowledgment) {
        try {
            log.info("Received message: {}", payload);
            JsonObject json = JsonParser.parseString(payload)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();
            String type = json.get("type").getAsString();
            handlers.get(type)
                    .handle(json, acknowledgment);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
