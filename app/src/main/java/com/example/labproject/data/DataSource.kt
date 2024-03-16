package com.example.labproject.data
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.labproject.R

object DataSource {
    val labsOption = listOf(
        Pair(R.string.lab1, 1),
        Pair(R.string.lab2, 2),
        Pair(R.string.lab3, 3),
        Pair(R.string.lab4_5_6, 4),
        Pair(R.string.lab7, 6),
    )
    val TAG_FIRST_NUM = "TAG_FIRST_NUM"
    val TAG_SECOND_NUM = "TAG_SECOND_NUM"
    val TAG_RESULT = "TAG_RESULT"
    val TAG_PLUS = "TAG_PLUS"
    val TAG_MINUS = "TAG_MINUS"
    val TAG_MULTIPLY = "TAG_MULTIPLY"
    val TAG_DIVIDE = "TAG_DIVIDE"
    val TAG_FIRST_NAME_EDIT = "TAG_FIRST_NAME_EDOT"
    val TAG_LAST_NAME_EDIT = "TAG_LAST_NAME_EDIT"
    val TAG_SAVE_PROFILE = "TAG_SAVE_PROFILE"

    @Entity
    data class User(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "first_name") val firstName: String?,
        @ColumnInfo(name = "last_name") val lastName: String?
    )

    @Dao
    interface UserDao {
        @Query("SELECT * FROM user")
        fun getAll(): List<User>

        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<User>

        @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1")
        fun findByName(first: String, last: String): User

        @Update
        fun update(users: User)

        @Delete
        fun delete(user: User)
    }

    @Database(entities = [User::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao
    }
}




