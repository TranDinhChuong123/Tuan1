package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Role;

public class GrantAccessRepository {
    EntityManagerFactory emf;
    public GrantAccessRepository() {
        emf = Connection.getIntance().getEmf();
    }

// Thực hiện các thao tác Create, Update, Delete, Find by Id, Get All trên từng đối tượng.
public GrantAccess findGrantAccessOfId(String account_id) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tr = em.getTransaction();
    GrantAccess grantAccess = null;
    try {
        tr.begin();
        String sql="SELECT a FROM  GrantAccess  a WHERE a.account.account_id=\""+account_id+"\" \n";
        grantAccess = em.createQuery(sql, GrantAccess.class).getSingleResult();
        tr.commit();
        return grantAccess;
    } catch (Exception e) {
        tr.rollback();
        e.printStackTrace();
    }
    return null;
}
}
