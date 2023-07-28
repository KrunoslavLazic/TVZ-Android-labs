package hr.tvz.android.kalkulatorlazic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class WaterCalculatorActivity : AppCompatActivity() {
    private lateinit var intakeSpinner: Spinner
    private lateinit var dehydrateSpinner: Spinner
    private lateinit var drankButton: Button
    private lateinit var drinkButton: Button
    private lateinit var calculateButton: Button
    private lateinit var seekBar: SeekBar
    private lateinit var dailyGoalTextView: TextView
    private var waterIntake = 0.0
    private var dailyGoal = 2.0 // default value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intakeSpinner = findViewById(R.id.intake_spinner)
        dehydrateSpinner = findViewById(R.id.dehydrate_spinner)
        drankButton = findViewById(R.id.drank_button)
        drinkButton = findViewById(R.id.drink_button)
        calculateButton = findViewById(R.id.calculate_button)
        seekBar = findViewById(R.id.seek_bar)
        dailyGoalTextView = findViewById(R.id.daily_goal_text_view)

        // Set up the spinners
        val intakeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.intake_options,
            android.R.layout.simple_spinner_item
        )
        intakeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        intakeSpinner.adapter = intakeAdapter

        val dehydrateAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.dehydrate_options,
            android.R.layout.simple_spinner_item
        )
        dehydrateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dehydrateSpinner.adapter = dehydrateAdapter

        drankButton.setOnClickListener {
            // Update water intake based on selected option
            val intakeString = intakeSpinner.selectedItem.toString()
            val intakeValue = intakeString.substringAfterLast(" ").removeSuffix("l").toDouble()
            waterIntake += intakeValue
            updateSeekBar()
        }

        drinkButton.setOnClickListener {
            // Update water intake based on selected option
            val intakeString = intakeSpinner.selectedItem.toString()
            val intakeValue = intakeString.substringAfterLast(" ").removeSuffix("l").toDouble()
            waterIntake += intakeValue
            updateSeekBar()
            // Show message
            Snackbar.make(
                findViewById(android.R.id.content),
                "Great job, keep it up!",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        calculateButton.setOnClickListener {
            // Update daily goal based on input from user
            val inputText = dailyGoalTextView.text.toString()
            if (inputText.isNotEmpty()) {
                dailyGoal = inputText.toDouble()
            }
            updateSeekBar()
        }

        seekBar.max = (dailyGoal * 10).toInt()
        updateSeekBar()
    }

    private fun updateSeekBar() {
        seekBar.progress = (waterIntake * 10).toInt()
    }
}
