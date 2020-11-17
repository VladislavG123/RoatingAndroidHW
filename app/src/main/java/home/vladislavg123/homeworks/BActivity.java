package home.vladislavg123.homeworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null){
            TextView textView =  findViewById(R.id.textView);
            textView.setText(message);
        }


        Button goA = findViewById(R.id.goAButton);
        goA.setOnClickListener(v -> openActivity(BActivity.class, "Hello from B"));

        Button goC = findViewById(R.id.goCButton);
        goC.setOnClickListener(v -> openActivity(CActivity.class, "Hello from B"));
    }


    private void openActivity(Class<?> nextActivity, String message){
        Intent myIntent = new Intent(BActivity.this, nextActivity);
        myIntent.putExtra("message", message);
        BActivity.this.startActivity(myIntent);
    }
}