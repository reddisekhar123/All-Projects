package sekhar;

//import javax.annotation.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
public static void main(String[] args) {
	
	Resource resource=new ClassPathResource("sekhar/applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(resource);
	 Student student=(Student)factory.getBean("studentbean");
	 student.setName("sanju");
	 student.displayInfo();
	 
	 Student objB=(Student)factory.getBean("studentbean");
	 objB.displayInfo();
}
}
