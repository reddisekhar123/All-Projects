package sekhar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Autowiring1 {

	Autowiring b;
	Autowiring1(){
		System.out.println("a is created");
	}
public Autowiring getAutowiring() {
		return b;
	}
	public void setAutowiring2(Autowiring b) {
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
