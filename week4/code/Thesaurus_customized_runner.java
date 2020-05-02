package com.sapient.week4;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Thesaurus_customized_runner {

	public static void main(String[] args) {
		MapExample example = new MapExample();
		example.populateMap();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Set<String> findInMap= example.mp.get(input);
		Set<String> inputSet = new HashSet<>();
		String line;
		if(findInMap == null) {
			System.out.println("Unable to  locate the present key in map.");
			System.out.println("Would you like to add the key in the map ?");
			System.out.println("Y/N");
			String choice = sc.nextLine();
			if(choice.equalsIgnoreCase("Y")) {

			    while (sc.hasNextLine()){   
			       line=sc.nextLine();  
			       if(line.isEmpty()){      
			           break;
			       }           
			       inputSet.add(line);
			    }
				example.mp.put(input, inputSet);
			} else if(choice.equalsIgnoreCase("Y")) {
				System.out.println("___SAYONARA___");
			} else {
				System.out.println("Please enter a vaild input and try again.");
			}
			if(choice.equalsIgnoreCase("Y")) {
				System.out.println("\nUpdated value of map is \n");
				for(String i : example.mp.keySet()) {
					System.out.println("key is " + i + " ,value is "+ example.mp.get(i));
				}
			}
		} 
		else {
			System.out.println(findInMap);
		}
	}

}