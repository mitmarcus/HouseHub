package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private Connection conn;

    public DatabaseManager(Connection conn) {
        this.conn = conn;
    }

    private void addDummyDataProject() throws SQLException {
        String query = "Insert into projects(name, description, deadline)" +
                "VALUES ('firstProject', 'I like potatoes', '2003-12-9')," +
                "('secondProject', 'I like bananas', '2006-12-4')," +
                "('thirdProject', 'I like apples', '2007-12-4');";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataTasks() throws SQLException {
        String query = "Insert into tasks(name, description, deadline, estimated_time, priority, status, project_id)" +
                "VALUES ('firstTask', 'I like fathers', '2003-12-9', 10, 'HIGH', 'IN PROGRESS', 1)," +
                "('secondTask', 'I like mothers', '2006-12-4', 10, 'HIGH', 'IN PROGRESS', 1)," +
                "('thirdTask', 'I like sons', '2007-12-4', 10, 'HIGH', 'IN PROGRESS', 1)," +
                "('fourthTask', 'I like daughters', '2007-12-4', 10, 'HIGH', 'IN PROGRESS', 2)," +
                "('fifthTask', 'I like brothers', '2007-12-4', 10, 'HIGH', 'IN PROGRESS', 2)," +
                "('sixthTask', 'I like sisters', '2007-12-4', 10, 'HIGH', 'IN PROGRESS', 3)," +
                "('seventhTask', 'I like grandfathers', '2007-12-4', 10, 'HIGH', 'IN PROGRESS', 3);";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataEmployees() throws SQLException {
        String query = "INSERT INTO employees(name, working_number, role, gender, dob, phone_number, email)" +
                "VALUES('BOB',1,'WORKER', 'M', '1999-12-9', '123456789','Bob@gmail.com' )," +
                "('ALICE', 2, 'WORKER', 'F', '1999-12-9', '123456789', 'Alice@gmail.com')," +
                "('JOHN', 3, 'WORKER', 'M', '1999-12-9', '123456789', 'John@gmail.com')," +
                "('KARL', 4, 'PROJECT M', 'M', '1999-12-9', '123456789', 'John@gmail.com')," +
                "('JAN', 5, 'MAIN M', 'M', '1999-12-9', '123456789', 'John@gmail.com')," +
                "('ANNICKA', 6, 'HR', 'F', '1999-12-9', '123456789', 'object@gmail.com');";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataUserProfiles() throws SQLException {
        String query = "INSERT INTO user_profiles( password, working_number)\n" +
                "VALUES ('123', 1)," +
                "('123',2)," +
                "('123',3)," +
                "('123',4),"+
                "('123',5),"+
                "('123',6);";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataEmployeeProject() throws SQLException {
        String query = "INSERT INTO employee_project( working_number, project_id)\n" +
                "VALUES (1, 1)," +
                "(2,1)," +
                "(3,1)," +
                "(2,2)," +
                "(3,2)," +
                "(3,3);";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataWorkerTask() throws SQLException {
        String query = "INSERT INTO worker_task( working_number, task_id)\n" +
                "VALUES (1, 1)," +
                "(2,1)," +
                "(3,1)," +
                "(2,2)," +
                "(3,2)," +
                "(3,3);";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataManagerWorker() throws SQLException {
        String query = "INSERT INTO manager_worker(manager_number, worker_number)\n" +
                "VALUES (4, 2),\n" +
                "       (4, 1),\n" +
                "       (4, 3);";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }


    public void addDummyData() throws SQLException {
        addDummyDataProject();
        addDummyDataTasks();
        addDummyDataEmployees();
        addDummyDataUserProfiles();
        addDummyDataEmployeeProject();
        addDummyDataWorkerTask();
        addDummyDataManagerWorker();
    }
    public void clearAllTables() throws SQLException {
        String query = "DELETE FROM users cascade; DELETE FROM room cascade; DELETE FROM reservation cascade;";
        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }
}