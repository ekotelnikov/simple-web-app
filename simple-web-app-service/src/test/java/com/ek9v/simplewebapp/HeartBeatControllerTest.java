package com.ek9v.simplewebapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HeartBeatControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testHeartbeat() {
        String heartbeat = template.getForEntity("/v1/heartbeat", String.class).getBody();
        assertThat(heartbeat, startsWith("Application is up and running 0d 00h 00m"));
    }
}
