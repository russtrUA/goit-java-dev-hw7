package ua.goit.database_init;

import ua.goit.exception.ConnectionException;
import ua.goit.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static ua.goit.constant.Constant.CONNECTION_TROUBLE_MESSAGE;

public class DatabasePopulateService {
    private static final String CREATE_WORKER_SQL_TEMPLATE =
            "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) " +
                    "VALUES (?, ?, ?, ?)";
    private static final String CREATE_CLIENT_SQL_TEMPLATE =
            "INSERT INTO client (NAME) " +
                    "VALUES (?)";
    private static final String CREATE_PROJECT_SQL_TEMPLATE =
            "INSERT INTO project (CLIENT_ID, NAME, START_DATE, FINISH_DATE)" +
                    "VALUES (?, ?, ?, ?)";
    private static final String CREATE_PROJECT_WORKER_SQL_TEMPLATE =
            "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) " +
                    "VALUES (?, ?)";
    private static void createWorkers(List<Worker> workers) {
        Connection connection;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (PreparedStatement statement = connection.prepareStatement(CREATE_WORKER_SQL_TEMPLATE)) {
            for (Worker worker : workers) {
                statement.setString(1, worker.getName());
                statement.setDate(2, Date.valueOf(worker.getBirthDay()));
                statement.setObject (3, worker.getLevel(), java.sql.Types.OTHER);
                statement.setInt(4, worker.getSalary());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createClients(List<Client> clients) {
        Connection connection;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (PreparedStatement statement = connection.prepareStatement(CREATE_CLIENT_SQL_TEMPLATE)) {
            for (Client client : clients) {
                statement.setString(1, client.getName());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createProjects(List<Project> projects) {
        Connection connection;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (PreparedStatement statement = connection.prepareStatement(CREATE_PROJECT_SQL_TEMPLATE)) {
            for (Project project : projects) {
                statement.setInt(1, project.getClientId());
                statement.setString(2, project.getName());
                statement.setDate(3, Date.valueOf(project.getStartDate()));
                statement.setDate(4, Date.valueOf(project.getFinishDate()));
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createProjectWorkers(List<ProjectWorker> projectWorkerss) {
        Connection connection;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (PreparedStatement statement = connection.prepareStatement(CREATE_PROJECT_WORKER_SQL_TEMPLATE)) {
            for (ProjectWorker projectWorker : projectWorkerss) {
                statement.setInt(1, projectWorker.getProjectId());
                statement.setInt(2, projectWorker.getWorkerId());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Worker> workers = List.of(new Worker("Olena Ivanova", "1990-03-15", Level.Trainee, 950),
                                       new Worker("Andriy Petrov", "1985-07-22", Level.Junior, 1200),
                                       new Worker("Mykola Shevchenko", "1982-11-30", Level.Middle, 2500),
                                       new Worker("Iryna Kovalenko", "1978-05-19", Level.Senior, 5500),
                                       new Worker("Natalia Melnyk", "1991-09-10", Level.Trainee, 980),
                                       new Worker("Viktor Yushchenko", "1988-02-25", Level.Junior, 1400),
                                       new Worker("Oksana Moroz", "1986-04-14", Level.Middle, 3200),
                                       new Worker("Serhiy Petrenko", "1975-12-05", Level.Senior, 5500),
                                       new Worker("Tetiana Savchenko", "1992-06-30", Level.Trainee, 1000),
                                       new Worker("Pavlo Borysenko", "1984-10-01", Level.Junior, 1500)
                                       );
        List<Client> clients = List.of(
                new Client("Acme Corporation"),
                new Client("Beta Technologies"),
                new Client("Gamma Solutions"),
                new Client("Delta Enterprises"),
                new Client("Epsilon Innovations")
                );
        List<Project> projects = List.of(
                new Project(1, "PROJECT A","2018-01-01", "2023-02-01"),
                new Project(2, "PROJECT B","2023-02-01", "2023-07-15"),
                new Project(3, "PROJECT C","2019-03-01", "2023-08-30"),
                new Project(4, "PROJECT D","2022-04-01", "2023-09-15"),
                new Project(5, "PROJECT E","2023-05-01", "2023-10-01"),
                new Project(1, "PROJECT F","2020-06-01", "2024-11-30"),
                new Project(1, "PROJECT G","2017-07-01", "2024-12-31"),
                new Project(3, "PROJECT H","2023-08-01", "2024-01-15"),
                new Project(5, "PROJECT I","2021-09-01", "2024-02-28"),
                new Project(5, "PROJECT J","2023-10-01", "2024-03-15")
        );
        List<ProjectWorker> projectWorkers = List.of(
                new ProjectWorker(1, 1),
                new ProjectWorker(1, 2),
                new ProjectWorker(1, 3),
                new ProjectWorker(2, 4),
                new ProjectWorker(2, 5),
                new ProjectWorker(2, 6),
                new ProjectWorker(3, 7),
                new ProjectWorker(3, 8),
                new ProjectWorker(3, 9),
                new ProjectWorker(3, 1),
                new ProjectWorker(3, 2),
                new ProjectWorker(4, 10),
                new ProjectWorker(4, 1),
                new ProjectWorker(5, 2),
                new ProjectWorker(5, 3),
                new ProjectWorker(5, 4),
                new ProjectWorker(6, 5),
                new ProjectWorker(6, 6),
                new ProjectWorker(6, 7),
                new ProjectWorker(7, 8),
                new ProjectWorker(7, 9),
                new ProjectWorker(7, 10),
                new ProjectWorker(8, 1),
                new ProjectWorker(8, 2),
                new ProjectWorker(8, 3),
                new ProjectWorker(9, 4),
                new ProjectWorker(10, 6),
                new ProjectWorker(10, 7),
                new ProjectWorker(10, 8),
                new ProjectWorker(10, 9)
        );
        createWorkers(workers);
        createClients(clients);
        createProjects(projects);
        createProjectWorkers(projectWorkers);
    }
}