package endri.agung.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String showString;
    public TextView showText;
    public barang[] arrbarang = new barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = (TextView) findViewById(R.id.show_text);


        showString = " Manipulasi Class Java Android";
        addSeparator();

        initBarang();
        showString += arrbarang[5].toString();
        addSeparator();
        showString += arrbarang[2].toString();
        addSeparator();
        showText.setText(showString);

    }

    public void addSeparator() {
        showString += "\n........................................................\n";
    }

    public void initBarang() {
        arrbarang[0] = new barang("laptop", 1, 5000000);
        arrbarang[1] = new barang("printer", barang.ELEKTRONIK, 50000000);
        arrbarang[2] = new barang("monitor", barang.ELEKTRONIK, 6000000);
        arrbarang[3] = new barang("scanner", barang.ELEKTRONIK, 3000000);
        arrbarang[4] = new barang("meja", barang.NON_ELEKTRONIK, 32000000);
        arrbarang[5] = new barang("kursi", barang.NON_ELEKTRONIK, 4000000);
        arrbarang[6] = new barang("lemari", barang.NON_ELEKTRONIK, 3007760);
        arrbarang[7] = new barang("handphone", barang.ELEKTRONIK, 6008634);
        arrbarang[8] = new barang("softcase", barang.NON_ELEKTRONIK, 10000);
        arrbarang[9] = new barang("speaker", barang.ELEKTRONIK, 650000);

    }
}