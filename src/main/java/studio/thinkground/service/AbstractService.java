package studio.thinkground.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractService {
    @Autowired
    private ApiServerProperties properties;

    protected RestTemplate restTemplate;

    protected void setRestTemplate(RestTemplate restTemplate) {
        if(properties.getUrl() != null) {
            restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(properties.getUrl()));
        }
        
        if(properties.getKeyName() != null) {
            List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
            interceptors.add((HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
                request.getHeaders().add(properties.getKeyName(), properties.getKeyValue());
                return execution.execute(request, body);
            });
            restTemplate.setInterceptors(interceptors);
        }
        
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                try {
                    super.handleError(response);
                }
                catch(HttpStatusCodeException e) {
                    throw new IllegalArgumentException(e.getResponseBodyAsString(), e);
                }
            }
        });

        this.restTemplate = restTemplate;
    }

    protected void setRestTemplate(RestTemplate restTemplate, ResponseErrorHandler errorHandler) {
        if(properties.getUrl() != null) {
            restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(properties.getUrl()));
        }
        
        if(properties.getKeyName() != null) {
            List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
            interceptors.add((HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
                request.getHeaders().add(properties.getKeyName(), properties.getKeyValue());
                return execution.execute(request, body);
            });
            restTemplate.setInterceptors(interceptors);
        }
        
        restTemplate.setErrorHandler(errorHandler);

        this.restTemplate = restTemplate;
    }
}
