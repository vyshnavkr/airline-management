package vyshnav.io.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.models.Customer;
import vyshnav.io.services.CustomerService;

@AllArgsConstructor
public class CustomerController {
	private final CustomerService customerService;
	
	public String createCustomer(@NonNull String customerName) {
		return customerService.createCustomer(customerName).getId();
	}
	
	public Customer getCustomer(@NonNull String customerId) {
		return customerService.getCustomer(customerId);
	}
}
