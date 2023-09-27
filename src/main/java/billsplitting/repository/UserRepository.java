package billsplitting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.User;

//import org.apache.catalina.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);

	@Override
	Page<User> findAll(Pageable pageable);

	Page<User> findAllByOrderByUsernameAsc(Pageable pageable); // Add this method for sorting by username ascending

	Page<User> findAllByOrderByUsernameDesc(Pageable pageable); // Add this method for sorting by username descending

}
