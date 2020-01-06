package co.za.furniture.pnp.retail.controller;

import co.za.furniture.pnp.retail.model.Product;
import co.za.furniture.pnp.retail.service.ProductService;
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
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController( ProductService productService) {
        this.productService = productService;
        }

    @GetMapping("add-product")
    public String showaddProductForm(Product product) {
        return "add-product";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("roles", productService.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addRole(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product";
        }

        productService.save(product);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") ID id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("update/{id}")
    public String updateRole(@PathVariable("id") Long id, @Valid Product product, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "update-product";
        }

        productService.save(product);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") ID id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        productService.delete(product);
        model.addAttribute("products", productService.findAll());
        return "index";
    }
}