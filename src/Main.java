package week5.teknikIcerik3.src;

import java.util.Scanner;

import static week5.teknikIcerik3.src.patikaStore.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("4 - ID'ye Göre Ürün Filtreleme");
            System.out.println("5 - Markaya Göre Ürün Filtreleme");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int tercih = input.nextInt();

            switch (tercih) {
                case 1:
                    notebookIslemleri();
                    break;
                case 2:
                    cepTelefonuIslemleri();
                    break;
                case 3:
                    markaListele();
                    break;
                case 4:
                    System.out.println("Filtrelemek istediğiniz id yi giriniz : ");
                    int IdFiltre = input.nextInt();
                    urunFiltreleById(IdFiltre);
                    break;
                case 5:
                    input.nextLine(); // Önceki girdiyi temizle
                    System.out.println("Filtrelemek istediğiniz markayı giriniz : ");
                    String markayaFiltre = input.nextLine().toUpperCase();
                    urunFiltreleByMarka(markayaFiltre);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    input.close();
                    return;
                default:
                    System.out.println("Geçersiz bir tercih yaptınız!");
            }
        }
    }
}
