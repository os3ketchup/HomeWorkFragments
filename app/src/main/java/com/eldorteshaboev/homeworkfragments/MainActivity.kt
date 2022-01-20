package com.eldorteshaboev.homeworkfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentDynamic = DynamicFragment()
        val staticFragment = StaticFragment()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager

        btn_add.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, fragmentDynamic)
                .addToBackStack(fragmentDynamic.toString())
                .commit()
            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
        }
        btn_remove.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(fragmentDynamic)
                .commit()
            Toast.makeText(this, "removed", Toast.LENGTH_SHORT).show()
        }

        btn_hide.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .hide(fragmentDynamic)
                .commit()
            Toast.makeText(this, "hided", Toast.LENGTH_SHORT).show()
        }
        btn_show.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .show(fragmentDynamic)
                .commit()
            Toast.makeText(this, "showed", Toast.LENGTH_SHORT).show()
        }
        btn_replace.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1,staticFragment)
                .commit()
            Toast.makeText(this, "replaced into static", Toast.LENGTH_SHORT).show()

        }

    }
}