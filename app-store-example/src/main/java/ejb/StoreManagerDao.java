package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Customer;
import model.Item;

@Stateless
public class StoreManagerDao {
	@PersistenceContext(unitName = "AppStore")
	private EntityManager em;

	public void createCustomer(String country, String name) {
		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setName(name);
		em.persist(customer);
	}

	public void saveItem(int customerId, int price, int quantity, String product) {
		Customer customer = findCustomerById(customerId);
		Item order = new Item();
		order.setCustomerFK(customer);
		order.setPrice(price);
		order.setQuantity(quantity);
		order.setProduct(product);
		em.persist(order);
	}

	public List<Item> findAllItems(int customerId) {
		Query query = em.createQuery("FROM Customer where id=:id");
		query.setParameter("id", customerId);
		Customer customer = (Customer) query.getSingleResult();

		List<Item> customerOrders = customer.getItems();
		return customerOrders;
	}

	public Customer findCustomerByName(String customerName) {
		Query query = em.createQuery("FROM Customer where name=:name");
		query.setParameter("name", customerName);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	public Customer findCustomerById(int id) {
		Query query = em.createQuery("FROM Customer where id=:id");
		query.setParameter("id", id);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("FROM Customer");
		List<Customer> customerList = query.getResultList();
		return customerList;
	}
}
