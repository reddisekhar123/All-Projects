package Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class Day{
	String[] days(String s,String s1,String s2)throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf.parse(s);
		Date d2=sdf.parse(s1);
		Date d3=sdf.parse(s2);
		SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
		String[] a=new String[3];
		a[0]=sdf1.format(d1);
		a[1]=sdf1.format(d2);
		a[2]=sdf1.format(d3);
		
		return a;
	}
}
public class Question2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter dates");
		String s1=s.nextLine();
		String s2=s.nextLine();
		String s3=s.nextLine();
		Day d=new Day();
		String[] o = null;
		try {
			o = d.days(s1, s2, s3);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		for(String e:o){
			System.out.println(e);
		}
		}
	}
		