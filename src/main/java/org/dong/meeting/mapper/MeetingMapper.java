package org.dong.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.dong.meeting.model.Meeting;

public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingId") Integer meetingId,@Param("mps") Integer[] mps);
}
