package module3.laba7.expense;


import java.util.ArrayList;

public interface ExpenseDAO {

    Expense getExpense(int num);

    ArrayList<Expense> getExpenses();

    int addExpense(Expense expense);

}
