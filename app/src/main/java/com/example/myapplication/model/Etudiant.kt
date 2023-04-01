package com.example.myapplication.model

import android.net.Uri

class Etudiant {
    var nom: String? = null
    var prenom: String? = null
    var ville: String? = null
    var dateNaissance: String? = null
    var photoUri: Uri? = null
    constructor(nom: String?, prenom: String?, ville: String?, dateNaissance: String?, photoUri: Uri) {
        this.nom = nom
        this.prenom = prenom
        this.ville = ville
        this.dateNaissance = dateNaissance
        this.photoUri = photoUri
    }}