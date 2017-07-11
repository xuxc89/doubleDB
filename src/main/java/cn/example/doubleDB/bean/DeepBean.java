package cn.example.doubleDB.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DeepBean implements Cloneable,Serializable{

	private String from;
	private DeepBase bean;
	private Date time;
	
	public DeepBean(int id,String name,String from,Date time) {
		this.bean = new DeepBase(id, name);
		this.from = from;
		this.time = time;
	}
	public DeepBean() {
		
	}
	
	@Override
	public DeepBean clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		DeepBean obj = (DeepBean)super.clone();
		obj.bean = (DeepBase) bean.clone();
		return obj;
	}
}
