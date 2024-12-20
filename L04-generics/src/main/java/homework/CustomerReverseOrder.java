package homework;

import java.util.*;

public class CustomerReverseOrder {
    private final Deque<Customer> customers;

    public CustomerReverseOrder() {
        this.customers = new ArrayDeque<>();
    }

    public void add(Customer customer) {
        customers.addFirst(customer);
    }

    public Customer take() {
        return customers.removeFirst();
    }
}
