package org.ejemplo.reactivo;
public class MainReactive {
    public static void main(String[] args) {
        BankAccountReactive account = new BankAccountReactive();
        account.addTransaction(new Transaction(100, "deposit", "2024-05-13"));
        account.addTransaction(new Transaction(50, "withdrawal", "2024-05-14"));
        account.addTransaction(new Transaction(200, "deposit", "2024-05-15"));
        account.addTransaction(new Transaction(150, "deposit", "2024-05-16"));
        account.addTransaction(new Transaction(75, "withdrawal", "2024-05-17"));


       //1 Devolver Depositos
        System.out.println("************Depositos***************");
        account.getDeposits().subscribe(depositos -> System.out.println("Deposito: "+ depositos.getAmount()));

        //2 Devolver Retiros
        System.out.println("************Retiros***************");
        account.getWithdrawals().subscribe(depositos -> System.out.println("Retiro: "+ depositos.getAmount()));

        //3 Total Depositos
        System.out.println("*******Total Depositos********");
        account.getTotalDeposits().subscribe(total -> System.out.println("Depositos: " + total));

        //3 Total Retiros
        System.out.println("*******Total Retiros********");
        account.getTotalWithdrawals().subscribe(total -> System.out.println("Retiros: " + total));

        //5 Balance de la cuenta
        System.out.println("******Balance Cuenta********");
        account.getTotalBalance().subscribe(balace -> System.out.println("Balance: " + balace ));


        //6 Movimientos por una fecha
        System.out.println("******Movimiento por la fecha 2024-05-17********");
        account.getTransactionsOnDate("2024-05-17").subscribe(aa -> System.out.println("La trn en la fecha dada es: " + aa.getAmount()));

    }

}
