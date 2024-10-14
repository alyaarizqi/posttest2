package manajemenKeuangan.models;

public class Pengeluaran extends Transaksi {
    private String metodePembayaran;

    public Pengeluaran(double jumlah, String keterangan, String metodePembayaran) {
        super(jumlah, keterangan);
        setJenis("Pengeluaran"); 
        this.metodePembayaran = metodePembayaran;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }
}
