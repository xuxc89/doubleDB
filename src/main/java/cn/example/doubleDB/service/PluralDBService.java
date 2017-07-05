package cn.example.doubleDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.example.doubleDB.dao.db1.gen.entity.Role;
import cn.example.doubleDB.dao.db1.gen.mapper.RoleMapper;
import cn.example.doubleDB.dao.db2.gen.entity.User;
import cn.example.doubleDB.dao.db2.gen.mapper.UserMapper;

/**
 * 测试复数的数据源示例
 * @author Administrator
 *
 */
@Service
public class PluralDBService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserMapper userMapper;
	
	public void dbTest() {
		Role role = new Role();
		role.setName("装逼王");
		role.setDelFlg(0);
		roleMapper.insert(role);
		User user = new User();
		user.setName("董大力");
		user.setRoleId(2);
		userMapper.insert(user);
	}
	
}
