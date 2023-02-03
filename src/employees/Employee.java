package employees;
/**
 * Interface used for Clyde Conservation employees.
 * This will be used across the application to contain employee types.
 * @author Erik
 */
public interface Employee {
    /**
     * Custom version of toString() to implement in child classes.
     * @return The details of the employee.
     */
    public String getDetails();
}
