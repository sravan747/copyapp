package com.example.copy;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button generate,copy;
    EditText count,dta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate=findViewById(R.id.generate);
        copy=findViewById(R.id.copy);
        count=findViewById(R.id.count);
        dta=findViewById(R.id.dta);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=dta.getText().toString();
                String b=count.getText().toString();
                int c=Integer.parseInt(b);
                if(a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter A text Please", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuilder d=new StringBuilder();
                    for(int i=0;i<=c;i++){
                        d.append(a).append(" ");
                    }
                    dta.setText(d);
                }
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String copytext=dta.getText().toString();
                 if(!copytext.isEmpty()){
                     ClipboardManager clipboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                     ClipData clip=ClipData.newPlainText("copied",copytext);
                     clipboard.setPrimaryClip(clip);
                     Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     Toast.makeText(MainActivity.this, "Nothing to copy", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
}