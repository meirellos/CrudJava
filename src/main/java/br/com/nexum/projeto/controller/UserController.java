package br.com.nexum.projeto.controller;

import br.com.nexum.projeto.model.Users;
import br.com.nexum.projeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired

    private UserService userService;



    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "users", new Users());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert( @ModelAttribute("user") Users users, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        userService.insertUsers(users);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "user", userService.getUsersById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete( @ModelAttribute("user")Users users, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        userService.deleteUsersById(users.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(  Long id) {
        return new ModelAndView("update", "user", userService.getUsersById(id).get());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate( @ModelAttribute("user")Users users, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        userService.updateUsers(users);
        return "redirect:";
    }
    @RequestMapping(value = "/read", method = RequestMethod.GET)

    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read");
        mav.addObject("users", userService.getAllUsers());
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", userService.getAllUsers());
        return mav;

    }
}
