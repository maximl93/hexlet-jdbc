package hexlet.code;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
            String sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }

            String sql2 = "INSERT INTO users (username, phone) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)) {
                preparedStatement.setString(1, "Tommy");
                preparedStatement.setString(2, "333333333");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Maria");
                preparedStatement.setString(2, "444444444");
                preparedStatement.executeUpdate();
            }

            String sql3 = "SELECT * FROM users";
            try (Statement statement3 = connection.createStatement();) {
                ResultSet resultSet = statement3.executeQuery(sql3);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.out.println(resultSet.getString("phone"));
                }
            }

            String sql4 = "DELETE FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql4)){
                preparedStatement2.setString(1, "Tommy");
                preparedStatement2.executeUpdate();
            }

            try (Statement statement4 = connection.createStatement();) {
                ResultSet resultSet = statement4.executeQuery(sql3);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.out.println(resultSet.getString("phone"));
                }
            }
        }
    }
}
