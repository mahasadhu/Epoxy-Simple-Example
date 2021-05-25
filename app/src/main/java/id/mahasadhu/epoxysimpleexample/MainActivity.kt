package id.mahasadhu.epoxysimpleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.mahasadhu.epoxymodule.EpoxyCustomViewActivity
import id.mahasadhu.epoxysimpleexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.buttonEpoxyCustomViewMode.setOnClickListener {
            startActivity(Intent(this, EpoxyCustomViewActivity::class.java))
        }
    }
}