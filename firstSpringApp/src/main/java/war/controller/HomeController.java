package war.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

@Controller
public class HomeController {

	@RequestMapping(value={"/", "/home"})
	public ModelAndView home(Model model) throws IOException{
		return new ModelAndView("home");
	}

	@RequestMapping(value="/last")
	public ModelAndView last(Model model, @RequestParam("name") String name) throws IOException {
		model.addAttribute("name", name);
        return new ModelAndView("second");
	}

	@RequestMapping(value="/middle")
	public ModelAndView middle(Model model, @RequestParam("last") String name) throws IOException {
		model.addAttribute("last", name);
        return new ModelAndView("third");
	}

	@RequestMapping(value="/result")
	public ModelAndView result(Model model, @RequestParam("middle") String name) throws IOException {
		model.addAttribute("middle", name);
        return new ModelAndView("result");
	}
}
