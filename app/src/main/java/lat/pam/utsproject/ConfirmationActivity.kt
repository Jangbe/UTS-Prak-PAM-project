package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        findViewById<ImageView>(R.id.foodImage).setImageResource(intent.getIntExtra("foodImage", 0))
        findViewById<TextView>(R.id.foodName).text = "Food Name: ${intent.getStringExtra("foodName")}"
        findViewById<TextView>(R.id.servings).text = "Number of Servings: ${intent.getStringExtra("servings")} pax"
        findViewById<TextView>(R.id.name).text = "Ordering Name: ${intent.getStringExtra("name")}"
        findViewById<TextView>(R.id.notes).text = "Additional Notes: ${intent.getStringExtra("notes")}"

        findViewById<Button>(R.id.backtoMenu).setOnClickListener({
            startActivity(Intent(this, ListFoodActivity::class.java))
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}