package com.example.bluetoothgatttutorial.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Bluetooth gatt service.
 *
 * @author Denver
 * @version 1.0.0
 */
public class BluetoothGattService extends Service {
    private final LocalBinder binder = new LocalBinder();
    private static boolean isServiceRunning = false;

    @Override
    public IBinder onBind(Intent intent) {
        isServiceRunning = true;
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        isServiceRunning = false;
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        isServiceRunning = false;
        super.onDestroy();
    }

    public class LocalBinder extends Binder {
        BluetoothGattService getService() {
            return BluetoothGattService.this;
        }
    }
}
