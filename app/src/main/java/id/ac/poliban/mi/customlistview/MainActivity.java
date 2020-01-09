package id.ac.poliban.mi.customlistview;

import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Country> countries = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;
    ListView lvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCountry = findViewById(R.id.lvResult);

        countries.addAll(CountryData.getAllData());

        adapter = new CountryListAdapter(countries);
        lvCountry.setAdapter(adapter);

        lvCountry.setOnItemClickListener((adapterView, view, i, l) -> {
            new AlertDialog.Builder(this)
                    .setTitle("info")
                    .setMessage(countries.get(i).toString())
                    .setPositiveButton("OK", null )
                    .show();
        });

        //buat toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        //pasang toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agustya Fazriani");
        toolbar.setSubtitle("https://github.com/agustyafazriani");
        toolbar.setLogo(android.R.drawable.ic_dialog_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



}