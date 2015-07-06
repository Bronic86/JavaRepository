package module3.laba7.expense;


import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAOImpl implements ExpenseDAO {
    private String bdURL = "jdbc:mysql://localhost:3306/test_database";
    private String login = "root";
    private String password = "admin123";

    @Override
    public Expense getExpense(int num) {
        String query = "SELECT * FROM expenses WHERE num = " + num;
        return findExpenseForNum(query);
    }

    private Expense findExpenseForNum(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Expense expense = new Expense();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getDate("paydate").toString());
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getDouble("value"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Driver\" not found.");
        } catch (SQLException e) {
            System.out.println("SQL exception.");
        } finally {
            close(connection, statement, resultSet);
        }
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        String query = "SELECT * FROM expenses";
        return findExpenses(query);
    }

    private ArrayList<Expense> findExpenses(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Expense> expenses = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getDate("paydate").toString());
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getDouble("value"));
                expenses.add(expense);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Driver\" not found");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return expenses;
    }

    @Override
    public int addExpense(Expense expense) {
        String query = "INSERT INTO expenses (num, paydate, receiver, value) VALUES (?, ?, ?, ?)";
        return addRecording(query, expense);
    }

    private int addRecording(String query, Expense expense) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, expense.getNum());
            preparedStatement.setDate(2, Date.valueOf(expense.getPaydate()));
            preparedStatement.setInt(3, expense.getReceiver());
            preparedStatement.setDouble(4, expense.getValue());
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Driver\" not found");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return -1;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Close exception.");
        }
    }
}
