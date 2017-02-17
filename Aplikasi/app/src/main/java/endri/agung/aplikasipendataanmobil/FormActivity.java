package endri.agung.aplikasipendataanmobil;
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

    private String  [] jenisStr = {"pemasukan ", "pengeluaran "};
    private EditText edtNama,edtProduksi,edtThnproduksi, edtJumlah, edtKeterangan;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spnJenis = (Spinner) findViewById(R.id.spn_jenis);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtProduksi = (EditText) findViewById(R.id.edt_produksi);
        edtThnproduksi = (EditText) findViewById(R.id.edt_thnproduksi);
        edtJumlah = (EditText) findViewById(R.id.edt_jumlah);
        edtKeterangan = (EditText) findViewById(R.id.edt_keterangan);
    }

    public void tambah(View view)
    {
        Helper dbHelper = new Helper(this);
        String nama = edtNama.getText().toString();
        String produksiby = edtProduksi.getText().toString();
        int thnproduksi = Integer.parseInt(edtThnproduksi.getText().toString());
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(edtJumlah.getText().toString());
        String keterangan = edtKeterangan.getText().toString();

        dbHelper.insertMobil(nama,produksiby,thnproduksi, jenis, jumlah, keterangan);
        Log.d("form.mobil", nama+" - "+ produksiby+" - "+Integer.toString(thnproduksi)+" - "+Integer.toString(jenis)+" - "+Integer.toString(jumlah)
                +" - "+keterangan);
        Toast.makeText(this, "Mobil "+nama+" berhasil disimpan", Toast.LENGTH_SHORT).show();

        //startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
