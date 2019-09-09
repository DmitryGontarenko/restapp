package com.accenture.gradlejooq.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class AuthorRequest {


    public AuthorRequest(@NotNull(groups = {CreateAuthorRequest.class}) String firstName, @NotNull(groups = {CreateAuthorRequest.class}) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public interface Default {

    }
    public interface CreateAuthorRequest extends Default {

    }
    public interface UpdateAuthorRequest extends Default {

    }

    @JsonProperty("id")
    private Integer id;

    @NotNull(groups = {CreateAuthorRequest.class})
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(groups = {CreateAuthorRequest.class})
    @JsonProperty("last_name")
    private String lastName;
}
