package co.za.furniture.pnp.retail.controller;

import co.za.furniture.pnp.retail.model.Role;
import co.za.furniture.pnp.retail.service.RoleService;
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
@RequestMapping("role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("add-role")
    public String showAddRoleForm(Role role, Model model) {
        model.addAttribute(role);
        return "role/add-role";
    }

    @GetMapping({"","list"})
    public String showUpdateForm(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addRole(@Valid Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/add-role";
        }

        roleService.save(role);
        return "redirect:/role/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") ID id, Model model) {
        Role role = roleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("role", role);
        return "role/update-role";
    }

    @PostMapping("update/{id}")
    public String updateRole(@PathVariable("id") Long id, @Valid Role role, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            role.setId(id);
            return "role/update-role";
        }

        roleService.save(role);
        model.addAttribute("roles", roleService.findAll());
        return "role/index";
    }

    @GetMapping("delete/{id}")
    public String deleteRole(@PathVariable("id") ID id, Model model) {
        Role role = roleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid RoleId:" + id));
        roleService.delete(role);
        model.addAttribute("roles", roleService.findAll());
        return "role/index";
    }
}