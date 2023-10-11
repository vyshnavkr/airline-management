package vyshnav.io.repositories;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import vyshnav.io.models.Customer;

public class CustomerRepository {
	
	private Map<String, Customer> customerMap;
	
	public CustomerRepository() {
		this.customerMap = new HashMap<>();
	}
	
	public Customer createCustomer(Customer customer) {
		customerMap.put(customer.getId(), customer);
		return customerMap.get(customer.getId());
	}

	public Customer getCustomer(String customerId) {
		return customerMap.get(customerId);
	}

	public Customer updateCustomer(String customerId, Customer customer) {
		customerMap.put(customer.getId(), customer);
		return customerMap.get(customer.getId());
	}

}
