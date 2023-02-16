package com.joana.save_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joana.save_travels.models.Expenses;

@Repository
public interface ExpenseRepository extends CrudRepository<Expenses, Long> {
  List<Expenses> findAll();
}
