package week5.teknikIcerik3.src;

import java.util.*;

import static week5.teknikIcerik3.src.patikaStore.markalar;
import static week5.teknikIcerik3.src.patikaStore.urunler;

public class Notebook extends Urun{

    public Notebook(int id, String urunAdi, double fiyat, Marka marka, int depolama, double ekran, int ram) {
        super(id, urunAdi, fiyat, marka, depolama, ekran, ram);
    }
    public static void notebookListele() {
        System.out.println("Notebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-12s|\n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        Set<Urun> notebooklar = urunler.get("Notebook");
        for (Urun urun : notebooklar) {
            Notebook notebook = (Notebook) urun;
            System.out.printf("| %-3d| %-30s| %-10.2f| %-10s| %-10d| %-10.1f| %-12d|\n",
                    notebook.getId(), notebook.getUrunAdi(), notebook.getFiyat(), notebook.getMarka().getName(),
                    notebook.getDepolama(), notebook.getEkran(), notebook.getRam());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
    }
    public static void notebookEkle() {
        Scanner input = new Scanner(System.in);

        System.out.print("Ürün Adı: ");
        String urunAdi = input.nextLine();
        System.out.print("Fiyat: ");
        double fiyat = input.nextDouble();
        List<Marka> siraliMarkalar = new ArrayList<>(markalar);
        siraliMarkalar.sort(Comparator.comparingInt(Marka::getId));

        System.out.println("Marka ID'leri ve Markalar:");
        for (Marka m : siraliMarkalar) {
            System.out.println(m.getId() + " - " + m.getName());
        }
        System.out.print("Eklemek İstediğiniz Ürünün Marka ID: ");
        int markaId = input.nextInt();
        Marka marka = null;
        for (Marka m : markalar) {
            if (m.getId() == markaId) {
                marka = m;
                break;
            }
        }
        if (marka == null) {
            System.out.println("Geçersiz marka ID'si!");
            return;
        }
        System.out.print("Depolama: ");
        int depolama = input.nextInt();
        System.out.print("Ekran: ");
        double ekran = input.nextDouble();
        System.out.print("RAM: ");
        int ram = input.nextInt();

        urunler.get("Notebook").add(new Notebook(patikaStore.urunIdCounter++, urunAdi, fiyat, marka, depolama, ekran, ram));
        System.out.println("Notebook başarıyla eklendi!");
    }
    public static void notebookSil() {
        Scanner input = new Scanner(System.in);
        System.out.print("Silinecek Notebook ID'si: ");
        int notebookId = input.nextInt();

        Set<Urun> notebooklar = urunler.get("Notebook");
        for (Iterator<Urun> iterator = notebooklar.iterator(); iterator.hasNext(); ) {
            Urun urun = iterator.next();
            if (urun.getId() == notebookId) {
                iterator.remove();
                System.out.println("Notebook başarıyla silindi!");
                return;
            }
        }
        System.out.println("Belirtilen ID'ye sahip bir notebook bulunamadı!");
    }


}
