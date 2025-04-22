public class UserRegistration {
    private String username;
    private String password;
    private String phoneNumber;

    public UserRegistration(String username, String password, String cellNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = cellNumber;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 8;
    }

    public boolean checkPasswordComplexity() {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=]).{8,}$");
    }

     public boolean checkCellPhoneNumber() {
        return phoneNumber.matches("^\\+27[0-9]{9}$");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than eight characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        return "User successfully registered.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String returnLoginStatus(String inputUsername, String inputPassword, String firstName, String lastName) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
