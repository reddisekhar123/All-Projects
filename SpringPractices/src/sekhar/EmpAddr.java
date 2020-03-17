package sekhar;

public class EmpAddr {
 private int id;
 private String name;
 private Address address;
 
 public EmpAddr() {
	 System.out.println("def cons");
 }
 public EmpAddr(int id,String name,Address address) {
	 this.id=id;
	 this.name=name;
	 this.address=address;
	 
 }
 void show() {
	 System.out.println(id+" "+name);
	 System.out.println(address.toString());
 }
}
