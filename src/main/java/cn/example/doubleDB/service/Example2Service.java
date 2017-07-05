package cn.example.doubleDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Example2Service {

	@Autowired
	private ExampleService exampleService;
	
	
	
	
	@Transactional
	public void transactionExample(){
		exampleService.transactionExample01();
		exampleService.transactionExample02();
	}
}
