package endri.agung.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String strShow="";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow = (TextView) findViewById(R.id.txt_show);

        Transaksihelper dbHelper =new Transaksihelper(this);
        List<Transaksi> ListTrans = dbHelper.getTransaksi();

        for(int i=0; i<ListTrans.size();i++){
            Transaksi trans = ListTrans.get(i);
            strShow += "-------------------------\n";
            strShow += trans.nama+" ["+trans.getjenis()+"] : "+trans.jumlah+"\n"+trans.keterangan;

        }
        txtShow.setText(strShow);
    }
    public  void addTransaksi(View view)
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

}
