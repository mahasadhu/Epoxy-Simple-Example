package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.Nullable
import com.airbnb.epoxy.*
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxySimpleloadingBinding


@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = true)
class SimpleLoading @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val epoxySimpleLoadingBinding: EpoxySimpleloadingBinding =
        EpoxySimpleloadingBinding.bind(
            LayoutInflater.from(context).inflate(
                R.layout.epoxy_simpleloading,
                this,
                true
            )
        )

    init {
        orientation = VERTICAL
    }

    private var loadingVisibilityChanged: (() -> Unit)? = null

    @CallbackProp
    fun onLoadingVisibilityChanged(@Nullable loadingVisibilityChanged: (() -> Unit)?) {
        this.loadingVisibilityChanged = loadingVisibilityChanged
    }

    @OnVisibilityStateChanged
    fun myMethodForWatchingVisibilityState(@VisibilityState.Visibility visibilityState: Int) {
        if (visibilityState == VisibilityState.VISIBLE){
            this.loadingVisibilityChanged?.invoke()
        }
    }

}