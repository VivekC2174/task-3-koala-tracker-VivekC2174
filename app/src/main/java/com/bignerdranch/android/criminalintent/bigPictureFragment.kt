package com.bignerdranch.android.criminalintent

import android.app.ActivityManager
import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.bignerdranch.android.criminalintent.databinding.FragmentCrimeDetailBinding
import com.bignerdranch.android.criminalintent.databinding.LargeImageBinding
import com.bignerdranch.android.criminalintent.databinding.LargeImageBinding.inflate


class bigPictureDialogfragment : DialogFragment(){
    private var _binding: LargeImageBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = layoutInflater.inflate(R.layout.large_image, container, false)
        return rootView

    }

    fun updatePicture(bitmap: Bitmap){
        binding.apply {
            binding.placeholderLarge.setImageBitmap(bitmap)
        }
    }


 /*   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        return dialog
    }
    companion object {
        const val dialog = "dialog"
    }*/





}