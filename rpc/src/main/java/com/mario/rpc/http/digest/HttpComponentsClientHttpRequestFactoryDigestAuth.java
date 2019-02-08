package com.mario.rpc.http.digest;

import org.apache.http.HttpHost;
import org.apache.http.client.AuthCache;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * https://mp.weixin.qq.com/s/Czn0E5dl2qVKqkLG27OVfg
 */
public class HttpComponentsClientHttpRequestFactoryDigestAuth extends HttpComponentsClientHttpRequestFactory {
    RestTemplate restTemplate;
    HttpHost host;

    @Test
    public  void main(String[] args) {
        String uri ="http://localhost:8080/spring-security-rest-digest-auth/api/foos/1";
//        ResponseEntity<Foo>entity
    }
    public HttpComponentsClientHttpRequestFactoryDigestAuth(HttpHost host,HttpClient httpClient) {
        super(httpClient);
        this.host = host;
    }

    @Override
    protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
        return createHttpContext();
    }

    private HttpContext createHttpContext() {
        AuthCache authCache =new BasicAuthCache();
        DigestScheme digestScheme =new DigestScheme();
        digestScheme.overrideParamter("realm","custom realm name");
        authCache.put(host,digestScheme);
        BasicHttpContext basicHttpContext =new BasicHttpContext();
        basicHttpContext.setAttribute(ClientContext.AUTH_CACHE,authCache);
        return basicHttpContext;
    }
}
