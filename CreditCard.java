public class CreditCard{
    private String customer;
    private String bank;
    private String account;
    private int limit;
    private double balance;

    public CreditCard( String customer, String bank, String account, int limit, double balance){
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;

    }

    // Getter methods
    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    // Method to charge a certain price to the credit card
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false; // Insufficient credit limit
        }
        balance += price;
        return true;
    }

    // Method to make payment towards the credit card balance
    public void makePayment(double amount) {
        balance -= amount;
    }

    // Main method for testing
    public static void main(String[] args) {
        CreditCard card = new CreditCard("John Doe", "Example Bank", "1234 5678 9012 3456", 5000, 1000);
        System.out.println("Customer: " + card.getCustomer());
        System.out.println("Bank: " + card.getBank());
        System.out.println("Account: " + card.getAccount());
        System.out.println("Limit: " + card.getLimit());
        System.out.println("Balance: " + card.getBalance());

        double chargeAmount = 2000;
        System.out.println("\nAttempting to charge $" + chargeAmount + " to the card...");
        if (card.charge(chargeAmount)) {
            System.out.println("Charge successful. New balance: " + card.getBalance());
        } else {
            System.out.println("Charge failed. Insufficient credit limit.");
        }

        double paymentAmount = 500;
        System.out.println("\nMaking a payment of $" + paymentAmount + " towards the balance...");
        card.makePayment(paymentAmount);
        System.out.println("New balance after payment: " + card.getBalance());
    }
}