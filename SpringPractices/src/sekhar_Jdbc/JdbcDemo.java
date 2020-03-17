package sekhar_Jdbc;



	import org.springframework.context.ConfigurableApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class JdbcDemo {

	public static void main(String[] args) {

	String confFile="sekhar_Jdbc/springDatabase.xml";
	ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(confFile);
	EmployeeDao empDao=(EmployeeDao)context.getBean("employeeDao");
	Employee1 emp=empDao.findEmployeeById(846740);
	System.out.println(emp.getName()+"|"+emp.getSalary()+"|"+emp.getDept());
	}

	}



