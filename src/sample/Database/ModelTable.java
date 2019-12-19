package sample.Database;

public class ModelTable {
    String id,name,lastname,books;

    public ModelTable(String id, String name, String lastname, String books) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }
}
