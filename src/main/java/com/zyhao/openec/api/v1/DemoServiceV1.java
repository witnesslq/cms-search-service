package com.zyhao.openec.api.v1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zyhao.openec.entity.User;

/**
 * The {@link DemoServiceV1} implements business logic for aggregating the state of
 * a user's actions represented by a sequence of {@link CartEvent}. The generated aggregate
 * uses event sourcing to produce a {@link ShoppingCart} containing a collection of
 * {@link demo.cart.LineItem}.
 *
 * @author Ben Hale
 * @author Kenny Bastani
 */
@Service
public class DemoServiceV1 {

    private final Log log = LogFactory.getLog(DemoServiceV1.class);
    private OAuth2RestTemplate oAuth2RestTemplate;
    private RestTemplate restTemplate;

    @Autowired
    public DemoServiceV1(
                                 @LoadBalanced OAuth2RestTemplate oAuth2RestTemplate,
                                 @LoadBalanced RestTemplate normalRestTemplate) {
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.restTemplate = normalRestTemplate;
    }

    /**
     * Get the authenticated user from the user service
     *
     * @return the currently authenticated user
     */
    public User getAuthenticatedUser() {
        return oAuth2RestTemplate.getForObject("http://user-service/uaa/v1/me", User.class);
    }
    public User getDemo() throws Exception {
        //User user = oAuth2RestTemplate.getForObject("http://user-service/uaa/v1/me", User.class);
        return new User();
    }
//    public Catalog postDemo() throws Exception{
//        Catalog catalog = restTemplate.getForObject("http://catalog-service/v1/catalog", Catalog.class);
//        return catalog;
//    }
}
