package com.crudfirebase.crudfirebaseestudo.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.ByteArrayInputStream
import java.io.InputStream

@Configuration
class FirebaseConfig {

    @Bean
    fun initializeFirebaseApp(): FirebaseApp {
        // Obtém o JSON das credenciais da variável de ambiente
        val serviceAccountJson = System.getenv("FIREBASE_SERVICE_ACCOUNT")
            ?: throw IllegalStateException("Variável de ambiente FIREBASE_SERVICE_ACCOUNT não está definida!")

        val serviceAccountStream = ByteArrayInputStream(serviceAccountJson.toByteArray())

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
            .build()

        return FirebaseApp.initializeApp(options)
    }


    @Bean
    fun getFirestore(): com.google.cloud.firestore.Firestore {
        return FirestoreClient.getFirestore()
    }
}
