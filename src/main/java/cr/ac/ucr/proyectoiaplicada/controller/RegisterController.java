package cr.ac.ucr.proyectoiaplicada.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {

	@RequestMapping(value = {"/Register"}, method = RequestMethod.GET)
	public String Principal(Model model) {
		return "Register";
	}
}
