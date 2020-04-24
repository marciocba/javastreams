package br.com.moraes.treinamento.oo.streams.demo;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		total();
		total2();

	}
	static void total() {
	List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
	Integer sum = integers.stream()
	  .reduce(1, (a, b) -> a + b);
	System.out.println("total:"+sum);
	}
	
	static void total2() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream()
		  .reduce(0, Integer::sum);
		System.out.println("total:"+sum);
		}
}
