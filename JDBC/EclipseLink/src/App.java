import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
public class App {
   public static void main(String[] args) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistenceUnitName");
      EntityManager entitymanager = emfactory.createEntityManager();
      
      entitymanager.getTransaction().begin();
      
      // Create and persist a new entity
      emp emp = new emp();
      /* employee.setEmpName("John Doe");
      employee.setSalary(50000); */
      
      entitymanager.persist(employee);
      entitymanager.getTransaction().commit();
      
      // Retrieve the entity
      Employee foundEmployee = entitymanager.find(Employee.class, employee.getEmpId());
      System.out.println("Employee name: " + foundEmployee.getEmpName());
      System.out.println("Employee salary: " + foundEmployee.getSalary());
      
      entitymanager.close();
      emfactory.close();
   }
}

