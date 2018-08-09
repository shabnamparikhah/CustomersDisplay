package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
@Autowired
    CustomersRepository customersRepository;

    @RequestMapping("/")
    public String showAllData(Model model)
{
    model.addAttribute("customers",customersRepository.findAll());
    return "list";
}



    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id , Model model)
    {
        model.addAttribute("customers",customersRepository.findById(id).get());
        return  "show";
    }

    @RequestMapping("/process" )
    public String processForm (@RequestParam("search") String lastName, Model model)
    {
        model.addAttribute("customers",customersRepository.findBylastname(lastName));
        return "list";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customers",new Customer());
        return "add";
    }

    @PostMapping("/processAdd")
    public String processForm (@Valid Customer customer , BindingResult result)
    {
        if (result.hasErrors())
        {
            return "list";
        }
        customersRepository.save(customer);
        return "redirect:/";
    }

}
