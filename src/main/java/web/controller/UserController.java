package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService us;

    @GetMapping(name = "/")
    public String startPage() {
        return "index";
    }

    @GetMapping(value = "/getUsers")
    public String getCarController(ModelMap model) {
        model.addAttribute("users", us.getAll());
        return "users";
    }

    @GetMapping("/addUser")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute User user) {
        us.add(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        us.delete(id);
        return "redirect:/getUsers";
    }


    @PostMapping("/editUser")
    public String showEditUserForm(@RequestParam Long id, Model model) {
        User user = us.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUserInfo(@ModelAttribute User user) {
        us.update(user);
        return "redirect:/getUsers";
    }
}
