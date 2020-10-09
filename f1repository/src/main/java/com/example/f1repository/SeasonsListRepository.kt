package com.example.f1repository

import androidx.lifecycle.LiveData
import com.example.database.F1Database
import com.example.models.seasons.SeasonsDetailModel
import com.example.models.seasons.SeasonsListWrapperModel
import com.example.retrofit.SeasonListRemoteDataProvider
import com.example.retrofit.SeasonsListCommunicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeasonsListRepository @Inject constructor(
    var database: F1Database
) : SeasonsListCommunicator {

    var seasonsListDao = database.seasonsListDao()

    var remoteDataProvider: SeasonListRemoteDataProvider =
        SeasonListRemoteDataProvider(this)

    fun getCurrentSeason(): LiveData<SeasonsDetailModel> {
        CoroutineScope(Dispatchers.IO).launch {
            if (checkIfSeasonsDataIsPresent()) {
                remoteDataProvider.getSeasonsListFromRemoteStorage()
            }
        }
        return seasonsListDao.getCurrentSeason()
    }

    private suspend fun checkIfSeasonsDataIsPresent(): Boolean {
        return seasonsListDao.getSeasonsCount() != 0
    }

    override fun onSeasonsListResponseSuccessful(result: SeasonsListWrapperModel?) {
        CoroutineScope(Dispatchers.IO).launch {
            seasonsListDao.insertSeasonsList(result?.data?.seasonsTable?.seasons!!)
        }
    }

    override fun onSeasonsListResponseFailed() {
        // tell UI that the operation is failed
    }

}
