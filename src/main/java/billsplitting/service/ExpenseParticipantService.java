package billsplitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.dto.ExpenseParticipantDTO;
import billsplitting.entities.ExpenseParticipant;
import billsplitting.repository.ExpenseParticipantRepository;

@Service
public class ExpenseParticipantService {

    @Autowired
    private ExpenseParticipantRepository expenseParticipantRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new expense participant
    public ExpenseParticipant createExpenseParticipant(ExpenseParticipantDTO expenseParticipantDTO) {
        ExpenseParticipant expenseParticipant = modelMapper.map(expenseParticipantDTO, ExpenseParticipant.class);
        return expenseParticipantRepository.save(expenseParticipant);
    }

    // Get expense participant by ID
    public Optional<ExpenseParticipant> getExpenseParticipantById(Long id) {
        return expenseParticipantRepository.findById(id);
    }

    // Get all expense participants
    public List<ExpenseParticipant> getAllExpenseParticipants() {
        return expenseParticipantRepository.findAll();
    }

    // Update an existing expense participant
    public ExpenseParticipant updateExpenseParticipant(ExpenseParticipant expenseParticipant) {
        return expenseParticipantRepository.save(expenseParticipant);
    }

    // Delete expense participant by ID
    public boolean deleteExpenseParticipant(Long id) {
        if (expenseParticipantRepository.existsById(id)) {
            expenseParticipantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
