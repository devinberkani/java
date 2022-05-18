public class Person {
    private String firstName;
    private String lastName;
    private int age;

    //get firstName
    public String getFirstName() {
        return this.firstName;
    }

    //get lastName
    public String getLastName() {
        return this.lastName;
    }

    //get age
    public int getAge() {
        return this.age;
    }

    //set firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //set lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //set age
    public void setAge(int age) {
        if(age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    //teenChecker
    public boolean isTeen() {
        if(this.age > 12 && this.age < 20) {
            return true;
        } else {
            return false;
        }
    }

    //getFullName
    public String getFullName() {
        if(this.firstName.equals("") && this.lastName.equals("")) {
            return "";
        } else if (this.lastName.equals("")) {
            return firstName;
        } else if (this.firstName.equals("")) {
            return lastName;
        }
        return this.firstName + " " + this.lastName;
    }
}
