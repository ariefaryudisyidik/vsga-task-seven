package id.vsga.ariefaryudisyidik.taskseven.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.vsga.ariefaryudisyidik.taskseven.R;
import id.vsga.ariefaryudisyidik.taskseven.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        countryList();
        countryListClick();
        inputCountry();
    }

    private void countryList() {
        list = new ArrayList<>();
        list.add(getString(R.string.indonesia));
        list.add(getString(R.string.malaysia));
        list.add(getString(R.string.thailand));
        list.add(getString(R.string.kamboja));
        list.add(getString(R.string.filipina));
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item_country, list);
        binding.lvCountry.setAdapter(arrayAdapter);
    }

    private void countryListClick() {
        binding.lvCountry.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(this, list.get(i), Toast.LENGTH_SHORT).show());
    }

    private void inputCountry() {
        binding.btnSubmit.setOnClickListener(view -> {
            String countryName = binding.edtCountry.getText().toString().trim();
            if (countryName.isEmpty()) {
                Toast.makeText(this, getString(R.string.empty_country), Toast.LENGTH_SHORT).show();
            } else {
                list.add(countryName);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}