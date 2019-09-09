package com.accenture.gradlejooq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthorMockTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Вызов контроллера с помощью MockMvc и проверка содержимого.
     * @throws Exception
     */
    @Test
    public void shouldGetAuthorList() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print()) // выводим полученный результат в консоль
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[*].first_name").value(containsInAnyOrder("Katya", "Bert", "John")));
    }
}
