package com.BrandonHellwarth.FullCrudSaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BrandonHellwarth.FullCrudSaveTravels.models.Expense;
import com.BrandonHellwarth.FullCrudSaveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
	
	public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
	
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    public Expense updateExpense(Long id, String name, String vendor, String description, Float amount){
    	Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            optionalExpense.get().setName(name);
            optionalExpense.get().setVendor(vendor);
            optionalExpense.get().setDescription(description);
            optionalExpense.get().setAmount(amount);
            return expenseRepository.save(optionalExpense.get());
        } else {
            return null;
        }
    }

    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
}
