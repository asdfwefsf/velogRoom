package com.company.velogroom

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// RoomDatabase에 접근해서 데이터를 관리하고 싶을 때 필요한 메서드를 정의하고 싶으면 Dao Annotation을 작성해주면 된다.
// Dao Annotation을 사용하게 되면 Room이 Dao Annotation을 적용한 인터페이스를 구현한 데이터 엑세스 객체를 자동으로 생성해서
// 해당 interface를 활용해서 데이터를 관리 및 처리 할 수 있다.
@Dao
interface ContactDao {

    // @Dao Interface 내부에 데이터를 처리 및 관리 할 수 있는 메서드를 정의 할 때 parameter에 Entity Annotation을 달아준
    // 데이터 항목을 넣어주어야 한다.

    // RoomDatabase에 데이터를 Update + Insert
    @Upsert
    suspend fun upsertContact(contact: Contact)

    // RoomDatabase에 데이터를 삭제
    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName DESC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName DESC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}