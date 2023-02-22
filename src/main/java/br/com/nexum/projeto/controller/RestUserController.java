package br.com.nexum.projeto.controller;



import java.util.List;
import java.util.Optional;

import br.com.nexum.projeto.model.Users;
import br.com.nexum.projeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class RestUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/rest/getAll", method = RequestMethod.GET)
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/rest/get/{id}", method = RequestMethod.GET)
    public Optional<Users> getUsers(@PathVariable("id") Integer id) {
        return userService.getUsersById(id);
    }

    @RequestMapping(value = "/rest/update/{id}", method = RequestMethod.POST)
    public void updateUsers(@RequestBody Users users, @PathVariable("id") Integer id) {
        userService.updateUsersById(id, users);
    }

    @RequestMapping(value = "/rest/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable("id") Integer id) {
        userService.deleteUsersById(id);
    }

    @RequestMapping(value = "/rest/insert", method = RequestMethod.POST, produces = {"application/json", "application/xml"},
            consumes = {"application/x-www-form-urlencoded"} )
    public void updateUsers( Users users) {
        userService.insertUsers(users);

        //return "redirect:/curriculo-register.html";

    }

/*
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }


    @GetMapping("/register")
    public String add(Model model) {
        model.addAttribute("users", new Users());
        return "register";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUsers(@ModelAttribute("users") Users user) {
        service.save(user);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUsersPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Users user = (Users) service.get(id);
        mav.addObject("users", user);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteUsersPage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    } */
}
