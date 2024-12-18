package homework;

import java.util.*;

public class CustomerReverseOrder {
    private final LinkedHashSet<Customer> customers;

    public CustomerReverseOrder() {
        this.customers = new LinkedHashSet<>();
    }

    public void add(Customer customer) {
        customers.addFirst(customer);
    }

    public Customer take() {
        return customers.removeFirst();
    }
}
