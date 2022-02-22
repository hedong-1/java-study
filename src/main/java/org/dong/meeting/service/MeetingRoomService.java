package org.dong.meeting.service;

import org.dong.meeting.mapper.MeetingRoomMapper;
import org.dong.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomId) {
        return meetingRoomMapper.getMrById(roomId);
    }

    public Integer updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateRoom(meetingRoom);
    }

    public Integer doAddMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.doAddMr(meetingRoom);
    }
}
