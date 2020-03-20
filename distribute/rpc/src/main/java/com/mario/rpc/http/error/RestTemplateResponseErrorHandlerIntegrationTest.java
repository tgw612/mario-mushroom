package com.mario.rpc.http.error;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseException.class, Bar.class})
@RestClientTest
public class RestTemplateResponseErrorHandlerIntegrationTest {
    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestTemplateBuilder builder;

    @Test(expected = BaseException.class)
    public void giveRemoteApiCall() {
        Assert.assertNotNull(this.builder);
        Assert.assertNotNull(this.builder);
        RestTemplate restTemplate = this.builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        this.server.expect(ExpectedCount.once(), requestTo("/bars/4242")).andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));
        Bar response = restTemplate.getForObject("/bars/4242", Bar.class);
        this.server.verify();
    }
}
