import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbcon {
    public static Connection c;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/interest_database?useSSL=false","root","lak170BG@");
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void IUD(String Query) throws Exception{ // I - insert / U - update / D - delete
        Statement s = c.createStatement();
        s.executeUpdate(Query);
    }
    public static ResultSet SEARCH(String query) throws Exception{
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(query);
        return rs;
    }
    
        
    
    public static int calculateMaxAllowedLoan(int loanNumber) {
        int maxLoans = 2;
        double firstLoanLimit = 20000.00;
        int currentLoans = 0; // Replace with a mechanism to track current loans
        
        if (currentLoans >= maxLoans) {
            return 0;
        }

        if (loanNumber == 1) {
            return (int) Math.min(firstLoanLimit, maxLoans);
        } else {
            return maxLoans;
        }
    }
    
     public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfInstallments) {
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfInstallments));
        return monthlyPayment;
    }

  
    
}
