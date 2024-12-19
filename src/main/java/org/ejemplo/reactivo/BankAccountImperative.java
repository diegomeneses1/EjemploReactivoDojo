package org.ejemplo.reactivo;

import java.util.*;
import java.util.stream.Collectors;

class BankAccountImperative {
    private List<Transaction> transactions;

    public BankAccountImperative() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // TODO 1: Implementar getDeposits utilizando streams (No reactivo)
    public Optional<List<Transaction>> getDeposits() {
        List<Transaction> deposits = transactions.stream()
                .filter(transaction -> "deposit".equalsIgnoreCase(transaction.getType()))
                .collect(Collectors.toList());
        return Optional.of(deposits);
    }

    // TODO 2: Implementar getWithdrawals utilizando streams (No reactivo)
    public Optional<List<Transaction>> getWithdrawals() {
        List<Transaction> withdrawals = transactions.stream()
                .filter(transaction -> "withdrawal".equalsIgnoreCase(transaction.getType()))
                .collect(Collectors.toList());
        return Optional.of(withdrawals);
    }

    // TODO 3: Implementar getTotalBalance utilizando streams (No reactivo)
    public Optional<Double> getTotalBalance() {
        return transactions.stream()
                .map(transaction -> "deposit".equalsIgnoreCase(transaction.getType()) ? transaction.getAmount() : -transaction.getAmount())
                .reduce(Double::sum);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "transactions=" + transactions +
                '}';
    }
}


