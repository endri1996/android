package endri.agung.aplikasipendataanmobil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D2J-00 on 15/02/2017.
 */
public class Helper extends SQLiteOpenHelper{
    public static final String DB_NAME = "mobil.db";
    public static final int DB_VERSION = 7;

    SQLiteDatabase db;

    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Mobil.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Mobil.SQL_DELETE);
        onCreate(db);
    }
    public void insertMobil(String nama,String produksiby,int thnproduksi, int jenis, int jumlah, String keterangan){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Mobil.COL_NAMA, nama);
        values.put(Mobil.COL_PRODUKSIBY, produksiby);
        values.put(Mobil.COL_THNPRODUKSI, thnproduksi);
        values.put(Mobil.COL_JENIS, jenis);
        values.put(Mobil.COL_JUMLAH, jumlah);
        if(keterangan == null)
            keterangan = "";
        values.put(Mobil.COL_KETERANGAN, keterangan);

        db.insert(Mobil.TABLE_NAME, null, values);
    }



    public List<Mobil> getTransaksi(){
        db = getReadableDatabase();
        List<Mobil> mobils = new ArrayList<>();
        String [] projection = {Mobil._ID, Mobil.COL_NAMA, Mobil.COL_PRODUKSIBY , Mobil.COL_THNPRODUKSI,Mobil.COL_JENIS,
                Mobil.COL_JUMLAH, Mobil.COL_KETERANGAN};
        String sortOrder = Mobil._ID;

        Cursor cursor = db.query(Mobil.TABLE_NAME, projection, null, null, null, null, sortOrder);

        Mobil newMobils;
        while (cursor.moveToNext()){
            newMobils = new Mobil(
                    cursor.getString(cursor.getColumnIndex(Mobil.COL_NAMA)),
                    cursor.getString(cursor.getColumnIndex(Mobil.COL_PRODUKSIBY)),
                    cursor.getInt(cursor.getColumnIndex(Mobil.COL_THNPRODUKSI)),
                    cursor.getInt(cursor.getColumnIndex(Mobil.COL_JENIS)),
                    cursor.getInt(cursor.getColumnIndex(Mobil.COL_JUMLAH)),
                    cursor.getString(cursor.getColumnIndex(Mobil.COL_KETERANGAN))
            );
            mobils.add(newMobils);
        }
        cursor.close();

        return mobils;
    }



}

