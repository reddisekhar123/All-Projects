package Test;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
class MapDemo{

void DisplayMap(HashMap s){

Set<Entry<String,String>>entries=s.entrySet();

ArrayList<String> map=new ArrayList<String>(s.values());

Collections.sort(map);

System.out.println("after sorting");

Iterator<String>it=map.iterator();

while(it.hasNext()){

String c=it.next();

for(Entry<String,String>e:entries){

String key=e.getKey();

String value=e.getValue();

if(c.compareTo(value)==0){

System.out.println(key+" : "+value);
}
}
}
}
}
public class Question5 {
public static void main(String[] args) {
HashMap<String,String> s= new HashMap<String,String>();
s.put("India","Delhi");
s.put("Afganisthan","Kabul");
s.put("China","Beijing");
s.put("Russia","Moscow");
s.put("Japan","Tokyo");
MapDemo m=new MapDemo();
m.DisplayMap(s);
}

}