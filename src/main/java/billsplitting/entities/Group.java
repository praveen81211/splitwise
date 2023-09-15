package billsplitting.entities;

import billsplitting.dto.GroupDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[Group]")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "group_name", nullable = false)
	private String groupName;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "created_by_user_id")
	private User createdByUser;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Expense> expenses = new ArrayList<>();

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserGroup> userGroups = new ArrayList<>();

	public void setGroupName(String groupName2) {
		// TODO Auto-generated method stub

	}

	public List<GroupDTO> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

}
