package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoRepo extends MongoRepository<Demo, String>{

}
