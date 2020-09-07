package com.forcode.e4y.data;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.forcode.e4y.dto.BeerDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "beer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {

    private String uuid;

    private String name;

    private String image_url;
    
    private String description;

    private String tagline;


    public Beer(BeerDTO dto) {
    	this.uuid = UUID.randomUUID().toString();
    	this.image_url = dto.getImage_url();
    	this.name = dto.getName();
    	this.description = dto.getDescription();
    	this.tagline = dto.getTagline();
    	
    }


}
