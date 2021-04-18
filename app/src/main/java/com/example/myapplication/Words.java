package com.example.myapplication;

import com.example.myapplication.R;

import java.util.Arrays;

public class Words extends Sounds {
  private String word;
  public Words(int imageId, int soundId, String word) {
    super(imageId, soundId);
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }
}