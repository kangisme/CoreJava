package chapter14;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank accounts
 */
public class Bank {
    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();
    /**
     * Constructs the bank.
     *
     * @param n             the number of accounts
     * @param initialBaland initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBaland) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBaland);
    }

    /**
     * Transfers money from one account to another
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the numbers of account in the bank.
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }
}
