package com.esq.tiktokviddownload.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.esq.tiktokviddownload.R
import com.esq.tiktokviddownload.databinding.FragmentHomeBinding
import com.esq.tiktokviddownload.model.UrlValidationCallback
import com.esq.tiktokviddownload.utils.toast

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), UrlValidationCallback {
    var position = 0
    private val textView: TextView? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            position = arguments!!.getInt("pos")
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container,false )
        // Obtain ViewModel from ViewModelProviders
        val _viewModel = ViewModelProvider(this, HomeViewModelFactory(this)).get(HomeViewModel::class.java)
        binding.viewModel = _viewModel
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putInt("pos", position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCorrectUrl(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun onIncorrectUrl(errorMessage: String) {
        activity!!.toast(errorMessage)
    }

    override fun onSendDownloadIntent() {
        TODO("Not yet implemented")
    }
}