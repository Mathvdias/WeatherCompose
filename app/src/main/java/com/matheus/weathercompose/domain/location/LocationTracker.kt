package com.matheus.weathercompose.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?

}