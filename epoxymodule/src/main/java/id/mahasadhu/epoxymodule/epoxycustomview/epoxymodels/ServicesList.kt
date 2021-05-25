package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.*
import id.mahasadhu.common.dp
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxyServicesListBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = true, saveViewState = true)
class ServicesList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    data class State(val servicesList: List<ServiceItemPojoModel>){
        data class ServiceItemPojoModel(val name: String)
    }

    interface ServicesItemClickListener {
        fun onClick(model: ServiceItemModel_, parentView: ServiceItem, clickedView: View, position: Int)
    }

    private val epoxyServicesListBinding: EpoxyServicesListBinding =
        EpoxyServicesListBinding.bind(
            LayoutInflater.from(context).inflate(
                R.layout.epoxy_services_list,
                this,
                true
            )
        )

    init {
        setPadding(0, 16.dp, 0, 0)
        orientation = VERTICAL
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
    }

    @ModelProp
    lateinit var state: State

    /**
     * Property ini pake DoNotHash karena ini interface untuk onClick event.
     * Dan kalo interface berubah, gaperlu rebind view nya
     */
    @ModelProp(options = [ModelProp.Option.DoNotHash])
    lateinit var onServiceItemClickListener: ServicesItemClickListener

    @AfterPropsSet
    fun render() {
        epoxyServicesListBinding.epoxyRecyclerViewServicesList.apply {
            withModels {
                state.servicesList.forEachIndexed { index, serviceItemPojoModel ->
                    serviceItem {
                        val id = "serviceItem $index"
                        id(id)
                        onClickServiceItem { model, parentView, clickedView, position ->
                            onServiceItemClickListener.onClick(model, parentView, clickedView, position)
                        }
                        serviceName(serviceItemPojoModel.name)
                    }
                }
            }
        }
    }

}