package endri.agung.aplikasipendataanmobil;

import android.provider.BaseColumns;

import java.io.Serializable;


/**
 * Created by D2J-00 on 15/02/2017.
 */
public class Mobil implements BaseColumns,Serializable{
    public String nama; //nama transaksi
    public int jenis; // 1 = pemasukan 2 = pengeluaran
    public int jumlah;
    public String produksiby;
    public int thnproduksi;
    public String keterangan;

    public Mobil(String nama,String produksiby,int thnproduksi, int jenis, int jumlah) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.produksiby = produksiby;
        this.thnproduksi = thnproduksi;


    }

    public Mobil(String nama,String produksiby,int thnproduksi, int jenis, int jumlah, String keterangan) {
        this.nama = nama;
        this.produksiby = produksiby;
        this.thnproduksi = thnproduksi;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public String getJenis()
    {
        if (this.jenis == 1)
            return "pemasukan ";
        return "pengeluaran ";
    }

    public String toString()
    {
        return this.nama+": "+this.jumlah;
    }

    // informasi properti Tabel
    public static final String TABLE_NAME = "mobil";
    public static final String COL_NAMA = "name";
    public static final String COL_PRODUKSIBY = "produksiby";
    public static final String COL_THNPRODUKSI = "tahunproduksi";
    public static final String COL_JENIS = "type";
    public static final String COL_JUMLAH = "amount";
    public static final String COL_KETERANGAN = "keterangan";

    // query pembuatan dan penghapusan tabel
    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" integer primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_PRODUKSIBY+" text,"
            +" "+COL_THNPRODUKSI+" integer,"
            +" "+COL_JENIS+" integer,"
            +" "+COL_JUMLAH+" integer,"
            +" "+COL_KETERANGAN+" text)";
    public static final String SQL_DELETE = "drop table if exists "+TABLE_NAME;


}


