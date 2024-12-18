package homework;

import java.util.*;

public class CustomerService {
    private final TreeMap<Customer, String> items;

    public CustomerService() {
        this.items = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
    }

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> smallest = items.entrySet().iterator().next();
        return Map.entry(new Customer(smallest.getKey().getId(), smallest.getKey().getName(), smallest.getKey().getScores()),
                smallest.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return items.containsKey(customer)
                ? items.entrySet().stream()
                        .dropWhile(entry -> !entry.getKey().equals(customer))
                        .skip(1)
                        .findFirst()
                        .orElse(null)
                : items.entrySet().stream()
                .filter(entry -> entry.getKey().getScores() > customer.getScores())
                .findFirst()
                .orElse(null);
    }

    public void add(Customer customer, String data) {
        items.put(customer, data);
    }
}
