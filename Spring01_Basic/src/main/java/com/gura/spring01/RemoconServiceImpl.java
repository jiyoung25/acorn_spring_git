package com.gura.spring01;

import org.springframework.stereotype.Service;

//service라는 annotation을 만든다.
@Service
public class RemoconServiceImpl implements RemoconService {

	@Override
	public void up() {
		System.out.println("채널을 올려요~!");
		
	}

	@Override
	public void down() {
		System.out.println("채널을 내려요!");
		
	}

}
