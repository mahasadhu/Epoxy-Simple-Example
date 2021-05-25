package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.Nullable
import com.airbnb.epoxy.*
import com.bumptech.glide.Glide
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxyProfileOverviewBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ProfileOverview @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    data class State(
        val avatarUrl: String,
        val saldoMapan: Int,
        val poinMapan: Int
    )

    private val epoxyProfileOverviewBinding = EpoxyProfileOverviewBinding.bind(
        LayoutInflater.from(context).inflate(R.layout.epoxy_profile_overview, this, true)
    )

    init {
        orientation = VERTICAL
    }

    @ModelProp
    lateinit var state: State

    @CallbackProp
    fun onClickNotifikasiButton(@Nullable onClickListener: OnClickListener?) {
        epoxyProfileOverviewBinding.linearLayoutNotificationButton.setOnClickListener(
            onClickListener
        )
    }

    @CallbackProp
    fun onClickBantuanButton(@Nullable onClickListener: OnClickListener?) {
        epoxyProfileOverviewBinding.linearLayoutHelpButton.setOnClickListener(onClickListener)
    }

    @AfterPropsSet
    fun render() {
        epoxyProfileOverviewBinding.run {
            textViewSaldoMapan.text = state.saldoMapan.toString()
            textViewPoinMapan.text = state.poinMapan.toString()

            Glide
                .with(context)
                .load(state.avatarUrl)
                .into(imageViewAvatar)
        }
    }

    @OnViewRecycled
    fun clear() {
        epoxyProfileOverviewBinding.run {
            textViewSaldoMapan.text = null
            textViewPoinMapan.text = null

            imageViewAvatar.setImageDrawable(null)
        }
    }

}