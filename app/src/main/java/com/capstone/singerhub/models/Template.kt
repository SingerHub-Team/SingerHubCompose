package com.capstone.singerhub.models

val postTemplate = PostModel(
    1,
    "Lead Singer",
    "You get lead singer yes",
    1,
    200_000,
    500_000,
    "Hour",
    "Yesterday",
    "https://cdn.discordapp.com/attachments/775027234096414720/1111591176634630174/backdrop.png"
)

val officeTemplate = OfficeModel(
    1,
    "Kurokoffee",
    "Ciumbuleuit",
    "https://cdn.discordapp.com/attachments/775027234096414720/1111591505476468808/kurokoffee.png",
    (-6.5).toFloat(),
    100.083.toFloat()
)

fun postTemplateGenerator(amount: Int): ArrayList<PostModel> {
    val posts = ArrayList<PostModel>()
    for (i in 0 until amount) {
        posts.add(
            PostModel(
                i,
                "Position $i",
                "Desc $i",
                i,
                100_000 * i,
                110000 * i,
                "Hour",
                "$i days ago",
                "https://cdn.discordapp.com/attachments/775027234096414720/1111591176634630174/backdrop.png"
            )
        )
    }
    return posts
}

fun officeTemplateGenerator(amount: Int): ArrayList<OfficeModel> {
    val offices = ArrayList<OfficeModel>()
    for (i in 0 until amount) {
        offices.add(
            OfficeModel(
                i,
                "Office $i",
                "Place $i",
                "https://cdn.discordapp.com/attachments/775027234096414720/1111591505476468808/kurokoffee.png",
                i.toFloat(),
                i.toFloat()
            )
        )
    }
    return offices
}
