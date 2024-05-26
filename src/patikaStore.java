package week5.teknikIcerik3.src;

import java.util.*;

public class patikaStore {

    public static Map<String, Set<Urun>> urunler = new HashMap<>();
    public static Set<Marka> markalar = new TreeSet<>((m1, m2) -> m1.getName().compareTo(m2.getName()));
    public static int urunIdCounter = 1;
    static {
        markalar.add(new Marka(1, "Samsung"));
        markalar.add(new Marka(2, "Lenovo"));
        markalar.add(new Marka(3, "Apple"));
        markalar.add(new Marka(4, "Huawei"));
        markalar.add(new Marka(5, "Casper"));
        markalar.add(new Marka(6, "Asus"));
        markalar.add(new Marka(7, "HP"));
        markalar.add(new Marka(8, "Xiaomi"));
        markalar.add(new Marka(9, "Monster"));

        urunler.put("Cep Telefonları", new HashSet<>());
        urunler.put("Notebook", new HashSet<>());
    }
    public static void notebookIslemleri() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Notebook İşlemleri");
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("4 - Geri");
            System.out.print("Tercihiniz: ");
            int tercih = input.nextInt();

            switch (tercih) {
                case 1:
                    Notebook.notebookListele();
                    break;
                case 2:
                    Notebook.notebookEkle();
                    break;
                case 3:
                    Notebook.notebookSil();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz bir tercih yaptınız!");
            }
        }
    }

    public static void cepTelefonuIslemleri() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Cep Telefonu İşlemleri");
            System.out.println("1 - Cep Telefonu Listele");
            System.out.println("2 - Cep Telefonu Ekle");
            System.out.println("3 - Cep Telefonu Sil");
            System.out.println("4 - Geri");
            System.out.print("Tercihiniz: ");
            int tercih = input.nextInt();

            switch (tercih) {
                case 1:
                    CepTelefonu.cepTelefonuListele();
                    break;
                case 2:
                    CepTelefonu.cepTelefonuEkle();
                    break;
                case 3:
                    CepTelefonu.cepTelefonuSil();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz bir tercih yaptınız!");
            }
        }
    }

    public static void markaListele() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Marka marka : markalar) {
            System.out.println("- " + marka.getName());
        }
        System.out.println();
    }

}
