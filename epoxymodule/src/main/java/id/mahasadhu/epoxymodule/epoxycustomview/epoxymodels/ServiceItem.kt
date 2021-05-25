package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.Nullable
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import id.mahasadhu.common.dp
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxyServiceItemBinding

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT, fullSpan = true)
class ServiceItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val epoxyServiceItemBinding: EpoxyServiceItemBinding =
        EpoxyServiceItemBinding.bind(
            LayoutInflater.from(context).inflate(
                R.layout.epoxy_service_item,
                this,
                true
            )
        )

    init {
        orientation = VERTICAL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            epoxyServiceItemBinding.root.setBackgroundResource(TypedValue().apply {
                context.theme.resolveAttribute(
                    android.R.attr.selectableItemBackgroundBorderless,
                    this,
                    true
                )
            }.resourceId)
        }
    }

    @TextProp
    lateinit var serviceName: CharSequence

    @CallbackProp
    fun onClickServiceItem(@Nullable onClickListener: OnClickListener?) {
        epoxyServiceItemBinding.root.setOnClickListener(onClickListener)
    }

    @AfterPropsSet
    fun render() {
        setPadding(6.dp, 6.dp, 6.dp, 6.dp)
        epoxyServiceItemBinding.textViewServiceName.text = serviceName
    }

}