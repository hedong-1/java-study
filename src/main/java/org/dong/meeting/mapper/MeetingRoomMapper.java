package org.dong.meeting.mapper;

import org.dong.meeting.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomMapper {
    public List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomId);

    Integer updateRoom(MeetingRoom meetingRoom);

    Integer doAddMr(MeetingRoom meetingRoom);
}
