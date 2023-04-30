package com.example.waffle.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.waffle.R
import com.example.waffle.databinding.DialogNewdiaryBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.addDiaryDialogPresenter
import javax.inject.Inject

class MyDialogFragment : DialogFragment() {

    lateinit var presenter: addDiaryDialogPresenter

    @Inject
    lateinit var dbRepository: DbRepository
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //use bundle to get userId
         lateinit var binding: DialogNewdiaryBinding

        presenter = addDiaryDialogPresenter(dbRepository)

        val builder = AlertDialog.Builder(activity)

        // Get the layout inflater
        val inflater = requireActivity().layoutInflater

        val userId = arguments?.getInt("key")

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_newdiary, null))

            // Add action buttons
            .setPositiveButton(R.string.add,
                DialogInterface.OnClickListener { dialog, id ->
                    presenter.addDiary(0,binding.nameDiary.text.toString())

                })
            .setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->

                })

        return builder.create()

    }
}