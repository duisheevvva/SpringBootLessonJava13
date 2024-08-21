package peaksoft.springbootlessonjava13.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootlessonjava13.entity.User;
import peaksoft.springbootlessonjava13.service.UserService;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "getAllUsers";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/api/users";
    }

    @GetMapping("/{id}/get")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("updateUser", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable Long id,
                             @ModelAttribute("updateUser") User user) {
        userService.updateUser(id, user);
        return "redirect:/api/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/api/users";
    }

    @GetMapping("/{email}/getUser")
    public String getUserByEmail(@PathVariable String email, Model model) {
        model.addAttribute("updateUser",userService.getUserByEmail(email));
        return "updateUser";
    }


}
