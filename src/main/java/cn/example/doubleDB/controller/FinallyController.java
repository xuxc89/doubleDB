package cn.example.doubleDB.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.example.doubleDB.service.FinallyService;

@Controller
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public final class FinallyController {

	@Autowired
	private FinallyService finallyService;
	
	private int id;
	protected char sex;
	List<String> list;
	public String name;
	
	@Test
	public void returnString() {
		String str = finallyService.returnType();
		System.out.println(str);
	}

	public FinallyController() {
		System.out.println("FinallyController init");
	}
}
