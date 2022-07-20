package com.example.a05androidpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainDetail extends AppCompatActivity {
    public static final String
            EXTRA_PICTURE = "extra_picture",
            EXTRA_NAME = "extra_name",
            EXTRA_SEWA = "extra_sewa",
            EXTRA_SPESIFIKASI = "extra_detail",
            EXTRA_KAPASITAS = "extra_kapasitas",
            EXTRA_TRANMISI = "extra_tranmisi",
            EXTRA_BAHAN ="extra_bahan",
            EXTRA_KETERANGAN = "extra_keterangan";
    private TextView tvNama, tvSewa, tvDetail, tvKapasitas,tvTranmisi,
            tvBahanBakar, tvKeterangan;
    private ImageView imgFoto;
    private Button btnSewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        binding();
        intentShow();




    }


    private void intentShow() {
        String nama = getIntent().getStringExtra(EXTRA_NAME);
        String sewa = String.valueOf(getIntent().getIntExtra(EXTRA_SEWA,0));
        String spesifikasi = getIntent().getStringExtra(EXTRA_SPESIFIKASI);
        int foto = getIntent().getIntExtra(EXTRA_PICTURE, 0);
        String kapasitas = getIntent().getStringExtra(EXTRA_KAPASITAS);
        String transmisi = getIntent().getStringExtra(EXTRA_TRANMISI);
        String bahanBakar = getIntent().getStringExtra(EXTRA_BAHAN);
        String keterangan = getIntent().getStringExtra(EXTRA_KETERANGAN);

        Glide.with(this)
                .load(foto)
                .apply(new RequestOptions().override(350,355))
                .into(imgFoto);
        tvNama.setText(nama);
        tvSewa.setText("Harga Sewa : Rp. "+sewa + " / Hari");
        tvDetail.setText(spesifikasi);
        tvBahanBakar.setText(nama);
        tvKapasitas.setText(kapasitas);
        tvTranmisi.setText(transmisi);
        tvBahanBakar.setText(bahanBakar);
        tvKeterangan.setText(keterangan);
        btnSewa.setOnClickListener(e->{
            Toast.makeText(this, "Anda Menyewa : " +nama ,
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void binding() {
        imgFoto = findViewById(R.id.foto_detail);
        tvNama = findViewById(R.id.tv_car_name);
        tvSewa = findViewById(R.id.tv_harga_sewa);
        tvDetail = findViewById(R.id.tv_car_spec);
        tvKapasitas = findViewById(R.id.car_capacity);
        tvTranmisi = findViewById(R.id.car_tranmition);
        tvBahanBakar = findViewById(R.id.bahan_bakar);
        tvKeterangan = findViewById(R.id.keterangan);
        btnSewa = findViewById(R.id.btn_sewa);
    }
}