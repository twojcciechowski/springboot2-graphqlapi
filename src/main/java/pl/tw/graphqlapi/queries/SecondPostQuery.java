package pl.tw.graphqlapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import pl.tw.graphqlapi.PermissionsConstants;
import pl.tw.graphqlapi.RolesConstants;
import pl.tw.graphqlapi.types.Post;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tomasz Wojciechowski
 */
@Component
public class SecondPostQuery implements GraphQLQueryResolver {

	@Secured(PermissionsConstants.CAN_FETCH_RECENT_POSTS)
	public List<Post> getRecentPosts(int count, int offset) {
		return Arrays.asList(
				new Post("1","title1","AAA","book","A1"),
				new Post("2","title2","AAA","book","A2"),
				new Post("3","title3","AAA","book","A2")
		);
	}

}
