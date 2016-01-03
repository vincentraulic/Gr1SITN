package com.pmo.controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Task;
import com.pmo.service.TaskService;
import com.pmo.user.service.UserPmo;

@Controller
public class HomeController {

	@EJB(mappedName="java:module/TaskServiceImpl")
	private TaskService taskService;
	
	@EJB(mappedName="java:module/UserDaoImpl")
	private UserDao userDao;
	
	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public String displayHome(ModelMap pModel) {
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Employee employee = userDao.getUser(user.getUsername());
		
		List<Task> tasks = taskService.getTasks(employee);
		
		pModel.addAttribute("user", user);
		pModel.addAttribute("tasks", tasks);

		return "home/home";

	}
	
}
