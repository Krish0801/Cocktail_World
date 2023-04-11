package com.example.cocktailworld.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cocktailworld.R
import com.example.cocktailworld.data.model.drinks.AllDrinks
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale.filter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_alcoholic,
                R.id.navigation_non_alcoholic
            )
        )

        navController.addOnDestinationChangedListener { _, destination,_ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_alcoholic -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_non_alcoholic -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.action_signOut -> {
                    navView.visibility = View.VISIBLE
                }
                else -> {
                    navView.visibility = View.GONE
                }
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.action_signOut){
            FirebaseAuth.getInstance().signOut();
            navController.navigate(R.id.navigation_login)
            Toast.makeText(this, "Logged Out Successfully",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.sign_out, menu)
//        val inflater = menuInflater
//        inflater.inflate(R.menu.search_menu, menu)
//        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)
//        val searchView: SearchView = searchItem.getActionView() as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
//            android.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(msg: String): Boolean {
//                // inside on query text change method we are
//                // calling a method to filter our recycler view.
//                filter(msg)
//                return false
//            }
//        })
        return true

    }
//    private fun filter(text: String) {
//        // creating a new array list to filter our data.
//        val filteredlist: List<Drink> = ArrayList()
//
//        // running a for loop to compare elements.
//        for (item in filteredlist) {
//            // checking if the entered string matched with any item of our recycler view.
//            if (item.idDrink.toLowerCase().contains(text.toLowerCase())) {
//                // if the item is matched we are
//                // adding it to our filtered list.
//                filteredlist.add(item)
//            }
//        }
//        if (filteredlist.isEmpty()) {
//            // if no item is added in filtered list we are
//            // displaying a toast message as no data found.
//            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
//        } else {
//            // at last we are passing that filtered
//            // list to our adapter class.
//            Drink.filterList(filteredlist)
//        }
//    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}