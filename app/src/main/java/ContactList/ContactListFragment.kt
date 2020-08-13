package ContactList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentContactListBinding

class ContactListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentContactListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_contact_list, container, false)

        val application = requireNotNull(this.activity).application

        return binding.root
    }
}