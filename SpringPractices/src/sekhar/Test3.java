package sekhar;


	

    import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	
	
	public class Test3 {	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("sekhar/applicationContext3.xml");
		ABS p=(ABS)context.getBean("a");
		p.display();
		//B.getA();
		//Printable p=(Printable)context.getBean("p");  
		//p.print();
	}
	}








