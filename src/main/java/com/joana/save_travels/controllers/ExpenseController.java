package com.joana.save_travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joana.save_travels.models.Expenses;
import com.joana.save_travels.services.ExpenseService;

@Controller
public class ExpenseController {
  @Autowired
  ExpenseService expenseService;

  @RequestMapping("/")
  public String allExpenses(@ModelAttribute("theexpense") Expenses theexpense, Model model) {
    List<Expenses> expenses = expenseService.allExpenses();
    model.addAttribute("expenses", expenses);
    return "index.jsp";
  }
  @PostMapping("/expenses")
  public String create(@Valid @ModelAttribute("theexpense") Expenses expenses, BindingResult result, Model model) {
    if(result.hasErrors()){
      List<Expenses> expense = expenseService.allExpenses();
      model.addAttribute("expenses", expense);
      return "index.jsp";

    }else{
          expenseService.createExpense(expenses);
          return "redirect:/";
        }
  }

  @RequestMapping("/expenses/edit/{id}")
  public String showOne(@PathVariable("id")Long id, Model model){
    Expenses expenses = expenseService.findExpense(id);
    model.addAttribute("expenses", expenses);
    return "edit.jsp";
  }

  @PutMapping("/edit/{id}")
  public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expenses") Expenses expenses,  BindingResult result, Model model) {
    if(result.hasErrors()){
      model.addAttribute("expenses", expenses);
      return "edit.jsp";

    }else{
          expenseService.updateExpense(expenses);
          return "redirect:/";
        }
  }

      @DeleteMapping("/expenses/delete/{id}")
      public String delete(@PathVariable("id")Long id){
        Expenses expense = expenseService.findExpense(id);
          expenseService.deleteExpense(expense);
          return "redirect:/";
  
      }

    @GetMapping("/expenses/{id}")
    public String display(@PathVariable("id")Long id, Model model){
      Expenses expense = expenseService.findExpense(id);
      System.out.println(expense);
      model.addAttribute("expense", expense);
      return "display.jsp";
    }
}
