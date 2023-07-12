package com.todo.task.activity

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.todo.task.R
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "task_item_table")
class TaskItem(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "dueTimeString") var dueTimeString: String?,
    @ColumnInfo(name = "completedDateString") var completedDateString: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
{

    private fun completedDate(): LocalDate? = if (completedDateString == null) null else LocalDate.parse(completedDateString, dateFormatter)
    fun dueTime(): LocalTime? = if (dueTimeString == null) null else LocalTime.parse(dueTimeString, timeFormatter)

    fun isCompleted() = completedDate() != null
    fun imageResource(): Int = if(isCompleted()) R.drawable.baseline_check_circle_24 else R.drawable.baseline_circle_24
    fun imageColor(context: Context): Int = if(isCompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.lite_green)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.lite_white)

    companion object {
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_TIME
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }
}