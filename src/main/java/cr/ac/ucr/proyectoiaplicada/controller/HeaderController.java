package cr.ac.ucr.proyectoiaplicada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {

	@RequestMapping(value = {"/Header"}, method = RequestMethod.GET)
	public String ShowHeader(Model model) {
		return "Header";
	}
	
	@RequestMapping(value = {"/Footer"}, method = RequestMethod.GET)
	public String ShowFooter(Model model) {
		return "Footer";
	}
}
