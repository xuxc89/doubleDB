package cn.example.doubleDB.service;

import org.springframework.stereotype.Service;

@Service
public class FinallyService {

	public String returnType() {
		String hello = "hello";
		try{
			return hello;
		}finally {
			hello = null;
		}
	}
}
