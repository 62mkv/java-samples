package com.mkv.demo;

import com.mkv.demo.jms.SamplePublisher;
import com.mkv.demo.service.MessageProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    SamplePublisher publisher;

    @MockBean
    MessageProcessor messageProcessor;

    @Test
    public void contextLoads() throws InterruptedException {
        String message = "Hello world";
        publisher.send(message);
        Thread.sleep(5000L);
        Mockito.verify(messageProcessor).processMessage(Mockito.contains(message));
    }

}

