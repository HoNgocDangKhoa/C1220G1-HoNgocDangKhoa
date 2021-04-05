package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("list", "listBlog", blogService.findAllBlog());
    }

    @GetMapping("save")
    public String showForm(Model model) {
        model.addAttribute("add", new Blog());
        return "save";
    }

    @PostMapping("addBlog")
    public String addBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("editBlog", blogService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String editBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("view")
    public String showView(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("showView", blog);
        return "view";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id) {
        blogService.remove(id);
        return "redirect:/";
    }
}
