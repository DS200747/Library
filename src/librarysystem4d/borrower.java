
package librarysystem4d;

import java.util.ArrayList;


public class borrower {
    
    private String borrowerName;
    private String email;
    
    //constructor

    public borrower(String borrowerName, String email) {
        this.borrowerName = borrowerName;
        this.email = email;
    }
    
    public String toString(){
        return borrowerName+", "+email;
    }
    
    //getter
    public String getBorrowerName() {
        return borrowerName;
    }

    public String getEmail() {
        return email;
    }

    
    //setter

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
