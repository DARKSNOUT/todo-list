package com.harsh.springboot.Firstproject.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int count=0;
	static {
		todos.add(new Todo(count++, "a", "Learn AWS", false ));
		todos.add(new Todo(count++, "a", "Learn DevOps", false ));
		todos.add(new Todo(count++, "a", "Learn Full Stack Development", false ));
	}
	public List<Todo> findbyusername(String username){
		return todos;
	}
	public void addtodo(String username,String description,boolean done) {
		Todo todo=new Todo(count++,username,description,done);
		todos.add(todo);
	}
}
