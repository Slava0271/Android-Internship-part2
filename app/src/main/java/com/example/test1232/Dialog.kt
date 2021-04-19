package com.example.test1232

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import kotlin.system.exitProcess

class Dialog :DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Вы не заполнили поля ввода")
                .setPositiveButton("Ок",
                    DialogInterface.OnClickListener { _, _ ->
                        // FIRE ZE MISSILES!
                    })
                .setNegativeButton("Выход",
                    DialogInterface.OnClickListener { _, _ ->
                        exitProcess(0)
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}