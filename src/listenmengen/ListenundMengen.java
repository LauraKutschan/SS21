package listenmengen;

import java.util.*; 			// alle Klassen aus Java.util importiert, die wir gebrauchen

public class ListenundMengen {

	public static void main (String[] args)
	{
		Set<String> set1 = new HashSet<>();
		Set set2 = new TreeSet();
		
		String s1 = "erster";
		String s2 = "zweiter";
		String s3 = "dritter";
		String s4 = "zweiter";
		
		Integer i1 = 1;
		
		System.out.println("----------Hinzugefügt?------------------------");
		System.out.println(set1.add(s1));
		System.out.println(set1.add(s2));
		System.out.println(set1.add(s3));
		System.out.println(set1.add(s4));
		// System.out.println(set1.add(i1));  --> geht nicht, da kein String
		
		System.out.println("----------Wie viel Elemente in set1?----------");
		System.out.println(set1.size());
		
		System.out.println("----------Elemente auflisten mit Iterator-----");
		Iterator it = set1.iterator();				// wie for-Schleife bei Arrays zum durchgehen
		while(it.hasNext()) 						// Iterator kann auch typ haben
		{
			System.out.println(it.next());
		}
		
		System.out.println("----------Elemente auflisten mit for-each-----");
		for(String element : set1)				// for-each-Schleife
		{
			System.out.println(element);
		}
		
		set1.remove("erster");

		System.out.println("----------Elemente auflisten nach Löschung----");
		for(String element : set1)				// for-each-Schleife
		{
			System.out.println(element);
		}
		
		System.out.printf("%n%n----------ArrayList---------------------------%n");
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new LinkedList<>();
		
		l1.add(s1);
		l1.add(s2);
		l1.add(s3);
		l1.add(s4);
		
		for(String s : l1)
		{
			System.out.println(s);
		}
		
		System.out.println("----------Wie viel Elemente in set1?----------");
		System.out.println(l1.size());
		
		System.out.println("----------Elemente gelöscht?------------------");
		System.out.println(l1.remove("zweiter"));
		System.out.println("geloescht: " + l1.remove(1));
		System.out.println(l1.remove("vierter"));
		
		System.out.println();
		for(String s : l1)
		{
			System.out.println(s);
		}
		
		
		System.out.printf("%n%n----------LinkedList---------------------------%n");
		l2.add("neu");
		l2.add("alt");
		
		for(String s : l2)
		{
			System.out.println(s);
		}
		
		System.out.printf("%n%n----------Beide Listen-------------------------%n");
		l1.addAll(l2);
		
		for(String s : l1)
		{
			System.out.println(s);
		}
		
	}
}
