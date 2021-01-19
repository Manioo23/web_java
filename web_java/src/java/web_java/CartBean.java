// SelectionsBean.java
// Manages a user's topic selections
package web_java;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean( name="cartBean" )
@SessionScoped
public class CartBean implements Serializable {
    // Map of delivery services
    public static final HashMap< String, String > deliveryMap =
        new HashMap< String, String >();
    public static final HashMap<String, Float> itemsMap = 
        new HashMap<String, Float >(); // Produkt na cenę

    // Delivery map initialization
    static
    {
        deliveryMap.put( "paczkomat", "Paczkomat In-Post 19.99zł" );
        deliveryMap.put( "kurier", "Kurier 27.99zł" );
        deliveryMap.put( "poczta", "Poczta Polska 15.99" );
        deliveryMap.put( "odbior", "Odbiór osobisty" );
    }

    private String selection = "odbior"; // stores the current selection
    private float price = 0.0f;
    // returns the current selection

    public int getItemsCount() {
        return itemsMap.size();
    }

    public float getItemsPrice() {
        float res = 0.0f;
        for (Map.Entry<String, Float> entry : itemsMap.entrySet()) {
            res += entry.getValue();
        }

        return res;
    }
    public float getPrice() {
        return price + getItemsPrice();
    }

    public String getSelection()
    {
        return selection;
    } 

    // store user's selection
    public void setSelection( String topic )
    {
        selection = deliveryMap.get( topic );
        
        switch(topic) {
          
        case "poczta":
            price = 15.99f;
            break;
        case "paczkomat":
            price = 19.99f;
            break;
        case "kurier":
            price = 27.99f;
            break;
        default:
            price = 0.0f;
            break;
        }
        
    } // end method setSelection

    // return the Set of selections
    //end method getSelections
} // end class SelectionsBean