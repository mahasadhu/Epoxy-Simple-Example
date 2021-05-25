package id.mahasadhu.epoxymodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyVisibilityTracker
import com.airbnb.epoxy.OnModelClickListener
import id.mahasadhu.epoxymodule.databinding.ActivityEpoxyCustomViewBinding
import id.mahasadhu.epoxymodule.epoxycustomview.addAnotherHomeSliderComponent
import id.mahasadhu.epoxymodule.epoxycustomview.defaultDummyState
import id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels.*
import kotlin.random.Random

data class State(
    val homeSliderUrls: List<String>,
    val profileState: ProfileOverview.State,
    val userPostFeeds: List<UserPostFeed.State>,
    val servicesList: List<ServicesList.State.ServiceItemPojoModel>
)

class EpoxyCustomViewActivity : AppCompatActivity() {

    private lateinit var activityEpoxyCustomViewBinding: ActivityEpoxyCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityEpoxyCustomViewBinding = ActivityEpoxyCustomViewBinding.inflate(layoutInflater)
        setContentView(activityEpoxyCustomViewBinding.root)

        /**
         * biar bisa cek apa component nya udah kerender atau belum di RV nya
         */
        val epoxyVisibilityTracker = EpoxyVisibilityTracker()
        epoxyVisibilityTracker.attach(activityEpoxyCustomViewBinding.epoxyRecyclerView)

        render(defaultDummyState)
    }

    /**
     * Method untuk set recyclerview nya jadi pake grid layout.
     * Jumlah grid yang dipake per child ditentuin dari annotation parameter di epoxy model class nya, namanya fullSpan
     */
    private fun setAsGridLayout(epoxyController: EpoxyController, spanCount: Int){
        val layoutManager = GridLayoutManager(this, spanCount)
        layoutManager.spanSizeLookup = epoxyController.spanSizeLookup
        epoxyController.spanCount = spanCount

        activityEpoxyCustomViewBinding.epoxyRecyclerView.layoutManager = layoutManager
    }

    private fun render(state: State){
        val context = this

        activityEpoxyCustomViewBinding.epoxyRecyclerView.withModels {
            /**
             * Kalo mau uncomment ini, uncomment juga fungsi addAnotherHomeSliderComponent dibawah.
             * Soalnya yang fullSpan == false itu cuma di component homeSlider
             */
            // setAsGridLayout(this, 2)
            // addAnotherHomeSliderComponent(this, state)

            homeSlider {
                id("homeSlider_" + 1)
                imageUrl(state.homeSliderUrls)
            }

            profileOverview {
                id("profileOverview_" + 1)
                state(state.profileState)
                onClickNotifikasiButton { model, parentView, clickedView, position ->
                    Toast.makeText(context, "NOTIFIKASI", Toast.LENGTH_SHORT).show()
                }
                onClickBantuanButton { model, parentView, clickedView, position ->
                    Toast.makeText(context, "BANTUAN", Toast.LENGTH_SHORT).show()
                }
            }

            servicesList {
                id("servicesList_1")
                state(ServicesList.State(state.servicesList))
                onServiceItemClickListener(object : ServicesList.ServicesItemClickListener {
                    override fun onClick(
                        model: ServiceItemModel_,
                        parentView: ServiceItem,
                        clickedView: View,
                        position: Int
                    ) {
                        Toast.makeText(this@EpoxyCustomViewActivity, model.getServiceName(this@EpoxyCustomViewActivity), Toast.LENGTH_SHORT).show()
                    }

                })
            }

            state.userPostFeeds.forEachIndexed { index, state ->
                userPostFeed {
                    val id = "commentFeed_" + index
                    id(id)
                    state(state)
                    onClickMoreButton { model, parentView, clickedView, position ->
                        Toast.makeText(context, "MORE " + id, Toast.LENGTH_SHORT).show()
                    }
                    onClickLikeButton { model, parentView, clickedView, position ->
                        Toast.makeText(context, "LIKE " + id, Toast.LENGTH_SHORT).show()
                    }
                    onClickCommentButton { model, parentView, clickedView, position ->
                        Toast.makeText(context, "COMMENT " + id, Toast.LENGTH_SHORT).show()
                    }
                    onClickShareButton { model, parentView, clickedView, position ->
                        Toast.makeText(context, "SHARE " + id, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            simpleLoading {
                id("simple_loading")
                onLoadingVisibilityChanged {
                    Toast.makeText(this@EpoxyCustomViewActivity, "Berhubung circular progressbar nya udah keliatan, start loading next page...", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}