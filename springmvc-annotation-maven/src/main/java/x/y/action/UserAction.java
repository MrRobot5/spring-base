package x.y.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import x.y.model.User;
import x.y.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserAction {

	private Log logger = LogFactory.getLog(getClass());
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping(value = "save.do")
	public String save(String uname){
		logger.info("user/save " + uname);
		
		userService.add(uname);
		return "index";
	}
	
	@RequestMapping(value = "list.do")
	@ResponseBody
	public List<User> list() throws Exception {
		logger.info("user/list ");
		List<User> list = userService.listAll();
		return list;
	}
}
