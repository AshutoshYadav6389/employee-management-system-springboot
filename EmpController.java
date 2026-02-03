package com.ashutosh.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashutosh.basic.entity.Employee;
import com.ashutosh.basic.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

    @Autowired
    private EmpService service; // ✅ Renamed to follow Java convention

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emp = service.getAllEmp(); // ✅ Fetch all employees
        m.addAttribute("emp", emp);               // ✅ Add to model correctly
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
        System.out.println(e);
        service.addEmp(e); // ✅ Save employee
        session.setAttribute("msg", "Employee Added Successfully..");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m)
    {
    	 Employee e = service.getEmpById(id);
    	 m.addAttribute("emp", e);
    	 
		 return "edit";
    	
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
    	 service.addEmp(e);
    	 session.setAttribute("msg", "Employee Data Update Sucessfully..");
    	 return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
    	service.deleteEmp(id);
    	session.setAttribute("msg", "Employee Data Delete Sucessfully..");
    	return "redirect:/";
    }
    
}
