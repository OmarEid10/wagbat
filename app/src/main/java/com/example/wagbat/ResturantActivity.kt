package com.example.wagbat


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import com.example.wagbat.databinding.ActivityResturantBinding
import com.mkrdeveloper.nestedrecyclerviewexample.models.ChildDataClass
import com.mkrdeveloper.nestedrecyclerviewexample.models.ParentDataClass
import java.util.*
import kotlin.collections.ArrayList



class ResturantActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResturantBinding
    private val parentItemsList = ArrayList<ParentDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResturantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvParent = findViewById<RecyclerView>(R.id.rv_parent)
        rvParent.setHasFixedSize(true)
        rvParent.layoutManager = LinearLayoutManager(this)

        val adapter = ParentAdapter(parentItemsList)

        val searchView = findViewById<SearchView>(R.id.searchView)

        setData()

        rvParent.adapter = adapter

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.cart -> {
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                    true // Return true to indicate that the listener has consumed the event
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.home -> {
                    val intent = Intent(this, ResturantActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false // Return false for all other items to indicate that the event has not been consumed
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchList = ArrayList<ParentDataClass>()

                if (newText != null) {
                    for (i in parentItemsList) {
                        if (i.title.lowercase(Locale.ROOT).contains(newText)) {
                            searchList.add(i)
                        }
                    }
                    if (searchList.isEmpty()) {
                        Toast.makeText(
                            this@ResturantActivity,
                            " No Data",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        adapter.onApplySearch(searchList)
                    }
                }

                return true
            }

        })
    }






    private fun setData() {

        val childItemsList = ArrayList<ChildDataClass>()

        childItemsList.add(ChildDataClass("combo" , R.drawable.dish1 , "100"))
        childItemsList.add(ChildDataClass("big" , R.drawable.dish1 , "150"))
        childItemsList.add(ChildDataClass("midum" , R.drawable.dish1 , "100"))
        childItemsList.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Macdonalds", childItemsList))


        val childItemsList2 = ArrayList<ChildDataClass>()

        childItemsList2.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList2.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList2.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList2.add(ChildDataClass("title" , R.drawable.dish1 , "100"))



        parentItemsList.add(ParentDataClass("More in", childItemsList2))

        val childItemsList3 = ArrayList<ChildDataClass>()

        childItemsList3.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList3.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList3.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList3.add(ChildDataClass("title" , R.drawable.dish1 , "100"))



        parentItemsList.add(ParentDataClass("Bazzoka", childItemsList3))

        val childItemsList4 = ArrayList<ChildDataClass>()

        childItemsList4.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList4.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList4.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList4.add(ChildDataClass("title" , R.drawable.dish1 , "100"))



        parentItemsList.add(ParentDataClass("Abo Tarek", childItemsList4))

        val childItemsList5 = ArrayList<ChildDataClass>()

        childItemsList5.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList5.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList5.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList5.add(ChildDataClass("title" , R.drawable.dish1 , "100"))



        parentItemsList.add(ParentDataClass("karm el sham", childItemsList5))

        val childItemsList6 = ArrayList<ChildDataClass>()

        childItemsList6.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList6.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList6.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList6.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Novel:", childItemsList6))



        val childItemsList7 = ArrayList<ChildDataClass>()

        childItemsList7.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList7.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList7.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList7.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Novel:", childItemsList7))




        val childItemsList8 = ArrayList<ChildDataClass>()

        childItemsList8.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList8.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList8.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList8.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Novel:", childItemsList8))


        val childItemsList9 = ArrayList<ChildDataClass>()

        childItemsList9.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList9.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList9.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList9.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Novel:", childItemsList9))

        val childItemsList10 = ArrayList<ChildDataClass>()

        childItemsList10.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList10.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList10.add(ChildDataClass("title" , R.drawable.dish1 , "100"))
        childItemsList10.add(ChildDataClass("title" , R.drawable.dish1 , "100"))


        parentItemsList.add(ParentDataClass("Novel:", childItemsList10))


    }

}