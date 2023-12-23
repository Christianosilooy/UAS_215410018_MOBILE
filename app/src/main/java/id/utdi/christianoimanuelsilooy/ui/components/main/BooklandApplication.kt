package id.utdi.christianoimanuelsilooy.ui.components.main

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import id.utdi.christianoimanuelsilooy.db.BookDatabase
import id.utdi.christianoimanuelsilooy.networking.BookApi
import id.utdi.christianoimanuelsilooy.networking.RetrofitClient
import id.utdi.christianoimanuelsilooy.repositories.BookRepository
import id.utdi.christianoimanuelsilooy.utils.PrefsHelper

enum class ThemeMode {
    LIGHT, DARK, AUTO
}

class BooklandApplication : Application() {
    lateinit var bookRepository: BookRepository

    val themeMode = mutableStateOf(ThemeMode.AUTO)

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

       // Deklarasi Metode `initialize`: Inisialisasi komponen-komponen utama aplikasi.
    private fun initialize() {
           // Inisialisasi `bookApi` menggunakan RetrofitClient untuk membuat instance dari BookApi.
        val bookApi = RetrofitClient.getInstance().create(BookApi::class.java)
           // Inisialisasi `database`: Mendapatkan instance dari BookDatabase menggunakan fungsi `getDatabase`.
        val database = BookDatabase.getDatabase(applicationContext)
        bookRepository = BookRepository(bookApi, database)

        PrefsHelper.initPrefs(applicationContext)
    }
}