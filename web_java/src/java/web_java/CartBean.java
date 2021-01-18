// SelectionsBean.java
// Manages a user's topic selections
package sessiontracking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean( name="cartBean" )
@SessionScoped
public class SelectionsBean implements Serializable {
    // Map of delivery services
    private static final HashMap< String, String > deliveryMap =
        new HashMap< String, String >();

    // Delivery map initialization
    static
    {
        deliveryMap.put( "paczkomat", "Paczkomat In-Post 19.99zł" );
        deliveryMap.put( "kurier", "Kurier 27.99zł" );
        deliveryMap.put( "poczta", "Poczta Polska 15.99" );
        deliveryMap.put( "odbior", "Odbiór osobisty" );
    }

    private String selection; // stores the current selection
    private float price = 0.0f;
    // returns the current selection

    public String getPrice() {
        return "Chuj i dupa";
    }

    public String getSelection()
    {
        return selection;
    } 

    // store user's selection
    public void setSelection( String topic )
    {
        selection = deliveryMap.get( topic );
        switch (topic) {
            case kurier:
                price = 27.99f
                break;
            case paczkomat:
                price = 19.99f
                break;
            case poczta:
                price = 15.99f
                break;
            default:
                price = 0.0f
                break;
        }
        selections.add( selection );
    } // end method setSelection

    // return the Set of selections
    public String[] getSelections()
    {
        return selections.toArray( new String[ selections.size() ] );
    } // end method getSelections
} // end class SelectionsBean