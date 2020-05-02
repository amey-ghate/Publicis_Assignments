package com.sapient.week3;

import java.util.*;

public class Alphabet_Prime_Hex_mapper {
    public static HashMap<Character, Integer> getPrimeList(int count){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        int index = 0;
        for (int i = 1; i<Integer.MAX_VALUE; i++) {
            if(count == 0){
                break;
            }
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                hmap.put(alphabet[index],i);
                index = index+1;
                count = count - 1;
            }
        }
        return hmap;
    }

    public static void HexaCode(String input){
        try{
            HashMap<Character, Integer> hmap = getPrimeList(26);
            StringBuilder output = new StringBuilder();
            input = input.toLowerCase();
            for(int i =0;i<input.length();i++){
                char c = input.charAt(i);
                output.append(Integer.toHexString(hmap.get(c)));
            }
            System.out.println(output.toString().toUpperCase());
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("use only alpha string");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HexaCode(input);
        sc.close();
      }
}