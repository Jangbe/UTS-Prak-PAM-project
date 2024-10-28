package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val etFoodName = findViewById<TextView>(R.id.etFoodName)
        val ivFoodImage = findViewById<ImageView>(R.id.ivFoodImage)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        val name = intent.getStringExtra("name");
        val image = intent.getIntExtra("image", 0)
        etFoodName.text = name
        ivFoodImage.setImageResource(image)

        btnOrder.setOnClickListener({
            val etServings = findViewById<EditText>(R.id.etServings)
            val etName = findViewById<EditText>(R.id.etName)
            val etNotes = findViewById<EditText>(R.id.etNotes)

            if (etServings.text.toString() == "") return@setOnClickListener Toast.makeText(applicationContext, "Serving harus diisi!", Toast.LENGTH_LONG).show()
            if (etName.text.toString() == "") return@setOnClickListener Toast.makeText(applicationContext, "Serving harus diisi!", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("foodName", name)
            intent.putExtra("foodImage", image)
            intent.putExtra("servings", etServings.text.toString())
            intent.putExtra("name", etName.text.toString())
            intent.putExtra("notes", etNotes.text.toString())
            startActivity(intent)
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}