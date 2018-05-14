package pl.tw.graphqlapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import pl.tw.graphqlapi.types.Post;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tomasz Wojciechowski
 */
@Component
public class SecondPostQuery implements GraphQLQueryResolver {

	public List<Post> getRecentPosts(int count, int offset) {
		return Arrays.asList(
				new Post("1","title1","AAA","book","A1"),
				new Post("2","title2","AAA","book","A2"),
				new Post("3","title3","AAA","book","A2")
		);
	}

}
