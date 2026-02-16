package com.example.shopy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val session = SessionManager(requireContext())

        view.findViewById<TextView>(R.id.tvName).text = session.getName()
        view.findViewById<TextView>(R.id.tvEmail).text = session.getEmail()
    

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            session.logout()
            startActivity(Intent(requireContext(), WelcomeActivity::class.java))
            requireActivity().finish()
        }

        return view
    }
}

private fun SessionManager.getPhone() {
    TODO("Not yet implemented")
}
