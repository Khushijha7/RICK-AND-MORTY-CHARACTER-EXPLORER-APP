package eu.tutorials.assignment_task1.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.assignment_task1.OnItemClickListener
import eu.tutorials.assignment_task1.R
import eu.tutorials.assignment_task1.ViewModel.ItemViewModel
import eu.tutorials.assignment_task1.adapter.RecyclerAdapter
import eu.tutorials.assignment_task1.databinding.FragmentHomeBinding
import eu.tutorials.assignment_task1.model.Shopping


class HomeFragment : Fragment(), OnItemClickListener {
    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemViewModel: ItemViewModel
    private var progressBar: ProgressBar? = null

    private val mBinding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(requireActivity())[ItemViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = mBinding.progressBar
        recyclerView = mBinding.recycleView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.setHasFixedSize(true)
        adapter = RecyclerAdapter(requireContext(), this)
        recyclerView.adapter = adapter
//        Log.d(" API1","HomeFragment")
//        itemViewModel.getData()
        itemViewModel.item.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
            if (it.size != 0) {
                Log.d("Ankita", "onViewCreated: " + it.size)
                progressBar?.setVisibility(View.GONE)
            }
        })


    }

    override fun onclick(data: Shopping) {
//        val bundle: Bundle = data
        val frag2 = FragmentTwo()
        itemViewModel.DataItem = data
        val transac =
            this.parentFragmentManager.beginTransaction().replace(R.id.frame_layout, frag2)
                .addToBackStack(null)
        transac.commit()
    }
}