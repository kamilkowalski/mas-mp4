package ordered2;

public class OrderedStudent implements Comparable<OrderedStudent> {
    private String firstName;
    private String lastName;

    public OrderedStudent(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(OrderedStudent otherStudent) {
        if(otherStudent.getLastName().equals(getLastName())) {
            return getFirstName().compareTo(otherStudent.getFirstName());
        } else {
            return getLastName().compareTo(otherStudent.getLastName());
        }
    }
}
