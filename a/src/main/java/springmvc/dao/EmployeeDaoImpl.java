package springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import springmvc.model.Employee;
 

    
    @Repository("employeeDao")
    public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
     
        public Employee findById(int id) {
            return getByKey(id);
        }
     
        public void saveEmployee(Employee employee) {
            persist(employee);
        }
     
        public void deleteEmployeeBySsn(String ssn) {
            Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
            query.setString("ssn", ssn);
            query.executeUpdate();
        }
     
        @SuppressWarnings("unchecked")
        public List<Employee> findAllEmployees() {
            Criteria criteria = createEntityCriteria();
            return (List<Employee>) criteria.list();
        }
     
        public Employee findEmployeeBySsn(String ssn) {
            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("ssn", ssn));
            return (Employee) criteria.uniqueResult();
        }
        
        
      //@Repository("employeeDao")
      //public class EmployeeDaoImpl implements EmployeeDao {
//      	@Autowired LocalSessionFactoryBean localfactory;
      //
//      	SessionFactory factory= localfactory.getObject();
      // 
//          public Employee findById(int id) {
//          	Session session = factory.getCurrentSession();
//          	
//          	Query <Employee> theQuery = session.createQuery("from Employee", Employee.class); theQuery = session.createQuery("from Employee", Employee.class);
//          	
//          	Employee employee = theQuery.getSingleResult();
//          	
//              return employee;   
//              
//              
//          }
      // 
//          public void saveEmployee(Employee employee) {
////              persist(employee);
//          }
      // 
//          public void deleteEmployeeBySsn(String ssn) {
////              Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
////              query.setString("ssn", ssn);
////              query.executeUpdate();
//          }
      // 
//          @SuppressWarnings("unchecked")
//          public List<Employee> findAllEmployees() {
////              Criteria criteria = createEntityCriteria();
//              return null;
//          }
      // 
//          public Employee findEmployeeBySsn(String ssn) {
//              return null;
//          }
}
