package Model;

import java.util.List;

public class Calendar {
    private final WorkingHours workingHours;
    private final List<Meeting> plannedMeetings;

    public Calendar(WorkingHours workingHours, List<Meeting> plannedMeetings) {
        this.workingHours = workingHours;
        this.plannedMeetings = plannedMeetings;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public List<Meeting> getPlannedMeetings() {
        return plannedMeetings;
    }
}
