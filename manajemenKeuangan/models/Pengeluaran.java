package manajemenKeuangan.models;

public class Pengeluaran extends Transaksi {
    public Pengeluaran(double jumlah, String keterangan) {
        super(jumlah, "Pengeluaran", keterangan);
    }
}
