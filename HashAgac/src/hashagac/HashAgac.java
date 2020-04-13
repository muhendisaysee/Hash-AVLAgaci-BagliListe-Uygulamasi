package hashagac;

import java.util.Scanner;

public class HashAgac {

    public static void main(String[] args) {

        System.out.println("-----------ULKELERİN VERİLERİNİN TUTULDUĞU SISTEME HOSGELDINIZ!!---------");
        Scanner giris = new Scanner(System.in);
        Node agac = null;
        Node gelenDeger = null;

        int t = 0;
        int secim = 0;
        System.out.println("Lutfen Hash'in eleman sayisini giriniz ? : ");
        int N;
        N = giris.nextInt();
        HashIslemler hash = new HashIslemler(N);

        while (t == 0) {
            System.out.println("Hangi veri yapısını kullanmak istiyorsunuz?");
            System.out.println("1 : Agac");
            System.out.println("2 : Hash");
            t = giris.nextInt();

            if (t == 1) {
                System.out.println("Hangi işlemi yapmak istiyorsunuz?");
                System.out.println("1 : Ekleme");
                System.out.println("2 : Silme");
                System.out.println("3 : Arama");
                System.out.println("4 : Güncelleme");
                System.out.println("5 : Listeleme");

                secim = giris.nextInt();
                /*------------------------------------------------------------------------------------------------------------*/
                if (secim == 1) {
                    int ulkeNo;
                    boolean kontrol;
                    String isim;
                    int x = 0;
                    System.out.println("Eklemek istedigiz ulkenin ismi : ");
                    isim = giris.next();
                    System.out.println("Eklemek istediginiz ulkenin numarasi : ");
                    ulkeNo = giris.nextInt();
                    System.out.println("Eklemek istediginiz ulkenin denize kiyisi var mi? : ");
                    System.out.println("Evet : 1 ");
                    System.out.println("Hayir : 0  ");
                    x = giris.nextInt();
                    if (x == 1) {
                        kontrol = true;
                    } else {
                        kontrol = false;
                    }
                    AVL nesne = new AVL();
                    agac = nesne.EkleRecursive(ulkeNo, isim, kontrol, agac);

                } /*------------------------------------------------------------------------------------------------------------*/
                else if (secim == 2) {
                    int silinecek;
                    System.out.println("Silinecek ulkenin numarasini giriniz : ");
                    silinecek = giris.nextInt();

                    AVL nesne = new AVL();
                    agac = nesne.UlkeSil(agac, silinecek);
                    agac=nesne.SilmeDengele(agac);
                } /*------------------------------------------------------------------------------------------------------------*/ 
                else if (secim == 3) {

                    int aranan;
                    System.out.println("Aramak istediginiz ulkenin numarasini giriniz : ");
                    aranan = giris.nextInt();
                    AVL nesne = new AVL();
                    gelenDeger = nesne.AraRecursive(agac, aranan);
                    if (gelenDeger == null) {
                        System.out.println("Aranan deger bulunamadi!!");
                    } else {
                        System.out.println("Aranan deger bulundu, ulkeNo : " + gelenDeger.ulkeNo);
                    }

                } /*------------------------------------------------------------------------------------------------------------*/
                else if (secim == 4) {
                    int tmp;
                    String yeniIsim = null;
                    int yeniUlkeNo = 0;
                    boolean kontrol = false;
                    int guncellenecek;
                    System.out.println("Guncellemek istediginiz ulkenin numarasini giriniz");
                    guncellenecek = giris.nextInt();
                    System.out.println("Yeni ulke ismini giriniz : ");
                    yeniIsim = giris.next();
                    System.out.println("Yeni ulke numarasini giriniz : ");
                    yeniUlkeNo = giris.nextInt();
                    System.out.println("Yeni ulkenin denize kiyisi var mi : ");
                    System.out.println("1 : Evet ");
                    System.out.println("2 : Hayir ");
                    tmp = giris.nextInt();
                    if (tmp == 1) {
                        kontrol = true;
                    } else {
                        kontrol = false;
                    }

                    AVL yeni = new AVL();
                    agac = yeni.AgactaElemanGuncelleme(agac, guncellenecek, yeniUlkeNo, yeniIsim, kontrol);

                } /*------------------------------------------------------------------------------------------------------------*/ 
                else if (secim == 5) {
                    AVL nesne = new AVL();
                    nesne.inOrder(agac);
                }
                /*------------------------------------------------------------------------------------------------------------*/
            } else if (t == 2) {

                System.out.println("Hangi islemi yapmak istiyorsunuz ?");
                System.out.println("1 : Ekleme");
                System.out.println("2 : Silme");
                System.out.println("3 : Arama");
                System.out.println("4 : Guncelleme");
                System.out.println("5 : Listeleme");
                secim = giris.nextInt();
                if (secim == 1) {
                    String isim;
                    int ulkeNo;
                    boolean kiyi;
                    int kontrol;
                    System.out.println("Eklemek istediginiz ulkenin ismi : ");
                    isim = giris.next();
                    System.out.println("Eklemek istediginiz ulkenin numarasi : ");
                    ulkeNo = giris.nextInt();
                    System.out.println("Eklemek istediginiz ulkenin denize kiyisi var mi? : ");
                    System.out.println("1 : Evet");
                    System.out.println("0 : Hayir");
                    kontrol = giris.nextInt();
                    if (kontrol == 1) {
                        kiyi = true;
                    } else {
                        kiyi = false;
                    }
                    hash.HashElemanEkle(isim, ulkeNo, kiyi);
                } else if (secim == 2) {
                    int silinecek;
                    System.out.println("Silmek istediginiz ulkenin numarasi : ");
                    silinecek = giris.nextInt();
                    hash.sil(silinecek);
                } else if (secim == 3) {
                    int aranacak;
                    System.out.println("Aranacak ulkenin numarasini giriniz : ");
                    aranacak = giris.nextInt();
                    hash.HashAra(aranacak);
                } else if (secim == 4) {

                    int guncellenecek;
                    int kontrol;
                    String yeniIsim;
                    int yeniUlkeNo;
                    boolean yeniKontrol;
                    System.out.println("Guncellencek ulkenin numarasini giriniz : ");
                    guncellenecek = giris.nextInt();
                    System.out.println("Yeni ulkenin ismini giriniz : ");
                    yeniIsim = giris.next();
                    System.out.println("Yeni ulkenin numarasini giriniz : ");
                    yeniUlkeNo = giris.nextInt();
                    System.out.println("Yeni ulkenin denize kiyisi var mi? : ");
                    System.out.println("1 : Evet");
                    System.out.println("0 : Hayir");
                    kontrol = giris.nextInt();
                    if (kontrol == 1) {
                        yeniKontrol = true;
                    } else {
                        yeniKontrol = false;
                    }
                    hash.HashGuncelle(guncellenecek, yeniIsim, yeniUlkeNo, yeniKontrol);
                } else if (secim == 5) {
                    hash.yazdir();
                }
            }
            System.out.println("Devam etmek istiyorsaniz 0'a basınız !");
            t = giris.nextInt();
        }
    }
}
