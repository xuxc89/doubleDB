package cn.example.doubleDB.controller;

import java.util.Random;

import org.junit.Test;

public class gailv {

	@Test
	public void run() {
		long flag = 0;
		long index = 10000000L;
//		long index = 1000000000000000000L;
		int trueFlag = 0;
		int falseFlag = 0;
		int flag1 = 0;
		int flag2 = 0;
		int flag3 = 0;
		int flag4 = 0;
		int flag5 = 0;
		int flag6 = 0;
		int flag7 = 0;
		
		while(flag<index) {
			flag++;
			if(!random()) {
				System.out.println("第"+flag+"次循环，1跳出");
				flag1++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，2跳出");
				flag2++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，3跳出");
				flag3++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，4跳出");
				flag4++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，5跳出");
				flag5++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，6跳出");
				flag6++;
				falseFlag++;
				continue;
			}
			if(!random()) {
				System.out.println("第"+flag+"次循环，7跳出");
				flag7++;
				falseFlag++;
				continue;
			}
			trueFlag++;
		}
		double fa = new Double(flag);
		System.out.println("true" + trueFlag);
		System.out.println(trueFlag/fa);
		System.out.println("false"+falseFlag);
		System.out.println(falseFlag/fa);
		System.out.println("第一失败跳出占比"+flag1/fa);
		System.out.println("第二失败跳出占比"+flag2/fa);
		System.out.println("第三失败跳出占比"+flag3/fa);
		System.out.println("第四失败跳出占比"+flag4/fa);
		System.out.println("第五失败跳出占比"+flag5/fa);
		System.out.println("第六失败跳出占比"+flag6/fa);
		System.out.println("第七失败跳出占比"+flag7/fa);
	}
	
//	@Test
//	public void runelse() {
//		int flag = 0;
//		int trueFlag = 0;
//		int falseFlag = 0;
//		Random random = new Random();
//		while(flag<10000) {
//			int i = random.nextInt(10);
//			System.out.println("flag次"+i);
//			if(i<7) {
//				trueFlag++;
//			}else{
//				falseFlag++;
//			}
//			flag++;
//		}
//	double fa = new Double(flag);
//		System.out.println("true" + trueFlag);
//		System.out.println(trueFlag/fa);
//		System.out.println("false"+falseFlag);
//		System.out.println(falseFlag/fa);
//	}
	
	private boolean random(){
		int i = (int) (Math.random()*10);
//		System.out.println("flag次"+i);
		if(i<7) {
			return true;
		}else{
			return false;
		}
	}
}
