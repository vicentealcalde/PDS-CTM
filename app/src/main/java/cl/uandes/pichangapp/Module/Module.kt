package cl.uandes.pichangapp.Module

import android.app.Application
import androidx.room.Room
import cl.uandes.pichangapp.api.Repository
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.friend.FriendRepository
import cl.uandes.pichangapp.database.lobby.LobbyRepository
import cl.uandes.pichangapp.database.user.UsersRepository
import cl.uandes.pichangapp.views.viewModels.FriendViewModel
import cl.uandes.pichangapp.views.viewModels.LobbyViewModel
import cl.uandes.pichangapp.views.viewModels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module{

    //Local Database with Room
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database") }

    //Repositories
    single { UsersRepository(get()) }
    single { LobbyRepository(get()) }
    single { FriendRepository(get()) }

    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().friendDao() }
    single { get<AppDatabase>().lobbyDao() }

    //API
    single { Repository() }
    viewModel { ApiViewModel(Application(),get()) }

    viewModel { FriendViewModel(Application(), get())}
    viewModel { LobbyViewModel(Application(), get()) }
    viewModel { UserViewModel(Application(), get()) }
}