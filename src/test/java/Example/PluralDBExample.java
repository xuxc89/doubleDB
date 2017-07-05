package Example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import cn.example.doubleDB.service.PluralDBService;

//@RunWith(SpringRunner.class)
//@SpringBootTest(value={PluralDBService,RoleMapper.class,UserMapper.class})
@Controller
public class PluralDBExample {

	@Autowired
	private PluralDBService pluralDBService;

	@Test
	public void doubleDB() {
		System.out.println("in");
		pluralDBService.dbTest();
	}
}
