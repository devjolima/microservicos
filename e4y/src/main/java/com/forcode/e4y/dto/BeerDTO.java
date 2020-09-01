package com.forcode.e4y.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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
