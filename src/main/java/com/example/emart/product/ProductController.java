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
public class ProductController {


    @Autowired private ProductService service;

    @GetMapping("/products")
    public String showUserList(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts",listProducts);
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Add new Racket");
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes ra){
        service.save(product);
        ra.addFlashAttribute("message","The product has been saved successfully");
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Product product = service.get(id);
            model.addAttribute("product",product);
            model.addAttribute("pageTitle", "Update Racket ID:"+id);
            return "product_form";

        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/products";
        }

    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The Product ID: "+id+" has been deleted.");
            return "redirect:/products";
        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/products";
        }

    }

}
