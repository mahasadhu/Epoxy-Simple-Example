package id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.*
import com.bumptech.glide.Glide
import id.mahasadhu.common.dp
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.EpoxyFeedBinding
import id.mahasadhu.epoxymodule.epoxycustomview.customviews.FeaturedCommentView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserPostFeed @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    data class State(
        val avatarUrl: String,
        val username: String,
        val createdOn: String,
        val content: String,
        val likeCount: Int,
        val commentCount: Int,
        val featuredComment: List<FeaturedComment>
    )

    data class FeaturedComment(
        val avatarUrl: String,
        val name: String,
        val createdOn: String,
        val content: String,
    )

    private val epoxyFeedBinding = EpoxyFeedBinding.bind(
        LayoutInflater.from(context).inflate(R.layout.epoxy_feed, this, true)
    )

    init {
        orientation = VERTICAL
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
    }

    @ModelProp
    lateinit var state: State

    @CallbackProp
    fun onClickMoreButton(@Nullable onClickListener: OnClickListener?){
        epoxyFeedBinding.imageViewMoreButton.setOnClickListener(onClickListener)
    }

    @CallbackProp
    fun onClickLikeButton(@Nullable onClickListener: OnClickListener?){
        epoxyFeedBinding.imageViewLikeButton.setOnClickListener(onClickListener)
    }

    @CallbackProp
    fun onClickCommentButton(@Nullable onClickListener: OnClickListener?){
        epoxyFeedBinding.imageViewCommentButton.setOnClickListener(onClickListener)
    }

    @CallbackProp
    fun onClickShareButton(@Nullable onClickListener: OnClickListener?){
        epoxyFeedBinding.imageViewShareButton.setOnClickListener(onClickListener)
    }

    @AfterPropsSet
    fun render(){
        layoutParams = (epoxyFeedBinding.root.layoutParams as MarginLayoutParams).apply {
            setMargins(0, 16.dp, 0, 0)
        }
        epoxyFeedBinding.run {
            Glide
                .with(context)
                .load(state.avatarUrl)
                .into(imageViewTSAvatar)

            textViewTSUsername.text = state.username
            textViewTSCreatedOn.text = state.createdOn
            textViewContent.text = state.content
            textViewLikeCounter.text = if (state.likeCount != 0) "${state.likeCount} Suka" else ""
            textViewCommentCounter.text = if (state.commentCount != 0) "${state.commentCount}" else ""

            if (state.featuredComment.isNotEmpty()){
                state.featuredComment.forEachIndexed { index, featuredComment ->
                    linearLayoutFeaturedCommentsWrapper.addView(FeaturedCommentView(context).apply {
                        Glide
                            .with(context)
                            .load(featuredComment.avatarUrl)
                            .into(imageViewAvatarFeaturedComment)

                        textViewFeaturedCommentUsername.text = featuredComment.name
                        textViewFeaturedCommentCreatedOn.text = featuredComment.createdOn
                        textViewFeaturedCommentContent.text = featuredComment.content
                    })
                }
                linearLayoutFeaturedCommentsWrapper.visibility = View.VISIBLE
            }
            else {
                linearLayoutFeaturedCommentsWrapper.removeAllViews()
                linearLayoutFeaturedCommentsWrapper.visibility = View.GONE
            }
        }
    }

    @OnViewRecycled
    fun clear() {
        epoxyFeedBinding.run {
            imageViewTSAvatar.setImageDrawable(null)

            textViewTSUsername.text = null
            textViewTSCreatedOn.text = null
            textViewContent.text = null
            textViewLikeCounter.text = null
            textViewCommentCounter.text = null

            linearLayoutFeaturedCommentsWrapper.removeAllViews()
        }
    }

}