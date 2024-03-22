package com.company.velogroom

import androidx.room.Entity
import androidx.room.PrimaryKey

// 아래의 data class Contact를 RoomDatabase 내부의 테이블 행으로 사용하겠다는 것을 Room에게 알려주려면 @Entity Annotation을 사용해야 한다.
// 아래의 data class Contact의 각 속성들은 RoomDatabase의 Column에 매칭된다.
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,

    // 데이터베이스의 각 단일 테이블에는 고유한 접근 키 값을 가지고 있어야 하기 때문에 data class에 id를 넣어준것이다.
    // 데이터베이스의 테이블에 접근 할 때 해당 id를 가진 테이블이 단 한개만 존재해야 하기 때문에 PrimaryKey Annotation을 작성해서
    // Room에게 id 변수가 고유 접근 키값이라고 알려주어야 한다.
    // 또한 데이터베이스에 테이블을 추가 할 때마다 일일이 id 값을 업데이트 해주기 불편하므로 "autoGenerate = true"로 설정해주어야 한다.
    // PrimaryKey(autoGenerate = true)는 데이터 테이블'행'이 추가 될 때마다 자동으로 1씩 키값이 증가하도록 도와준다.

)