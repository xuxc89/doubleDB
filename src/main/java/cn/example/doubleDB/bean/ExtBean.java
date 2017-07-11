package cn.example.doubleDB.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ExtBean implements Cloneable,Serializable{

	private String from;
	private BaseBean bean;
	private Date time;
	
	public ExtBean(int id,String name,String from,Date time) {
		this.bean = new BaseBean(id, name);
		this.from = from;
		this.time = time;
	}
	public ExtBean() {
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
