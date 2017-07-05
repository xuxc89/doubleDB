package cn.example.doubleDB.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.example.doubleDB.service.Transactional2Service;
import cn.example.doubleDB.service.TransactionalService;

@Service
@RequestMapping("/example")
/**
 * 没有此注解时要再看
 * @author xxc@SpringBootTest后制定要实例化的包
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ExampleController {
	@Autowired
	private TransactionalService exampleService;
	@Autowired
	private Transactional2Service example2Service;
	
	/**
	 * 明日解决 test对象未注入问题
	 * 
	 * @author xxc
	 * @since 2017年7月4日 下午5:54:15
	 * ExampleController.java
	 * TODO
	 */
//	@RequestMapping("/test")
//	@Test
//	public void dbTest() {
//		exampleService.dbTest();
//	}
	/**
	 * 事物加在controller层怎样回滚 service层
	 * 在controller层验证控制多个service层回滚操作
	 * 结果可行 第一个service成功 第二个失败时可完成事物回滚
	 * 但当系统未出现问题时未出现提交结果，判断service结束提交被事物拦截
	 * controller层要进行提交service已结束
	 * 
	 * 方案二 
	 * 在每个service层上单独加transactional
	 * 结果未达成 
	 * 第一个表提交成功未回滚
	 * 
	 * 方案三
	 * service使用一个标识了transactional的方法调用另外的未标识的service
	 * 成功完美达成目标
	 * 
	 * 方案四
	 * service中使用一个未声明事物的方法调另外两个声明了事物的方法
	 * 失败 未回滚
	 * 
	 * 方案五
	 * 使用一个声明了事物的调用另外两个声明了事物的方法
	 * 成功但此方案符合方案三的条件
	 * 
	 * 补充测试
	 * 在service中调用其他service类方法出现错误时，可以正常回滚。
	 * 同时也无法进行提交
	 * 
	 * 结论为事物只能加在同一个service下的调用其他方法的主入口方法上
	 * 或将数据库操作都写到同一个方法中
	 * 
	 * @author xxc
	 * @since 2017年7月5日 上午9:28:10
	 * ExampleController.java
	 * 
	 */
	@RequestMapping("/transactionRollBack")
	@Test
	/**
	 * contoller层标识事物是否会导致提交失败
	 * 会导致提交失败
	 * 
	 * @author xxc
	 * @since 2017年7月5日 上午9:48:38
	 * ExampleController.java
	 * 
	 */
	@Transactional
	public void transactionRollBack() {
		/**
		 * 事物拦截成功效果类似于提交后添加完毕后删除该条记录
		 * 虽然实际效果是为添加至数据库
		 * 但数据库自增的主键实际已发生更改
		 */
//		exampleService.transactionExample01();
//		exampleService.transactionExample02();
//		exampleService.transactionExample03();
		
		example2Service.transactionExample();
	}
	
}
