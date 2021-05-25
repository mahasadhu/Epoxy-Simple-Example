package id.mahasadhu.epoxymodule.epoxycustomview.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import id.mahasadhu.common.dp
import id.mahasadhu.epoxymodule.R
import id.mahasadhu.epoxymodule.databinding.CompoundFeaturedCommentBinding

class FeaturedCommentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val compoundFeaturedCommentBinding = CompoundFeaturedCommentBinding.bind(
        LayoutInflater.from(context)
            .inflate(R.layout.compound_featured_comment, this, true)
    )

    val imageViewAvatarFeaturedComment = compoundFeaturedCommentBinding.imageViewAvatarFeaturedComment
    val textViewFeaturedCommentUsername = compoundFeaturedCommentBinding.textViewFeaturedCommentUsername
    val textViewFeaturedCommentCreatedOn = compoundFeaturedCommentBinding.textViewFeaturedCommentCreatedOn
    val textViewFeaturedCommentContent = compoundFeaturedCommentBinding.textViewFeaturedCommentContent

    init {
        orientation = HORIZONTAL
        setPadding(16.dp, 16.dp, 16.dp, 0)
    }

}