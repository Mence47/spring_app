package war.controller;

import war.services.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

@Controller
public class HomeController {

	@Autowired
	// @Qualifier("other")
	private DataBaseService service;

	@RequestMapping(value={"/", "/home"})
	public ModelAndView home(HttpServletRequest rq) throws IOException{
		service.printMessage();
		service.putData();
		return new ModelAndView("home"); // can return just String with name of the view
	}

	@RequestMapping(value="/last")
	public ModelAndView last(HttpServletRequest rq, @RequestParam("name") String name) throws IOException {
		rq.getSession().setAttribute("name", name);
        return new ModelAndView("second");
	}

	@RequestMapping(value="/middle")
	public ModelAndView middle(HttpServletRequest rq, @RequestParam("last") String name) throws IOException {
		rq.getSession().setAttribute("last", name);
        return new ModelAndView("third");
	}

	@RequestMapping(value="/result")
	public ModelAndView result(HttpServletRequest rq, @RequestParam("middle") String name) throws IOException {
		rq.getSession().setAttribute("middle", name);
        return new ModelAndView("result");
	}
}
