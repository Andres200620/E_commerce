package com.example.e_commerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {
    companion object {
        fun newInstance() = HomePageFragment()
    }

    private lateinit var viewModel: HomePageViewModel
    private lateinit var _binding: FragmentHomePageBinding
    private val binding get() = _binding

    private lateinit var adapter: ProductListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomePageViewModel::class.java]

        //API CALL
        viewModel.getProductsList()

        //RECYCLER ADAPTER
        adapter = ProductListAdapter(viewModel.productList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter



         // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.responseListLivedata.observe(viewLifecycleOwner,  Observer<ArrayList<ProductDetail>>
        { latestList ->
            adapter.updateProduct(latestList)
        })



    }




}