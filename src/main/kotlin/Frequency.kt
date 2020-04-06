enum class Frequency(val value: Int) {
    DAILY(1),
    WEEKLY(7),
    BIWEEKLY(15),
    MONTHLY(30),
    QUARTERLY(90),
    HALFYEARLY(180),
    ANNUAL(360),
    NONPERIODIC(0);
}
