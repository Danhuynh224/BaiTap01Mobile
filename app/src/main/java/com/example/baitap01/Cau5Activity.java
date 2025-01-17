package com.example.baitap01;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cau5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cau5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Ánh xạ
        EditText editText = (EditText) findViewById(R.id.editTextNhap);
        TextView viewKq = (TextView) findViewById(R.id.textViewKq);
        Button btn = (Button) findViewById(R.id.buttonTT);

        //Thực hiện
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(Cau5Activity.this,"Vui lòng nhập chuỗi",Toast.LENGTH_SHORT).show();
                    return;
                }
                String[] words = input.split(" ");
                StringBuilder kq = new StringBuilder();
                // Đảo ngược thứ tự các từ
                for (int i = words.length - 1; i >= 0; i--) {
                    kq.append(words[i]).append(" ");
                }

                // Chuyển chuỗi thành in hoa và loại bỏ khoảng trắng dư thừa
                String fnal = kq.toString().trim().toUpperCase();
                Toast.makeText(Cau5Activity.this,fnal,Toast.LENGTH_SHORT).show();
                viewKq.setText(fnal);
            }
        });
    }
}