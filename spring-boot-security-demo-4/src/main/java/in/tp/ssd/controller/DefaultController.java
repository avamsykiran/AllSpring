package in.tp.ssd.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@GetMapping("/login")
	public ModelAndView gotoLogin() {
		return new ModelAndView("loginPage");
	}

	@GetMapping({ "", "/", "/home" })
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView("home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("unm", auth.getName());
		}
		return mv;
	}

}
