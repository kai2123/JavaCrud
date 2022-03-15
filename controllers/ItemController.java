package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.itemform.Itemform;
import com.example.demo.service.ItemService;


@Controller
@RequestMapping("/item")
public class ItemController {

	
	@Autowired
	 private ItemService itemService;


	@GetMapping("/create")
	public String create(Itemform itemform) {
		return "item/create";
	}
	
	@GetMapping("/read")
	public String read(Itemform itemform, Model model) {
		List<Itemform>itemlist = itemService.searchAll();
		model.addAttribute("itemlist",itemlist); 
		return "item/read";
	}
	
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model,Itemform itemform) { 
		itemService.inforead(itemform,id);
        model.addAttribute("Itemform", itemform);
        return "item/edit";
    }
	
	
	@PostMapping("/create")
	public String create(@Validated Itemform itemform, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "item/create";
		}

		
		itemService.create(itemform);
		itemform.clear();
		model.addAttribute("message", "商品情報を受け付けました");
		return "item/create";
	}
	
	
	 @PutMapping("/edit/{id}")
	 public String update(@PathVariable Long id,@ModelAttribute Itemform itemform) {
		 	itemService.update(itemform,id);
	        return "root/index";
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public String destroy(@PathVariable Long id) {
		 	itemService.delete(id);
	        return "root/index";
	    }
}