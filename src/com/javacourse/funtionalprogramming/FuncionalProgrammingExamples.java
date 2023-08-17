package com.javacourse.funtionalprogramming;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FunctionalProgrammingMagic {
    // Utiliza la API de Stream para operar en la lista
    /**
     * This method filters out the odd numbers from a given list of integers.
     * @param numbers This is the list of integers from which odd numbers are to be filtered out.
     * @return List<Integer> This returns a list of odd integers.
     */
    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
            
            //Utilizando Funcional Programming
            return numbers.stream() //Se llama a stream 
                .filter(num -> num%2 != 0) //Se filtra
                .collect(Collectors.toList()); //Se convierte en a lista 
                
    }
    
    /**
     * This method generates the cubes of the first n natural numbers.
     * @param n The number of natural numbers for which cubes are to be calculated.
     * @return List<Integer> This returns a list of cubes of the first n natural numbers.
     */
    public static List<Integer> getCubesOfFirstNNumbers(int n) {
        return IntStream.range(1,n+1) //Se crea un Stream de numeros
            .map(num-> num*num*num) //Los cubos de los numeros
            .boxed() //Transforma el IntStream en un flujo de objetos Stream<Integer>.
            .collect(Collectors.toList()); //Convierte a lista
    }
    
    /**
     * In this problem, you are required to complete the getCourseNameCharacterCount() 
     * function inside the FunctionalProgrammingMagic class. 
     * This function receives a list of course names and returns a 
     * list of the character counts of each course name.
     * */
    public static List<Integer> getCourseNameCharacterCount(List<String> courses) {
        // Verifica si la lista 'courses' es nula
        if (courses == null) {
            // Si es nula, devuelve una lista vacía usando List.of()
            return List.of();
        }

        // Mapea la longitud de cada nombre de curso a un nuevo Stream de enteros
        // que representa la cantidad de caracteres en cada nombre de curso
        return courses.stream()
                      .map(String::length)
                      // Recolecta los valores mapeados en una lista de enteros
                      .collect(Collectors.toList());
    }

    
    /**
     * You have to implement a function named sumOfSquares 
     * in the class FunctionalProgrammingMagic which takes 
     * a list of integers as input and returns the sum of squares 
     * of these integers.
     * 
     * */
 public static long sumOfSquares(List<Integer> numbers) {
        
        // Check if the list is null. If so, return 0.
        if(numbers == null){
            return 0;
        }

        // Stream over the list of numbers, find squares and sum them up
        return numbers.stream()
                .mapToLong(num -> num * num)
                .sum();
    }
 
 /**
  * In this task, you are given a list of integers. 
  * Your task is to complete the function findMaxEvenNumber, 
  * which returns the maximum even number from the list.
  *  If the list is null or doesn't contain any even numbers, return 0.
  * */
 
 public static int findMaxEvenNumber(List<Integer> numbers) {
	    // Verifica si la lista 'numbers' es nula o está vacía
	    if (numbers == null || numbers.isEmpty()) {
	        // Si es nula o está vacía, devuelve 0
	        return 0;
	    }

	    // Crea un flujo (stream)
	    Optional<Integer> maxEven = numbers.stream()
	                                       .filter(num -> num % 2 == 0)  // Filtra los números pares del flujo
	                                       .max(Integer::compare); 	    // Encuentra el número par máximo utilizando 'max'

	    // Devuelve el número par máximo o 0 si no se encuentra ninguno
	    return maxEven.orElse(0);
	}

    
}

public class FuncionalProgrammingExamples {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> courses = List.of("Java", "Python", "C++", "JavaScript", "Ruby");
        
        // Test filterOddNumbers method
        List<Integer> oddNumbers = FunctionalProgrammingMagic.filterOddNumbers(numbers);
        System.out.println("Odd Numbers: " + oddNumbers);

        // Test getCubesOfFirstNNumbers method
        int n = 5;
        List<Integer> cubes = FunctionalProgrammingMagic.getCubesOfFirstNNumbers(n);
        System.out.println("Cubes of first " + n + " numbers: " + cubes);

        // Test getCourseNameCharacterCount method
        List<Integer> courseNameCharacterCounts = FunctionalProgrammingMagic.getCourseNameCharacterCount(courses);
        System.out.println("Course name character counts: " + courseNameCharacterCounts);

        // Test sumOfSquares method
        long sumSquares = FunctionalProgrammingMagic.sumOfSquares(numbers);
        System.out.println("Sum of squares: " + sumSquares);

        // Test findMaxEvenNumber method
        int maxEven = FunctionalProgrammingMagic.findMaxEvenNumber(numbers);
        System.out.println("Max even number: " + maxEven);
	}

}
