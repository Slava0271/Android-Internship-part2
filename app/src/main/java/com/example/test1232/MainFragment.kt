package com.example.test1232

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.test1232.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: ModelView = ModelView()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        addListeners(binding)
        setBackgroundOnClick()
        setAvatarOnCLick()
    }

    private fun setBackgroundOnClick() {
        var count: Int = 0;
        binding.linearLayout.setOnClickListener {
            if (count >= 3)
                count = 0

            when (count) {
                2 -> binding.linearLayout.setBackgroundResource(R.drawable.background_snow)
                0 -> binding.linearLayout.setBackgroundResource(R.drawable.background_fire)
                1 -> binding.linearLayout.setBackgroundResource(R.drawable.background_rose)
            }
            count++

        }
    }

    private fun setAvatarOnCLick() {
        binding.imageView.setOnClickListener {
            imageChooser()
        }
    }

    private fun addListeners(binding: FragmentMainBinding) {

        binding.buttonTest.setOnClickListener {
            if (checkInputFields(binding)) {
                findNavController().navigate(R.id.postcardFragment, sendData())
            } else showDialog()
        }
        binding.buttonLaunch.setOnClickListener {
            if (checkInputFields(binding)) {
                this.requireActivity().moveTaskToBack(true)
                val handler = Handler()
                handler.postDelayed(Runnable {
                    findNavController().navigate(R.id.postcardFragment, sendData())
                }, 200)


            } else showDialog()
        }

    }

    private fun sendData() :Bundle{
        val bundle = Bundle()
        bundle.putString("name", binding.editTextName.text.toString())
        bundle.putString("title", binding.editTextTitle.text.toString())
        bundle.putString("text", binding.editTextText.text.toString())
        return bundle

    }


    private fun checkInputFields(binding: FragmentMainBinding): Boolean {
        val checkInputFields = CheckInputFields()
        return checkInputFields.checkAllInputField(
                binding.editTextText,
                binding.editTextName,
                binding.editTextTitle
        )
    }

    private fun showDialog() {
        val dialog = Dialog()
        dialog.show(this.requireActivity().supportFragmentManager, "dialog")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root

        // Inflate the layout for this fragment }
    }

    private fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == 200) {
                // Get the url of the image from data
                val selectedImageUri: Uri? = data?.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imageView.setImageURI(selectedImageUri)
                }
            }
        }
    }
}