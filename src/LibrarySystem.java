import java.util.Scanner;

public class LibrarySystem {

    static Scanner sc = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
System.out.println("1. Add New Book");
System.out.println("2. Register Member");
System.out.println("3. Display All Books");
System.out.println("4. Display Available Books");   // NEW
System.out.println("5. Search Books");
System.out.println("6. Borrow Book");
System.out.println("7. Return Book");
System.out.println("8. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> library.displayAllBooks();
                case 4 -> searchBooks();
                case 5 -> borrowBook();
                case 6 -> returnBook();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Genre: ");
        String genre = sc.nextLine();

        library.addBook(new Book(isbn, title, author, genre));
        System.out.println("Book added successfully!");
    }

    static void addMember() {
        System.out.print("Member ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        library.addMember(new Member(id, name, contact));
        System.out.println("Member registered!");
    }

    static void searchBooks() {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();
        library.searchBooks(keyword);
    }

    static void borrowBook() {
        System.out.print("Member ID: ");
        String memberId = sc.nextLine();

        System.out.print("Book ISBN: ");
        String isbn = sc.nextLine();

        Member m = library.findMember(memberId);
        Book b = library.findBook(isbn);

        if (m != null && b != null && m.borrowBook(b)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Borrowing failed!");
        }
    }

    static void returnBook() {
        System.out.print("Member ID: ");
        String memberId = sc.nextLine();

        System.out.print("Book ISBN: ");
        String isbn = sc.nextLine();

        Member m = library.findMember(memberId);
        Book b = library.findBook(isbn);

        if (m != null && b != null && m.returnBook(b)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Return failed!");
        }
    }
}