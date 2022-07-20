package com.example.a05androidpemula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListCarAdapter listCarAdapter = new ListCarAdapter(new CarManager());


    private RecyclerView rvCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCars = findViewById(R.id.rv_cars);
        rvCars.setLayoutManager(new LinearLayoutManager(this));
        rvCars.setAdapter(listCarAdapter);

        addCars();
        clickItemCar();

    }

    private void clickItemCar() {
        listCarAdapter.setOnItemClickCallback(new ListCarAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Car car) {
                showSelectedCar(car);
            }
        });
    }
    private void addCars() {
        listCarAdapter.addCar(new Car(
                "Land Cruiser",2500000,"GR-S 5 Type",
                "6 orang","Matic","Pertamax Turbo",
                R.drawable._1_land_cruiser));
        listCarAdapter.addCar(new Car(
                "Alphard",2500000,"2.5 X A/T Type",
                "8 orang","Manual","Pertamax Turbo",
                R.drawable._2_alphard));
        listCarAdapter.addCar(new Car(
                "Camry",2300000,"Hybrid Type",
                "4 orang","Manual","Pertamax Turbo",
                R.drawable._3_camry));
        listCarAdapter.addCar(new Car(
                "Voxy",2300000,"20 CVT Type",
                "6 orang","Manual","Pertamax Turbo",
                R.drawable._4_voxy));
        listCarAdapter.addCar(new Car(
                "Fortuner",2450000,"VRZ Type",
                "6 orang","Manual","Pertamax Turbo",
                R.drawable._5_fortuner));
        listCarAdapter.addCar(new Car(
                "Kijang Innova",1800000,"Venturer Type",
                "6 orang","Matic","Pertamax Turbo",
                R.drawable._6_innova));
        listCarAdapter.addCar(new Car(
                "Corolla",1950000,"Hybrid Type",
                "6 orang","Manual","Pertamax Turbo",
                R.drawable._7_corrolla));
        listCarAdapter.addCar(new Car(
                "Rush",2350000,"GR Sport Type",
                "6 orang","Manual","Pertamax",
                R.drawable._8_rush));
        listCarAdapter.addCar(new Car(
                "Vellfire",2450000,"2,5 G A/T Type",
                "6 orang","Manual","Pertamax Turbo",
                R.drawable._9_vellvire));

        listCarAdapter.addCar(new Car(
                "Raize",2400000,"1,2 G Type",
                "6 orang","Manual","Pertamax Turbo",
                R.drawable._10_raize));
    }
    private void showSelectedCar(Car car) {
//        Toast.makeText(this, "Anda Memilih : " + car.getNama(),
//                Toast.LENGTH_SHORT).show();
        Intent moveWithDataIntent = new Intent(MainActivity.this,
                MainDetail.class);
        moveWithDataIntent.putExtra(MainDetail.EXTRA_PICTURE, car.getFoto());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_NAME, car.getNama());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_SEWA, car.getSewa());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_SPESIFIKASI, car.getDetail());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_KAPASITAS, car.getKapasitas());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_TRANMISI, car.getTranmisi());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_BAHAN, car.getBahanBakar());
        moveWithDataIntent.putExtra(MainDetail.EXTRA_KETERANGAN, car.getKeterangan());

        startActivity(moveWithDataIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }


    public void setMode(int selectedMode) {
        Intent moveIntent = new Intent(MainActivity.this, About.class);
        startActivity(moveIntent);
    }

}