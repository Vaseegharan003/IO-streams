import java.io.*;

class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    
    public Author(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private Author author;
    private double price;
    
    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public String toString() {
        return "Book{title='" + title + "', author='" + author.getName() + "', price=" + price + "}";
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", new Author("John Doe"), 499.99);
        String filename = "book.ser";
        
        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(book);
            System.out.println("Book serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Book deserializedBook = (Book) in.readObject();
            System.out.println("Deserialized Book: " + deserializedBook);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
