public class Main {
    public static void main(String[] args) {
        // Menyimpan produk dengan key berupa String
        AdvancedStorage<String, Product> productStorage = new AdvancedStorage<>();
        productStorage.setKey("P001");
        productStorage.save(new Product("A123", 150.0));
        productStorage.printStorage();

        // Menyimpan customer dengan key berupa Integer
        AdvancedStorage<Integer, Customer> customerStorage = new AdvancedStorage<>();
        customerStorage.setKey(1001);
        customerStorage.save(new Customer(1, "Rifqi"));
        customerStorage.printStorage();
    }
}

// === Interface ===
interface Storable<T> {
    void save(T data);
    T load();
}

// === Generic Class ===
class GenericStorage<T> implements Storable<T> {
    private T data;

    @Override
    public void save(T data) {
        this.data = data;
        System.out.println("Data saved: " + data);
    }

    @Override
    public T load() {
        return data;
    }
}

// === Multiple Generic Class + Inheritance ===
class AdvancedStorage<K, V> extends GenericStorage<V> {
    private K key;

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void printStorage() {
        System.out.println("Key: " + key + ", Value: " + load());
    }
}

// === Model: Product ===
class Product {
    String id;
    double price;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public String toString() {
        return "[Product ID: " + id + ", Price: " + price + "]";
    }
}

// === Model: Customer ===
class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "[Customer ID: " + id + ", Name: " + name + "]";
    }
}
