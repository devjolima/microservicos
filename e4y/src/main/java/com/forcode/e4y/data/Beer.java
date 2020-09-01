package com.forcode.e4y.data;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "beer")
public class Beer {

    private String uuid;

    private String name;

    private String image_url;




}
