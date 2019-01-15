package Locale;

import java.util.TreeMap;
import java.util.Map.Entry;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Locale;


public class LocaleKeeper
	{
		// A class to display Locales to the console, with minimal dependencies on other classes
		// TreeMap is used for automatic sorting
		
		private static TreeMap<String, String> countriesToCode = new TreeMap<String, String>();
		private static TreeMap<String, String> codeToCountries = new TreeMap<String, String>();
		private static String[] countryCodes = Locale.getISOCountries();

		public static void main(String[] args)
			{
				for (String cc : countryCodes) 
					{
					countriesToCode.put(new Locale("", cc).getDisplayCountry(), cc.toUpperCase());
					codeToCountries.put(cc.toUpperCase(), new Locale("", cc).getDisplayCountry());
					}

				HashMapToConsole(codeToCountries);
				System.out.println(getLocaleFromCode("us"));
				System.out.println(getCodeFromLocale("united States"));
			}
		
		public static void HashMapToConsole(TreeMap<String, String> TempTreeMap)
			{			
				for(Entry<String, String> entry : TempTreeMap.entrySet()) 
					{
	//			    String key = entry.getKey();
	//			    String value = entry.getValue();
	//
	//			    System.out.println(key + " = " + value);
					System.out.println(entry.toString());
					}
				
				System.out.println("Total Locales: " + TempTreeMap.size());
			}

		/* -------------------------------- Getters & Setters  -------------------------------- */

		public static String getLocaleFromCode(String Code_str)
			{
			Code_str = Code_str.toUpperCase();
			return codeToCountries.get(Code_str);
			}
		
		public static String getCodeFromLocale(String Locale_str)
			{
			Locale_str = StringUtils.capitalize(Locale_str);
			return countriesToCode.get(Locale_str);
			}
		/* -------------------------------- End Getters & Setters  -------------------------------- */
	}
