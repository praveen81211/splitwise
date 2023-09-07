package billsplitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // You can add custom query methods if needed
}
