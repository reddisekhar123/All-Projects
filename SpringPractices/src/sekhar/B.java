package sekhar;

public class B implements ABS {
	
		
		// private static final B obj=new B();
		 private B() {
			 System.out.println("private constructor");
		 }
			 public static ABS getB() {
				 System.out.println("static method");
				 return new C1();

			 }
			 public void msg() {
				 System.out.println("hello user");

			 }
			@Override
			public void display() {
				System.out.println("Display method");
			}
			 
		 }

