package com.example.ecommercemubuto;

import com.example.ecommercemubuto.helper.AppConstants;
import com.example.ecommercemubuto.helper.mubuto.NotificationHelper;
import com.example.ecommercemubuto.helper.storage.StorageHelper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import io.intercom.android.sdk.push.IntercomPushClient;
@SuppressWarnings("unchecked")
public class MubutoFirebaseMessagingService extends FirebaseMessagingService {
    private final IntercomPushClient intercomPushClient = new IntercomPushClient();


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            Map message = remoteMessage.getData();
            if (intercomPushClient.isIntercomPush(message)) {
                intercomPushClient.handlePush(getApplication(), message);
            } else {
                NotificationHelper.showNotification(this, remoteMessage);
            }
        } catch (Exception e) {
            NotificationHelper.showNotification(this, remoteMessage);
        }
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        try {
            StorageHelper.getSecureStorage().insert(AppConstants.FIREBASE_TOKEN_KEY, s);
        } catch (Exception e) {
        }

    }

    public static String getToken() {
        try {
            return StorageHelper.getSecureStorage().get(AppConstants.FIREBASE_TOKEN_KEY, String.class);
        } catch (Exception e) {
            return "";
        }
    }
}
