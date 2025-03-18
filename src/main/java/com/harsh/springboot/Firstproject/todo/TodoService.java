package com.harsh.springboot.Firstproject.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1, "a", "Learn AWS", false ));
		todos.add(new Todo(2, "a", "Learn DevOps", false ));
		todos.add(new Todo(3, "a", "Learn Full Stack Development", false ));
	}
	public List<Todo> findbyusername(String username){
		return todos;
	}
}
