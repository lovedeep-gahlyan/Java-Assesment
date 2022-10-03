package Assesment;
import java.util.*;
import java.util.Map.Entry;

class People
{
	String name;
	String type;
	String toothpaste;
	static int colgate,pepsodent,patanjali,dabar;
	public People(String name, String type, String toothpaste) {
		super();
		this.name = name;
		this.type = type;
		this.toothpaste = toothpaste;
	}
	
	
}

public class Survey {
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter no of people in survey");
		int num = ob.nextInt();
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i=0; i<num; i++) {
			System.out.println("Enter name");
			String name = ob.next();
			System.out.println("Enter type");
			String type = ob.next();
			System.out.println("Enter toothpaste");
			String toothpaste = ob.next();
			People p = new People(name,type,toothpaste);
			if(p.toothpaste.equals("colgate")) {
				p.colgate = p.colgate + 1;
				hm.put(p.toothpaste, p.colgate);
			}
			else if(p.toothpaste.equals("dabar")) {
				p.dabar++;
				hm.put(p.toothpaste, p.dabar);
			}
			else if(p.toothpaste.equals("pepsodent")) {
				p.pepsodent++;
				hm.put(p.toothpaste, p.pepsodent);
			}
			else if(p.toothpaste.equals("patanjali")) {
				p.patanjali++;
				hm.put(p.toothpaste, p.patanjali);
			}
			
		}
		
		int maxValueInMap = (Collections.max(hm.values()));
		for (Entry<String, Integer> entry :
            hm.entrySet()) {

           if (entry.getValue() == maxValueInMap) {

               System.out.println(entry.getKey());
           }
       }
	}
}
