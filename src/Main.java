import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> savedPasswords = PasswordManager.loadPasswords();

        while (true)
        {
            System.out.println("\nPASSWORD MANGER");
            System.out.println("---------------\n");

            System.out.println("1. Generate a secure password");
            System.out.println("2. Evaluate a passwords strength");
            System.out.println("3. Store a password");
            System.out.println("4. View your saved passwords");
            System.out.println("5. Exit\n");

            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    String generatedPassword = PasswordGenerator.generate();
                    System.out.println("Generated password: " + generatedPassword);
                    break;

                case "2":
                    System.out.println("Enter a password to evaluate it's strength: ");

                    String userPassword = scanner.nextLine();
                    int score = PasswordEvaluator.evaluate(userPassword);

                    System.out.println("Password strength: " + score + "/100.");
                    break;

                case "3":
                    System.out.println("Enter a password to save: ");

                    String savedPassword = scanner.nextLine();
                    savedPasswords.add(savedPassword);
                    PasswordManager.savePasswords(savedPasswords);

                    System.out.println("Password saved.");
                    break;

                case "4":
                    if (savedPasswords.isEmpty())
                    {
                        System.out.println("No saved passwords on file.");
                    }
                    else
                    {
                        System.out.println("Saved passwords: ");
                        for (String password : savedPasswords)
                        {
                            System.out.println("- " + password);
                        }
                    }
                    break;

                case "5":
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
