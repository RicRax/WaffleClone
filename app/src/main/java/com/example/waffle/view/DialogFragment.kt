package com.example.waffle.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.waffle.R
import com.example.waffle.databinding.DialogNewdiaryBinding
import com.example.waffle.model.repository.DbRepository
import com.example.waffle.presenter.addDiaryDialogPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MyDialogFragment : DialogFragment() {


    private lateinit var binding: DialogNewdiaryBinding

    lateinit var presenter: addDiaryDialogPresenter

    @Inject
    lateinit var dbRepository: DbRepository
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{

            binding = FragmentLoginBinding.setContentView(this, R.layout.dialog_newdiary)

            presenter = addDiaryDialogPresenter(dbRepository)

            val inflater = requireActivity().layoutInflater

            val builder = AlertDialog.Builder(it)

            val userId = arguments?.getInt("key")

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_newdiary, null))

                // Add action buttons
                .setPositiveButton(R.string.add,
                    DialogInterface.OnClickListener { dialog, id ->
                        presenter.addDiary(0, binding.nameDiary.text.toString())

                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->

                    })

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}