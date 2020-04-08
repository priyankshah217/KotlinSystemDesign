package com.coding.challenge.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.MonthDay
import java.time.temporal.TemporalAdjusters
import java.util.stream.Collectors
import java.util.stream.IntStream


class CalenderUtils {
    companion object {
        fun getRemainingDaysToCompleteAWeekInMonth(
            year: Int = LocalDate.now().year,
            month: Int = LocalDate.now().monthValue,
            dayOfMonthDay: Int = MonthDay.now().dayOfMonth
        ): MutableList<DayOfWeek> {
            val localDate = LocalDate.of(year, month, dayOfMonthDay)
            val firstDayOfMonth =
                localDate.with(TemporalAdjusters.firstDayOfMonth())
            val lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth())
            val additionalDays = lastDayOfMonth.dayOfMonth - 28
            return IntStream
                .range(0, additionalDays)
                .mapToObj { firstDayOfMonth.atStartOfDay().dayOfWeek + it.toLong() }
                .collect(Collectors.toUnmodifiableList())
        }
    }
}