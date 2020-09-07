package com.forcode.e4y.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO implements Serializable{

    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private String image_url;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tagline")
    private String tagline;

}
