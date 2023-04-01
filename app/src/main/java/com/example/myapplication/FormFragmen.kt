package com.example.myapplication


import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

import com.example.myapplication.model.Etudiant
import com.example.myapplication.service.EtudiantService
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class FormFragment : Fragment() {
    lateinit var imageuser:ImageView
    lateinit var selectedImageUri:Uri
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {


        val view : View = inflater.inflate(R.layout.fragment_form, container, false)
        val nom : EditText = view.findViewById(R.id.nom);
        val prenom : EditText = view.findViewById(R.id.prenom);
        val date : Button = view.findViewById(R.id.date);
        val ville : Spinner = view.findViewById(R.id.ville);
        imageuser = view.findViewById(R.id.image_user);
        val send : Button = view.findViewById(R.id.send);
        send.setOnClickListener{
            if(nom.text.isEmpty() || prenom.text.isEmpty()  || ville.selectedItem.toString().isEmpty() || date.text.isEmpty()){
                    Toast.makeText(context,"Entre tout les choix",Toast.LENGTH_LONG).show()
            }
            else{
                val e : Etudiant = Etudiant(nom.text.toString(), prenom.text.toString(),  ville.selectedItem.toString(),date.text.toString(),selectedImageUri)
                val es : EtudiantService = EtudiantService.instance!!
                es.addStudent(e)

                nom.setText("")
                prenom.setText("")
                imageuser.setImageResource(R.drawable.ic_baseline_person_24)
                date.text = "DD/MM/YY"

                Log.d("Test", "onCreateView: " + es.students[0].nom)
            }

        }


        imageuser.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_PICK_IMAGES)
            // starting activity on below line.
            startActivityForResult(intent, 1)



        }






        date.setOnClickListener {
            val c = Calendar.getInstance()

            // on below line we are getting
            // our day, month and year.
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = context?.let { it1 ->
                DatePickerDialog(
                    // on below line we are passing context.
                    it1,
                    { view, year, monthOfYear, dayOfMonth ->
                        // on below line we are setting
                        // date to our text view.
                        date.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    },
                    // on below line we are passing year, month
                    // and day for the selected date in our date picker.
                    year,
                    month,
                    day

                )
            }
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog?.show()
        }
        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            // compare the resultCode with the
            // constant
            if (requestCode === 1) {
                // Get the url of the image from data
                selectedImageUri = data?.data!!
                imageuser.setImageURI(selectedImageUri)

        }
    }

}


