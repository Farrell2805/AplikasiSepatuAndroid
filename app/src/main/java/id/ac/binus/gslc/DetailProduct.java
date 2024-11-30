package id.ac.binus.gslc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailProduct extends AppCompatActivity {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int index = getIntent().getIntExtra("index",-1);
        int gambar = getIntent().getIntExtra("image",-1);
        String nama = getIntent().getStringExtra("name");
        String harga = getIntent().getStringExtra("price");

        ImageView imageView = findViewById(R.id.imgDetail);
        TextView txtNama = findViewById(R.id.txtNameDetail);
        TextView txtHargaa = findViewById(R.id.txtPriceDetail);

        if(index != -1){
            imageView.setImageResource(gambar);
            txtNama.setText(nama);
            txtHargaa.setText(harga);
        }
        backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProduct.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}