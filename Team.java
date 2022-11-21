public class Team {
    private String name;
    private String[] employees;
    private String[] tasks;
    private String[] deadlines;

    public Team(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String[] getEmployees() {
        return employees;
    }

    public String[] getTasks() {
        return tasks;
    }

    public String[] getDeadlines() {
        return deadlines;
    }

    public void setEmployees(String[] employees) {
        this.employees = employees;
    }

    public void setTasks(String[] tasks) {
        this.tasks = tasks;
    }

    public void setDeadlines(String[] deadlines) {
        this.deadlines = deadlines;
    }

}