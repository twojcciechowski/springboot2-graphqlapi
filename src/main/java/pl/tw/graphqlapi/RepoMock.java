package pl.tw.graphqlapi;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pl.tw.graphqlapi.types.Post;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static pl.tw.graphqlapi.RolesConstants.ROLE_1;
import static pl.tw.graphqlapi.RolesConstants.ROLE_2;
import static pl.tw.graphqlapi.RolesConstants.ROLE_3;

/**
 * @author Tomasz Wojciechowski
 */
@Service
public class RepoMock {

	private static List<User> users = Arrays.asList(
			new User("tomek", "AAA111", Arrays.asList(ROLE_1)),
			new User("marek", "BBB221", Arrays.asList(ROLE_2)),
			new User("janek", "vFA316", Arrays.asList(ROLE_3))
	);


	public List<Post> getPosts() {
		return Arrays.asList(
				new Post("1", "title1", "AAA", "book", "A1"),
				new Post("2", "title2", "AAA", "book", "A2"),
				new Post("3", "title3", "AAA", "book", "A2")
		);
	}

	@Nullable
	public Optional<User> getUser(String username, String password) {
		return users.stream().filter(user -> {
			return StringUtils.isNotBlank(username)
					&& StringUtils.isNotBlank(password)
					&& username.equals(user.username)
					&& password.equals(user.password);
		}).findFirst();
	}

	@Nullable
	public Optional<User> getUser(String username) {
		return users.stream().filter(user -> {
			return StringUtils.isNotBlank(username) && username.equals(user.username);
		}).findFirst();
	}
}
