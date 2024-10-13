package manajemenKeuangan.models;

public class Transaksi {
    private double jumlah;
    private String jenis;
    private String keterangan;

     // Constructor
    public Transaksi(double jumlah, String jenis, String keterangan) {
        this.jumlah = jumlah;
        this.jenis = jenis;
        this.keterangan = keterangan;
    }

    // Getter dan Setter
    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    // Method untuk menampilkan transaksi
    public void tampilkanTransaksi() {
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Jenis: " + jenis);
        System.out.println("Keterangan: " + keterangan);
        System.out.println("--------------------------"); 
    }
}