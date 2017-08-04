package cn.example.doubleDB.bean;

public enum enmuBean {
	dllg("dalian","benke",2017,5);
	
	private String addr;
	private String level;
	private int year;
	private int mouth;
	
	
	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMouth() {
		return mouth;
	}


	public void setMouth(int mouth) {
		this.mouth = mouth;
	}


	private enmuBean(String addr,String level,int year,int mouth) {
		this.addr = addr;
		this.level = level;
	}
	
}
