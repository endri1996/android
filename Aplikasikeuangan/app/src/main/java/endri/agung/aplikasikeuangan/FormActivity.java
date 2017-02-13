package endri.agung.aplikasikeuangan;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private String []jenisStr = {"pemasukan , pengeluaran"};
    private EditText edtnama,edtjumlah,edtketerangan;
    private Spinner spnjenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spnjenis = (Spinner) findViewById(R.id.spn_jenis);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnjenis.setAdapter(adapter);

        edtnama =(EditText) findViewById(R.id.edt_nama);
        edtjumlah = (EditText) findViewById(R.id.edtjumlah);
        edtketerangan = (EditText) findViewById(R.id.edt_keterangan);
    }
    public void tambah( View view){
        Transaksihelper dbHelper= new Transaksihelper(this);
        String nama = edtnama.getText().toString();
        int jenis = spnjenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(edtjumlah.getText().toString());
        String keterangan = edtketerangan.getText().toString();

        dbHelper.insertTransaksi(nama, jenis,jumlah,keterangan);
        Log.d("form.transaksi",nama+" - "+ Integer.toString(jenis)+" - "+Integer.toString(jumlah)+" - "+keterangan);

        Toast.makeText(this, "Transaksi "+nama+" berhasil disaimpan", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));





    }


}
