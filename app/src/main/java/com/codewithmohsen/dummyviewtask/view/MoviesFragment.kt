package com.codewithmohsen.dummyviewtask.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codewithmohsen.dummyviewtask.AppCoroutineDispatchers
import com.codewithmohsen.dummyviewtask.R
import com.codewithmohsen.dummyviewtask.adapter.MovieItemAdapter
import com.codewithmohsen.dummyviewtask.databinding.FragmentMoviesBinding
import com.codewithmohsen.dummyviewtask.utils.autoCleared
import com.codewithmohsen.dummyviewtask.vm.MoviesViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MoviesFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MoviesViewModel by viewModels {
        viewModelFactory
    }
    @Inject lateinit var appCoroutineDispatchers: AppCoroutineDispatchers

    var binding by autoCleared<FragmentMoviesBinding>()
    private lateinit var adapter: MovieItemAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this

        adapter = MovieItemAdapter(appCoroutineDispatchers) { item ->
            //onclick implementation
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.recyclerViewMovies.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMovies.adapter = adapter
        initItemList()
        return binding.root
    }

    private fun initItemList() {
        viewModel.getMovies().observe(viewLifecycleOwner, Observer {movie ->
            adapter.submitList(movie)
        })
    }
}