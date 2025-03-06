 package com.example.ToDoApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.ToDoApplication.Entity.ToDoEntity;
import com.example.ToDoApplication.Service.ToDoServiceClass;

@Controller
public class ToDoController{
@Autowired
private ToDoServiceClass service;

@GetMapping({"/", "viewToDoList"})
public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
	model.addAttribute("list", service.getAllToDoItems());
	model.addAttribute("message", message);
	
	return "ViewToDoList";
}

@GetMapping("/updateToDoStatus/{id}")
public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	if(service.updateStatus(id)) {
		redirectAttributes.addFlashAttribute("message", "update Sucess");
		return "redirect:/viewToDoList";
	}
	redirectAttributes.addFlashAttribute("message", "update Failure");
	return "redirect:/viewToDoList";
}

@GetMapping("/addToDoTask")
public String addToDoItem(Model model) {
	model.addAttribute("todo", new ToDoEntity());	
	return "AddToDoTask";
}

@PostMapping("/saveToDoTask") 
public String saveToDoItem(ToDoEntity todo, RedirectAttributes redirectAttributes) {
	if(service.saveOrUpdateToDoItem(todo)) {
		redirectAttributes.addFlashAttribute("message", "Save Success");		
		return "redirect:/viewToDoList";
	}
	
	redirectAttributes.addFlashAttribute("message", "Save Failure");
	return "redirect:/addToDoTask";
}

@GetMapping("/editToDoTask/{id}")
public String editToDoItem(@PathVariable Long id, Model model) {
	model.addAttribute("todo", service.getToDoItemById(id));
	
	return "EditToDoTask";
}

@PostMapping("/editSaveToDoTask")
public String editSaveToDoItem(ToDoEntity todo, RedirectAttributes redirectAttributes) {
	if(service.saveOrUpdateToDoItem(todo)) {
		redirectAttributes.addFlashAttribute("message", "Edit Success");
		return "redirect:/viewToDoList";
	}
	
	redirectAttributes.addFlashAttribute("message", "Edit Failure");
	return "redirect:/editToDoTask" + todo.getId();
}

@GetMapping("/deleteToDoTask/{id}")
public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	if (service.deleteToDoItem(id)) {
		redirectAttributes.addFlashAttribute("message", "Delete Success");
		return "redirect:/viewToDoList";
	}
	
	redirectAttributes.addFlashAttribute("message", "Delete Failure");
	return "redirect:/viewToDoList";
}

}                         