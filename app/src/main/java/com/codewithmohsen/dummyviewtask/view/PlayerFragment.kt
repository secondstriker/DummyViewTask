package com.codewithmohsen.dummyviewtask.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codewithmohsen.dummyviewtask.AppCoroutineDispatchers
import com.codewithmohsen.dummyviewtask.R
import com.codewithmohsen.dummyviewtask.adapter.MovieItemAdapter
import com.codewithmohsen.dummyviewtask.databinding.ItemMoviesBinding
import com.codewithmohsen.dummyviewtask.utils.autoCleared
import com.codewithmohsen.dummyviewtask.vm.MoviesViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PlayerFragment : Fragment() {

    private var isFullScreen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.button_fullscreen).setOnClickListener {
            isFullScreen = !isFullScreen
            toggleFullScreen()
        }
    }

    /**
     * Detects and toggles immersive mode.
     */
    private fun toggleFullScreen() {
        if (isFullScreen) {
            (requireActivity() as AppCompatActivity).supportActionBar?.hide()
            requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            view?.setPadding(0, getStatusAndTitleBarHeight(), 0, getNavigationBarHeight())
        } else {
            (requireActivity() as AppCompatActivity).supportActionBar?.show()
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            view?.setPadding(0, 0, 0, 0)
        }
        // BEGIN_INCLUDE (get_current_ui_flags)
        // The UI options currently enabled are represented by a bitfield.
        // getSystemUiVisibility() gives us that bitfield.
        val uiOptions = requireActivity().window.decorView.systemUiVisibility
        var newUiOptions = uiOptions
        // END_INCLUDE (get_current_ui_flags)
        // BEGIN_INCLUDE (toggle_ui_flags)

        // Immersive mode: Backward compatible to KitKat (API 19).
        // Note that this flag doesn't do anything by itself, it only augments the behavior
        // of HIDE_NAVIGATION and FLAG_FULLSCREEN.  For the purposes of this sample
        // all three flags are being toggled together.
        // This sample uses the "sticky" form of immersive mode, which will let the user swipe
        // the bars back in again, but will automatically make them disappear a few seconds later.
        newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_FULLSCREEN
        newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        requireActivity().window.decorView.systemUiVisibility = newUiOptions
        //END_INCLUDE (set_ui_flags)
    }

    private fun getStatusAndTitleBarHeight(): Int{

        // status bar height
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }

        // action bar height
        var actionBarHeight = 0
        val styledAttributes =
            requireActivity().theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        actionBarHeight = styledAttributes.getDimension(0, 0f).toInt()
        styledAttributes.recycle()

        return statusBarHeight + actionBarHeight
    }

    private fun getNavigationBarHeight(): Int{

        // navigation bar height
        var navigationBarHeight = 0
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        if (resourceId > 0) {
            navigationBarHeight = resources.getDimensionPixelSize(resourceId)
        }

        return navigationBarHeight
    }

}