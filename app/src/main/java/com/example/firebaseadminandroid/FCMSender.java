package com.example.firebaseadminandroid;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FCMSender {
    public void sendFCM(Context context) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            try {
                AssetManager assetManager = context.getAssets();

                InputStream serviceAccount =  assetManager.open("cred.json");

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);

                Notification notification = Notification.builder()
                        .setTitle("Test FCM Notification")
                        .setBody("Test FCM Message").build();

                Message message = Message.builder()
                        .setToken("fik25uWpQ7at34bw8yxrK4:APA91bEOrfwgkZHgXEpeH2KZCVF-NFaAHDhwaak6-kEuc-fCLyJdQyuSX14nUFulcdKyJ9nMqAPRY54dITpGlOOJ1_j8jzZYccjzLH5xKsetGo0kI_ZyrycLfOOpW3KJCW5WdjnWt9aR")
                        .setNotification(notification).build();

                String response = FirebaseMessaging.getInstance().send(message);

                Log.d("T", "Message sent successfully! " + response);
            } catch (IOException | FirebaseMessagingException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }
}