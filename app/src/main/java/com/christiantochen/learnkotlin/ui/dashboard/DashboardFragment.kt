package com.christiantochen.learnkotlin.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.christiantochen.learnkotlin.R
import com.christiantochen.learnkotlin.databinding.FragmentDashboardBinding
import com.christiantochen.learnkotlin.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : BaseFragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(DashboardViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        task_overview_seekbar.isEnabled = false
    }

    companion object {
        const val TAG = "DashboardFragment"

//        fun newInstance() : DashboardFragment {
//            var fragment = DashboardFragment()
//            var bundle = Bundle()
//            fragment.arguments = bundle
//            return fragment
//        }

        fun newInstance() : DashboardFragment {
            return DashboardFragment()
        }
    }
}