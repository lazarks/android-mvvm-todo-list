package com.example.todolist.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.database.TaskEntry
import com.example.todolist.databinding.FragmentUpdateBinding
import com.example.todolist.viewmodel.TaskViewModel

class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentUpdateBinding.inflate(inflater)
        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateEdtTask.setText(args.taskEntry.title)
            updateSpinner.setSelection(args.taskEntry.priority)

            btnUpdate.setOnClickListener{
                if(TextUtils.isEmpty(updateEdtTask.text)){
                    Toast.makeText(requireContext(), "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val taskStr = updateEdtTask.text
                val priority = updateSpinner.selectedItemPosition

                val taskEntry = TaskEntry(args.taskEntry.id, taskStr.toString(), priority, args.taskEntry.timeStamp)

                viewModel.update(taskEntry)
                Toast.makeText(requireContext(), "Updated!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)
            }
        }

        return binding.root
    }
}