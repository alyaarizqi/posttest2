package manajemenKeuangan.models;

public class Pemasukan extends Transaksi {
    public Pemasukan(double jumlah, String keterangan) {
        super(jumlah, "Pemasukan", keterangan);
    }
}
