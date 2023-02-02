import jakarta.persistence.EntityManager;
import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.EntityManagerFactory;
public class App {
   public static void main(String[] args) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistenceUnit");
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction().begin();
      
      // Create and persist a new entity
      List<emp> employees = getAllEmployees(entitymanager);
      for (emp employee : employees) {
         System.out.println("Employee name: " + employee.getEname());
         System.out.println("Employee salary: " + employee.getSal());
      }
      entitymanager.close();
      emfactory.close();
   }
   public static List<emp> getAllEmployees(EntityManager entitymanager) {
      Query query = entitymanager.createQuery("SELECT e FROM emp e");
      List<emp> employees = query.getResultList();
      return employees;
   }
   
}

