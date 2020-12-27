package com.app.social_m.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.social_m.R
import com.app.social_m.model.Users
import com.google.android.material.textview.MaterialTextView
import kotlin.math.log


class UserDetailsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }


    private lateinit var detailsText :MaterialTextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsText = view.findViewById(R.id.detailsText)

       // Log.d(TAG, "onViewCreated: ${arguments.toString()}")
        detailsText.text = arguments.toString()
    }


    companion object {

        private const val TAG = "UserDetailsFragmentScr"

    }





}