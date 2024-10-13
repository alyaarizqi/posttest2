/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemenKeuangan.Interfaces;

/**
 *
 * @author LENOVO
 */

public interface TransaksiInterface {
    void tambahTransaksi(double nominal, String jenis, String keterangan);
    void lihatTransaksi();
    void hapusTransaksi(String keterangan);
    void updateTransaksi(String keterangan);
}

