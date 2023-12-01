package com.example.usagestat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var _bg__splash: View? = null
    private var _bg__shape: View? = null
    private var ellipse_1: View? = null
    private var ellipse_2: View? = null
    private val _bg__notification: View? = null
    private var _bg__wifi_ek1: View? = null
    private var vector: ImageView? = null
    private var _bg__signal_ek1: View? = null
    private var vector_ek1: ImageView? = null
    private var _bg__battery_three_quarters_ek1: View? = null
    private var vector_ek2: ImageView? = null
    private var _9_45: TextView? = null
    private var button: Button? = null
    private val _bg__notification_ek5: View? = null
    private var _bg__wifi_ek3: View? = null
    private val vector_ek3: ImageView? = null
    private var _bg__signal_ek3: View? = null
    private val vector_ek4: ImageView? = null
    private var _bg__battery_three_quarters_ek3: View? = null
    private val vector_ek5: ImageView? = null
    private var _9_45_ek1: TextView? = null
    private var gets_things_done_faster: TextView? = null
    private var take_your_first_step_towards_digital_well_being___start_your_journey_to_a_healthier_relationship_with_social_media: TextView? =
        null
    private var _bg__button: View? = null
    private var rectangle_1: View? = null
    private var get_started: TextView? = null
    private var _bg__undraw_mindfulness_8gqa_2_1_ek1: View? = null
    private var vector_ek6: ImageView? = null
    private var vector_ek7: ImageView? = null
    private var vector_ek8: ImageView? = null
    private var vector_ek9: ImageView? = null
    private var vector_ek10: ImageView? = null
    private var vector_ek11: ImageView? = null
    private var vector_ek12: ImageView? = null
    private var vector_ek13: ImageView? = null
    private var vector_ek14: ImageView? = null
    private var vector_ek15: ImageView? = null
    private var vector_ek16: ImageView? = null
    private var vector_ek17: ImageView? = null
    private var vector_ek18: ImageView? = null
    private var vector_ek19: ImageView? = null
    private var vector_ek20: ImageView? = null
    private var vector_ek21: ImageView? = null
    private var vector_ek22: ImageView? = null
    private var vector_ek23: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        _bg__splash = findViewById(R.id._bg__splash) as View
        _bg__shape = findViewById(R.id._bg__shape) as View
        ellipse_1 = findViewById(R.id.ellipse_1) as View
        ellipse_2 = findViewById(R.id.ellipse_2) as View
        _bg__wifi_ek1 = findViewById(R.id._bg__wifi_ek1) as View
        vector = findViewById<View>(R.id.vector) as ImageView
        _bg__signal_ek1 = findViewById(R.id._bg__signal_ek1) as View
        vector_ek1 = findViewById<View>(R.id.vector_ek1) as ImageView
        _bg__battery_three_quarters_ek1 = findViewById(R.id._bg__battery_three_quarters_ek1) as View
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
       // _9_45 = findViewById<View>(R.id._9_45) as TextView
        _bg__wifi_ek3 = findViewById(R.id._bg__wifi_ek3) as View
        _bg__signal_ek3 = findViewById(R.id._bg__signal_ek3) as View
        _bg__battery_three_quarters_ek3 = findViewById(R.id._bg__battery_three_quarters_ek3) as View
        //_9_45_ek1 = findViewById<View>(R.id._9_45_ek1) as TextView
        gets_things_done_faster = findViewById<View>(R.id.gets_things_done_faster) as TextView
        take_your_first_step_towards_digital_well_being___start_your_journey_to_a_healthier_relationship_with_social_media =
            findViewById<View>(R.id.take_your_first_step_towards_digital_well_being___start_your_journey_to_a_healthier_relationship_with_social_media) as TextView
        _bg__button = findViewById(R.id._bg__button) as View
        rectangle_1 = findViewById(R.id.rectangle_1) as View
        //get_started = findViewById<View>(R.id.button) as TextView
        _bg__undraw_mindfulness_8gqa_2_1_ek1 =
            findViewById(R.id._bg__undraw_mindfulness_8gqa_2_1_ek1) as View
        vector_ek6 = findViewById<View>(R.id.vector_ek6) as ImageView
        vector_ek7 = findViewById<View>(R.id.vector_ek7) as ImageView
        vector_ek8 = findViewById<View>(R.id.vector_ek8) as ImageView
        vector_ek9 = findViewById<View>(R.id.vector_ek9) as ImageView
        vector_ek10 = findViewById<View>(R.id.vector_ek10) as ImageView
        vector_ek11 = findViewById<View>(R.id.vector_ek11) as ImageView
        vector_ek12 = findViewById<View>(R.id.vector_ek12) as ImageView
        vector_ek13 = findViewById<View>(R.id.vector_ek13) as ImageView
        vector_ek14 = findViewById<View>(R.id.vector_ek14) as ImageView
        vector_ek15 = findViewById<View>(R.id.vector_ek15) as ImageView
        vector_ek16 = findViewById<View>(R.id.vector_ek16) as ImageView
        vector_ek17 = findViewById<View>(R.id.vector_ek17) as ImageView
        vector_ek18 = findViewById<View>(R.id.vector_ek18) as ImageView
        vector_ek19 = findViewById<View>(R.id.vector_ek19) as ImageView
        vector_ek20 = findViewById<View>(R.id.vector_ek20) as ImageView
        vector_ek21 = findViewById<View>(R.id.vector_ek21) as ImageView
        vector_ek22 = findViewById<View>(R.id.vector_ek22) as ImageView
        vector_ek23 = findViewById<View>(R.id.vector_ek23) as ImageView
        button = findViewById<View>(R.id.buttonn) as Button
        button!!.setOnClickListener { openDashboard() }


        //custom code goes here
    }

    fun openDashboard() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}
