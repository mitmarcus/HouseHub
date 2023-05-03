package Database;

import model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class Database implements DatabaseConnection {

    private Connection conn;

    public void connect() {
        conn = null;
        try {
            conn = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.password);
            String query = "SET SCHEMA 'company';";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeQuery();
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveEmployee(Employee employee) throws SQLException {
        EmployeeDO employeeDO = new EmployeeDO(employee);
        String query = "INSERT INTO employees (name, working_number, email, phone_number, dob, gender, email, role) VALUES (" + employeeDO.getName() + ", " + employeeDO.getWorkingNumber() + ", " + employeeDO.getEmail() + ", " + employeeDO.getPhoneNumber() + ", " + employeeDO.getDob() + ", " + employeeDO.getGender() + ", " + employeeDO.getEmail() + ", " + employeeDO.getRole() + ");";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        addUserProfile(employee.getUserProfile());
    }

    public void addUserProfile(UserProfile userProfile) throws SQLException {
        UserProfileDO userProfileDO = new UserProfileDO(userProfile);
        String query = "INSERT INTO user_profiles (working_number, password) VALUES (" + userProfileDO.getWorkingNumber() + ", " + userProfileDO.getPassword() + ");";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    public Employee login(UserProfile userProfile) throws SQLException {
        UserProfileDO userProfileDO = new UserProfileDO(userProfile);
        String query = "SELECT * FROM user_profiles WHERE working_number = " + userProfileDO.getWorkingNumber() + " AND password = " + userProfileDO.getPassword() + ";";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            throw new RuntimeException("Invalid working number or password");
        } else {
            query = "SELECT * FROM employees WHERE working_number = " + userProfileDO.getWorkingNumber() + ";";
            statement = conn.prepareStatement(query);
            rs = statement.executeQuery();
            return getAllEmployeesFromSet(rs).get(0);
        }
    }

    public void saveProject(Project project) throws SQLException {
        ProjectDO projectDO = new ProjectDO(project);

        String query = "INSERT INTO projects (name, description, deadline) VALUES (" + projectDO.getName() + ", " + projectDO.getDescription() + ", " + projectDO.getDeadline() + ");";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    public void updateTask(Task task) throws SQLException {
        TaskDO taskDO = new TaskDO(task);

        if (taskDO.getId() == "NULL") {
            throw new RuntimeException("Id cannot be null");
        }

        String query = "UPDATE tasks SET name = " + taskDO.getName() + ", description = " + taskDO.getDescription() + ", status = " + taskDO.getStatus()
                + ", priority = " + taskDO.getPriority() + ", deadline = " + taskDO.getDeadline() + ", estimated_time = " + taskDO.getEstimatedTime() + ", starting_date = " + taskDO.getStartingDate() + ", project_id = " + taskDO.getProjectId() + " WHERE id = " + taskDO.getId() + ";";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }


    public void saveTask(Task task) throws SQLException {

        TaskDO taskDO = new TaskDO(task);

        String query = "INSERT INTO TASKS (project_id, name, description, status, priority, deadline, estimated_time, starting_date)" +
                "VALUES (" + taskDO.getProjectId() + ", " + taskDO.getName() + ", " + taskDO.getDescription() + ", " + taskDO.getStatus() + ", " + taskDO.getPriority() + ", " + taskDO.getDeadline() + ", " + taskDO.getEstimatedTime() + ", " + taskDO.getStartingDate() + ");";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    public void updateProject(Project project) throws SQLException {
        ProjectDO projectDO = new ProjectDO(project);
        String query = "UPDATE projects SET name = " + projectDO.getName() + ", description = " + projectDO.getDescription() + ", deadline = " + projectDO.getDeadline() + " WHERE id = " + projectDO.getId() + ";";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    public ProjectList getAllProjectsOfEmployee(int workingNumber) throws SQLException {
        String query = "SELECT * FROM projects WHERE id in (SELECT id FROM employee_project WHERE working_number = " + workingNumber + " );";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet set = st.executeQuery();
        ProjectList projectList = getAllProjectsFromSet(set);
//        for (int i = 0; i < projectList.size(); i++) {
//            query = "SELECT * FROM employees WHERE working_number in (SELECT working_number FROM employee_project WHERE id = " + projectList.get(0).getId() + ");";
//            PreparedStatement workerSt = conn.prepareStatement(query);
//            ResultSet workerSet = workerSt.executeQuery();
//            ArrayList<Employee> employees = getAllEmployeesFromSet(workerSet);
//            projectList.get(i).setProjectManager(employees);
//        }
        return projectList;
    }

    public TaskList getAllTasksOfProject(Long projectId) throws SQLException {
        System.out.println(projectId);
        String query = "SELECT * FROM tasks WHERE project_id = " + projectId + ";";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet set = st.executeQuery();
        TaskList taskList = getTasksFromSet(set);

        for (int i = 0; i < taskList.size(); i++) {
            String workerQuery = "SELECT * FROM employees WHERE working_number in (SELECT working_number FROM employee_project WHERE project_id = " + taskList.getTask(i).getId() + ");";
            PreparedStatement workerSt = conn.prepareStatement(workerQuery);
            ResultSet workerSet = workerSt.executeQuery();
            ArrayList<Employee> employees = getAllEmployeesFromSet(workerSet);
            System.out.println(employees);
            taskList.getTask(i).setWorkers(employees);
        }

        return taskList;
    }

    public void clearTasksTable() throws SQLException {
        String query = "DELETE FROM tasks;";
        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }

    public void clearAllTables() throws SQLException {
        String query = "DELETE FROM employee_project cascade; DELETE FROM worker_task cascade; DELETE FROM tasks cascade; DELETE FROM projects cascade;DELETE FROM user_profiles cascade; DELETE FROM employees cascade;";
        PreparedStatement st = conn.prepareStatement(query);
        st.executeUpdate();
    }

    public TaskList getAllTasks() throws SQLException {
        String query = "SELECT * FROM tasks;";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        TaskList taskList = getTasksFromSet(set);
        return taskList;
    }

    public void resetSequences() throws SQLException {
        String query = "ALTER SEQUENCE projects_id_seq RESTART WITH 1; ALTER SEQUENCE tasks_id_seq RESTART WITH 1;";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }

    public ProjectList getAllProjects() throws SQLException {
        String query = "SELECT * FROM projects;";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        ProjectList projectList = getAllProjectsFromSet(set);

        return projectList;
    }

    private TaskList getTasksFromSet(ResultSet set) throws SQLException {
        TaskList taskList = new TaskList();
        while (set.next()) {
            Long id = set.getLong("id");
            Long project_id = set.getLong("project_id");
            String name = set.getString("name");
            String description = set.getString("description");
            String status = set.getString("status");
            String priority = set.getString("priority");
            LocalDate deadline;
            try {
                deadline = set.getDate("deadline").toLocalDate();
            } catch (NullPointerException e) {
                deadline = null;
            }
            Integer estimated_time = set.getInt("estimated_time");
            LocalDate starting_date;
            try {
                starting_date = set.getDate("starting_date").toLocalDate();
            } catch (NullPointerException e) {
                starting_date = null;
            }
            taskList.addTask(new Task(id, name, description, deadline, estimated_time, priority, status, project_id, starting_date));
        }
        return taskList;
    }

    private ArrayList<Employee> getAllEmployeesFromSet(ResultSet set) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        while (set.next()) {
            LocalDate dob;
            String name = set.getString("name");
            try {

                dob = set.getDate("dob").toLocalDate();
            } catch (NullPointerException e) {
                dob = null;
            }
            Integer managerNumber = set.getInt("working_number");
            String gender = set.getString("gender");
            String phoneNumber = set.getString("phone_number");
            String role = set.getString("role");
            EmployeeRole employeeRole;
            switch (role) {
                case "PROJECT M":
                    employeeRole = EmployeeRole.PROJECT_MANAGER;
                    break;
                case "WORKER":
                    employeeRole = EmployeeRole.WORKER;
                    break;
                case "HR":
                    employeeRole = EmployeeRole.HR;
                    break;
                case "MAIN MANAGER":
                    employeeRole = EmployeeRole.MAIN_MANAGER;
                    break;
                default:
                    throw new RuntimeException("Invalid role");
            }
            String email = set.getString("email");

            employees.add(new Employee(managerNumber, name, dob, phoneNumber, gender, employeeRole, email));
        }

        return employees;
    }

    private ProjectList getAllProjectsFromSet(ResultSet set) throws SQLException {
        ProjectList projectList = new ProjectList();
        while (set.next()) {
            Long id = set.getLong("id");

            String managerQuery = "SELECT * FROM employees WHERE working_number in (SELECT working_number FROM employee_project WHERE project_id = " + id + " ) and role = 'PROJECT_M';";
            PreparedStatement managerSt = conn.prepareStatement(managerQuery);
            ResultSet managerSet = managerSt.executeQuery();
            ArrayList<Employee> managers = getAllEmployeesFromSet(managerSet);

            String name = set.getString("name");
            String description = set.getString("description");

            LocalDate deadline;
            try {
                deadline = set.getDate("deadline").toLocalDate();
            } catch (NullPointerException e) {
                deadline = null;

            }
            projectList.addProject(new Project(id, name, description, deadline, managers));
        }
        return projectList;
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
                "VALUES('BOB,1,WORKER, 'M', '1999-12-9', '123456789','Bob@gmail.com' )," +
                "(ALICE, 2, WORKER, 'F', '1999-12-9', '123456789', 'Alice@gmail.com')," +
                "(JOHN, 3, WORKER, 'M', '1999-12-9', '123456789', 'John@gmail.com');";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    private void addDummyDataUserProfiles() throws SQLException {
        String query = "INSERT INTO user_profiles( password, working_number)\n" +
                "VALUES ('123', 1)," +
                "('123',2)," +
                "('123',3);";
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

    public void addDummyData() throws SQLException {
        addDummyDataProject();
        addDummyDataTasks();
        addDummyDataEmployees();
        addDummyDataUserProfiles();
        addDummyDataEmployeeProject();
        addDummyDataWorkerTask();
    }
}
