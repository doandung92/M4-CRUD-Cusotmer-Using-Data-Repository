package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @Autowired
    IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public String home(Model model, Pageable pageable){
        pageable = new PageRequest(pageable.getPageNumber(),3,Direction.ASC,"name","id" );
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers",customers);
        return "list";
    }
    @GetMapping("/create")
    public String showAddForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/create")
    public String saveCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public String showAddForm(@PathVariable("id") Long id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "delete";
    }
    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id);
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","Customer "+customer.getName()+" is deleted");
        return "redirect:/customers";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("/edit")
    public String updateCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
}
