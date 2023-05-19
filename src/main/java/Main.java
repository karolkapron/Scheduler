import Logic.MeetingSchelduler;
import Model.Calendar;
import Model.Meeting;
import JsonReader.Reader;
import Model.MeetingSlot;
import Model.WorkingHours;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader readerFirstCalendar = new Reader("resources/test.json");
        Reader readerSecondCalendar = new Reader("resources/Calendar2.json");
        List<LocalTime> workingHoursFirst = readerFirstCalendar.readerWorkingHours();
        WorkingHours workingHourF  = new WorkingHours(workingHoursFirst.get(0), workingHoursFirst.get(1));

        List<LocalTime> workingHoursSecond = readerSecondCalendar.readerWorkingHours();
        WorkingHours workingHourS  = new WorkingHours(workingHoursSecond.get(0), workingHoursSecond.get(1));

        List<Meeting> callsFirst = readerFirstCalendar.readerCalls();
        List<Meeting> callsSecond = readerSecondCalendar.readerCalls();
        Duration meetingDuration = Duration.ofMinutes(30);
        Calendar calendar1 = new Calendar(workingHourF, callsFirst);
        Calendar calendar2 = new Calendar(workingHourS, callsSecond);
        List<MeetingSlot> availableSlots = MeetingSchelduler.findMeetingSlots(calendar1, calendar2, meetingDuration);

        System.out.println("Available meeting slots:");
        for (MeetingSlot slot : availableSlots) {
            System.out.println(slot.getStart() + " , " + slot.getEnd());
        }
    }
}