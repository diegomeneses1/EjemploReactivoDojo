package org.ejemplo.reactivo;
public class MainImperative {
    public static void main(String[] args) {
        BankAccountImperative account = new BankAccountImperative();
        account.addTransaction(new Transaction(100, "deposit", "2024-05-13"));
        account.addTransaction(new Transaction(50, "withdrawal", "2024-05-14"));
        account.addTransaction(new Transaction(200, "deposit", "2024-05-15"));
        account.addTransaction(new Transaction(150, "deposit", "2024-05-16"));
        account.addTransaction(new Transaction(75, "withdrawal", "2024-05-17"));

        //1 Devolver Depositos
        System.out.println("************Depositos***************");
        account.getDeposits().ifPresent(depositos -> System.out.println("Deposito: "+ depositos));

        //2 Devolver Retiros
        System.out.println("************Retiros***************");
        account.getWithdrawals().ifPresent(depositos -> System.out.println("Retiro: "+ depositos));

        //3 Balance
        System.out.println("************Balance***************");
        account.getTotalBalance().ifPresent(balance -> System.out.println("Saldo total de la cuenta origen: " + balance));

    }
}
