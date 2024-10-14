package manajemenKeuangan.models;

public abstract class Transaksi {
    protected double jumlah;
    protected String keterangan;
    protected String jenis;

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

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public abstract void tampilkanTransaksi();
}
