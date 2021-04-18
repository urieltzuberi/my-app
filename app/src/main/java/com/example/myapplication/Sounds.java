package com.example.myapplication;

import com.example.myapplication.Image;


public class Sounds extends Image {
    private int soundId;
    public Sounds(int imageId, int soundId) {
        super(imageId);
        this.soundId = soundId;
    }

 

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }
}
