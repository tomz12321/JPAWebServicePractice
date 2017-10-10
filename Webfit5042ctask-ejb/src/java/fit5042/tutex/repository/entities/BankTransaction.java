package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author tomz123
 */
@Entity
@NamedQueries({
    @NamedQuery(name = BankTransaction.GET_ALL_QUERY_NAME, query = "SELECT t FROM BankTransaction t")})
public class BankTransaction implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "BankTransaction.getAllTransactions";

    @Id
    @Column(name = "transaction_Id")
    private int transactionId;
    private String type;
    private String bankingTransactionName;
    private int bankingTransactionNo;
    
    public BankTransaction() {

    }

    public BankTransaction(BankTransaction bankTransaction) {
        transactionId = bankTransaction.transactionId;
        type = bankTransaction.type;
        bankingTransactionName = bankTransaction.bankingTransactionName;
        bankingTransactionNo = bankTransaction.bankingTransactionNo;
    }

    public BankTransaction(int transactionId, String type, String bankingTransactionName, int bankingTransactionNo) {
        //this.transactionId = transactionId;
        this.transactionId = transactionId;
        this.type = type;
        this.bankingTransactionName = bankingTransactionName;
        this.bankingTransactionNo = bankingTransactionNo;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankingTransactionName() {
        return bankingTransactionName;
    }

    public void setBankingTransactionName(String bankingTransactionName) {
        this.bankingTransactionName = bankingTransactionName;
    }

    public int getBankingTransactionNo() {
        return bankingTransactionNo;
    }

    public void setBankingTransactionNo(int bankingTransactionNo) {
        this.bankingTransactionNo = bankingTransactionNo;
    }
}
