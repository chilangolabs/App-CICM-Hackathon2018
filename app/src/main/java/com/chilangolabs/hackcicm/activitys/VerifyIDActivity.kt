package com.chilangolabs.hackcicm.activitys

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.chilangolabs.hackcicm.CameraPicker.PickerBuilder
import com.chilangolabs.hackcicm.R
import kotlinx.android.synthetic.main.activity_verify_id.*
import org.jetbrains.anko.imageURI

class VerifyIDActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_id)

        imgIDFront?.setOnClickListener {
            PickerBuilder(this, PickerBuilder.SELECT_FROM_CAMERA)
                    .setOnImageReceivedListener {
                        imgIDFront?.imageURI = it
                    }
                    .setImageName("Front_ID")
                    .setImageFolderName("KolpiID")
                    .setCropScreenColor(Color.BLACK)
                    .start()
        }

        imgIDBack?.setOnClickListener {
            PickerBuilder(this, PickerBuilder.SELECT_FROM_CAMERA)
                    .setOnImageReceivedListener {
                        imgIDBack?.imageURI = it
                    }
                    .setImageName("Back_ID")
                    .setImageFolderName("KolpiID")
                    .setCropScreenColor(Color.BLACK)
                    .start()

        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }
}
