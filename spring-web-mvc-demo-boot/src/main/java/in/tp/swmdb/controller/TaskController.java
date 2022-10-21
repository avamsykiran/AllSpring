package in.tp.swmdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class TaskController {

	private List<String> taskList;
	
	public TaskController() {
		this.taskList=new ArrayList<>();
	}
	
	@GetMapping("/tasks")
	public ModelAndView showTasks() {
		return new ModelAndView("tasksPage","tasks",taskList);
	}
	
	@GetMapping("/addTask")
	public ModelAndView addTask(@RequestParam("task") String task) {
		this.taskList.add(task);
		return new ModelAndView("tasksPage","tasks",taskList);
	}
	
	@GetMapping("/delTask")
	public ModelAndView delTask(@RequestParam("task") String task) {
		this.taskList.remove(task);
		return new ModelAndView("tasksPage","tasks",taskList);
	}
}
