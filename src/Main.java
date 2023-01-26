import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();


        List<String[]> newAccounts = utilities.Csv.read(String.valueOf(Path.of("NewBankAccounts.csv")));

        for (String[] account : newAccounts) {
            String name = account[0];
            String sSN = account[1];
            String accountType = account[2];
            double initDeposit = Double.parseDouble(account[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ERROR");
            }
        }
        for (Account acc : accounts) {
            System.out.println("\n -----------------");
            acc.showInfo();

        }
    }
}