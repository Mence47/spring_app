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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import com.fasterxml.jackson.annotation.JsonView;

import war.model.*;

@Controller
public class HomeController {

	@Autowired
	// @Qualifier("other")
	private DataBaseService service;

	@Autowired
	UserDto user;

	@RequestMapping(value={"/", "/home"})
	public ModelAndView home(HttpServletRequest rq) throws IOException{
		return new ModelAndView("home"); // can return just String with name of the view
	}

	@RequestMapping(value="/last")
	public ModelAndView last(HttpServletRequest rq, @RequestParam("name") String name) throws IOException {
		rq.getSession().setAttribute("name", name);
		user.setName(name);
        return new ModelAndView("second");
	}

	@RequestMapping(value="/middle")
	public ModelAndView middle(HttpServletRequest rq, @RequestParam("last") String name) throws IOException {
		rq.getSession().setAttribute("last", name);
		user.setLast(name);
        return new ModelAndView("third");
	}

	// @RequestMapping(value="/result")
	// // @ResponseBody
	// public ModelAndView result(HttpServletRequest rq, @RequestParam("middle") String name) throws IOException {
	// 	rq.getSession().setAttribute("middle", name);
	// 	user.setMiddle(name);
	// 	service.putData();
    //     return new ModelAndView("result");
	// }

	/*****	ModelMapper
			jackson 	****/

	@RequestMapping(value="/result", produces = "application/json")
	// @JsonView(war.model.StringResponse.class)
	public @ResponseBody UserDto result(HttpServletRequest rq, @RequestParam("middle") String name) throws IOException {
		rq.getSession().setAttribute("middle", name);
		user.setMiddle(name);
        return service.putData();
	}
}