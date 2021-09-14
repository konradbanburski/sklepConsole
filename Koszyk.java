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
 */
public class Koszyk 
{
    
    String szukajProdukt;
    double ilosc;
    
    List<Produkt> koszyk = new ArrayList<Produkt>();
    ListaProduktow listaProduktow = new ListaProduktow();
    
    //Wyszukuje produkt w sklepie, zwraca index produktu.
    int wyszukajProduktWSklepie(String szukajProdukt)  
    {  
        return listaProduktow.wyszukajProdukt(szukajProdukt); 
    }
    //Wyszukuje produkt w sklepie, wyświetla informacje tekstową czy produkt jest w sklepie.
    void wyszukajProduktWSklepieOpcja(String szukajProdukt)  
    {  
        listaProduktow.wyszukajProduktOpcja(szukajProdukt); 
    }
    
    //Wyszukuje produkt w koszyku, zwraca index produktu.
    int wyszukajProduktWKoszyku(String szukajProdukt)
    {
       int index=-1;
       for(int i=0; i < koszyk.size(); i++)
       {
            String trim = szukajProdukt.trim();
            int nazwaP = trim.compareToIgnoreCase(koszyk.get(i).getNazwa());
            if(nazwaP == 0)
            {
                index = i;
            }
                       
       }
       
       return index;
          
    }
    //Wyszukuje produkt w koszyku, wyświetla informacje tekstową czy produkt znajduje sie w koszyku.
    void wyszukajProduktWKoszykuOpcja (String szukajProdukt)
    {
       int index=-1;
       for(int i=0; i < koszyk.size(); i++)
       {    
            String trim = szukajProdukt.trim();
            int nazwaP = trim.compareToIgnoreCase(koszyk.get(i).getNazwa());
            if(nazwaP == 0)
            {
                index = i;
            }
           
            
       }
       
      if(index == -1)
       {
           System.out.println("Produkt nie znajduje się w koszyku");
       }
       else
       {
           System.out.println("Produkt znajduje się w koszyku");
       }
          
    }
    
    //Wyświetla zawartość koszyka.
    void wyswietlKoszyk()
    {
        if(koszyk.isEmpty())
        {
            System.out.println("Koszyk jest pusty!");
        }
        else
        {
        for(int i=0; i < koszyk.size(); i++)
            {
           System.out.println(koszyk.get(i).getNazwa() + " " + "Cena" + " " + koszyk.get(i).getCena() + " " + "Ilość" + " " + koszyk.get(i).getIlosc());           
            }
        }
    }
    //Wyświetla liste produktów w sklepie.
    void wyswietlListaProduktow()
    {
        
        listaProduktow.wyswietlProdukty();
  
    }
    //Dodaje produkt do koszyka.
    void dodajDoKoszyka(int index, int ilosc)
    {   
        Produkt produkt = new Produkt(listaProduktow.listaProduktow.get(index).getNazwa(), listaProduktow.listaProduktow.get(index).getCena(), listaProduktow.listaProduktow.get(index).getIlosc(), listaProduktow.listaProduktow.get(index).getIloscMin());
        koszyk.add(produkt);
        koszyk.get(koszyk.size()-1).zmienIlosc(ilosc);
        double iloscOdejm = listaProduktow.listaProduktow.get(index).getIlosc()-ilosc;
        listaProduktow.listaProduktow.get(index).zmienIlosc(iloscOdejm);
    }
    //Usuwa produkt z koszyka
    void usunZKoszyka(int index)   
    {   
        double iloscDodaj = listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).getIlosc() + koszyk.get(index).getIlosc();
        listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).zmienIlosc(iloscDodaj);
        koszyk.remove(index);
        
    }
    //Kupuj, czyści zawartość koszyka.
    void kupuj()
    {    
        if(koszyk.isEmpty())
        {
            System.out.println("Koszyk jest pusty.");
        }
        else
        {
        koszyk.clear();
        System.out.println("Dokonano zakupu.");
        }
    }
    //Zlicza wartość koszyka i ją zwraca.
    double wartoscKoszyka()
    {
        double wartosc = 0;
        for(int i = 0;i < koszyk.size(); i++)
        {
           wartosc += koszyk.get(i).getCena()*koszyk.get(i).getIlosc();
        }
        return wartosc;
    }
    
    //Zmienia ilość produktu koszyku, odejmując ilość produktu w sklepie. 
    void zmienIlosc(int index, double ilosc)
    {
        listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).zmienIlosc(listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).getIlosc()+ koszyk.get(index).getIlosc());
        koszyk.get(index).zmienIlosc(ilosc);
        double iloscOdejm = listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).getIlosc()-ilosc;
        listaProduktow.listaProduktow.get(listaProduktow.wyszukajProdukt(koszyk.get(index).getNazwa())).zmienIlosc(iloscOdejm);
    }

}
    
   
       
    
    
    
    
    
