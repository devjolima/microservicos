package com.forcode.e4y.mapper;

import com.forcode.e4y.data.Beer;
import com.forcode.e4y.dto.BeerDTO;

public class BeerMapper {
	
	private BeerMapper() {
	}
	
	public static BeerDTO toBeerDto(Beer beer) {
		
		return new BeerDTO(
				beer.getDescription(),
				beer.getImage_url(),
				beer.getName(),
				beer.getTagline()
				);
	}

}
