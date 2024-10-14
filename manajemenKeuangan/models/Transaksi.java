package manajemenKeuangan.models;

public class Transaksi {
    private double jumlah;
    private String keterangan;
    private String jenis; // "Pendapatan" atau "Pengeluaran"

    public Transaksi(double jumlah, String keterangan) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
