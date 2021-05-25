package id.mahasadhu.epoxymodule.epoxycustomview

import com.airbnb.epoxy.EpoxyController
import id.mahasadhu.epoxymodule.State
import id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels.ProfileOverview
import id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels.ServicesList
import id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels.UserPostFeed
import id.mahasadhu.epoxymodule.epoxycustomview.epoxymodels.homeSlider
import kotlin.random.Random

val defaultDummyState = State(
    homeSliderUrls = listOf(
        "https://images.unsplash.com/photo-1619266912950-6f3f37a61693?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2788&q=80",
    ),
    profileState = ProfileOverview.State(
        avatarUrl = "https://images.unsplash.com/photo-1542103749-8ef59b94f47e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
        saldoMapan = 10000,
        poinMapan = 20000
    ),
    userPostFeeds = listOf(
        UserPostFeed.State(
            avatarUrl = "https://images.unsplash.com/photo-1542103749-8ef59b94f47e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
            username = "Mahasadhu",
            createdOn = "2 hari yang lalu",
            content = "Tes Komen wauw",
            likeCount = Random.nextInt(0, 100),
            commentCount = Random.nextInt(0, 100),
            listOf(
                UserPostFeed.FeaturedComment(
                    avatarUrl = "https://images.unsplash.com/photo-1593104547489-5cfb3839a3b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2536&q=80",
                    name = "Petra",
                    createdOn = "Kemarin",
                    content = "Tes featured comment 1"
                ),
                UserPostFeed.FeaturedComment(
                    avatarUrl = "https://images.unsplash.com/photo-1593104547489-5cfb3839a3b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2536&q=80",
                    name = "Petra",
                    createdOn = "Kemarin",
                    content = "Tes featured comment 2"
                ),
                UserPostFeed.FeaturedComment(
                    avatarUrl = "https://images.unsplash.com/photo-1593104547489-5cfb3839a3b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2536&q=80",
                    name = "Petra",
                    createdOn = "Kemarin",
                    content = "Tes featured comment 3"
                )
            )
        ),
        UserPostFeed.State(
            avatarUrl = "https://images.unsplash.com/photo-1542103749-8ef59b94f47e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
            username = "Mahasadhu",
            createdOn = "2 hari yang lalu",
            content = "Tes Komen wauw",
            likeCount = Random.nextInt(0, 100),
            commentCount = Random.nextInt(0, 100),
            listOf(
                UserPostFeed.FeaturedComment(
                    avatarUrl = "https://images.unsplash.com/photo-1593104547489-5cfb3839a3b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2536&q=80",
                    name = "Petra",
                    createdOn = "Kemarin",
                    content = "Tes featured comment"
                ),
            )
        ),
        UserPostFeed.State(
            avatarUrl = "https://images.unsplash.com/photo-1542103749-8ef59b94f47e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
            username = "Mahasadhu",
            createdOn = "2 hari yang lalu",
            content = "Tes Komen wauw",
            likeCount = Random.nextInt(0, 100),
            commentCount = Random.nextInt(0, 100),
            listOf()
        ),
        UserPostFeed.State(
            avatarUrl = "https://images.unsplash.com/photo-1542103749-8ef59b94f47e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
            username = "Mahasadhu",
            createdOn = "2 hari yang lalu",
            content = "Tes Komen wauw",
            likeCount = Random.nextInt(0, 100),
            commentCount = Random.nextInt(0, 100),
            listOf(
                UserPostFeed.FeaturedComment(
                    avatarUrl = "https://images.unsplash.com/photo-1593104547489-5cfb3839a3b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2536&q=80",
                    name = "Petra",
                    createdOn = "Kemarin",
                    content = "Tes featured comment"
                )
            )
        ),
    ),
    servicesList = listOf(
        ServicesList.State.ServiceItemPojoModel("Arisan 1"),
        ServicesList.State.ServiceItemPojoModel("Arisan 2"),
        ServicesList.State.ServiceItemPojoModel("Arisan 3"),
        ServicesList.State.ServiceItemPojoModel("Arisan 4"),
        ServicesList.State.ServiceItemPojoModel("Arisan 5"),
        ServicesList.State.ServiceItemPojoModel("Arisan 6"),
        ServicesList.State.ServiceItemPojoModel("Arisan 7"),
        ServicesList.State.ServiceItemPojoModel("Arisan 8"),
        ServicesList.State.ServiceItemPojoModel("Arisan 9"),
        ServicesList.State.ServiceItemPojoModel("Arisan 10"),
    )
)

fun addAnotherHomeSliderComponent(epoxyController: EpoxyController, state: State){
    epoxyController.apply {
        homeSlider {
            id("homeSlider_" + 1)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 2)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 3)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 4)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 5)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 6)
            imageUrl(state.homeSliderUrls)
        }
        homeSlider {
            id("homeSlider_" + 7)
            imageUrl(state.homeSliderUrls)
        }
    }
}