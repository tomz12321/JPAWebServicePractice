package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple repository implementation that uses ArrayList as the data storage
 * 
 * @author tomz123
 */
public class SimpleTransactionRepositoryImpl implements TransactionRepository {
    
    private final List<BankTransaction> transactions;

    protected SimpleTransactionRepositoryImpl()
    {
        transactions = new ArrayList<>();
    }
    
    @Override
    public void addTransaction(BankTransaction transaction) throws Exception
    {
        if ((!transactions.contains(transaction)) && (searchTransactionById(transaction.getTransactionId()) == null))
            transactions.add(transaction);
    }
    
    @Override
    public BankTransaction searchTransactionById(int id) throws Exception
    {   
        for (BankTransaction transaction : this.transactions) {
            if (transaction.getTransactionId() == id) {
                return transaction;
            }
        }
        
        return null;
    }
    
    @Override
    public List<BankTransaction> getAllTransactions() throws Exception
    {
        List<BankTransaction> transactions = new ArrayList<>(this.transactions.size());
        for (BankTransaction transaction : this.transactions) {
            transactions.add(new BankTransaction(transaction));
        }
        return transactions;
    }

    @Override
    public void removeTransaction(int transactionId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editTransaction(BankTransaction transaction) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
