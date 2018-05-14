package pl.tw.graphqlapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomasz Wojciechowski
 */
@RestController
public class IndexController {

	@RequestMapping(path = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public Integer getInt(){
		return 1;
	}
}
