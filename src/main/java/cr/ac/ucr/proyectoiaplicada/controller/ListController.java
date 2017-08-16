package cr.ac.ucr.proyectoiaplicada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListController {
    @RequestMapping(value = {"/ProductList","List","Products"},method = RequestMethod.GET)
    public String runList(Model model) {
        return "List";
    }
}
