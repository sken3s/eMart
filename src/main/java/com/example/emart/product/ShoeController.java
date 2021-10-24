package com.example.emart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShoeController {


    @Autowired private ShoeService service;

    @GetMapping("/shoes")
    public String showUserList(Model model){
        List<Shoe> listShoes = service.listAll();
        model.addAttribute("listShoes",listShoes);
        return "shoes";
    }

    @GetMapping("/shoes/new")
    public String showNewForm(Model model){
        model.addAttribute("shoe", new Shoe());
        model.addAttribute("pageTitle", "Add new Shoe");
        return "shoe_form";
    }

    @PostMapping("/shoes/save")
    public String saveShoe(Shoe shoe, RedirectAttributes ra){
        service.save(shoe);
        ra.addFlashAttribute("message","The shoe has been saved successfully");
        return "redirect:/shoes";
    }

    @GetMapping("/shoes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Shoe shoe = service.get(id);
            model.addAttribute("shoe",shoe);
            model.addAttribute("pageTitle", "Update Shoe ID:"+id);
            return "shoe_form";

        } catch (ShoeNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/shoes";
        }

    }

    @GetMapping("/shoes/delete/{id}")
    public String deleteShoe(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The Shoe ID: "+id+" has been deleted.");
            return "redirect:/shoes";
        } catch (ShoeNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/shoes";
        }

    }

}
