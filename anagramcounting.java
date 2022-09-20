package workTest;

import java.math.*;

import java.util.*;

//import java.util.stream.Collectors;


public class anagramcounting {
	
	public static void main(String args[]) {
		

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			nrAnagrams(sc.next());
		}
		
		sc.close();

		
	}
	
	public static void nrAnagrams(String bird) {

		
		HashMap<Character, Integer> lettersDuplicates = new HashMap<Character,Integer>();
		//List <Character> ch=(List<Character>) bird.chars().mapToObj(e->(char)e).collect(Collectors.toList());;
		
		char [] Array = bird.toCharArray();
		
		for(char temp : Array) {
			if(lettersDuplicates.containsKey(temp)) {
				lettersDuplicates.put(temp, lettersDuplicates.get(temp)+1);
			}else {
				lettersDuplicates.put(temp, 1);
			}
			
		}
		
		
		BigInteger divisor = BigInteger.valueOf(1);
		
		for(Map.Entry<Character, Integer> entry: lettersDuplicates.entrySet()) {
			if(!entry.getValue().equals(1))
				divisor=divisor.multiply(factorial(entry.getValue()));
			
		}

		BigInteger anwser = factorial(bird.length()).divide(divisor);
		
		
		System.out.println(anwser);
	}
	
	public static BigInteger factorial(int fac) {
		BigInteger anwser = BigInteger.valueOf(1);
		for(int i =fac;i>0;i--) {
			anwser=anwser.multiply(BigInteger.valueOf(i));
		}
		return anwser;
	}

}
