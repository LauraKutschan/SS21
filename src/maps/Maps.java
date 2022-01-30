package maps;

import java.util.*;		// Wildcard Operator *

public class Maps {

	public static void main(String[] args)
	{
		/*
		 * in Maps speicher wir Schluessel-Werte-Paare
		 * Schluessel sind eindeutig (keine Doppelungen), Schluesseltyp K
		 * Werte können mehrdeutig sein (sich doppeln), Wertetyp V
		 * statt add(), addAll() --> put(), putAll()
		 */
		
		Map<String, Integer> mapA = new HashMap<>();
		mapA.put("A", 1);
		mapA.put("B", 2);
		mapA.put("C", 3);
		
		/*
		 * ein einzelnes Schluessel-Werte-Paar ist vom Typ Map.Entry
		 * typisiert: Map.Entry<K, V>
		 * unser Beispiel: Map.Entry<String, Integer>
		 */
		
		/*
		 * leider kein iterator() zur Verfügung, sondern entrySet()
		 * entrySet() erzeugt eine Set von lauter Schluessel-Werte-Paaren
		 */
		
		Set<Map.Entry<String, Integer>> allEntriesFromMapA = mapA.entrySet();	// nur Zwischenspeicherung von mapA.entrySet()
		
		for(Map.Entry<String, Integer> entry : allEntriesFromMapA)
		{
			System.out.println("Schluessel: " + entry.getKey() + "  Wert: " + entry.getValue());
			System.out.println(entry);
		}
		
		System.out.printf("%n%n-----------ohne Zwischenspeicherung von mapA.entrySet()------------%n");
		for(Map.Entry<String, Integer> entry : mapA.entrySet())
		{
			System.out.println("Schluessel: " + entry.getKey() + "  Wert: " + entry.getValue());
			System.out.println(entry);
		}
		
		System.out.printf("%n%n-----------contains()----------------------------------------------%n");
		System.out.println("B enthalten? : " + mapA.containsKey("B"));
		System.out.println("D enthalten? : " +mapA.containsKey("D"));
		
		
		System.out.printf("%n%n-----------Wert des Eintrages, in dem B der Schlüssel ist----------%n");
		System.out.println(mapA.get("B"));
		
		
		System.out.printf("%n%n-----------Schlüssel speichern-------------------------------------%n");
		Set<String> allKeys = mapA.keySet();					

		for(String key : allKeys)
		{
			System.out.println("key : " + key);
		}
		
		System.out.printf("%n%n-----------Values speichern-------------------------------------%n");
		Collection<Integer> allValues = mapA.values();
		
		for(Integer value : allValues)
		{
			System.out.println("value : " + value);
		}
		
		System.out.printf("%n%n-----------etwas hinzufügen, was es schon gibt--> Wert wird mit neuem ersetzt-%n");
		mapA.put("B", 5);
		for(Map.Entry<String, Integer> entry : mapA.entrySet())
		{
			System.out.println("Schluessel: " + entry.getKey() + "  Wert: " + entry.getValue());
			System.out.println(entry);
		}
		
		System.out.printf("%n%n-----------neue Map-------------------------------------------------%n");
		Map<String, Integer> mapB = new HashMap<>();
		mapB.put("B", 6);
		mapB.put("D", 7);
		
		for(Map.Entry<String, Integer> entry : mapB.entrySet())
		{
			System.out.println("Schluessel: " + entry.getKey() + "  Wert: " + entry.getValue());
			System.out.println(entry);
		}
		
		System.out.printf("%n%n-----------Map kopieren-------------------------------------------------%n");
		mapA.putAll(mapB);
		
		for(Map.Entry<String, Integer> entry : mapA.entrySet())
		{
			System.out.println("Schluessel: " + entry.getKey() + "  Wert: " + entry.getValue());
			System.out.println(entry);
		}
		
	
	}
}
