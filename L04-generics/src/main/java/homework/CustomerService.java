package homework;

import java.util.*;

public class CustomerService {
    private final NavigableMap<Customer, String> items;

    public CustomerService() {
        this.items = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
    }

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> smallest = items.firstEntry();
        return smallest == null ? null : getDeepCopy(smallest);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> next = items.higherEntry(customer);
        return next == null ? null : getDeepCopy(next);
    }

    public void add(Customer customer, String data) {
        items.put(customer, data);
    }

    private Map.Entry<Customer, String> getDeepCopy(Map.Entry<Customer, String> value) {
        return Map.entry(
                new Customer(
                        value.getKey().getId(),
                        value.getKey().getName(),
                        value.getKey().getScores()),
                value.getValue());
    }
}
