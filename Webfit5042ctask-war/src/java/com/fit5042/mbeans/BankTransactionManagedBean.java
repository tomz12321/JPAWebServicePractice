/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fit5042.mbeans;

import javax.ejb.EJB;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fit5042.tutex.repository.*;
import fit5042.tutex.repository.entities.BankTransaction;

/**
 *
 * @author tomz123
 */
@Named(value = "bankTransactionManagedBean")
@SessionScoped
public class BankTransactionManagedBean implements Serializable {

    @EJB
    TransactionRepository transactionRepository;
    
    /**
     * Creates a new instance of BankTransactionManagedBean
     */
    public BankTransactionManagedBean() {   
    }
    
    public List<BankTransaction> getAllProperties() {
        try {
            return transactionRepository.getAllTransactions();
        } catch (Exception ex) {
            Logger.getLogger(BankTransactionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
