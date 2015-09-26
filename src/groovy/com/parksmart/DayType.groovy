package com.parksmart


public enum DayType {
    Monday('M', 1),
    Tuesday('T', 2),
    Wednesday('W', 3),
    Thursday('Th', 4),
    Friday('F', 5),
    Saturday('S', 6),
    Sunday('Su', 7)

    String shortName
    Integer jodaDayValue
    Integer value

    DayType(String shortName, Integer jodaDayValue) {
        this.shortName = shortName
        this.jodaDayValue = jodaDayValue
        this.value = jodaDayValue
    }
}