package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankTransaction;
import java.util.List;

/**
 * @autor tomz123
 */
public interface TransactionRepository {

    /**
     * Add the transaction being passed as parameter into the repository
     *
     * @param bankTransaction - the transaction to add
     */
    public void addTransaction(BankTransaction bankTransaction) throws Exception;

    /**
     * Search for a transaction by its transaction ID
     *
     * @param id - the transactionId of the transaction to search for
     * @return the transaction found
     */
    public BankTransaction searchTransactionById(int id) throws Exception;

    /**
     * Return all the transactions in the repository
     *
     * @return all the transactions in the repository
     */
    public List<BankTransaction> getAllTransactions() throws Exception;
    
    /**
     * Remove the transaction, whose transaction ID matches the one being passed as parameter, from the repository
     *
     * @param transactionId - the ID of the transaction to remove
     */
    public void removeTransaction(int transactionId) throws Exception;
    
    /**
     * Update a transaction in the repository
     *
     * @param transaction - the updated information regarding a transaction
     */
    public void editTransaction(BankTransaction transaction) throws Exception;
    
    /**
     * Close all resources in the repository
     */
    public void close();
}
