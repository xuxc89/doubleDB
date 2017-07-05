package cn.example.doubleDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.example.doubleDB.dao.db1.gen.entity.Role;
import cn.example.doubleDB.dao.db1.gen.mapper.RoleMapper;
import cn.example.doubleDB.dao.db2.gen.entity.User;
import cn.example.doubleDB.dao.db2.gen.mapper.UserMapper;

/**
 * 事物验证测试用例
 * @author xxc
 * @since 2017年7月5日 上午10:10:52
 *
 */
@Service
public class TransactionalService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserMapper userMapper;
	
//	@Transactional
	public void transactionExample01(){
		User user = new User();
		user.setName("董大力");
		user.setRoleId(2);
		userMapper.insert(user);
	}
	
//	@Transactional
	public void transactionExample02(){
		//崩溃调试代码
//		int[] arr = new int[1];
//		int i = arr[2];
		//崩溃调试代码
		Role role = new Role();
		role.setName("装逼王");
		role.setDelFlg(0);
		roleMapper.insert(role);
	}
	
	@Transactional
	public void transactionExample03(){
		transactionExample01();
		transactionExample02();
	}
}
