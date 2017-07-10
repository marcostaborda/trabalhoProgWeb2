package classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marcostaborda
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("TrabalhoAulaPU");
        return emf.createEntityManager();
    }
    public void fechaEntityManager(){
        emf.close();
    }
}
