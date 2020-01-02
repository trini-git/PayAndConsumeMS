package com.payandconsume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.payandconsume.model.CreditCardModel;
import com.payandconsume.model.PayAndConsumeModel;
import com.payandconsume.repository.IPayAndConsumeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PayAndConsumeService implements IPayAndConsumeService {

	@Autowired
	IPayAndConsumeRepository iPayAndConsumeRepository;

	@Autowired
	@Qualifier("creditCard")
	WebClient client;

	CreditCardModel creditCardModel = new CreditCardModel();

	@Override
	public Flux<PayAndConsumeModel> findByCreditCardNumber(String creditCardNumber) {

		return iPayAndConsumeRepository.findByCreditCardNumber(creditCardNumber);
	}

	@Override
	public Mono<PayAndConsumeModel> insertOperation(PayAndConsumeModel payAndConsumeModel) {

		creditCardModel.setCreditCardNumber(payAndConsumeModel.getCreditCardNumber());
		creditCardModel.setAvalibleAmount(payAndConsumeModel.getAmount());

		if (payAndConsumeModel.getType().equalsIgnoreCase("C")) {
			return updateConsumeCreditCard(creditCardModel)
				.flatMap(creditCard -> {
				return iPayAndConsumeRepository.save(payAndConsumeModel);
			}).switchIfEmpty(Mono.empty());
		} else if (payAndConsumeModel.getType().equalsIgnoreCase("P")) {
			return updatePayCreditCard(creditCardModel)
				.flatMap(creditCard -> {
					return iPayAndConsumeRepository.save(payAndConsumeModel);
				});
		}
		return Mono.empty();

	}

	/* Microservice that connects */
	public Mono<CreditCardModel> updateConsumeCreditCard(CreditCardModel creditCardModel) {
		return client.put()
				.uri("/update-consume")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.syncBody(creditCardModel).retrieve()
				.bodyToMono(CreditCardModel.class)
				.switchIfEmpty(Mono.empty());
	}

	/* Microservice that connects */
	public Mono<CreditCardModel> updatePayCreditCard(CreditCardModel creditCardModel) {
		return client.put()
				.uri("/update-pay")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.syncBody(creditCardModel).retrieve()
				.bodyToMono(CreditCardModel.class)
				.switchIfEmpty(Mono.empty());
	}

}
