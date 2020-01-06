package co.za.furniture.pnp.retail.controller;

import co.za.furniture.pnp.retail.model.User;
import co.za.furniture.pnp.retail.service.UserService;
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
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("add-user")
    public String showAddUserForm(User user, Model model) {
        model.addAttribute(user);
        return "user/add-user";
    }

    @GetMapping({"","list"})
    public String showUpdateForm(Model model) {
        model.addAttribute("roles", userService.findAll());
        return "user/index";
    }

    @PostMapping("add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add-user";
        }

        userService.saveAndFlush(user);
        model.addAttribute("users", userService.findAll());
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") ID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        model.addAttribute("user", user);
        return "user/update-user";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid User user, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "user/update-user";
        }

        userService.saveAndFlush(user);
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") ID id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        userService.delete(user);
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }
}