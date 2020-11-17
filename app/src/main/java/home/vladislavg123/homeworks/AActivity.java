package home.vladislavg123.homeworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null){
            TextView textView =  findViewById(R.id.textView);
            textView.setText(message);
        }

        Button goB = findViewById(R.id.goBButton);
        goB.setOnClickListener(v -> openActivity(BActivity.class, "Hello from A"));

        Button goC = findViewById(R.id.goCButton);
        goC.setOnClickListener(v -> openActivity(CActivity.class, "Hello from A"));
    }


    private void openActivity(Class<?> nextActivity, String message){
        Intent myIntent = new Intent(AActivity.this, nextActivity);
        myIntent.putExtra("message", message);
        AActivity.this.startActivity(myIntent);
    }
}