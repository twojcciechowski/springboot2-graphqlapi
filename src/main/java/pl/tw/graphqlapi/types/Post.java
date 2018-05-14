package pl.tw.graphqlapi.types;

import javafx.geometry.Pos;
import lombok.*;

/**
 * @author Tomasz Wojciechowski
 */

@Data
@AllArgsConstructor
public class Post {
	private String id;
	private String title;
	private String text;
	private String category;
	private String authorId;

	public Post(){};

	public Post(String id){
		this.setId(id);
	};

	public Post(String id,String title){
		this.setId(id);
		this.setTitle(title);
	};

}