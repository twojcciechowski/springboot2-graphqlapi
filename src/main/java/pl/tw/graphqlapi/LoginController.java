package pl.tw.graphqlapi;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * @author Tomasz Wojciechowski
 */
@RestController
public class LoginController {

	@Autowired
	private RepoMock repository;

	@RequestMapping(path = "/login", method = {RequestMethod.POST})
	public void login( @RequestBody LoginData data, HttpServletResponse response){
		Optional<User> optUser = repository.getUser(data.getUsername(), data.getPassword());

		if(optUser.isPresent()) {
			String JWT = Jwts.builder()
					.setSubject(optUser.get().username)
					.setExpiration(Date.from(LocalDateTime.now().plusMinutes(15).atZone(ZoneId.systemDefault()).toInstant()))
					.signWith(SignatureAlgorithm.HS512, SECRETS.SECRET)
					.compact();
			response.addHeader("X-Authorization", "Bearer" + " " + JWT);
		}
	}
}


// na co uważać:
// * co z "reply attacks" -> https://stormpath.com/blog/jwt-the-right-way
// * nie trzymammy permissionów w JWT :
//      - permission change (co ze starymi JWT? są ważne do czasu upłynięcia daty ważności)
