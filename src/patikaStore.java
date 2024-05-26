package week5.teknikIcerik3.src;

import java.util.*;

public class patikaStore {

    public static Map<String, Set<Urun>> urunler = new HashMap<>();
    public static Set<Marka> markalar = new TreeSet<>((m1, m2) -> m1.getName().compareTo(m2.getName()));
    public static int urunIdCounter = 1;
    static {
        markalar.add(new Marka(1, "SAMSUNG"));
        markalar.add(new Marka(2, "LENOVA"));
        markalar.add(new Marka(3, "APPLE"));
        markalar.add(new Marka(4, "HUAWEİ"));
        markalar.add(new Marka(5, "CASPER"));
        markalar.add(new Marka(6, "ASUS"));
        markalar.add(new Marka(7, "HP"));
        markalar.add(new Marka(8, "XİAOMİ"));
        markalar.add(new Marka(9, "MONSTER"));

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
    public static void urunFiltreleById(int id) {
        System.out.println("ID'ye Göre Ürün Filtreleme");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-12s|\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        boolean urunBulundu = false;

        for (Set<Urun> urunSet : urunler.values()) {
            for (Urun urun : urunSet) {
                if (urun.getId() == id) {
                    urunBulundu = true;
                    System.out.printf("| %-3d| %-30s| %-10.2f| %-10s| %-10d| %-10.1f| %-12d|\n",
                            urun.getId(), urun.getUrunAdi(), urun.getFiyat(), urun.getMarka().getName(),
                            urun.getDepolama(), urun.getEkran(), urun.getRam());
                    break; // Bulunan ürünün ID'si eşleştiği için döngüden çık
                }
            }
        }

        if (!urunBulundu) {
            System.out.println("Aradığınız ID'ye ait ürün bulunamadı.");
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public static void urunFiltreleByMarka(String markaAdi) {
        System.out.println("Markaya Göre Ürün Filtreleme");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-12s|\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        boolean urunBulundu = false;

        for (Set<Urun> urunSet : urunler.values()) {
            for (Urun urun : urunSet) {
                if (urun.getMarka().getName().equalsIgnoreCase(markaAdi)) {
                    urunBulundu = true;
                    System.out.printf("| %-3d| %-30s| %-10.2f| %-10s| %-10d| %-10.1f| %-12d|\n",
                            urun.getId(), urun.getUrunAdi(), urun.getFiyat(), urun.getMarka().getName(),
                            urun.getDepolama(), urun.getEkran(), urun.getRam());
                }
            }
        }

        if (!urunBulundu) {
            System.out.println("Aradığınız markaya ait ürün bulunamadı.");
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
    }

}
