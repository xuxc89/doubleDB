package cn.example.doubleDB.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class FinalController extends Example/* final 类无法继承 extends finalExample*/{
	/**
	 * final修饰方法无法重写
	 * @author xxc
	 * @since 2017年7月10日 下午4:48:07
	 * FinalController.java
	 * TODO
	 */
//	@Override
//	public void write() {
//		System.out.println("重写");
//	}
	@Test
	public void test() {
		FinalController c = new FinalController();
		c.write();
	}
//	@Test
	/**
	 * 声明为final的数组无法改变，指容器中装载的数组类型大小不可变而与数组中的内容无关
	 * @author xxc
	 * @since 2017年7月10日 下午4:10:50
	 * FinalController.java
	 * TODO
	 */
	public void test_final() {
		final int[] bounds ={0,1,2,3,4,5,6,7,8,9};
		int size = bounds.length;
		System.out.println("-----------------------使用foreach更改顺序-------------------------------");
		for(int item:bounds) {
			System.out.println(item);
			item = size-1;
		}
		System.out.println("------------------------foreach遍历------------------------------");
		bounds[2]=6;
		for(int item:bounds) {
			System.out.println(item);
		}
		System.out.println("-----------------------使用for更改顺序-------------------------------");
		for(int i=0;i<bounds.length;i++) {
			bounds[i] = bounds.length-i-1;
		}
		System.out.println("------------------------------------------------------");
		for(int item:bounds) {
			System.out.println(item);
		}
	}
	
//	@Test
	/**
	 * 集合声明为final后效果同数组，证明final至对容器起效果
	 * 对容器中的操作无效
	 * @author xxc
	 * @since 2017年7月10日 下午4:40:00
	 * FinalController.java
	 * TODO
	 */
	public void final_list(){
		final List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 10 ; i ++){
			list.add(i);
		}
		Iterator<Integer> item = list.iterator();
		int flag = list.size();
		/**
		 * 循环时条件为hasNext时 必须调用.next()方法
		 * 否则会出现死循环
		 */
		while(item.hasNext()) {
			//对产生迭代器的对象操作会直接生效
			System.out.println(item.next());
			list.set(list.size()-flag, flag);
			flag--;
//			System.out.println(flag);
		}
		item = list.iterator();
		System.out.println("--------------------------------------");
		do{
			System.out.println(item.next());
		}while(item.hasNext());
		
	}
}

class Example{
	public final void write() {
		System.out.println("final 方法无法重写");
	}
}
final class finalExample{
	
}
