package id.ac.binus.gslc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());

        ArrayList<DataModel> hstry = new ArrayList<>();
        Cursor cursor = databaseHelper.getAllHistory();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
            int image = cursor.getInt(cursor.getColumnIndexOrThrow("image"));

            hstry.add(new DataModel(image,name,price));
        }

        ListView listView = findViewById(R.id.listHistory);
        listView.setAdapter(new ContentAdapter(hstry,getApplicationContext()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailProduct.class);
                intent.putExtra("index",position);
                intent.putExtra("image",hstry.get(position).getImage());
                intent.putExtra("name",hstry.get(position).getNama());
                intent.putExtra("price",hstry.get(position).getHarga());
                startActivity(intent);
            }
        });

        Button back = findViewById(R.id.backHistory);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHelper.close();
    }
}