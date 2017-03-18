package com.tazuzuapp.api.user.web;

/**
 * Created by deana on 13/03/2017.
 * This test starts the application up and listens for a connection like it would do in production,
 * and then sends an HTTP request and asserts the response.
 */
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDefaultMessageOnStartup() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/",
                String.class)).contains("_links");
    }

}
