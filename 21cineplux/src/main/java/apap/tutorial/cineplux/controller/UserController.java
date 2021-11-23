package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/viewall")
    private String viewAllUser(Model model) {
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{username}")
    private String deleteUserForm(
            @PathVariable String username,
            Model model
    ) {
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "form-delete-user";
    }

    @PostMapping(value = "/delete")
    private String deleteSubmit(
            @ModelAttribute UserModel user,
            Model model
    ) {
        model.addAttribute("user", user);
        userService.deleteUser(user);
        return "delete-user";
    }

    @GetMapping(value = "/updatePassword")
    private String changePasswordSite() {
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String changePassword(@ModelAttribute UserModel userModel, String newPassword, String confPassword, Model model){
        UserModel myUser = userService.getUserByUsername(userModel.getUsername());

        if (userService.isMatch(userModel.getPassword(), myUser.getPassword() )){
            if (newPassword.equals(confPassword)){
                userService.setPassword(myUser, newPassword);
                userService.addUser(myUser);
                model.addAttribute("message", "Password berhasil diubah");
            }else {
                model.addAttribute("message", "Password tidak sama");
            }
        }else {
            model.addAttribute("message", "Password salah");
        }
        return "home";
    }
}
