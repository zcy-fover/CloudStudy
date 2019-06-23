package com.zcyfover.spring.controller;

import com.zcyfover.spring.service.Blog;
import com.zcyfover.spring.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zcy-fover
 * @description TODO
 * @date 2019-05-26 16:00
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        List<Blog> blogs = iBlogService.getList();
        model.addAttribute("blogsList", blogs);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        iBlogService.deleteBlog(id);
        model.addAttribute("blogsList", iBlogService.getList());
        return new ModelAndView("blogs/list", "blogModel", model);
    }

}
