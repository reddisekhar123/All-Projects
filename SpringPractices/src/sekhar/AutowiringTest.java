package sekhar;

import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
public class AutowiringTest {
 
public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("sekhar/applicationContext5.xml");
		Auto_Wire_Annatation_A a=context.getBean("auto_Wire_Annatation_A",Auto_Wire_Annatation_A.class);
		a.display();

}
}
