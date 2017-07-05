package cn.example.doubleDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事物验证测试用例
 * @author xxc
 * @since 2017年7月5日 上午10:10:35
 *
 */
@Service
public class Transactional2Service {

	@Autowired
	private TransactionalService exampleService;
	
	
	
	
	@Transactional
	public void transactionExample(){
		exampleService.transactionExample01();
		exampleService.transactionExample02();
	}
}
