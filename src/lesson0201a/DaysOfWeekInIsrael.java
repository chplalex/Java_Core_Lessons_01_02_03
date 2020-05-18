package lesson0201a;

public enum DaysOfWeekInIsrael {
    Sunday(8),
    Monday(8),
    Tuesday(8),
    Wednesday(8),
    Thursday(8),
    Friday(4),
    Saturday(0);

    int workingHours;

    DaysOfWeekInIsrael(int workingHours) {
        this.workingHours = workingHours;
    }

}
