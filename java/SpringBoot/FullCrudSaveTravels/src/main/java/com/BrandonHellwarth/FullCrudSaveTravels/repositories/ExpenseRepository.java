package com.BrandonHellwarth.FullCrudSaveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BrandonHellwarth.FullCrudSaveTravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
