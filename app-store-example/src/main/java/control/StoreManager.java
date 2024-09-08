package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;


import view.CustomerView;
import view.ItemView;

import ejb.StoreManagerDao;

import model.Customer;
import model.Item;
@ManagedBean()
@RequestScoped
public class StoreManager  {

	@Inject  
	private StoreManagerDao storeManager;

	@ManagedProperty(value="#{customerView}") 
	private CustomerView customerView;

	@ManagedProperty(value="#{itemView}") 
	private ItemView itemView;

	List<Item> listOrders;
	List <SelectItem> listCustomers;

	public ItemView getItemView() {
		return itemView;
	}

	public void setItemView(ItemView itemView) {
		this.itemView = itemView;
	}

	public CustomerView getCustomerView() {
		return customerView;
	}

	public void setCustomerView(CustomerView customerView) {
		this.customerView = customerView;
	}


	public StoreManager() { 	}

	public void findOrders() {  

		listOrders = storeManager.findAllItems(customerView.getCustomerId());

	}
	public void findAllCustomers() {  

		List<Customer> listCustomersEJB = storeManager.findAllCustomers();

		for (int ii=0;ii<listCustomersEJB.size();ii++) {
			Customer customer = listCustomersEJB.get(ii);
			listCustomers.add(new  SelectItem(customer.getId(),customer.getName()));

		}
	}

	public void saveOrder() { 
		storeManager.saveItem(customerView.getCustomerId(),itemView.getOrderPrice(),itemView.getOrderQuantity(),itemView.getOrderProduct());

		FacesMessage fm = new FacesMessage("Saved order for "+itemView.getOrderQuantity()+ " of "+itemView.getOrderProduct());
		FacesContext.getCurrentInstance().addMessage("Message", fm);

	}

	public void insertCustomer() {
		System.out.println("Inserting  "+customerView.getCustomerCountry());
		storeManager.createCustomer(customerView.getCustomerCountry(), customerView.getCustomerName());

		FacesMessage fm = new FacesMessage("Created Customer  "+customerView.getCustomerName()+ " from "+customerView.getCustomerCountry());
		FacesContext.getCurrentInstance().addMessage("Message", fm);

		// Forces customer reloading
		this.listCustomers=null;
	}


	public List<Item> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Item> listOrders) {
		this.listOrders = listOrders;
	}

	public List<SelectItem> getListCustomers() {
		if (listCustomers == null) {
			listCustomers= new ArrayList();
			findAllCustomers();

		}
		return listCustomers;
	}

	public void setListCustomers(List<SelectItem> listCustomers) {
		this.listCustomers = listCustomers;
	}
}

