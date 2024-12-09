package hexlet.code;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
            String sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }

            User userTom = new User("Tom", "333333333");
            User userMaria = new User("Maria", "444444444");

            UserDAO userDAO = new UserDAO(connection);

            userDAO.save(userTom);
            userDAO.save(userMaria);

            userTom.setPhone("555555555");
            userDAO.save(userTom);
            userDAO.find(userTom.getId());

            userDAO.delete(userMaria.getId());
        }
    }
}
