package com.crudfirebase.crudfirebaseestudo.controller

import com.google.firebase.cloud.FirestoreClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class FirebaseTestController {

    @PostMapping("/save")
    fun saveData(@RequestBody data: Map<String, Any>): ResponseEntity<String> {
        return try {
            val db = FirestoreClient.getFirestore()
            val docRef = db.collection("testCollection").document()
            docRef.set(data).get() // Aguarde a conclusão da operação
            ResponseEntity.ok("Dados salvos com sucesso! ID do documento: ${docRef.id}")
        } catch (e: Exception) {
            println("Erro ao salvar no Firestore: ${e.message}")
            ResponseEntity.status(500).body("Erro ao salvar no Firestore: ${e.message}")
        }
    }

    @GetMapping("/test")
    fun testEndpoint(): ResponseEntity<String> {
        return ResponseEntity.ok("GET Endpoint funcionando!")
    }
}
