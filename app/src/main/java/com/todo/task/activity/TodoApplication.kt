package com.todo.task.activity

import android.app.Application
import com.todo.task.database.TaskItemDatabase
import com.todo.task.repository.TaskItemRepository

class TodoApplication : Application()
{
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}