package com.george.android_class_2019_winter_midterm_publisher.data.source

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class FirestoreRepository {

    val TAG = "FIREBASE_REPOSITORY"
    var firestoreDB = FirebaseFirestore.getInstance()


//    // save address to firebase
//    fun saveAddressItem(addressItem: AddressItem): Task<Void> {
//        //var
//        var documentReference = firestoreDB.collection("users").document(user!!.email.toString())
//            .collection("saved_addresses").document(addressItem.addressId)
//        return documentReference.set(addressItem)
//    }

    // get saved addresses from firebase
    fun getArticles(): CollectionReference {
        var collectionReference = firestoreDB.collection("articles")

        return collectionReference
    }

//    fun deleteAddress(addressItem: AddressItem): Task<Void> {
//        var documentReference =  firestoreDB.collection("users/${user!!.email.toString()}/saved_addresses")
//            .document(addressItem.addressId)
//
//        return documentReference.delete()
//    }

}