package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import vn.edu.iuh.fit.models.Account;

//public class Connection {
//    private static Connection instance;
//    private SessionFactory sessionFactory;
//
//    public Connection() {
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//
//        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass(Account.class)
//                .getMetadataBuilder()
//                .build()
//
//                ;
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
//    }
//    public static Connection getInstance() {
//        if(instance == null) {
//            instance = new Connection();
//        }
//        return instance;
//    }
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}
public class Connection {
    private static Connection intance =null;
    private EntityManagerFactory emf;



    public Connection() {
        emf = Persistence.createEntityManagerFactory("Bai2Chuong04_TranDinhChuong");

    }
    public EntityManagerFactory getEmf() {
        return emf;
    }

    public static Connection getIntance() {
        if(intance == null) {
            intance = new Connection();
        }
        return intance;
    }
}
