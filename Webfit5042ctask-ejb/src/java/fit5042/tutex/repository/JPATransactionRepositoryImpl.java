package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankTransaction;
import java.util.ArrayList;
//import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tomz123
 */
//@Stateless
public class JPATransactionRepositoryImpl implements TransactionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    JPATransactionRepositoryImpl() {
        //Pay attention to the name of the Persistent Unit here.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fit5042ctaskPU");
        entityManager = entityManagerFactory.createEntityManager();

    }

    @Override
    public void addTransaction(BankTransaction bankTransaction) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(bankTransaction);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public BankTransaction searchTransactionById(int id) throws Exception {
        BankTransaction bankTransaction = entityManager.find(BankTransaction.class, id);
        return bankTransaction;
    }

    @Override
    public List<BankTransaction> getAllTransactions() throws Exception {
        return entityManager.createNamedQuery(BankTransaction.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeTransaction(int transactionId) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            BankTransaction bankTransaction = this.searchTransactionById(transactionId);

            if (bankTransaction != null) {
                entityManager.remove(bankTransaction);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void editTransaction(BankTransaction bankTransaction) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(bankTransaction);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void close() {
        entityManager.close();
    }

}
