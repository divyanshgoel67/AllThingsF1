package com.example.f1repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.database.F1Database
import com.example.database.SeasonsListDao
import com.example.models.seasons.SeasonsDetailModel
import com.example.models.seasons.SeasonsListWrapperModel
import com.example.retrofit.communicator.SeasonsListCommunicator
import com.example.retrofit.dataprovider.SeasonListRemoteDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeasonsListRepository @Inject constructor() {

    @Inject
    lateinit var database: F1Database

    @Inject
    lateinit var seasonsListDao: SeasonsListDao

    var failedResultLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        RepositoryInitialiser.instance.getDataBaseComponent().inject(this)
    }

    private var communicator = object : SeasonsListCommunicator {
        override fun onSeasonsListResponseSuccessful(result: SeasonsListWrapperModel?) {
            CoroutineScope(Dispatchers.IO).launch {
                seasonsListDao.insertSeasonsList(result?.data?.seasonsTable?.seasons!!)
            }
        }

        override fun onSeasonsListResponseFailed(message: String) {
            failedResultLiveData.value = message
        }
    }

    private var remoteDataProvider: SeasonListRemoteDataProvider =
        SeasonListRemoteDataProvider(communicator)

    fun getCurrentSeason(): LiveData<SeasonsDetailModel> {
        CoroutineScope(Dispatchers.IO).launch {
            if (!checkIfSeasonsDataIsPresent()) {
                remoteDataProvider.getSeasonsListFromRemoteStorage()
            }
        }
        return seasonsListDao.getCurrentSeason()
    }

    fun getSeasonsList(): LiveData<List<SeasonsDetailModel>> {
        CoroutineScope(Dispatchers.IO).launch {
            if (!checkIfSeasonsDataIsPresent()) {
                remoteDataProvider.getSeasonsListFromRemoteStorage()
            }
        }
        return seasonsListDao.getAllSeasons()
    }

    private suspend fun checkIfSeasonsDataIsPresent(): Boolean {
        return seasonsListDao.getSeasonsCount() != 0
    }
}
