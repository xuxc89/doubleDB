package cn.example.doubleDB.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeepBase implements Cloneable,Serializable{

	public int id;
	public String name;
	
	public DeepBase(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public DeepBase() {
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
