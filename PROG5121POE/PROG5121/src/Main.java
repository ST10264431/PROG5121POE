import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Registration System");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number (e.g. +27838968976): ");
        String phone = scanner.nextLine();

        UserRegistration user = new UserRegistration(username, password, phone);

        String regMessage = user.registerUser();
        System.out.println(regMessage);

        if (regMessage.equals("User successfully registered.")) {
            System.out.println("Please log in.");

            System.out.print("Enter your username again: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter your password again: ");
            String loginPass = scanner.nextLine();

            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            String loginMessage = user.returnLoginStatus(loginUser, loginPass, firstName, lastName);
            System.out.println(loginMessage);
        }
    }
}
