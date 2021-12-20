package com.uni.examsystem.web;

import com.uni.examsystem.models.binding.UserUpdateBindingModel;
import com.uni.examsystem.service.UserService;
import com.uni.examsystem.service.impl.AppUser;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/panel")
    public String usersPanel() {
        return "users-panel";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {

        var userDetailsView = userService.findById(id);

        var userUpdateBindingModel = modelMapper.map(userDetailsView, UserUpdateBindingModel.class);

        model.addAttribute("userModel", userUpdateBindingModel);

        return "edit-user";
    }

    @PatchMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, @Valid UserUpdateBindingModel userModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/" + id + "/edit";
        }

        userService.updateUser(userModel);
        return "redirect:/users/details";
    }

    @GetMapping("/details")
    public String userDetails(Model model, Principal principal) {

        model.addAttribute("user", userService.findByUserName(principal.getName()).get());
        return "user-details";
    }

    @GetMapping("/{userId}/{examId}/take")
    public String takeExam(@PathVariable String examId, @PathVariable String userId, Model model) {

        return "take-exam-student";
    }


}
