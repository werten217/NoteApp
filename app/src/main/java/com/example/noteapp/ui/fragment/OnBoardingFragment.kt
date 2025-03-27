package com.example.noteapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.ui.Adapter.OnBoardPageAdapter
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardingBinding
import com.example.noteapp.ui.models.OnBoardModel
import com.example.noteapp.ui.utils.PreferenceHelper


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    private var onBoardPageAdapter: OnBoardPageAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }


    private fun initialize() {
        onBoardPageAdapter = OnBoardPageAdapter(generateDataOnBoard(), this@OnBoardingFragment)
        binding.viewpager.adapter = onBoardPageAdapter
    }

    fun generateDataOnBoard() = listOf<OnBoardModel>(
        OnBoardModel(
            "https://files.oaiusercontent.com/file-3hVYcQbvtpKWuX347W38FG?se=2025-03-18T19%3A52%3A34Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3D%25D0%2598%25D0%25B7%25D0%25BE%25D0%25B1%25D1%2580%25D0%25B0%25D0%25B6%25D0%25B5%25D0%25BD%25D0%25B8%25D0%25B5.jpeg&sig=yXXaE6cfR29hTy/1C4bzNWpcxrRe2MPX1jW9GM5YQI0%3D",
            "Удобство",
            "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
        ),
        OnBoardModel(
            "https://files.oaiusercontent.com/file-XrmUGNMf139HChNSztpVfL?se=2025-03-19T05%3A01%3A36Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3Da706adaaf21259444457321bd362df20.gif&sig=6nMROqjggyDQXyPwNxKcBTYj38CZt85KWMmYwZhAbwo%3D",
            "Организация",
            "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
        ),
        OnBoardModel(
            "https://files.oaiusercontent.com/file-MtD2kAuW6qyri2SDEMWuqW?se=2025-03-19T16%3A01%3A19Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3Db705755e5a87fa01bc1de6f9a54c7e17.gif&sig=8UVciy4GjG5C7GqpslCjup7b3T/%2BvNS0EjMIIs1qJqY%3D", "Синхронизация",
            "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
        )
    )

    private fun setupListeners() {
        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.buttonStart.isVisible = position == 2
                binding.skippBtn.isInvisible = position == 2
            }
        })
        val shared = PreferenceHelper()
        shared.init(requireContext())
        binding.buttonStart.setOnClickListener{
            findNavController().navigate(R.id.action_onBoardingFragment_to_noteFragment)
            shared.isOnBoard = true
        }
    }


}
