package ua.goit.database_init;

import ua.goit.exception.ConnectionException;
import ua.goit.reader.SQLReader;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ua.goit.constant.Constant.CONNECTION_TROUBLE_MESSAGE;

public class DatabaseInitService {
    public static void main(String[] args){
        String contentSql = new SQLReader().readContent(Path.of("./sql/init_db.sql"));
        Connection connection;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (PreparedStatement statement = connection.prepareStatement(contentSql)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
