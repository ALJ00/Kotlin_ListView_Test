package com.example.app_listviewtest

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        var listView:ListView = this.findViewById(R.id.listView)

        //creating one list of data
        val list = mutableListOf<String>("uno","dos")

        //initialize an array adapter
        val adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list)

        // attach the array adapter with list view
        listView.adapter = adapter

        // list view item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)

            Snackbar.make(view, "Selected : $selectedItem", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            //adding to list new item
            list.add("nuevo")

            // finally, notify the adapter for data set changed
            adapter.notifyDataSetChanged()
            
            Snackbar.make(view, "New item added", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}