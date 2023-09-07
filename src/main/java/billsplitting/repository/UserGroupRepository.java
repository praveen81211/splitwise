package billsplitting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

}
