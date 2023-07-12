package com.todo.task.service

import com.todo.task.activity.TaskItem

interface TaskItemClickListener
{
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}