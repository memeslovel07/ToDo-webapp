package com.example.ToDO_web.controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ToDO_web.model.ToDo;
import com.example.ToDO_web.service.ToDOservice;

@Controller
public class ToDoController {
	 @Autowired
	private ToDOservice service;
	 @GetMapping({"/","ViewToDoList"})
	 public String viewAllToDoItems(Model model,@ModelAttribute("message") String message) {
		 
		 model.addAttribute("list", service.getAllToDoItems());
		 model.addAttribute("message", message);
		 return "ViewToDoList";
		 
	 }
	 @GetMapping("/updateToDostatus/{id}")
 public String updateToDoStatus(@PathVariable Long id,RedirectAttributes redirectAttributes) {
		 if(service.updateStatus(id)) {
			 redirectAttributes.addFlashAttribute("message", "Updated Success");
			 return "redirect:/ViewToDoList";
		 }
		 redirectAttributes.addFlashAttribute("message", "Updated Failure");
		 return "redirect:/ViewToDoList";
	 }
 @GetMapping("/addToDoItem")
 public String addToDoItem(Model model) {
model.addAttribute("todo", new ToDo());
return "AddToDoItem";
 }
 @PostMapping("/saveToDoItem")
 public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
	
	if(service.saveOrUpdateToDoItems(todo)) {
		redirectAttributes.addFlashAttribute("message", "Save Success");
		return "redirect:/ViewToDoList";
	}
	redirectAttributes.addFlashAttribute("message", "Save Failure");
	return "redirect:/addToDoItem";
 }
 @GetMapping("/editToDoItem/{id}")
 public String editToDoItem(@PathVariable Long id,Model model) {
	 model.addAttribute("todo",service.getToDoitemsById(id));
	 
	 return "EditToDoItem";
 }
 @PostMapping("/editSaveToDoitem")
 public String editsaveToDoItem(ToDo todo,RedirectAttributes redirectAttributes) {
	 if(service.saveOrUpdateToDoItems(todo)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/ViewToDoList";
		}
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editToDoItem/"+ todo.getId();
 }
 @GetMapping("/deleteToDoItem/{id}")
 public String deleteToDoItem(@PathVariable Long id,RedirectAttributes redirectAttributes) {
	 
	 if(service.deleteToDoItems(id)) {
		 redirectAttributes.addFlashAttribute("message", "Delete Success");
		 return "redirect:/ViewToDoList";
	 }
	 redirectAttributes.addFlashAttribute("message", "Delete Failure");
	 return "redirect:/ViewToDoList";
 }

}
