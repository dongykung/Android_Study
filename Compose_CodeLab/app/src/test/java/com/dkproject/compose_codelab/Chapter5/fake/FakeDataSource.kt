package com.dkproject.compose_codelab.Chapter5.fake

import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.MarsPhoto
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.network.MarsApiService

object FakeDataSource {
    const val idOne = "img1"
    const val idTwo = "imag2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf(
        MarsPhoto(id = idOne, imageSrc = imgOne),
        MarsPhoto(id = idTwo, imageSrc = imgTwo)
    )
}

class FakeMarsApiService: MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}