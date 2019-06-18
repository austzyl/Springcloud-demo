package com.nr.job.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yaleizhu on 2019/4/26.
 * description:
 */
@Component
@Slf4j
public class JobFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        log.info("====================================getRoute=======================================");
        return "service-eureka-client";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                log.info("====================================getHeaders=======================================");

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                log.info("====================================getBody=======================================");

                return new ByteArrayInputStream("fallback".getBytes());
            }

            @Override
            public String getStatusText() throws IOException {
                log.info("====================================getStatusText=======================================");

                return "OK";
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                log.info("====================================getStatusCode=======================================");

                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                log.info("====================================getRawStatusCode=======================================");

                return 200;
            }

            @Override
            public void close() {

            }
        };
    }
}
