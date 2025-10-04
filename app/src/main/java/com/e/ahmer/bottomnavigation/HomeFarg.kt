package com.e.ahmer.bottomnavigation

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFarg.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFarg : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val rootView = inflater.inflate(R.layout.fragment_home_farg, container, false)

        // Find button from layout
        val viewAllBtn = rootView.findViewById<Button>(R.id.viewbtn)
        val backBtn=rootView.findViewById<ImageButton>(R.id.backBtn)

        // Set click listener
        viewAllBtn.setOnClickListener {
            val intent = Intent(requireContext(), productWithApi::class.java)
            startActivity(intent)
        }


        backBtn.setOnClickListener {
            val builder= AlertDialog.Builder(requireContext())

            builder.setIcon(R.drawable.baseline_exit_to_app_24)
            builder.setTitle("Exit")
            builder.setMessage("Do you close the App?")
            builder.setNegativeButton("No", DialogInterface.OnClickListener{ DialogInterface,i ->
            })

            builder.setPositiveButton("Yes", DialogInterface.OnClickListener{ DialogInterface,i ->
                Toast.makeText(requireContext(),"you exit this App", Toast.LENGTH_SHORT).show()
                requireActivity().finish()
            })
            builder.show()
        }

        return rootView
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFarg.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFarg().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }
}