package com.harsh.springboot.Firstproject.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService=todoService;
	}
	
	private TodoService todoService;
	
	
	
	@RequestMapping("list-todo")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findbyusername("in28minutes");
		model.addAttribute("todos",todos);
		return "todo";
	}
}