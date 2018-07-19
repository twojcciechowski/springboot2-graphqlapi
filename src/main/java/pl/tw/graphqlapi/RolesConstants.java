package pl.tw.graphqlapi;

import java.util.Arrays;

/**
 * @author Tomasz Wojciechowski
 */
public class RolesConstants {

	public static final Role ROLE_1=new Role("ROLE_1",
			Arrays.asList(PermissionsConstants.CAN_FETCH_RECENT_POSTS));

	public static final Role ROLE_2=new Role("ROLE_2",
			Arrays.asList(PermissionsConstants.CAN_FETCH_SINGLE_POST));

	public static final Role ROLE_3=new Role("ROLE_3",
			Arrays.asList(
				PermissionsConstants.CAN_FETCH_RECENT_POSTS,
				PermissionsConstants.CAN_FETCH_SINGLE_POST ));

}
