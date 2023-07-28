package hr.tvz.android.kalkulatorlazic

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CalculatorActivity : AppCompatActivity() {

    private lateinit var spinnerIntake: Spinner
    private lateinit var spinnerOuttake: Spinner
    private lateinit var spinnerLng: Spinner
    private lateinit var buttonIntake: Button
    private lateinit var buttonOuttake: Button
    private lateinit var buttonClear: Button
    private lateinit var tvDailyGoal: TextView
    private lateinit var historyRecyclerView: RecyclerView

    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var historyList: MutableList<String>

    private var currentIntake: Float = 0F
    private var goalIntake: Float = 0f
    private var trueRedColor: Int = 0
    private var trueBlackColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        spinnerIntake=findViewById(R.id.spinnerIntake)
        spinnerOuttake=findViewById(R.id.spinnerOuttake)
        spinnerLng=findViewById(R.id.spinnerLng)
        buttonIntake=findViewById(R.id.buttonIntake)
        buttonOuttake=findViewById(R.id.buttonOuttake)
        buttonClear=findViewById(R.id.buttonClear)
        tvDailyGoal=findViewById(R.id.tvGoalIntake)
        historyRecyclerView=findViewById(R.id.historyRecyclerView)

        trueRedColor = ContextCompat.getColor(this, R.color.true_red)
        trueBlackColor= ContextCompat.getColor(this,R.color.black)

        historyList= mutableListOf()
        historyAdapter=HistoryAdapter(historyList)
        historyRecyclerView.adapter=historyAdapter
        historyRecyclerView.layoutManager=LinearLayoutManager(this)

        goalIntake = intent.getFloatExtra("goalValue",0F)
        update()

        spinnerLng.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedLanguage = resources.getStringArray(R.array.languages)[position]
                setLocale(selectedLanguage)
                if (selectedLanguage=="ENG"){
                    setLocale(selectedLanguage)
                }
                else if (selectedLanguage=="CRO"){
                    setLocale(selectedLanguage)
                    recreate()
                }
                else if(selectedLanguage=="SRB"){
                    setLocale(selectedLanguage)
                    recreate()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        buttonIntake.setOnClickListener{
            val selectedItem = spinnerIntake.selectedItem.toString()
            currentIntake+=extractDecimalValue(selectedItem)
            update()

            historyList.add(selectedItem)
            historyAdapter.notifyItemInserted(historyList.size-1)
        }

        buttonOuttake.setOnClickListener{
            val selectedItem = spinnerOuttake.selectedItem.toString()
            currentIntake+=extractDecimalValue(selectedItem)
            update()

            historyList.add(selectedItem)
            historyAdapter.notifyItemInserted(historyList.size-1)
        }

        buttonClear.setOnClickListener {
            historyList.clear()
            historyAdapter.notifyDataSetChanged()
            currentIntake = 0F
            update()
        }
    }

    private fun extractDecimalValue(item: String): Float {
        val startIndex = item.lastIndexOf('(') + 1
        val endIndex = item.lastIndexOf('l')

        if (startIndex != -1 && endIndex != -1) {
            val decimalValue = item.substring(startIndex, endIndex).trim()
            return decimalValue.toFloatOrNull() ?: 0f
        }
        return 0f
    }

    private fun update(){
        tvDailyGoal.setText(buildString {
        append(String.format("%.2f", currentIntake))
        append(" / ")
        append(goalIntake)
        append('l')
        })
        if (currentIntake >= goalIntake){
            Toast.makeText(this,"You did it! Idemooo", Toast.LENGTH_SHORT).show()
            tvDailyGoal.setTextColor(trueRedColor)
        }
        else{
            tvDailyGoal.setTextColor(trueBlackColor)
        }
    }

    private fun setLocale(language : String){
        val locale = when (language){
            "ENG" -> Locale("en","GB")
            "CRO" -> Locale("hr","HR")
            "SRB" -> Locale("sr","RS")
            else -> Locale.getDefault()
        }
        Locale.setDefault(locale)

        val config = baseContext.resources.configuration
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )

    }
}