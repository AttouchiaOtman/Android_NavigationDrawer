package com.example.myapplication.service

import com.example.myapplication.model.Etudiant

class EtudiantService private constructor() {
    var students: ArrayList<Etudiant>
    fun addStudent(e: Etudiant) {
        students.add(e)
    }
    companion object {
        var instance: EtudiantService? = null
            get() {
                if (field == null) {
                    synchronized(EtudiantService::class.java) {
                        if (field == null) {
                            field = EtudiantService()
                        }
                    }
                }
                return field
            }
            private set
    }
    init {
        students = ArrayList()
    }}