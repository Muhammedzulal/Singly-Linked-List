package LinkedList;

import java.util.Scanner;

public class Uygulama {
    public static void main(String[] args) {
        Liste list = new Liste();
        int secim = 1;
        int sayi, index;
        Scanner sc = new Scanner(System.in);
        while (secim != 0) {
            System.out.println("1: Başa ekle");
            System.out.println("2: Sona ekle");
            System.out.println("3: Araya ekle");
            System.out.println("4: Baştan sil");
            System.out.println("5: Sondan sil");
            System.out.println("6: Aradan sil");
            System.out.println("7: Yazdır");
            System.out.println("0: Çıkış");
            System.out.print("Seçim : ");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    System.out.print("Sayı: ");
                    sayi = sc.nextInt();
                    System.out.println();
                    list.basaEkle(sayi);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Sayı: ");
                    sayi = sc.nextInt();
                    System.out.println();
                    list.sonaekle(sayi);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Sayı: ");
                    sayi = sc.nextInt();
                    System.out.print("Index: ");
                    index = sc.nextInt();
                    System.out.println();
                    list.arayaEkle(index, sayi);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    list.bastanSil();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    list.sondanSil();
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Index: ");
                    index = sc.nextInt();
                    System.out.println();
                    list.aradanSil(index);
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    list.yazdir();
                    System.out.println();
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------");
            System.out.println();
        }
        sc.close();
    }
}
