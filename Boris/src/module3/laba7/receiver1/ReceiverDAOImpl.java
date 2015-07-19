package module3.laba7.receiver1;


import java.sql.*;
import java.util.ArrayList;

public class ReceiverDAOImpl implements ReceiverDAO {
    private String bdURL = "jdbc:mysql://localhost:3306/test_database";
    private String login = "root";
    private String password = "admin123";


    @Override
    public Receiver getReceiver(int num) {
        String query = "SELECT * FROM receivers WHERE num = " + num;
        return findReceiverForNum(query);
    }

    private Receiver findReceiverForNum(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Receiver receiver = new Receiver();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                receiver.setNum(resultSet.getInt("num"));
                receiver.setName(resultSet.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Driver\" not found.");
        } catch (SQLException e) {
            System.out.println("SQL exception.");
        } finally {
            close(connection, statement, resultSet);
        }
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() {
        String query = "SELECT * FROM receivers";
        return findReceivers(query);
    }

    private ArrayList<Receiver> findReceivers(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Receiver> receivers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Receiver receiver = new Receiver();
                receiver.setNum(resultSet.getInt("num"));
                receiver.setName(resultSet.getString("name"));
                receivers.add(receiver);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Driver\" not found");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return receivers;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        String query = "INSERT INTO receivers (num, name) VALUES (?, ?)";
        return addRecording(query, receiver);
    }

    private int addRecording(String query, Receiver receiver) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(bdURL, login, password);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, receiver.getNum());
            preparedStatement.setString(2, receiver.getName());
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
