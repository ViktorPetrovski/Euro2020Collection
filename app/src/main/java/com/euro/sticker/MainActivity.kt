package com.euro.sticker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.euro.sticker.gallery.data.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

val categories = listOf<String>(
    "Intro",
    "Group A",
    "Italy",
    "Switzerland",
    "Turkey",
    "Wales",
    "Group B",
    "Belgium",
    "Denmark",
    "Finland",
    "Russia",
    "Group C",
    "Austria",
    "Netherlands",
    "Northern Macedonia",
    "Ukraine",
    "Group D",
    "Croatia",
    "Czech Republic",
    "England",
    "Scotland",
    "Group E",
    "Poland",
    "Slovakia",
    "Spain",
    "Sweden",
    "Group F",
    "France",
    "Germany",
    "Hungary",
    "Portugal",
    "France",
)

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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