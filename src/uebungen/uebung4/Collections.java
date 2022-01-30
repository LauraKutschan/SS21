package uebungen.uebung4;

import java.util.*;

public class Collections {
	
	public static List<String> createArrayList(String[] words)
	{
		List<String> list = new ArrayList<>();
		for(int i = 0; i < words.length; i++)
		{
			list.add(words[i]);
		}
		
		return list;
	}
	
	
	public static Set<String> createHashSet(String[] words)
	{
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < words.length; i++)
		{
			set.add(words[i]);
		}
		
		return set;
	}
	
	
	public static Set<String> createTreeSet(String[] words)
	{
		Set<String> set = new TreeSet<>();
		
		for(int i = 0; i < words.length; i++)
		{
			set.add(words[i]);
		}
		
		return set;
	}
	
	public static List<String> findDoublets(List<String> list)
	{
		List<String> copy = new ArrayList<>();
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			copy.add(it.next());
		}
		
		List<String> singles = new ArrayList<>();
		it = copy.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			if(copy.indexOf(s) == copy.lastIndexOf(s))
			{
				singles.add(s);
			}
		}
		copy.removeAll(singles);
		
		return copy;
	}
	
	public static void printList(List<String> list)
	{
		for(String s : list)
		{
			System.out.println(s);
		}
		System.out.println("die Liste hat " + list.size() +" Elemente.");
	}
	
	public static void printSet(Set<String> set) 
	{
		for(String s : set)
		{
			System.out.println(s);
		}
		System.out.println("die Liste hat " + set.size() +" Elemente.");
	}
	
	public static void main(String[] args)
	{
		System.out.printf("------------------------A-----------------------%n");
		
		String[] words = {"Linux", "Apple", "Facebook", "Amazon", "IBM", "Lenovo", "Google", "IBM", "Microsoft", "Apple", "Google", "Twitter", "Skype", "Chrome", "Linux", "Firefox"};
	
		List<String> l1 = createArrayList(words);
		printList(l1);
	
		System.out.printf("%n%n------------------------B-----------------------%n");

		System.out.println("Index des ersten Auftretens von Apple : " + l1.indexOf("Apple") );
		System.out.println("Index des letzten Auftretens von Apple : " + l1.lastIndexOf("Apple") );
		System.out.println("Erstes Element der Liste : " + l1.get(0) );
		System.out.println("Letztes Element der Liste : " + l1.get(l1.size()-1));
		
		System.out.printf("%n%n------------------------C-----------------------%n");

		l1.remove(l1.indexOf("Apple"));
		l1.remove(l1.indexOf("Google"));
		l1.remove(l1.indexOf("Facebook"));
		printList(l1);
		
		System.out.printf("%n%n------------------------D-----------------------%n");
		Set<String> h1 = createHashSet(words);
		printSet(h1);							// Set hat keine doppelten Elemente
	
		System.out.printf("%n%n------------------------E-----------------------%n");
		Set<String> t1 = createTreeSet(words);	// TreeSet sortiert die Elemente
		printSet(t1);
		
		System.out.printf("%n%n------------------------F-----------------------%n");
		List<String> l2 = createArrayList(words);
		System.out.println("Liste mit doppelten Elementen: ");
		printList(findDoublets(l2));
		
	}
}
