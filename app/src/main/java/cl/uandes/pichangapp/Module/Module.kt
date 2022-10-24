package cl.uandes.pichangapp.Module

import android.app.Application
import androidx.room.Room
import cl.uandes.pichangapp.api.Repository
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.AppRepository
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerRepository
import cl.uandes.pichangapp.database.friend.FriendRepository
import cl.uandes.pichangapp.database.lobby.LobbyRepository
import cl.uandes.pichangapp.database.user.UserRepository
import cl.uandes.pichangapp.viewModels.FriendViewModel
import cl.uandes.pichangapp.viewModels.InGamePlayersViewModel
import cl.uandes.pichangapp.viewModels.LobbyViewModel
import cl.uandes.pichangapp.viewModels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module{

    //Local Database with Room
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build() }

    //Repositories
    single { AppRepository(get()) }

    single { UserRepository(get()) }
    single { LobbyRepository(get()) }
    single { FriendRepository(get()) }
    single { InGamePlayerRepository(get()) }

    // Daos
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().friendDao() }
    single { get<AppDatabase>().lobbyDao() }
    single { get<AppDatabase>().inGamePlayerDao() }

    //API
    single { Repository() }
    viewModel { ApiViewModel(Application(),get(), get(), get(), get(), get() ) }

    // ViewModels
    viewModel { FriendViewModel(Application(), get()) }
    viewModel { LobbyViewModel(Application(), get()) }
    viewModel { UserViewModel(Application(), get()) }
    viewModel { InGamePlayersViewModel(Application(), get()) }
}