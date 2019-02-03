package com.mkv.demo.jms;

import com.mkv.demo.service.MessageProcessor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    private final MessageProcessor messageProcessor;

    public SampleListener(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "default")
    public void receive(@Payload String message) {
        messageProcessor.processMessage(message);
    }
}
