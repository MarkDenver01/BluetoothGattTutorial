package com.example.bluetoothgatttutorial.Utility;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;

/**
 * Utility of this project.
 *
 * @author Denver
 * @version 1.0.0
 */
public class Utils {
    private Utils instance = null;

    /**
     * Get instance of this class.
     *
     * @return instance
     */
    public Utils getInstance() {
        if (instance == null) {
            instance = Utils.this;
        }

        return instance;
    }

    /**
     * Send a broadcast update.
     *
     * @param context - required context
     * @param action  - required string
     */
    public void sendBroadcastUpdate(final Context context,
                                    final String action) {
        Intent intent = new Intent();
        context.sendBroadcast(intent);
    }

    /**
     * Send broadcast update with ble characteristics.
     *
     * @param context        - required context
     * @param action         - required action
     * @param characteristic - required bluetooth characteristics
     */
    public void sendBroadcastUpdateWithCharacteristics(final Context context,
                                                       final String action,
                                                       final BluetoothGattCharacteristic characteristic) {
        Intent intent = new Intent();
        intent.putExtra(action, characteristic.getValue());
        context.sendBroadcast(intent);
    }
}
