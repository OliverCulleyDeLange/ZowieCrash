package com.example.zowiecrash

import ai.zowie.Zowie
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import com.example.zowiecrash.databinding.FragmentContainerViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/** Fragment which shows Zowie Fragment in a bottom sheet dialog */
class ZowieFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentContainerViewBinding? = null
    private val binding: FragmentContainerViewBinding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentContainerViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replace(Zowie.createChatFragment(), "ZOWIE")
    }

    private fun replace(fragment: Fragment, tag: String) {
        childFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}