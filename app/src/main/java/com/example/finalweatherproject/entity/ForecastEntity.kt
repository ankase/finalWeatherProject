package com.example.finalweatherproject.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalweatherproject.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Forecast")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.ID) val id: Int = 0,
    @ColumnInfo(name = Constants.CITY) val city: CityEntity?,
    @ColumnInfo(name = Constants.LIST) val list: List<ListItem>?
) : Parcelable

