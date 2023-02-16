package com.joana.save_travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joana.save_travels.models.Expenses;
import com.joana.save_travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
  @Autowired
  ExpenseRepository expenseRepository;

  //returns all the expenses
  public List<Expenses> allExpenses() {
    return expenseRepository.findAll();
  }

  //creates an expense
  public Expenses createExpense(Expenses e) {
    return expenseRepository.save(e);
  }


    // edit a expense
    public void updateExpense(Expenses b) {
      expenseRepository.save(b);
  }

  //retrieves an expense
  public Expenses findExpense(Long id) {
    Optional<Expenses> optionalExpense = expenseRepository.findById(id);
    if (optionalExpense.isPresent()) {
      return optionalExpense.get();
    } else {
      return null;
    }
  }
  
  //deletes an expense
  public void deleteExpense(Expenses expense) {
    expenseRepository.delete(expense);
  }
}
