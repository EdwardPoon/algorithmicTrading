package com.edward.dataproducer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class Test {

	public static void main(String[] args) {
		Flowable.just("Hello world").subscribe(System.out::println);

		
		Flowable.range(1, 10)
		  //.observeOn(Schedulers.computation())
		  .map(v -> v * v)
		  .blockingSubscribe(System.out::println);
		System.out.println("==================");
		
		System.out.println(new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2));
		System.out.println(new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2));
		
		System.out.println("==================");
		 
		//Flowable.interval(0, 5, TimeUnit.SECONDS)
		//.take(5)//only emit 5 elements
		//.blockingSubscribe(integer -> {System.out.println(integer);});
	}
}
