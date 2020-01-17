package com.example.latihanlogin;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Siswa> rvdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initDataset();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Adapter(rvdata);

        Log.e("","onCreate:"+rvdata.size());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initDataset(){

        Siswa s1 = new Siswa();
        s1.setNama("REYKA");
        s1.setKelas("XII RPL");
        s1.setAlamat("GEBOG");
        rvdata.add(s1);

        Siswa s2 = new Siswa();
        s2.setNama("BADROL");
        s2.setKelas("XII RPL");
        s2.setAlamat("BESITO");
        rvdata.add(s2);

        Siswa s3 = new Siswa();
        s3.setNama("BAGAS");
        s3.setKelas("XII RPL");
        s3.setAlamat("BESITO");
        rvdata.add(s3);

        Siswa s4 = new Siswa();
        s4.setNama("RIFKI");
        s4.setKelas("XII RPL");
        s4.setAlamat("BESITO");
        rvdata.add(s4);

        Siswa s5 = new Siswa();
        s5.setNama("FREDI");
        s5.setKelas("XII RPL");
        s5.setAlamat("NALUMSARI");
        rvdata.add(s5);

        Siswa s6 = new Siswa();
        s6.setNama("UMAR");
        s6.setKelas("XII RPL");
        s6.setAlamat("BACIN");
        rvdata.add(s5);

        Siswa s7 = new Siswa();
        s7.setNama("BUDIMAN");
        s7.setKelas("XII RPL");
        s7.setAlamat("MENAWAN");
        rvdata.add(s5);

        Siswa s8 = new Siswa();
        s8.setNama("PANDU");
        s8.setKelas("XII RPL");
        s8.setAlamat("JEPARA");
        rvdata.add(s5);

        Siswa s9 = new Siswa();
        s9.setNama("REIYAN");
        s9.setKelas("XII RPL");
        s9.setAlamat("GONDOSARI");
        rvdata.add(s5);

        Siswa s10 = new Siswa();
        s10.setNama("ALDI");
        s10.setKelas("XII RPL");
        s10.setAlamat("GEBOG");
        rvdata.add(s5);

        Siswa s11= new Siswa();
        s11.setNama("PLAYERUNKNOWN");
        s11.setKelas("XII RPL");
        s11.setAlamat("ROZOK");
        rvdata.add(s11);

        Siswa s12= new Siswa();
        s12.setNama("PLAYERUNKNOWN");
        s12.setKelas("XII RPL");
        s12.setAlamat("ROZOK");
        rvdata.add(s12);

        Siswa s13= new Siswa();
        s13.setNama("PLAYERUNKNOWN");
        s13.setKelas("XII RPL");
        s13.setAlamat("ROZOK");
        rvdata.add(s13);

        Siswa s14= new Siswa();
        s14.setNama("PLAYERUNKNOWN");
        s14.setKelas("XII RPL");
        s14.setAlamat("ROZOK");
        rvdata.add(s14);

        Siswa s15= new Siswa();
        s10.setNama("PLAYERUNKNOWN");
        s10.setKelas("XII RPL");
        s10.setAlamat("ROZOK");
        rvdata.add(s15);
    }
}
