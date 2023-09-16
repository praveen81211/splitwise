package billsplitting.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty; // Import Jackson's JsonProperty

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

//	private Long userId;

	@NotBlank(message = "Username is required")
	@JsonProperty("username") // Specify the JSON property name
	private String username;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@JsonProperty("email") // Specify the JSON property name
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Specify write-only for password
	private String password;

	@JsonProperty("created_at") // Specify the JSON property name
	private LocalDateTime createdAt;

	@JsonProperty("updated_at") // Specify the JSON property name
	private LocalDateTime updatedAt;

	@JsonProperty("active") // Specify the JSON property name
	private boolean active;

	@JsonProperty("deleted") // Specify the JSON property name
	private boolean deleted;

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	// Add getter and setter methods for all fields
}
