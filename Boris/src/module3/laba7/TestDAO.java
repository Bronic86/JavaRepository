package module3.laba7;


//Создайте реализации DAO на основе интерфейсов приведенного выше. Также необходимо создать
//        классы Receiver и Expense, свойства которых соответствуют полям таблиц базы данных расходов.
//        Поле дата в классах можно хранить в виде строки.

import module3.laba7.expense.Expense;
import module3.laba7.expense.ExpenseDAO;
import module3.laba7.expense.ExpenseDAOImpl;
import module3.laba7.receiver.Receiver;
import module3.laba7.receiver.ReceiverDAO;
import module3.laba7.receiver.ReceiverDAOImpl;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        ExpenseDAO expenseDAO = new ExpenseDAOImpl();
        List<Expense> expenses = expenseDAO.getExpenses();
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            System.out.println(expense);
        }

        ReceiverDAO receiverDao = new ReceiverDAOImpl();
        Receiver receiver = new Receiver();
        receiver.setNum(10);
        receiver.setName("Гипермаркет proStore");
        System.out.println(receiverDao.addReceiver(receiver));


    }
}
