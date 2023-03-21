package id.insinyurdigital.doi.ui.generate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.insinyurdigital.doi.R

class GenerateVoucherFragment : Fragment() {

    companion object {
        fun newInstance() = GenerateVoucherFragment()
    }

    private lateinit var viewModel: GenerateVoucherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_generate_voucher, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenerateVoucherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}