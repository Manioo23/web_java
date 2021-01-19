package web_java;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JD
 */
@ManagedBean( name="categoryBean" )
@SessionScoped
    public class CategoryBean implements Serializable
       {
            private static String category;
            private String[] choices;
            public static HashMap<String, String> products = new HashMap<String, String>();
            public static HashMap<String, Float> prices = new HashMap<String, Float>();

            static {
              products.put("WHEY DELICIOUS PROTEIN - 700g", "odzywki_bialkowe");
              products.put("WHEY PROTEIN COMPLEX 100% - 700g", "odzywki_bialkowe");
              products.put("ULTRA WHEY - 908g", "odzywki_bialkowe");
              products.put("CREATINE XPLODE - 500g", "kreatyny");
              products.put("CREA X3 - 400g", "kreatyny");
              products.put("CELL TECH PERFORMANCE SERIES - 2270g", "kreatyny" );
              products.put("PROFI MASS - 1000g", "odzywki_na_mase");
              products.put("HARD MASS - 1000g", "odzywki_na_mase");
              products.put("DIET FUEL ULTRALEAN - 2000g", "odzywki_na_mase");
              prices.put("WHEY DELICIOUS PROTEIN - 700g", 120f);
              prices.put("WHEY PROTEIN COMPLEX 100% - 700g", 99f);
              prices.put("ULTRA WHEY - 908g", 115f);
              prices.put("CREATINE XPLODE - 500g", 39f);
              prices.put("CREA X3 - 400g", 59f);
              prices.put("CELL TECH PERFORMANCE SERIES - 2270g", 239f);
              prices.put("PROFI MASS - 1000g", 89f);
              prices.put("HARD MASS - 1000g", 119f);
              prices.put("DIET FUEL ULTRALEAN - 2000g", 249f);

            }

            public float getCena(String nazwa)
            {
                return prices.get(nazwa);
            }
            // return the name String
            public String getCategory()
            {
               return category;
            } // end method getName

            // set the name String
            public void setCategory( String _category )
            {
               this.category = _category;
            } // end method setName

            public String[] getChoices()
            {
               return choices;
            } // end method getName

            // set the name String
            public void setChoices( String[] _choices )
            {
               this.choices = _choices;
               CartBean.itemsMap.clear();
               for (String ch : _choices) {
                   CartBean.itemsMap.put(ch, prices.get(ch));
               }

            } // end method setName

            public String[] getBialka()
            {
                String[] lista;
                int i = 0;
                lista = new String[3];
                for (Map.Entry<String, String> entry : products.entrySet()) {
                    if (entry.getValue() == "odzywki_bialkowe"){
                        lista[i] = entry.getKey();
                        i++;
                        }
                    }
                    return lista;
            }

            public String[] getKreatyna()
            {
                String[] lista;
                int i = 0;
                lista = new String[3];
                for (Map.Entry<String, String> entry : products.entrySet()) {
                    if (entry.getValue() == "kreatyna"){
                        lista[i] = entry.getKey();
                        i++;
                    }
                }
                return lista;
            }

            public String[] getMasa()
            {
                String[] lista;
                int i = 0;
                lista = new String[3];
                for (Map.Entry<String, String> entry : products.entrySet()) {
                    if (entry.getValue() == "odzywki_na_mase"){
                        lista[i] = entry.getKey();
                        i++;
                    }
                }
                return lista;
            }

            public String[] getData()
            {
                if (category == "odzywki_bialkowe"){
                    return getBialka();
                }
                else if (category == "kreatyna"){
                    return getKreatyna();
                }
                else {
                    return getMasa();
                }
            }

            

       } // end class ValidationBean