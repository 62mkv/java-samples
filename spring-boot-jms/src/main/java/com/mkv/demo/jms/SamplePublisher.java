package com.mkv.demo.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class SamplePublisher {

    private final JmsTemplate jmsTemplate;
    private final Destination destination;

    public SamplePublisher(JmsTemplate jmsTemplate, Destination destination) {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
    }

    public void send(String messageBody) {
        jmsTemplate.send(destination, s -> s.createTextMessage(messageBody));
    }

}
