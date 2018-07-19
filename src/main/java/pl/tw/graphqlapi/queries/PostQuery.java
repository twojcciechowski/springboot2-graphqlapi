package pl.tw.graphqlapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import pl.tw.graphqlapi.PermissionsConstants;
import pl.tw.graphqlapi.RepoMock;
import pl.tw.graphqlapi.types.Post;

/**
 * @author Tomasz Wojciechowski
 */
@Component
public class PostQuery implements GraphQLQueryResolver {

	@Autowired
	private RepoMock repository;

	@Secured(PermissionsConstants.CAN_FETCH_SINGLE_POST)
	public Post getPost(String id) {
		return repository.getPosts()
				.stream()
				.filter(p->p.getId().equals(id))
				.findFirst()
				.get();
	}
}
