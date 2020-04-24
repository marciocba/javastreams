package br.com.moraes.treinamento.oo.streams.demo;

import java.util.function.Function;

public class UseTodo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseTodo useTodo = new UseTodo();
		Todo todo = parameter -> parameter + " from lambda";
		String result = useTodo.add("Message ", todo);
		System.out.println(result);
		
		Function<String, String> fn =
				parameter -> parameter + " from lambda";
		String result2 = useTodo.add2("I've added something", fn);
		System.out.println(result2);		
	}
	@FunctionalInterface
	public interface Todo {
	String method(String string);
	}
	
	public  String add(String string, Todo todo) {
		return todo.method(string);
	}
	public  String add2(String string, Function<String, String> fn) {
		return fn.apply(string);
		}
}
