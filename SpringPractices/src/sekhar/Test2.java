package sekhar;

    import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	public class Test2 {
		
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("sekhar/applicationContext2.xml");
		
		A a=(A)context.getBean("a");
		a.msg();
	}
	}






