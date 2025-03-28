package com.harsh.springboot.Firstproject.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	public String getvalue(ModelMap model) {
		String username= (String) model.get("name");
		Todo todo=new Todo(0,username,"Default Desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "new_todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String getnewvalue(ModelMap model,@Valid Todo todos,BindingResult result) {
		if(result.hasErrors()) {
			return "new_todo";
		}
		String username= (String) model.get("name");
		todoService.addtodo(username, todos.getDescription(), todos.getTargetDate(), true);
		return "redirect:list-todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		todoService.deleteById(id);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "new_todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "new_todo";
		}
		
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todo";
	}
}