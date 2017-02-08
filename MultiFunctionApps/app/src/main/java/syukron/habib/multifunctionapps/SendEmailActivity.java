package syukron.habib.multifunctionapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void sendEmail(View view)
    {
        EditText txtpenerima= (EditText) findViewById(R.id.penerima);
        EditText txtjudul= (EditText) findViewById(R.id.judul);
        EditText txtkonten= (EditText) findViewById(R.id.konten);

        Intent emailIntent =new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto   :"+txtpenerima.getText().toString()));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, txtpenerima.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtjudul.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, txtkonten.getText().toString());

       // try {
        //    startActivity(Intent.createChooser(emailIntent, "SEND mail ..."));
        //   finish();
       // }
      //  catch (android.content.ActivityNotFoundException ex)
      //  {
       //     Toast.makeText(SendEmailActivity.this," there is not email client installed", Toast.LENGTH_SHORT).show();
     //   }

    }
}
