
package librarysystem4d;


public class book {
    
    private String name;
    private String ISBN;
    private double price;
    private String author;
    private String genre;
    
//constructor
    public book(String name, String ISBN, double price, String author, String genre) {
        this.name = name;
        this.ISBN = ISBN;
        this.price = price;
        this.author = author;
        this.genre = genre;
    }
    
    public String toString(){
        return name+", "+ISBN+", "+price+", "+author+", "+genre;
    }
 //getter
    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
    
//setter
    public void setName(String name) {
        this.name = name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
    
}
