/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sklep;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mac
 */
public class ListaProduktow {
    
    
   List<Produkt> listaProduktow = new ArrayList<Produkt>();
   Produkt produkt1 = new Produkt("Brokuły", 5, 100, 20);
   Produkt produkt2 = new Produkt("Marchew", 2, 100, 20);
   Produkt produkt3 = new Produkt("Ziemniaki", 2, 100, 20);
   Produkt produkt4 = new Produkt("Kalafior", 10, 2, 10);
    public ListaProduktow()
    {
               listaProduktow.add(produkt1);
               listaProduktow.add(produkt2);
               listaProduktow.add(produkt3);
               listaProduktow.add(produkt4);
    }   
 
   //Wyświetla produkty w sklepie.         
   void wyswietlProdukty()
   {
       for(int i=0; i < listaProduktow.size(); i++)
       {
           System.out.println(listaProduktow.get(i).getNazwa() + " " + "Cena" + " " + listaProduktow.get(i).getCena() + " " + "Ilość" + " " + listaProduktow.get(i).getIlosc());
           
       }
   }
   //Dodaje nowy produkt do listy.
   void dodajProdukt(String nazwa, double cena, double ilosc, double iloscMin)
   {
       Produkt produkt = new Produkt(nazwa, cena, ilosc, iloscMin);
       listaProduktow.add(produkt);
   }
   //Usuwa produkt z listy.
   void usunProdukt(int i)
   {
       listaProduktow.remove(i);
   }
    
   //Wyszukuje produtk w sklepie, zwraca index produktu.
   int wyszukajProdukt (String nazwa)
   {
       int index=-1;
      
       for(int i=0; i < listaProduktow.size(); i++)
       {
            String trim = nazwa.trim();
            int nazwaP = trim.compareToIgnoreCase(listaProduktow.get(i).getNazwa());
           
            if(nazwaP == 0)
            {
                index = i;
            }
       }
          
       return index;
              
   }
   
   //Wyszukuje produkt w sklepie, wyświetla wiadomość tekstową czy produkt istnieje w sklepie.
   void wyszukajProduktOpcja (String nazwa)
   {
       int index = -1;
       
       for(int i=0; i < listaProduktow.size(); i++)
       {    
            String trim = nazwa.trim();
            int nazwaP = trim.compareToIgnoreCase(listaProduktow.get(i).getNazwa());
            if(nazwaP == 0)
            {
                index = i;
            }
       }
       
       if(index == -1)
       {
           System.out.println("Brak produktu");
       }
       else
       {
           System.out.println("Produkt dostępny");
       }
   }
   //Zmienia ilość produktu.
   void zmienIlosc (double ilosc, int index)
   {       
       listaProduktow.get(index).zmienIlosc(ilosc);       
   }
   //Zmienia cene produktu.
   void zmienCene (double cena, int index)
   {
       listaProduktow.get(index).setCena(cena);
   }
   //Wyświetla produkty z wartością równą lub mniejszą od minimalnej.
   void wyswietlMin()
   {
       for(int i=0; i < listaProduktow.size(); i++)
       {
           if(listaProduktow.get(i).getIloscMin()>=listaProduktow.get(i).getIlosc())
           {
           System.out.println(listaProduktow.get(i).getNazwa() + " " + "Ilość" + " " + listaProduktow.get(i).getIlosc() + " " + "Ilość minimalna" + " " + listaProduktow.get(i).getIloscMin());
           }
       }
   }
}
