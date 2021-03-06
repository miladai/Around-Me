package com.workshop.aroundme.data

import com.workshop.aroundme.data.mapper.toPlaceEntity
import com.workshop.aroundme.data.model.PlaceEntity
import com.workshop.aroundme.remote.datasource.PlaceDataSource

class PlaceRepository(private val placeDataSource: PlaceDataSource) {

    fun getFeaturedPlaces(success: (List<PlaceEntity>?) -> Unit) {
        Thread {
            val result = placeDataSource.getFeaturedPlaces()?.map { placeDto ->
                placeDto.toPlaceEntity()
            }
            success(result)
        }.start()
    }
}