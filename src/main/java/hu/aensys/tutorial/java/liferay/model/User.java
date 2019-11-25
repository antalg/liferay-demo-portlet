package hu.aensys.tutorial.java.liferay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long id;

    private String username;

    private String fullName;

}
