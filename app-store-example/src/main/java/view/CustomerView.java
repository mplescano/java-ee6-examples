package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.*;


@ManagedBean(name="customerView")
@RequestScoped
public class CustomerView {
	@Size(min = 5, max=20, message = "Please enter a valid Customer name (5-20 characters)")
	@NotNull(message = "Please enter a Customer name")
	private String customerName;
	
    @Size(min = 5, max=20, message = "Please enter a valid Country (5-20 characters)")
    @NotNull(message = "Please enter a Country")
	private String customerCountry;
    
    public void customerListener(AjaxBehaviorEvent event) { 
    	this.customerName = this.customerName.toUpperCase();
    }
    public void countryListener(AjaxBehaviorEvent event) { 
    	this.customerCountry = this.customerCountry.toUpperCase();
    } 
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	private int customerId;
	

}
