package com.uni.examsystem.web;

import com.uni.examsystem.models.binding.UserUpdateBindingModel;
import com.uni.examsystem.service.UserService;
import com.uni.examsystem.service.impl.AppUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/panel")
    public String usersPanel() {
        return "users-panel";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model,
                           @AuthenticationPrincipal AppUser currentUser) {
        return "";
    }

    @PatchMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, @Valid UserUpdateBindingModel userModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        return "";

    }

    @GetMapping("/{id}/details")
    public String userDetails(@PathVariable Long id, Model model, Principal principal) {

        model.addAttribute("user", userService.findById(id, principal.getName()));
        return "";
    }

    @GetMapping("/{userId}/{examId}/take")
    public String takeExam(@PathVariable String examId, @PathVariable String userId, Model model) {
        return "take-exam-student";
    }


}
