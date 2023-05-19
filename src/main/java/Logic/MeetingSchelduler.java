package Logic;

import Model.Calendar;
import Model.Meeting;
import Model.MeetingSlot;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingSchelduler {
    public static List<MeetingSlot> findMeetingSlots(Calendar calendar1, Calendar calendar2, Duration meetingDuration) {
        List<MeetingSlot> availableSlots = new ArrayList<>();

        LocalTime startTime = calendar1.getWorkingHours().getStart().isAfter(calendar2.getWorkingHours().getStart()) ? calendar1.getWorkingHours().getStart() : calendar2.getWorkingHours().getStart();
        LocalTime endTime = calendar1.getWorkingHours().getEnd().isBefore(calendar2.getWorkingHours().getEnd()) ? calendar1.getWorkingHours().getEnd() : calendar2.getWorkingHours().getEnd();

        LocalTime current = startTime;
        while (current.isBefore(endTime)) {
            boolean isAvailable = true;
            LocalTime slotEnd = current.plus(meetingDuration);
            for (Meeting meeting : calendar1.getPlannedMeetings()) {
                if (current.isBefore(meeting.getEnd()) && slotEnd.isAfter(meeting.getStart())) {
                    isAvailable = false;
                    break;
                }
            }
            for (Meeting meeting : calendar2.getPlannedMeetings()) {
                if (current.isBefore(meeting.getEnd()) && slotEnd.isAfter(meeting.getStart())) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableSlots.add(new MeetingSlot(current, slotEnd));
            }
            current = current.plusMinutes(30); // przesuwam 30 minut do przodu
        }

        return availableSlots;
    }
}
