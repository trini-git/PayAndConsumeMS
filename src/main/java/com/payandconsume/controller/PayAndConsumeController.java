package com.payandconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payandconsume.model.PayAndConsumeModel;
import com.payandconsume.service.PayAndConsumeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pay-and-consume")
@Api(value="PayAndConsumeController", description="PAY AND CONSUME WITH YOUR CREDIT CARD")
public class PayAndConsumeController {
	
	@Autowired
	PayAndConsumeService payAndConsumeService;
	
	@GetMapping("/find-by/{creditCardNumber}")
	@ApiOperation(value = "View your avalible operations with your credit card", response = PayAndConsumeModel.class)
	public Flux<PayAndConsumeModel> findByCreditCardNumber (@PathVariable String creditCardNumber){
		return payAndConsumeService.findByCreditCardNumber(creditCardNumber);
		
	}
	
	@PostMapping("/insert")
	@ApiOperation(value = "You can pay or consume, it depends on your avalible cash", response = PayAndConsumeModel.class)
	public Mono<PayAndConsumeModel> insertOperation (@RequestBody PayAndConsumeModel payAndConsumeModel){
		return payAndConsumeService.insertOperation(payAndConsumeModel);
		
	}
	
}
