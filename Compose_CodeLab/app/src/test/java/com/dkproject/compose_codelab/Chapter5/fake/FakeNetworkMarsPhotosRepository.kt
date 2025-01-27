package com.dkproject.compose_codelab.Chapter5.fake

import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.MarsPhoto
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.MarsPhotosRepository

class FakeNetworkMarsPhotosRepository: MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}