/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sklep;

import java.util.Scanner;
/**
 *
 * @author Mac
 */
public class Sklep {

    
    public static void main(String[] args) {
 
         int wybor = 0, ilosc = 0, iloscMin = 0;
         double cena = 0;
         boolean exit=false;
         String szukajProdukt, nazwaProduktu;
         
         
         
         System.out.println("1. User"); 
         System.out.println("2. Admin"); 
         
         Scanner odczyt1 = new Scanner(System.in); 
         wybor = odczyt1.nextInt();
         
         if(wybor == 1)
         {
             Koszyk user = new Koszyk();
             
             while(exit==false)
             {  
                 System.out.println("");
                 System.out.println("1. Wyświetl produkty w sklepie");
                 System.out.println("2. Wyszukaj produkt w sklepie");
                 System.out.println("3. Dodaj do koszyka");
                 System.out.println("4. Usuń z koszyka");
                 System.out.println("5. Wyświetl produkty w koszyku");
                 System.out.println("6. Wyszukaj produkt w koszyku");
                 System.out.println("7. Wyświetl łączną cene zawartości koszyka");
                 System.out.println("8. Dokonaj zakupu");
                 System.out.println("9. Wyjdź");
                 
                 Scanner odczyt2 = new Scanner(System.in);
                 wybor = odczyt2.nextInt();
                 
                 switch(wybor)
                 {
                     case (1):
                     {
                         user.wyswietlListaProduktow();
                         break;
                     }
                     case (2):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         
                         user.wyszukajProduktWSklepieOpcja(szukajProdukt);
                         
                         break;
                     }
                     case (3):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         if(user.wyszukajProduktWSklepie(szukajProdukt) == -1)
                         {
                             System.out.println("Podany produkt nie istnieje");
                         }
                         else
                         {
                         System.out.println("Podaj ilość");
                         Scanner inIlosc = new Scanner(System.in);
                         ilosc = inIlosc.nextInt();
                         
                         if( ilosc <= user.listaProduktow.listaProduktow.get(user.wyszukajProduktWSklepie(szukajProdukt)).getIlosc())
                         {
                            if(user.wyszukajProduktWKoszyku(szukajProdukt) == -1)
                            {
                                  
                                 user.dodajDoKoszyka(user.wyszukajProduktWSklepie(szukajProdukt), ilosc);
                          
                            }
                            else
                            {   
                               
                                
                                
                                user.zmienIlosc(user.wyszukajProduktWKoszyku(szukajProdukt), ilosc);
                                System.out.println("Produkt znajdował się już w koszyku, zastąpiono poprzednią ilość");
                            }
                         }
                         else
                         {
                             if(user.wyszukajProduktWKoszyku(szukajProdukt)== -1)
                             {
                                System.out.println("Podano zbyt dużą ilośc produktu, maksymalnie możesz zakupić:" + " " + user.listaProduktow.listaProduktow.get(user.wyszukajProduktWSklepie(szukajProdukt)).getIlosc());
                             }
                             else
                             {
                                double iloscDostepna = user.listaProduktow.listaProduktow.get(user.wyszukajProduktWSklepie(szukajProdukt)).getIlosc() + user.koszyk.get(user.wyszukajProduktWKoszyku(szukajProdukt)).getIlosc();                       
                                System.out.println("Podano zbyt dużą ilośc produktu, maksymalnie możesz zakupić:" + " " + iloscDostepna );
                             }
                         }
                         }
                         break;
                     }
                     case (4):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         
                         user.usunZKoszyka(user.wyszukajProduktWKoszyku(szukajProdukt));
                         break;
                     }
                     case (5):
                     {
                         user.wyswietlKoszyk();
                         break;
                     }
                     case (6):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         
                         user.wyszukajProduktWKoszykuOpcja(szukajProdukt);
                         break;
                     }
                     case (7):
                     {
                         System.out.println(user.wartoscKoszyka());
                         break;
                     }
                     case (8):
                     {
                         
                         user.kupuj();
                         break;
                     }
                     case (9):
                     {
                         exit=true;
                     }
                 }
                         
                 
                 
             }
             
             
             
         }
         else if(wybor == 2)
         {
             Administrator admin = new Administrator();
             
             while(exit==false)
             {  
                 System.out.println("");
                 System.out.println("1. Wyświetl produkty w sklepie");
                 System.out.println("2. Wyszukaj produkt w sklepie");
                 System.out.println("3. Wyświetl produkty o ilości minimalnej");
                 System.out.println("4. Dodaj produkt");
                 System.out.println("5. Usuń produkt");
                 System.out.println("6. Zmień cene produktu");
                 System.out.println("7. Zmień ilość produktu");
                 System.out.println("8. Wyjdź");
                 
                 Scanner odczyt2 = new Scanner(System.in);
                 wybor = odczyt2.nextInt();
                 
                 switch(wybor)
                 {
                     case (1):
                     {
                         admin.wyświetlProdukty();
                         break;
                     }
                     case (2):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         
                         admin.wyszukajProduktOpcja(szukajProdukt);
                         
                      
       
                         
                         break;
                     }
                     case (3):
                     {
                         admin.wyświetlMin();
                         break;
                     }
                     case (4):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj1 = new Scanner(System.in);
                         nazwaProduktu = szukaj1.nextLine();
                         
                         System.out.println("Podaj cene produktu");
                         Scanner szukaj2 = new Scanner(System.in);
                         cena = szukaj2.nextDouble();
                         
                         System.out.println("Podaj ilość produktu");
                         Scanner szukaj3 = new Scanner(System.in);
                         ilosc = szukaj3.nextInt();
                         
                         System.out.println("Podaj ilość minimalną produktu");
                         Scanner szukaj4 = new Scanner(System.in);
                         iloscMin = szukaj4.nextInt();
                         
                         admin.dodajProdukt(nazwaProduktu, cena, ilosc, iloscMin);
                         break;
                     }
                     case (5):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj = new Scanner(System.in);
                         szukajProdukt = szukaj.nextLine();
                         
                         admin.usunProdukt(admin.wyszukajProdukt(szukajProdukt));
                         
                         break;
                     }
                     case (6):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj1 = new Scanner(System.in);
                         szukajProdukt = szukaj1.nextLine();
                         
                         System.out.println("Podaj nową cene produktu");
                         Scanner szukaj2 = new Scanner(System.in);
                         cena = szukaj2.nextDouble();
                         
                         admin.zmienCena(cena, admin.wyszukajProdukt(szukajProdukt));
                         break;
                     }
                     case (7):
                     {
                         System.out.println("Podaj nazwę produktu");
                         Scanner szukaj1 = new Scanner(System.in);
                         szukajProdukt = szukaj1.nextLine();
                         
                         System.out.println("Podaj nową ilość produktu");
                         Scanner szukaj2 = new Scanner(System.in);
                         ilosc = szukaj2.nextInt();
                         
                         admin.zmienIlosc(ilosc, admin.wyszukajProdukt(szukajProdukt));
                         break;
                     }
                     case (8):
                     {
                         exit=true;
                     }
                   
                 }
                         
                 
                 
             }
             
         }
            
        }
       
    }
    

