package com.opts.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opts.crud.entity.Assert;
import com.opts.crud.entity.Employee;
import com.opts.crud.entity.Organisation;
import com.opts.crud.entity.UserAccount;
import com.opts.crud.service.AssertService;
import com.opts.crud.service.EmployeeService;
import com.opts.crud.service.OrgService;
import com.opts.crud.service.UserAccountService;
/*
 * OrganisationDataController performs the CRUD operations over Database.
 */

@Controller
@RequestMapping("/")
public class OrganisationDataController {
	
	
	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	OrgService orgService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AssertService assertService;
	
	private List<Organisation> orgs = new ArrayList<Organisation>();
	private List<Employee> employees =new ArrayList<Employee>();
	private List<Assert> projects = new ArrayList<Assert>();
	
	@GetMapping("/getOrg")
	public String getOrganisation(Model model) {
		orgs = orgService.getOrg();
		return "redirect:/";
	}
	
	@GetMapping("/getEmp")
	public String getEmployee(Long id) {
		employees = employeeService.getEmp();
		return "redirect:/";
	}
	
	@GetMapping("/getProjects")
	public String getProjects() {
		projects = assertService.getProjects();
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String register(Model model) {
		model.addAttribute("organisation",new Organisation());
		model.addAttribute("user",new UserAccount());
		model.addAttribute("employee",new Employee());
		model.addAttribute("project",new Assert());
		model.addAttribute("orgs",orgs);
		model.addAttribute("employees",employees);
		model.addAttribute("projects",projects);
		return "main/organisation/add.html";
		
	}
	
	@PostMapping("/saveOrg")
	public String insertOrgValue(Organisation org) {
		orgService.saveOrg(org);
		return "redirect:/";
	}

	@PostMapping("/saveEmp")
	public String insertEmployee(Employee employee) {
		employeeService.saveEmp(employee);
		return "redirect:/";
	}
	
	@PostMapping("/saveProject")
	public String insertProject(Assert project) {
		assertService.saveProject(project);
		return "redirect:/";
	}
	
	@GetMapping("/deleteOrg")
	public String deleteOrg(Model model,@RequestParam(value="_csrf",required = false) UUID _csrf,
			@RequestParam(value="orgId",required = false) Long orgId) {
		orgService.deleteOrg(orgId);
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp")
	public String deleteEmployee(Model model,@RequestParam(value="_csrf",required = false) UUID _csrf,
			@RequestParam(value="employeeId",required = false) Long empId) {
		employeeService.deleteEmp(empId);
		return "redirect:/";
	}
	
	@GetMapping("/deleteProj")
	public String deleteProject(Model model,@RequestParam(value="_csrf",required = false) UUID _csrf,
			@RequestParam(value="projectId",required = false) Long projectId) {
		assertService.deleteProject(projectId);
		return "redirect:/";
	}
	
	@PostMapping("/saveUser")
	public String createUser(UserAccount user) {
		userAccountService.save(user);
		return "redirect:/";
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(Long id) {
		userAccountService.deleteUser(id);
		return null;
	}
}
