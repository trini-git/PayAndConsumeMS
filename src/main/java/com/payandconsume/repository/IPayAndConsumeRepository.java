package com.payandconsume.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.payandconsume.model.PayAndConsumeModel;

import reactor.core.publisher.Flux;

@Repository
public interface IPayAndConsumeRepository extends ReactiveMongoRepository<PayAndConsumeModel, String>{
	
	Flux<PayAndConsumeModel> findByCreditCardNumber(String creditCardNumber);
}
