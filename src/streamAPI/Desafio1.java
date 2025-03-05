package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Desafio1 {

//	Desafio 1 - Mostre a lista na ordem numérica:
//		Crie um programa que utilize a Stream API para ordenar a lista de números em ordem crescente e a exiba no console.
	
	public static void main(String[] args) {
	    
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		List<Integer> numerosOrdenados = numeros.stream().sorted().toList();
			
		numerosOrdenados.forEach(System.out::println);
			

		
		
	}
}
