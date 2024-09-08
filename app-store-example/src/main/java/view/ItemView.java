package view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.*;

@ManagedBean(name="itemView")
 
@RequestScoped
public class ItemView {
	@Min(value=0, message = "Order minimum 1 item") 
	@Max(value=1000, message = "Order maximum 1000 items") 
	private int orderQuantity;
	@Min(value=0, message = "Price cannot be less then 1") 
	private int orderPrice;
	@Size(min = 5, max=20, message = "Please enter a valid Product name (5-20 characters)")
	private String orderProduct;
	
    public void productListener(AjaxBehaviorEvent event) { 
    	this.orderProduct = this.orderProduct.toUpperCase();
    } 
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}
	
}
