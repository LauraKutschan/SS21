package wrapperklassen;

import java.util.*;

public class Wrapper {

	public static void main(String[] args)
	{
		Set<String> s1 = new HashSet<>();
		
		Set<MYInteger> s2 = new HashSet<>(); 			// MYInteger = Referenztyp
		
		MYInteger i1 = new MYInteger(7);
		s2.add(i1);
		
		for(MYInteger element : s2)
		{
			System.out.println(element.getValue());		// getValue, weil value = privat
		}
		
		/*
		 *  3  Moeglichkeiten der Objekterzeugung
		 *  1. Konstruktor - deprecated (nicht verwenden)
		 *  2. valueOf() - Methode
		 *  3. "Boxing" 
		 *  
		 */
		
	
		int iWert1 = 12;
		String iString1 = "12";
		
		// 1. Konstruktor (nur zur Information, nicht verwenden!)
		Integer iReferenz1 = new Integer(iWert1);
		System.out.println(iReferenz1.toString());		//toString() nicht unbedingt nötig
		
		Integer iReferenz2 = new Integer(iString1);
		System.out.println(iReferenz2.toString());		//toString() nicht unbedingt nötig
	
		
		
	
		// 2. valueOf() --> (statische Methode)
		Integer iReferenz3 = Integer.valueOf(iWert1);
		Integer iReferenz4 = Integer.valueOf(iString1);

		System.out.println(iReferenz3.toString());
		System.out.println(iReferenz4.toString());

	
		
		
		// 3. Auto-Boxing
		Integer iReferenz5 = 1000;							// Auto-Boxing
		Integer iReferenz6 = 1000;
		
		System.out.println(iReferenz5.toString());
		System.out.println(iReferenz6.toString());

		System.out.println(iReferenz5 == iReferenz6);		// false, weil sie trotz gleichem Wert auf zwei unterschiedliche Objekte zeigen 
	
		System.out.println(iReferenz5 >= iReferenz6);		// Auto-Unboxing
	
		// weitere Beispiele für Auto-Boxing
		Double d1 = 5.5;
		Float f1 = 3.4f;
		Long l1 = 12345L;
		Boolean b1 = true;
	}
}
