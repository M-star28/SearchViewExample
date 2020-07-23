package com.example.searchviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {

    ListView listView;
    SearchView searchView;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listView= findViewById( R.id.List_View );
        searchView=findViewById( R.id.Search_View );

        final ArrayList<String > fruit = new ArrayList<>();
        fruit.add( "Lemons " );
        fruit.add( "Pineapples" );

        adapter= new ArrayAdapter<String>( this,R.layout.support_simple_spinner_dropdown_item,fruit );

        listView.setAdapter( adapter );

        searchView.setOnQueryTextListener( this );






    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter( newText );

        return false;
    }
}
