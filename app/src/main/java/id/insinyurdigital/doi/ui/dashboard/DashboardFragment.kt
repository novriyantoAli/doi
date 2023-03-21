package id.insinyurdigital.doi.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.insinyurdigital.doi.R
import id.insinyurdigital.doi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding = FragmentDashboardBinding.inflate(inflater, group, false)

        binding.btnPrint.setOnClickListener {
            findNavController().navigate(R.id.navigation_generate_voucher)
        }

        val root: View = binding.root
        requireActivity().setTitle(getString(R.string.title_dashboard))


        return root
    }

}