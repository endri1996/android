package endri.agung.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String showString;
    public TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText =(TextView) findViewById(R.id.show_text);

        barang newbarang = new barang();
        newbarang.setNama("laptop")
        String nmbarang = newbarang.getNama();

        showString = " Manipulasi Class Java Android";
        addSeparator();
        showText.setText(showString);
    }
    public void addSeparator(){
        showString += "\n........................................................\n";
    }
}
