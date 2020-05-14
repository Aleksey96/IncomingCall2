package com.alexey.incomingcall2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_phone_number_listener.*
import java.lang.NullPointerException

/**
 * A simple [Fragment] subclass.
 */
class PhoneNumberListener : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_phone_number_listener, container, false)
        return view
    }

}
