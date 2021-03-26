package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
     //   .setDatabaseUrl(dbUrl)
        .build()

    FirebaseApp.initializeApp(options)

//    val message = Message.builder()
//        .putData("action", "LIKE")
//        .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
//        .setToken(token)
//        .build()

    val message = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Артем",
          "postId": 2,
          "newPost": "Если вы знаете английский язык — у вас могут быть хорошие карьерные перспективы."
        }""".trimIndent())
       // .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
