package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entites.User;
import com.scm.form.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserSevices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

	@Autowired
	UserSevices userSevices;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("ContactWith", "Contact with Swarup");
		model.addAttribute("Youtube", "Code with Swarup");
		model.addAttribute("facebook", "https://www.facebook.com/");

		return "home.html";

	}

	@RequestMapping("/")
	public String index() {

		return "home.html";

	}

	@RequestMapping("/about")
	public String aboutPage() {

		return "about.html";

	}

	@RequestMapping("/services")
	public String services() {

		return "services.html";

	}

	@RequestMapping("/contact")
	public String contact() {

		return "contact.html";

	}

	@RequestMapping("/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";

	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "register.html";

	}

	// Processing register

	@RequestMapping(value = "/do-register", method = RequestMethod.POST)
	public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult,
			HttpSession session) {

		// fetch from data
		System.out.println(userForm);
		// validate from data

		if (bindingResult.hasErrors()) {
			return "redirect:/register";
		}

		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setAbout(userForm.getAbout());
		user.setProfilePic(
				"https://www.google.com/url?sa=i&url=https%3A%2F%2Fpixabay.com%2Fphotos%2Ftree-sunset-clouds-sky-silhouette-736885%2F&psig=AOvVaw27n4a0l4cIdaVGGz4xJLyC&ust=1738840011393000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMDmvoCyrIsDFQAAAAAdAAAAABAE");

		userSevices.saveUser(user);

		System.out.println("User saved");
		// message ="Register Successfully"
		// add the message
		Message message = new Message("Registration Successful", MessageType.green);
		session.setAttribute("message", message);
		// redirect to Login page
		return "register.html";

	}
}
