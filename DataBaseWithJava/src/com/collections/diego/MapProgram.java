package com.collections.diego;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
		
	public static void main(String[] args) {
		Map<String,String> languages=new HashMap<>();
		languages.put("Java", "a compiled high level, object-oriented, plataform indepedient language");
		languages.put("Python", "an");
		languages.put("Algon", "an algorithmic language");
		languages.put("Basic", "Beginners all purposes Symbol");
		
		if (languages.containsKey("Java")) {
			System.out.println("Java is already in the map");
		}else{
			languages.put("Java", "a compiled high level, object-oriented, plataform indepedient language");
		}
		
		if(languages.remove("Python", "an")){
			System.out.println("Python removed");
		}else{
			System.out.println("Python not removed, key/value pair not found");
		}
		
		System.out.println(languages.replace("Algon","Just a hard language"));
		System.out.println(languages.replace("Scale","This will not added"));
		
		for(String key: languages.keySet()){
			System.out.println(key + ":" 
					+ languages.get(key));
		}
		
	}
}
