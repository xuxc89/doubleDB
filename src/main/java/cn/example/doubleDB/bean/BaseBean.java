package cn.example.doubleDB.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseBean implements Serializable{

	public int id;
	public String name;
	
	public BaseBean(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public BaseBean() {
	}
}
