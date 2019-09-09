package com.accenture.gradlejooq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorRestTempTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Вызов контроллера с помощью RestTemplate и проверка содержимого.
     * Основное приложение при этом должно быть запущено!
     */
    @Test
    public void shouldGetAuthorListRestTemplate() {
        assertThat(this.restTemplate.getForObject("http://localhost:8090/all", String.class))
                .contains("{\"id\":1,\"first_name\":\"Katya\",\"last_name\":\"Sierra\"}");
    }
}
