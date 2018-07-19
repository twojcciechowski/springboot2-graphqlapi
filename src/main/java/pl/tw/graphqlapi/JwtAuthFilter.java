package pl.tw.graphqlapi;

import io.jsonwebtoken.Jwts;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Tomasz Wojciechowski
 */
public class JwtAuthFilter extends GenericFilterBean {

	private RepoMock repository;

	public JwtAuthFilter(RepoMock repoMock){
		this.repository = repoMock;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		doFilter((HttpServletRequest) request,
				(HttpServletResponse) response,
				filterChain
		);
	}


	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		String token = request.getHeader("X-Authorization");

		if (token != null) {
			// parse the token.
			String userName = Jwts.parser()
					.setSigningKey(SECRETS.SECRET)
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();

			Optional<User> optUser = repository.getUser(userName);

			if(optUser!=null && optUser.isPresent()){
				User user = optUser.orElse(null);

				List<String> privileges = new ArrayList<>();
				for(Role r : user.roles){
					privileges.addAll(r.getPrivileges());
				}

				List<GrantedAuthority> authorities = privileges.stream()
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());

				SecurityContextHolder.getContext()
						.setAuthentication(
								new UsernamePasswordAuthenticationToken(
										user.username, user.password, authorities));
			}
		}

		filterChain.doFilter(request, response);

	}
}
