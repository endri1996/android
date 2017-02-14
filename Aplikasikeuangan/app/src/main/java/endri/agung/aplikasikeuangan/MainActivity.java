package endri.agung.aplikasikeuangan;

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



       // for(int i=0; i<ListTrans.size();i++){
        //    Transaksi trans = ListTrans.get(i);
        //    strShow += "-------------------------\n";
         //   strShow += trans.nama+" ["+trans.getjenis()+"] : "+trans.jumlah+"\n"+trans.keterangan;

        }
     protected void onResume(){
        super.onResume();
         ListView ListTransaksi=(ListView) findViewById(R.id.List_transaksi);
        txtShow = (TextView) findViewById(R.id.txt_show);

        TransaksiHelper dbHelper =new TransaksiHelper(this);
        final List<Transaksi> ListTrans = dbHelper.getTransaksi();

         ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListTrans);
         ListTransaksi.setAdapter(adapter);

         int saldo =0;
         for (int i=0;i<ListTrans.size();i++){
             if(ListTrans.get(i).jenis==1){
                 saldo +=ListTrans.get(i).jumlah;
             }else{
                 saldo += ListTrans.get(i).jumlah;
             }

    }
        TextView txtsaldo =(TextView) findViewById(R.id.txt_saldo);
         txtsaldo.setText(" saldo tersisa = "+Integer.toString(saldo));

         ListTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener(){

             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Transaksi transaksi = ListTrans.get(position);
                 Intent intent = new Intent(parent.getContext(),DetailActivity.class);
                 intent.putExtra("transaksi.detail", transaksi);
                 startActivity(intent);

             }
         });

 //       txtShow.setText(strShow);
    }
    public  void addTransaksi(View view)
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

}
