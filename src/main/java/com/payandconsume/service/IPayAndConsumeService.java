package com.payandconsume.service;

import com.payandconsume.model.PayAndConsumeModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPayAndConsumeService {
	
	Flux<PayAndConsumeModel> findByCreditCardNumber(String creditCardNumber);
	Mono<PayAndConsumeModel> insertOperation (PayAndConsumeModel payAndConsumeModel);
}
