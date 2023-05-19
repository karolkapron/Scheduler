package Model;

import java.time.LocalTime;

public class MeetingSlot {
    private final LocalTime start;
    private final LocalTime end;

    public MeetingSlot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}
