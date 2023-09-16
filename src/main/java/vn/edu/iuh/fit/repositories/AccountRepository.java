package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Account;

import java.util.List;

public class AccountRepository {

EntityManagerFactory emf;
    public AccountRepository() {
        emf = Connection.getIntance().getEmf();
    }


// Thực hiện các thao tác Create, Update, Delete, Find by Id, Get All trên từng đối tượng.

    public boolean addAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(account);
            tr.commit();
            return true;
        }catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public Account findAccountOfId(String user, String pass) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        Account account = null;
		try {
			tr.begin();
            String sql = "SELECT  a FROM  Account a " +
                    "WHERE a.account_id=\""+user+"\" AND a.`password`=\""+pass+"\"";

            account= em.createQuery(sql, Account.class).getSingleResult();
			tr.commit();
            return account;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
        return null;
	}
    public List<Account> getAllAccountList() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        List<Account> accounts = null;
        try {
            tr.begin();
            TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
            accounts = query.getResultList();
            tr.commit();
            return accounts;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
