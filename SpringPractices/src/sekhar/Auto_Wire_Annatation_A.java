package sekhar;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	@Component
	public class Auto_Wire_Annatation_A {
	@Autowired
	Auto_Wire_Annatation_B b;
	Auto_Wire_Annatation_A(){
	System.out.println("a is created");
	}
	public 	Auto_Wire_Annatation_B getB() {
	return b;
	}
	public void setB(Auto_Wire_Annatation_B b) {
	this.b=b;
	}
	void print() {
	System.out.println("hello a");
	}
	void display() {
	print();
	b.print();
	}
	}

