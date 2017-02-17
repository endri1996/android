package endri.agung.aplikasipendataanmobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Mobil mobil =(Mobil) intent.getSerializableExtra("mobil.detail");

        ((TextView)findViewById(R.id.det_nama)).setText(mobil.nama);
        ((TextView)findViewById(R.id.det_produksiby)).setText(mobil.produksiby);
        ((TextView)findViewById(R.id.det_thnproduksi)).setText(Integer.toString(mobil.thnproduksi));
        ((TextView)findViewById(R.id.det_jenis)).setText(mobil.getJenis());
        ((TextView)findViewById(R.id.det_jumlah)).setText(Integer.toString(mobil.jumlah));
        ((TextView)findViewById(R.id.det_keterangan)).setText(mobil.keterangan);
    }
}
