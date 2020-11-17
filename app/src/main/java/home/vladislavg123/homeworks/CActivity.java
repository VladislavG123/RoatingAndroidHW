package home.vladislavg123.homeworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null){
            TextView textView =  findViewById(R.id.textView);
            textView.setText(message);
        }

        Button goB = findViewById(R.id.goBButton);
        goB.setOnClickListener(v -> openActivity(BActivity.class, "Hello from C"));

        Button goA = findViewById(R.id.goAButton);
        goA.setOnClickListener(v -> openActivity(AActivity.class, "Hello from C"));
    }


    private void openActivity(Class<?> nextActivity, String message){
        Intent myIntent = new Intent(CActivity.this, nextActivity);
        myIntent.putExtra("message", message);
        CActivity.this.startActivity(myIntent);
    }
}