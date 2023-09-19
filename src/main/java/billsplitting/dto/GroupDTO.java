package billsplitting.dto;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

	private Long groupId;
	private String groupName;

	private Long createdByUser;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private boolean isDeleted;

	// Regular expression pattern for a valid group name
	private static final String GROUP_NAME_PATTERN = "^[A-Za-z0-9_\\s-]+$";

	public boolean isValidGroupName() {
		// Check if the groupName matches the pattern
		return groupName != null && Pattern.matches(GROUP_NAME_PATTERN, groupName);
	}


}
