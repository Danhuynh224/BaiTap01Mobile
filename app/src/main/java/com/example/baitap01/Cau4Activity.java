package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Random;

public class Cau4Activity extends AppCompatActivity {

    int[] randomNumbers=new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_cau4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        //ánh xạ
        TextView txtSo = (TextView) findViewById(R.id.textViewRandom);
        Button btnRanDom = (Button) findViewById(R.id.buttonRandom);
        Button btnChan = (Button) findViewById(R.id.buttonChan);
        Button btnLe = (Button) findViewById(R.id.buttonLe);

        btnChan.setVisibility(View.INVISIBLE);
        btnLe.setVisibility(View.INVISIBLE);

        //Chức năng
        //RanDom 10 chữ số
        btnRanDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumbers = new int[10];
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    randomNumbers[i] = random.nextInt(101);
                }
                StringBuilder result = new StringBuilder();
                for (int number : randomNumbers) {
                    result.append(number).append(" ");
                }
                txtSo.setText(arrayToString(randomNumbers));
                if(txtSo.getText()!="") {
                    btnChan.setVisibility(View.VISIBLE);
                    btnLe.setVisibility(View.VISIBLE);
                }
            }
        });

        //In ra số chẵn
        btnChan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] chan  = filterNumbers(randomNumbers, true);
                Log.d("Số Chẵn", arrayToString(chan));
            }
        });

        //In ra số lẻ
        btnLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] le  = filterNumbers(randomNumbers, false);
                Log.d("Số Lẻ", arrayToString(le));
            }
        });
    }
    // Hàm chuyển mảng thành chuỗi
    private String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int number : array) {
            result.append(number).append(" ");
        }
        return result.toString().trim();
    }
    //Lọc số
    private int[] filterNumbers(int[] array, boolean isEven) {
        return Arrays.stream(array)
                .filter(number -> isEven ? number % 2 == 0 : number % 2 != 0)
                .toArray();
    }
}