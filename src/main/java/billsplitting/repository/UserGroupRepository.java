package billsplitting.repository;

import billsplitting.entities.Group;
import billsplitting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    // Check if a UserGroup record exists for the given group and user
    boolean existsByGroupAndUser(Group group, User user);
}
