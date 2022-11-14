package com.udacity.project4.locationreminders

import com.udacity.project4.locationreminders.data.ReminderDataSource
import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result
private var returningError = false

class FakeDataSource(var items: MutableList<ReminderDTO>? = mutableListOf()) : ReminderDataSource {
    private var SuddenError = false

    fun returningError(value: Boolean) {
        SuddenError = value
    }

    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        // when the reminder list arent loaded somehow this give the right path

        if (SuddenError) {
            return Result.Error("cant retrieve reminders")
        } else {
        }
        return Result.Success(ArrayList(items))
    }

    override suspend fun saveReminder(reminder: ReminderDTO) {
        items?.add(reminder)
    }

    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        // when the reminder list arent loaded somehow this give the right path

        if (SuddenError) {
            return Result.Error("cant retrieve reminders")
        }
        // getting the reminder by its id
        val reminder = items?.find {
            it.id == id
        }
        return if (reminder != null) {
            Result.Success(reminder)
        } else {
            Result.Error("cant retrieve reminders")
        }
    }


    override suspend fun deleteAllReminders() {
//delete all the items
        items?.clear()}


    }
}