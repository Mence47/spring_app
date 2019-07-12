package war.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThirdController {

	@RequestMapping(value="/result")
	public ModelAndView test(HttpServletRequest rq, @RequestParam("middlename") String name) throws IOException {
		rq.getSession().setAttribute("middle", name);
        return new ModelAndView("result");
	}
}