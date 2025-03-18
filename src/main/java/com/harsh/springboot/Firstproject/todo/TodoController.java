package com.harsh.springboot.Firstproject.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String getvalue() {
		return "new_todo";
	}
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String getnewvalue(@RequestParam String description,ModelMap model) {
		String username= (String) model.get("name");
		todoService.addtodo(username, description, true);
		
		return "redirect:list-todo";
	}
}