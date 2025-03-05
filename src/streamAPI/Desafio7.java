package streamAPI;

import java.util.Arrays;
import java.util.List;

public class Desafio7 {
    
    public static void main(String[] args) {
        //Com a ajuda da Stream API, encontre o segundo maior 
        //número da lista e exiba o resultado no console.

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        numeros.stream()
        .distinct()
        .sorted((a, b) -> Integer.compare(b, a))
        .skip(1)
        .findFirst()
        .ifPresent(n -> System.out.println("Segundo maior número: " + n));
        ;
    }
}
