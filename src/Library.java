import java.util.*;

// Manages books and members

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBook(String isbn) {
        for (Book b : books)
            if (b.getIsbn().equals(isbn))
                return b;
        return null;
    }

    public Member findMember(String memberId) {
        for (Member m : members)
            if (m.getMemberId().equals(memberId))
                return m;
        return null;
    }

    public void displayAllBooks() {
        for (Book b : books)
            b.displayInfo();
    }

    // Display only available books
public void displayAvailableBooks() {

    System.out.println("\n=== AVAILABLE BOOKS ===");

    boolean found = false;

    for (Book b : books) {
        if (b.isAvailable()) {
            b.displayInfo();
            found = true;
        }
    }

    if (!found) {
        System.out.println("No books available at the moment!");
    }
}

    public void searchBooks(String keyword) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                b.displayInfo();
            }
        }
    }
}