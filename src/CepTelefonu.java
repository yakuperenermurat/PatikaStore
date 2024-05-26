package week5.teknikIcerik3.src;

import java.util.*;

import static week5.teknikIcerik3.src.patikaStore.markalar;
import static week5.teknikIcerik3.src.patikaStore.urunler;

public class CepTelefonu extends Urun{
    private int pil;
    private String renk;
    private int kamera;
    public CepTelefonu(int id, String urunAdi, double fiyat, Marka marka, int depolama, double ekran, int ram ,int pil , String renk , int kamera) {
        super(id, urunAdi, fiyat, marka, depolama, ekran, ram);
        this.pil = pil;
        this.renk = renk;
        this.kamera = kamera;
    }

    public int getPil() {
        return pil;
    }

    public void setPil(int pil) {
        this.pil = pil;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }
    public static void cepTelefonuListele() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s|\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        Set<Urun> cepTelefonlari = urunler.get("Cep Telefonları");
        for (Urun urun : cepTelefonlari) {
            CepTelefonu cepTelefonu = (CepTelefonu) urun;
            System.out.printf("| %-3d| %-30s| %-10.2f| %-10s| %-10d| %-10.1f| %-10d| %-10.1f| %-10d| %-10s|\n",
                    cepTelefonu.getId(), cepTelefonu.getUrunAdi(), cepTelefonu.getFiyat(), cepTelefonu.getMarka().getName(),
                    cepTelefonu.getDepolama(), cepTelefonu.getEkran(), cepTelefonu.getKamera(), cepTelefonu.getPil(),
                    cepTelefonu.getRam(), cepTelefonu.getRenk());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void cepTelefonuEkle() {
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
        System.out.print("Pil: ");
        int pil = input.nextInt();
        System.out.print("Renk: ");
        input.nextLine();
        String renk = input.nextLine();
        System.out.print("Kamera: ");
        int kamera = input.nextInt();

        urunler.get("Cep Telefonları").add(new CepTelefonu(patikaStore.urunIdCounter++, urunAdi, fiyat, marka, depolama, ekran, ram, pil, renk, kamera));
        System.out.println("Cep telefonu başarıyla eklendi!");
    }
    public static void cepTelefonuSil() {
        Scanner input = new Scanner(System.in);
        System.out.print("Silinecek Cep Telefonu ID'si: ");
        int cepTelefonuId = input.nextInt();

        Set<Urun> cepTelefonlari = urunler.get("Cep Telefonları");
        for (Iterator<Urun> iterator = cepTelefonlari.iterator(); iterator.hasNext(); ) {
            Urun urun = iterator.next();
            if (urun.getId() == cepTelefonuId) {
                iterator.remove();
                System.out.println("Cep telefonu başarıyla silindi!");
                return;
            }
        }

        System.out.println("Belirtilen ID'ye sahip bir cep telefonu bulunamadı!");
    }
}

