package com.example.test1232

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test1232.databinding.FragmentPostcardBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_postcard.*


class PostcardFragment : Fragment() {


    private lateinit var binding: FragmentPostcardBinding
    private val viewModel: PostCardModel = PostCardModel()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostcardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel2 = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        showPostCardMess()
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

    private fun getRes(): ArrayList<String> {
        val list: ArrayList<String> = ArrayList()
        list.add(arguments?.getString("name").toString())
        list.add(arguments?.getString("title").toString())
        list.add(arguments?.getString("text").toString())

        return list
    }

    private fun showPostCardMess() {
        //set Title
        setField(binding.titleTextView, getRes(), 1)
        setField(binding.nameTextView, getRes(), 0)
        setField(binding.textViewPostCard, getRes(), 2)
    }

    private fun setAvatarOnCLick() {
        binding.avatar.setOnClickListener {
            imageChooser()
        }
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
                    avatar.setImageURI(selectedImageUri)
                }
            }
        }
    }
}