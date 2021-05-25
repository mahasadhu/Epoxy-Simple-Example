package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.OnViewRecycled
import com.bumptech.glide.Glide
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxyHomesliderBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class HomeSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val epoxyHomesliderBinding: EpoxyHomesliderBinding =
        EpoxyHomesliderBinding.bind(
            LayoutInflater.from(context).inflate(
                R.layout.epoxy_homeslider,
                this,
                true
            )
        )

    init {
        orientation = VERTICAL
    }

    @ModelProp
    lateinit var imageUrl: List<String>

    @AfterPropsSet
    fun render(){
        Glide
            .with(context)
            .load(imageUrl[0])
            .into(epoxyHomesliderBinding.imageViewDummySlider)
    }

    @OnViewRecycled
    fun clear() {
        epoxyHomesliderBinding.imageViewDummySlider.setImageDrawable(null)
    }
}