package id.ac.binus.gslc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        List<DataModel> listData = new ArrayList<>();
        DataModel sepatu = new DataModel(R.drawable.airjordanoffwhitechicago,"Off-White Nike Air Jordan 1 \"UNC\"","Rp 12.000.000,00");
        listData.add(sepatu);
        sepatu = new DataModel(R.drawable.airjordan9gnrgm24,"Air Jordan 9 G NRG","Rp 3,369,000");
        listData.add(sepatu);
        sepatu = new DataModel(R.drawable.airjordan13retro,"Air Jordan 13 Retro 'White and Midnight Navy'","Rp 3,269,000");
        listData.add(sepatu);
        sepatu = new DataModel(R.drawable.wmnsairjordan5retro,"Air Jordan 5 Retro 'Lucky Green'","Rp 3,169,000");
        listData.add(sepatu);
        sepatu = new DataModel(R.drawable.wnsairjordan4rm,"Air Jordan 4RM","Rp 2,199,000");
        listData.add(sepatu);

        listView = findViewById(R.id.listItem);
        ContentAdapter contentAdapter = new ContentAdapter(listData,getApplicationContext());
        listView.setAdapter(contentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, listData.get(position).getNama(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetailProduct.class);
                intent.putExtra("index",position);
                intent.putExtra("name", listData.get(position).getNama());
                intent.putExtra("price", listData.get(position).getHarga());
                intent.putExtra("image",listData.get(position).getImage());
                databaseHelper.insertedHistory(listData.get(position).getNama(),listData.get(position).getHarga(),listData.get(position).getImage());
                startActivity(intent);
            }
        });

        Button historybutton = findViewById(R.id.historyButton);
        historybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}