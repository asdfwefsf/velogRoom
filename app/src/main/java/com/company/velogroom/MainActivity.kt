package com.company.velogroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.company.velogroom.ui.theme.VelogRoomTheme

class MainActivity : ComponentActivity() {

    // lazy를 사용하여 한 번만 객체를 만들고 그 뒤로는 재사용 하도록 하였다.
    private val db by lazy {
        // Room.databaseBuilder()는 RoomDatabase Instance를 생성하는 빌더 함수이다.
        Room.databaseBuilder(
            applicationContext, // RoomDatabase가 applicationContext에서 작동한다는 것을 알려준다.
            ContactDatabase::class.java, // RoomDatabase Instance를 생성할 때 사용될 Database Class를 알려준다.
            "contacts.db" // RoomDatabase Instance의 이름을 알려준다.
        ).build() // Room.databaseBuilder()의 parameter에 설정된 옵션들을 사용하여 RoomDatabase Instance 생성.
    }
    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return ContactViewModel(db.dao) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VelogRoomTheme {
                val state by viewModel.state.collectAsState()
                ContactScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}