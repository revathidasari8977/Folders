package com.ty;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileDriver {
	public static void main(String[] args) {
		
//		BeanFactory beanFactory=new ClassPathXmlApplicationContext("person.xml");
//		Mobile mobile=(Mobile) beanFactory.getBean("mobile");
//		
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("mobile.xml");//here we give xml file name
		Mobile mobile= (Mobile) beanFactory.getBean("mobile");
		mobile.usedFor();
		
		
	}
}
//spring application context
//2.spring  xml configuration in java guide-->both can be used in xml file