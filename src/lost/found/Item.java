

import java.sql.Blob;
import java.util.Date;

public class Item {
    String Category;
    String Place;
    String Description;
    boolean Status ; //0=Lost 1=Found
    java.sql.Date Date_Of_Lost_or_Found;
    Blob Picture;
    
    Item(){
        
    }
    
    Item(String category, String place, String description, boolean status, java.sql.Date date, Blob picture){
        Category=category;
        Place=place;
        Description=description;
        Status=status;
        Date_Of_Lost_or_Found=date;
        Picture=picture;
    }

    @Override
    public String toString() {
        return "Item{" + "Category=" + Category + ", Place=" + Place + ", Description=" + Description + ", Status=" + Status + ", Date_Of_Lost_or_Found=" + Date_Of_Lost_or_Found + ", Picture=" + Picture + '}';
    }
    
}
