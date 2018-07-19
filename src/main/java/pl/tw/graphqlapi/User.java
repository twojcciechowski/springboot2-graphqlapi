package pl.tw.graphqlapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Tomasz Wojciechowski
 */
@Data
@AllArgsConstructor
public class User {
	String username;
	String password;
	List<Role> roles;
}
