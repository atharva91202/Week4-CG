package mapinterface.bankingsystem;

import java.util.*;

public class BankingSystem {
    private Map<Long, Double> accounts = new HashMap<>(); // Stores accounts
    private TreeMap<Double, List<Long>> sortedAccounts = new TreeMap<>(); // Stores sorted accounts
    private Queue<Long> withdrawalQueue = new LinkedList<>(); // Stores withdrawal requests

    // Add a new account
    public void addAccount(long accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " already exists.");
            return;
        }
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Deposit money into an account
    public void deposit(long accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }

        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;

        accounts.put(accountNumber, newBalance);

        // Update sortedAccounts
        sortedAccounts.get(oldBalance).remove(accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

        System.out.println("Deposited $" + amount + " into account " + accountNumber);
    }

    // Request a withdrawal
    public void requestWithdrawal(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Process withdrawals in FIFO order
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            long accountNumber = withdrawalQueue.poll();
            double currentBalance = accounts.get(accountNumber);
            double withdrawalAmount = 100; // Fixed withdrawal amount for simplicity

            if (currentBalance >= withdrawalAmount) {
                double newBalance = currentBalance - withdrawalAmount;
                accounts.put(accountNumber, newBalance);

                // Update sortedAccounts
                sortedAccounts.get(currentBalance).remove(accountNumber);
                if (sortedAccounts.get(currentBalance).isEmpty()) {
                    sortedAccounts.remove(currentBalance);
                }
                sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

                System.out.println("Processed withdrawal of $" + withdrawalAmount + " for account " + accountNumber);
            } else {
                System.out.println("Insufficient balance in account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, List<Long>> entry : sortedAccounts.entrySet()) {
            for (Long accountNumber : entry.getValue()) {
                System.out.println("Account: " + accountNumber + " - Balance: $" + entry.getKey());
            }
        }
    }

    // Getters for Testing
    public double getBalance(long accountNumber) {
        return accounts.getOrDefault(accountNumber, -1.0);
    }

    public boolean hasWithdrawalRequest(long accountNumber) {
        return withdrawalQueue.contains(accountNumber);
    }
}
