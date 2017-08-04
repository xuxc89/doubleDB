package cn.example.doubleDB.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReflectionController {
	
	public void getClassInfo() {
		Class<String> plan_a = String.class;
		Class<? extends String> plan_b = new String().getClass();
		String str = null;
		Class<? extends String> plan_c = str.getClass();
		try {
			/**
			 * 唯一一个动态获得的模式，可能会出现在地址中未找到文件 故要声明classnotfound异常
			 */
			Class<?> plan_d = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> copy = Class.forName("cn.example.doubleDB.controller.FinallyController");

		Object obj = copy.newInstance();
		System.out.println(obj.getClass());
	}

	@Test
	/**
	 * 反编译
	 * 
	 * @author xxc
	 * @since 2017年7月10日 上午11:49:44 ReflectionController.java TODO
	 */
	public void Decompile() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> copy = Class.forName("cn.example.doubleDB.controller.FinallyController");
		// Class<?> copy = Class.forName("java.lang.String");
		// 获得注释注释
		Annotation[] an = copy.getAnnotations();
		for (Annotation item : an) {
			System.out.println(item);
		}
		// 注释结束
		// 标识类开始
		System.out.print(Modifier.toString(copy.getModifiers()) + " class " + copy.getSimpleName());
		// 获得继承父类
		System.out.print(" extends " + copy.getSuperclass().getSimpleName());
		// 获得实现接口
		Class<?>[] type = copy.getInterfaces();
		for (int i = 0; i < type.length; i++) {
			if (i == 0) {
				System.out.print(" implements ");
			}
			if (i == type.length - 1) {
				System.out.print(type[i].getSimpleName());
			} else {
				System.out.print(type[i].getSimpleName() + ",");
			}
		}
		System.out.println("{");

		// 获得参数列表
		// Field[] fs = copy.getFields();
		System.out.println("----------------------------属性------------------------------------");
		// for (Field one :fs) {
		// System.out.print(Modifier.toString(one.getModifiers()));
		// System.out.print(one.getGenericType());
		// System.out.println(one.getName());
		// }
		Field[] fs = copy.getDeclaredFields();
		for (Field one : fs) {
			System.out.print("\t" + Modifier.toString(one.getModifiers()) + " ");
			// System.out.print(one.getType()+" ");
			System.out.print(one.getGenericType() + " ");
			System.out.println(one.getName() + "()");
		}
		// 获得构造方法列表
		System.out.println("----------------------------构造方法------------------------------------");
		Constructor<?>[] cs = copy.getDeclaredConstructors();
		for (Constructor item : cs) {
			System.out.print("\t" + Modifier.toString(item.getModifiers()) + " ");
			// System.out.print(item.getParameterTypes());

			// System.out.println();
			System.out.print(copy.getSimpleName() + " (");
			Class[] cl = item.getParameterTypes();
			for (int i = 0; i < cl.length; i++) {
				if (i == cl.length - 1) {
					System.out.print(cl[i].getSimpleName());
				} else {
					System.out.print(cl[i].getSimpleName() + ",");
				}

			}
			System.out.println(")");
		}
		// 获得构造方法列表

		// 方法列表
		System.out.println("----------------------------方法------------------------------------");
		Method[] m = copy.getMethods();
		for (Method item : m) {
			System.out.print("\t" + Modifier.toString(item.getModifiers()));
			System.out.print(" " + item.getReturnType());
			System.out.print(" " + item.getName());
			System.out.print(" (");
			Class[] classes = item.getParameterTypes();
			for (int i = 0; i < classes.length; i++) {
				if (i == classes.length - 1) {
					System.out.print(classes[i].getSimpleName());
				} else {
					System.out.print(classes[i].getSimpleName() + ",");
				}
			}
			System.out.println(")" + "{}");
		}
		// 方法列表结束
		System.out.println("}//类结束");
	}

	public void getType() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> copy = Class.forName("cn.example.doubleDB.controller.FinallyController");
		String param01 = copy.getTypeName();
		System.out.println(param01);
		TypeVariable<?>[] type = copy.getTypeParameters();
		for (TypeVariable item : type) {
			System.out.println(item);
		}
	}

	// @Test
	// public void getField() throws Exception {
	// Class<?> copy =
	// Class.forName("cn.example.doubleDB.controller.FinallyController");
	//// Field f = copy.getField("returnString");
	//// System.out.println(f);
	// }

}
