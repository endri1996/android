package endri.agung.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate (View view)
    {
        EditText input1 = (EditText) findViewById(R.id.tagihan);
        EditText input2 = (EditText) findViewById(R.id.persentip);
        EditText input3 = (EditText) findViewById(R.id.jmlorg);
        TextView result = (TextView) findViewById(R.id.result);

        String hasil=" ";
        double angka1,angka2,angka3;
        angka1 = Double.parseDouble(input1.getText().toString());
        angka2 = Double.parseDouble(input2.getText().toString());
        angka3 = Double.parseDouble(input3.getText().toString());

        hasil = "tips  :"+(+angka1*(angka2)/100)+"\n";
        hasil += "total :"+(angka1+(angka1*(angka2)/100))+"\n";
        hasil += "perorang  :"+((angka1+(angka1*(angka2)/100))/angka3)+"\n";

        result.setText(hasil);

    }

}

