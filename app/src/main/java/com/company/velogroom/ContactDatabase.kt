package com.company.velogroom

import androidx.room.Database
import androidx.room.RoomDatabase

// abstract class ContactDatabase가 RoomDatabase임을 Android RoomLibrary에게 알려서 실제 Database를 생성하게
// 하고 싶으면 Database Annotation을 사용하면 된다.
// Database Annotation의 Parameter인 entities에는 RoomDatabase에서 사용 할 테이블을 정의한 클래스를 넣어주면 된다.
// Database Annotation의 Parameter인 version에는 RoomDatabase의 버전을 지정해주면 된다.
@Database(
    entities = [Contact::class],
    version = 1
)
// RoomDatabase의 작업을 수행하는데 필요한 코드를 자동으로 만들어주기 위해서 RoomDatabase()를 상속 받는다.
abstract class ContactDatabase: RoomDatabase() {
    // RoomDatabase 작업을 위해서 정의한 Dao 인터페이스 타입의 추상 변수를 만든다.
    abstract val dao: ContactDao
}