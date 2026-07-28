package com.system.uiconfig;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FORCE WEBRTC AUDIO TO PHONE EARPIECE
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            audioManager.setSpeakerphoneOn(false); // Disables main speaker
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            audioManager.setSpeakerphoneOn(false);
        }
    }
}