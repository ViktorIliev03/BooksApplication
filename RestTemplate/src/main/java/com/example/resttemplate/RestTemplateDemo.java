package com.example.resttemplate;

import com.example.resttemplate.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateDemo implements CommandLineRunner {
    private final RestTemplate restTemplate;


    public RestTemplateDemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) {
        ResponseEntity<BookDTO[]> allBooksResponse = restTemplate.
                getForEntity("http://localhost:8080/api/books", BookDTO[].class);

        if (allBooksResponse.hasBody()) {
            for (BookDTO book: allBooksResponse.getBody()) {
                System.out.println("Book: " + book);
            }
        }
    }
}
