package com.harsh.springboot.Firstproject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int count=0;
	static {
		todos.add(new Todo(count++, "a", "Learn AWS", LocalDate.now().plusYears(1), false ));
		todos.add(new Todo(count++, "a", "Learn DevOps", LocalDate.now().plusYears(2), false ));
		todos.add(new Todo(count++, "a", "Learn Full Stack Development", LocalDate.now().plusYears(1), false ));
	}
	
	public List<Todo> findbyusername(String username){
		return todos;
	}
	public void addtodo(String username,String description,LocalDate targetdate, boolean done) {
		Todo todo=new Todo(count++,username,description,targetdate,done);
		todos.add(todo);
	}
	public void deleteById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
	
}
