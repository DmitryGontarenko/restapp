package com.accenture.gradlejooq.dto.response;

import com.accenture.gradlejooq.dto.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {

    @JsonView(View.Admin.class)
    @JsonProperty("id")
    private Integer id;

    @JsonView(View.Public.class)
    @JsonProperty("first_name")
    private String firstName;

    @JsonView(View.Full.class)
    @JsonProperty("last_name")
    private String lastName;
}
