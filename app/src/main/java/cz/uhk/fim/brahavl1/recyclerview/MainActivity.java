package cz.uhk.fim.brahavl1.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cz.uhk.fim.brahavl1.recyclerview.adapter.RecyclerViewAdapter;
import cz.uhk.fim.brahavl1.recyclerview.adapter.OnItemDeleteClickListener;
import cz.uhk.fim.brahavl1.recyclerview.model.PersonsData;

public class MainActivity extends AppCompatActivity implements OnItemDeleteClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter; //staticka trida - vezme data - seznam a sazi obsah dat do ui komponentu
    private RecyclerView.LayoutManager layoutManager;

    private PersonsData personsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); //vytahnuli jsme recycler view do javy

        layoutManager = new LinearLayoutManager(this); //vytovreni layoutu a nastaveni
        recyclerView.setLayoutManager(layoutManager); //propojeni

        personsData = new PersonsData(); //prazdny
        personsData = new PersonsData().newTestInstance(); //testovaci data

        // ADAPTER
        adapter = new RecyclerViewAdapter(personsData);
        adapter.setOnItemDeleteClickListener(this);
        recyclerView.setAdapter(adapter);




    }

    @Override
    public void onItemDelete(int position) {
        personsData.remove(position);

        adapter.notifyDataSetChanged();
    }
}
