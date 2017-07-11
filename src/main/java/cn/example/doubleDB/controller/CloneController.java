package cn.example.doubleDB.controller;

import java.util.Date;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

import cn.example.doubleDB.bean.DeepBean;
import cn.example.doubleDB.bean.ExtBean;

@Controller
public class CloneController {

	@Test
	public void testShallowCopy() throws CloneNotSupportedException {
		ExtBean bean = new ExtBean(1, "xxc", "DL", new Date());
		ExtBean clone = (ExtBean) bean.clone();
		ExtBean copy = bean;
		System.out.println(bean);
		System.out.println(clone);
		System.out.println(copy);
		
		System.out.println("------------------地址比较-------------------");
		System.out.println("bean == clone \n" + (bean == clone?true:false));
		System.out.println("bean == copy\n" + (bean == copy?true:false));
		
		System.out.println("---------------------修改参数测试-----------------------");
		System.out.println("---------------------修改前-----------------------");
		System.out.println("bean\n" + bean.getFrom());
		System.out.println(bean.getFrom().hashCode());
		System.out.println("clone\n" + clone.getFrom());
		System.out.println(clone.getFrom().hashCode());
		System.out.println("copy\n" + copy.getFrom());
		System.out.println(copy.getFrom().hashCode());
		System.out.println("---------------------修改bean from----------------------------");
		bean.setFrom("SH");
		System.out.println("---------------------修改后-----------------------------");
		System.out.println("bean\n" + bean.getFrom());
		System.out.println(bean.getFrom().hashCode());
		System.out.println("bean.hashcode\n" + bean.hashCode());
		System.out.println("clone.hashcode\n" + clone.hashCode());
		System.out.println("clone\n" + clone.getFrom());
		System.out.println(clone.getFrom().hashCode());
		System.out.println("copy\n" + copy.getFrom());
		System.out.println(copy.getFrom().hashCode());
		System.out.println("---------------------修改bean base Name----------------------------");
		bean.getBean().setName("wx");
		System.out.println("---------------------修改后-----------------------------");
		System.out.println("bean\n" + bean.getBean().getName());
		System.out.println("clone\n" + clone.getBean().getName());
		System.out.println("copy\n" + copy.getBean().getName());
		System.out.println("bean base hashcode\n" + bean.getBean().hashCode());
		System.out.println("clone base hashcode\n" + clone.getBean().hashCode());
		System.out.println("copy base hashcode\n" + copy.getBean().hashCode());
		System.out.println("bean name hashcode\n" + bean.getBean().getName().hashCode());
		System.out.println("clone name hashcode\n" + clone.getBean().getName().hashCode());
		System.out.println("copy name hashcode\n" + copy.getBean().getName().hashCode());
		System.out.println("----浅克隆其中的类中的类没有进行深度克隆,导致bean指向同一位置----");
		
		System.out.println("------------------深度克隆-------------------------");
		DeepBean deep = new DeepBean(1, "xxc", "DL", new Date());
		DeepBean deepClone = (DeepBean) deep.clone();
		DeepBean deepCopy = deep;
		System.out.println(deep);
		System.out.println(clone);
		System.out.println(copy);
		
		System.out.println("------------------地址比较-------------------");
		System.out.println("deep == deepClone \n" + (deep == deepClone?true:false));
		System.out.println("deep == deepCopy\n" + (deep == deepCopy?true:false));
		
		System.out.println("---------------------修改参数测试-----------------------");
		System.out.println("---------------------修改前-----------------------");
		System.out.println("deep\n" + deep.getFrom());
		System.out.println(deep.getFrom().hashCode());
		System.out.println("deepClone\n" + deepClone.getFrom());
		System.out.println("deepClone\n" + deepClone.getFrom());
		System.out.println(deepClone.getFrom().hashCode());
		System.out.println("deepCopy\n" + deepCopy.getFrom());
		System.out.println(deepCopy.getFrom().hashCode());
		System.out.println("---------------------修改deep from----------------------------");
		deep.setFrom("BJ");
		System.out.println("---------------------修改后-----------------------------");
		System.out.println("deep\n" + deep.getFrom());
		System.out.println(deep.getFrom().hashCode());
		System.out.println("deepClone\n" + deepClone.getFrom());
		System.out.println(deepClone.getFrom().hashCode());
		System.out.println("deepCopy\n" + deepCopy.getFrom());
		System.out.println(deepCopy.getFrom().hashCode());
		System.out.println("---------------------修改deep base Name----------------------------");
//		bean.setFrom("SH");
		deep.getBean().setName("wx");
		System.out.println("---------------------修改后-----------------------------");
		System.out.println("deep\n" + deep.getBean().getName());
		System.out.println("deepClone\n" + deepClone.getBean().getName());
		System.out.println("deepCopy\n" + deepCopy.getBean().getName());
		System.out.println("deep base hashcode\n" + deep.getBean().hashCode());
		System.out.println("deepClone base hashcode\n" + deepClone.getBean().hashCode());
		System.out.println("deepCopy base hashcode\n" + deepCopy.getBean().hashCode());
		System.out.println("deep name hashcode\n" + deep.getBean().getName().hashCode());
		System.out.println("deepClone name hashcode\n" + deepClone.getBean().getName().hashCode());
		System.out.println("deepCopy name hashcode\n" + deepCopy.getBean().getName().hashCode());
		System.out.println("----浅克隆其中的类中的类进行深度克隆,类中重新产生了一个新的指向----");
		


		System.out.println("-------------------JSON反序列化----------------------------");
		String str = JSON.toJSONString(bean);
		ExtBean jsonBean = JSON.parseObject(str, ExtBean.class);
		bean.setFrom("DL");
		System.out.println("bean == jsonBean\n" + (bean == jsonBean?true:false));
		System.out.println("bean\n" + bean.getFrom());
		System.out.println("bean.hashcode\n" + bean.hashCode());
		System.out.println(bean.getFrom().hashCode());
		System.out.println("jsonBean\n" + jsonBean.getFrom());
		System.out.println("jsonBean.hash\n" + jsonBean.hashCode());
		System.out.println(jsonBean.getFrom().hashCode());
		System.out.println("-----------实现了Serializable接口的bean通过序列化与反序列化可以实现深度克隆-------------");
		System.out.println("-----------需要注意序列化与反序列化时涉及到的对象都要有Serializable或为基本类型-------------");
	}
	
//	@Test
	public void test() {
		int flag = 37;
		int[] cont = new int[flag];
		for(int i = 0;i<flag;){
			
			cont[i] = ++i;
		}
		cont[3]=1;
		for(int item :cont){
			System.out.println(item);
		}
	}
}
