package com.danielkim.soundrecorder.adapters;

import com.danielkim.soundrecorder.RecordingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azad on 9/7/17.
 */

public class FakeList {

    static public List<RecordingItem> getSomeFakeData(){

        List<RecordingItem> recordingItemList = new ArrayList<>(1);
        RecordingItem r1 = new
                RecordingItem();
        r1.setFilePath("aaaaaaaa");
        r1.setId(1);
        r1.setName("Binate Solutions Ltd");
        r1.setTime(121212);
        r1.setLength(12);
        recordingItemList.add(r1);
        return recordingItemList;
    }
}
