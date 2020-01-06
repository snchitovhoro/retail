package co.za.furniture.pnp.retail.controller;

import co.za.furniture.pnp.retail.model.Category;
import co.za.furniture.pnp.retail.service.CategoryService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("add-category")
    public String showAddCategoryForm(Category category, Model model) {
        model.addAttribute(category);
        return "category/add-category";
    }

    @GetMapping({"","list"})
    public String showUpdateForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/category/index";
    }

    @PostMapping("add")
    public String addRole(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/add-category";
        }

        categoryService.save(category);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") ID id, Model model) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("category", category);
        return "category/update-category";
    }

    @PostMapping("update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid Category category, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "category/update-category";
        }

        categoryService.save(category);
        model.addAttribute("categories", categoryService.findAll());
        return "category/index";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") ID id, Model model) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        categoryService.delete(category);
        model.addAttribute("categories", categoryService.findAll());
        return "category/index";
    }
}