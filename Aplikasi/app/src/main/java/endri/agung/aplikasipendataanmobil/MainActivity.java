package endri.agung.aplikasipendataanmobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String strShow="";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    protected void onResume(){
        super.onResume();
        ListView ListMobil=(ListView) findViewById(R.id.List_mobil);
        txtShow = (TextView) findViewById(R.id.txt_show);

        Helper dbHelper =new Helper(this);
        final List<Mobil> ListMobils = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListMobils);
        ListMobil.setAdapter(adapter);

        int saldo =0;
        for (int i=0;i<ListMobils.size();i++){
            if(ListMobils.get(i).jenis==1){
                saldo +=ListMobils.get(i).jumlah;
            }else{
                saldo += ListMobils.get(i).jumlah;
            }

        }
        TextView txtsaldo =(TextView) findViewById(R.id.txt_saldo);
        txtsaldo.setText(" kuota = "+Integer.toString(saldo));

        ListMobil.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mobil mobil = ListMobils.get(position);
                Intent intent = new Intent(parent.getContext(),DetailActivity.class);
                intent.putExtra("mobil.detail", mobil);
                startActivity(intent);

            }
        });

        //       txtShow.setText(strShow);
    }
    public  void addMobil(View view)
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

}



