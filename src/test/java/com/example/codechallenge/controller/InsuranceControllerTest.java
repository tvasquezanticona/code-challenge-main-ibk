package com.example.codechallenge.controller;


import com.example.codechallenge.web.InsuranceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = InsuranceController.class)
public class InsuranceControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void savesimulate() {
        webTestClient.post().uri("/insurance")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);

    }


}
