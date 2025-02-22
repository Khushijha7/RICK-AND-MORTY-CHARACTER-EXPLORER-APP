package eu.tutorials.assignment_task1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import eu.tutorials.assignment_task1.R
import eu.tutorials.assignment_task1.ViewModel.ItemViewModel
import eu.tutorials.assignment_task1.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {
   lateinit var viewModel: ItemViewModel


   private val mBinding :FragmentTwoBinding by lazy{
       FragmentTwoBinding.inflate(layoutInflater)
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_two, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.frag2name.text = viewModel.DataItem.name
        mBinding.frag2desc.text = viewModel.DataItem.description
        Glide.with(requireContext()).load(viewModel.DataItem.image).into(mBinding.frag2img)


    }


}