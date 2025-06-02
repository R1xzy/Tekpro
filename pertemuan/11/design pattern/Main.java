// ===================== Structural Pattern =====================
interface RekamMedis {
    void tampilkanData();
}

class PasienRecord implements RekamMedis {
    private String nama;

    public PasienRecord(String nama) {
        this.nama = nama;
        loadDataDariDatabase();
    }

    private void loadDataDariDatabase() {
        System.out.println("Mengambil rekam medis lengkap dari database untuk " + nama);
    }

    public void tampilkanData() {
        System.out.println("Data lengkap pasien: " + nama);
    }
}

class RekamMedisProxy implements RekamMedis {
    private String nama;
    private PasienRecord realRecord;

    public RekamMedisProxy(String nama) {
        this.nama = nama;
    }

    public void tampilkanData() {
        if (realRecord == null) {
            realRecord = new PasienRecord(nama);
        }
        realRecord.tampilkanData();
    }
}

class AntrianService {
    void daftarkan(String nama) {
        System.out.println(nama + " telah masuk antrian.");
    }
}

class JadwalService {
    void aturJadwal(String nama) {
        System.out.println("Jadwal untuk " + nama + " telah dibuat.");
    }
}

class PembayaranService {
    void prosesPembayaran(String nama) {
        System.out.println("Pembayaran untuk " + nama + " telah diproses.");
    }
}

class KlinikApp {
    private AntrianService antrian = new AntrianService();
    private JadwalService jadwal = new JadwalService();
    private PembayaranService bayar = new PembayaranService();

    public void daftarPasien(String nama) {
        antrian.daftarkan(nama);
        jadwal.aturJadwal(nama);
        bayar.prosesPembayaran(nama);
    }
}

// ===================== Behavioral Pattern =====================
abstract class LayananPasien {
    public final void proses() {
        verifikasi();
        konsultasi();
        pembayaran();
    }

    protected abstract void verifikasi();
    protected abstract void konsultasi();
    protected abstract void pembayaran();
}

class LayananUmum extends LayananPasien {
    protected void verifikasi() {
        System.out.println("Verifikasi data pasien umum...");
    }

    protected void konsultasi() {
        System.out.println("Konsultasi dengan dokter umum...");
    }

    protected void pembayaran() {
        System.out.println("Bayar biaya layanan umum...");
    }
}

interface MetodePembayaran {
    void bayar(int jumlah);
}

class Tunai implements MetodePembayaran {
    public void bayar(int jumlah) {
        System.out.println("Bayar tunai: Rp" + jumlah);
    }
}

class QRIS implements MetodePembayaran {
    public void bayar(int jumlah) {
        System.out.println("Bayar via QRIS: Rp" + jumlah);
    }
}

class Asuransi implements MetodePembayaran {
    public void bayar(int jumlah) {
        System.out.println("Biaya ditanggung asuransi.");
    }
}

class PembayaranContext {
    private MetodePembayaran metode;

    public void setMetode(MetodePembayaran metode) {
        this.metode = metode;
    }

    public void prosesPembayaran(int jumlah) {
        metode.bayar(jumlah);
    }
}

// ===================== Creational Pattern =====================
class Pasien {
    private String nama;
    private String kontakDarurat;
    private String alergi;

    private Pasien(Builder builder) {
        this.nama = builder.nama;
        this.kontakDarurat = builder.kontakDarurat;
        this.alergi = builder.alergi;
    }

    public static class Builder {
        private String nama;
        private String kontakDarurat;
        private String alergi;

        public Builder(String nama) {
            this.nama = nama;
        }

        public Builder setKontakDarurat(String kontak) {
            this.kontakDarurat = kontak;
            return this;
        }

        public Builder setAlergi(String alergi) {
            this.alergi = alergi;
            return this;
        }

        public Pasien build() {
            return new Pasien(this);
        }
    }

    public void tampilkanInfo() {
        System.out.println("Pasien: " + nama);
        if (kontakDarurat != null) System.out.println("Kontak darurat: " + kontakDarurat);
        if (alergi != null) System.out.println("Alergi: " + alergi);
    }
}

abstract class Dokter {
    abstract void layaniPasien();
}

class DokterUmum extends Dokter {
    void layaniPasien() {
        System.out.println("Dokter umum melayani pasien...");
    }
}

class DokterGigi extends Dokter {
    void layaniPasien() {
        System.out.println("Dokter gigi melayani pasien...");
    }
}

class DokterTHT extends Dokter {
    void layaniPasien() {
        System.out.println("Dokter THT melayani pasien...");
    }
}

abstract class Klinik {
    abstract Dokter buatDokter();
}

class KlinikUmum extends Klinik {
    Dokter buatDokter() {
        return new DokterUmum();
    }
}

class KlinikGigi extends Klinik {
    Dokter buatDokter() {
        return new DokterGigi();
    }
}

class KlinikTHT extends Klinik {
    Dokter buatDokter() {
        return new DokterTHT();
    }
}

// ===================== MAIN =====================
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern ===");
        RekamMedis rekam = new RekamMedisProxy("Rifqi");
        rekam.tampilkanData();

        System.out.println("\n=== Facade Pattern ===");
        KlinikApp app = new KlinikApp();
        app.daftarPasien("Rifqi");

        System.out.println("\n=== Template Pattern ===");
        LayananPasien layanan = new LayananUmum();
        layanan.proses();

        System.out.println("\n=== Strategy Pattern ===");
        PembayaranContext context = new PembayaranContext();
        context.setMetode(new QRIS());
        context.prosesPembayaran(100000);

        System.out.println("\n=== Builder Pattern ===");
        Pasien pasien = new Pasien.Builder("Rifqi")
                .setKontakDarurat("081234567890")
                .setAlergi("Debu")
                .build();
        pasien.tampilkanInfo();

        System.out.println("\n=== Factory Method Pattern ===");
        Klinik klinik = new KlinikGigi();
        Dokter dokter = klinik.buatDokter();
        dokter.layaniPasien();
    }
}
