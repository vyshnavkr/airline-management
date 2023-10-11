package vyshnav.io.services;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.models.Customer;
import vyshnav.io.repositories.CustomerRepository;

@AllArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public Customer createCustomer(@NonNull String customerName) {
		String customerId = UUID.randomUUID().toString();
		Customer customer = new Customer(customerId, customerName);
		return customerRepository.createCustomer(customer);
	}

	public Customer getCustomer(@NonNull String cutomerId) {
		return customerRepository.getCustomer(cutomerId);
	}
	
	public Customer updateCustomer(@NonNull String customerId, @NonNull Customer customer) {
		Customer originalCustomer = customerRepository.getCustomer(customerId);
		customer.getTicketSet().forEach(ticket -> originalCustomer.getTicketSet().add(ticket));
		return customerRepository.updateCustomer(customerId, customer);
	}
}
