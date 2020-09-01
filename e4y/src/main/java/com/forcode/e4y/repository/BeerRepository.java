package com.forcode.e4y.repository;

import com.forcode.e4y.data.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {


}
