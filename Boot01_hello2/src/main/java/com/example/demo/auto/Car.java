package com.example.demo.auto;

import org.springframework.stereotype.Component;

//Component scan이 일어나면 자동으로 bean이 됨.
@Component
public class Car {
	public void drive() {
		System.out.println("달려요 ~~");
	}
}
