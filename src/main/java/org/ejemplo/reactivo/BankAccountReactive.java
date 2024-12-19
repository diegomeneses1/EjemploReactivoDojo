package org.ejemplo.reactivo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class BankAccountReactive {
    private Flux<Transaction> transactions;

    public BankAccountReactive() {
        transactions = Flux.empty();
    }

    public void addTransaction(Transaction transaction) {
        // Actualizamos el flujo con una nueva transacción
        this.transactions = Flux.concat(this.transactions, Flux.just(transaction));
    }

    // TODO 1: Implementar getDeposits
    public Flux<Transaction> getDeposits() {
      return transactions.filter(transaction -> "deposit".equalsIgnoreCase(transaction.getType()));
    }


    // TODO 2: Implementar getWithdrawals
    public Flux<Transaction> getWithdrawals() {
        return  transactions.filter(transaction -> "withdrawal".equalsIgnoreCase(transaction.getType()));
    }

    // TODO 3: Implementar getTotalDeposits
    public Mono<Double> getTotalDeposits() {
        return getDeposits()
                .map(Transaction::getAmount)
                .reduce(0.0, Double::sum);
    }

    // TODO 4: Implementar getTotalWithdrawals
    public Mono<Double> getTotalWithdrawals() {
        return getWithdrawals().map(Transaction::getAmount).reduce(0.0, Double::sum);
    }

    // TODO 5: Implementar getTotalBalance
    public Mono<Double> getTotalBalance() {
        return transactions
                .map(transaction -> "deposit".equalsIgnoreCase(transaction.getType())
                ? transaction.getAmount()
                : -transaction.getAmount())
                .reduce(0.0, Double::sum);
    }


    // TODO 6: Implementar getTransactionsOnDate
    public Flux<Transaction> getTransactionsOnDate(String date) {
        return transactions.filter(transaction -> date.equalsIgnoreCase(transaction.getDate()));
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "transactions=" + transactions +
                '}';
    }
}


