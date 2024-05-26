package week5.teknikIcerik3.src;

public class Urun {
    private int id;
    private String urunAdi;
    private double fiyat;
    private Marka marka;
    private int depolama ;
    private double ekran ;
    private int ram ;

    public Urun(int id, String urunAdi , double fiyat, Marka marka , int depolama , double ekran , int ram) {
        this.id = id;
        this.fiyat = fiyat;
        this.marka = marka;
        this.depolama = depolama;
        this.ekran = ekran;
        this.ram = ram;
        this.urunAdi = urunAdi;
        this.marka = marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public int getDepolama() {
        return depolama;
    }

    public void setDepolama(int depolama) {
        this.depolama = depolama;
    }

    public double getEkran() {
        return ekran;
    }

    public void setEkran(double ekran) {
        this.ekran = ekran;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
