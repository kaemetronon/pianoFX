package com.company.utils;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class SoundProcessor {

    Synthesizer synth;
    private String s;
    MidiChannel[] channels;

    public void setNoteAndPlay(String s) {
        this.s = s;
        switch (s) {
            case "c":
                play(60);
                return;
            case "d":
                play(62);
                return;
            case "e":
                play(64);
                return;
            case "f":
                play(65);
                return;
            case "g":
                play(67);
                return;
            case "a":
                play(69);
                return;
            case "b":
                play(71);
                return;
            case "cShrp":
                play(61);
                return;
            case "dShrp":
                play(63);
                return;
            case "fShrp":
                play(66);
                return;
            case "gShrp":
                play(68);
                return;
            case "aShrp":
                play(70);
                return;
            default:
                return;
        }
    }

    private void play(int note) {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        channels = synth.getChannels();
        channels[0].programChange(1);

        channels[0].noteOn(note, 100);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channels[0].noteOff(note);
        synth.close();
    }
}
