package com.alexey.incomingcall2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast

class CustomBroadcastReceiver:BroadcastReceiver() {
     companion object{
         var string:String=""
     }
    override fun onReceive(context: Context?, intent: Intent?) {
        val telephonyManager=context?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val phoneListener=object:PhoneStateListener(){
            override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                //val toast=Toast(context)
                //toast.setGravity(Gravity.CENTER_VERTICAL,0,0)
                //toast.duration=Toast.LENGTH_LONG

                when(state){
                    //состояние, когда телефон звонит
                    TelephonyManager.CALL_STATE_RINGING->{
                        Log.i("call","ringing")
                        Log.i("id",phoneNumber)
                        string=phoneNumber as String
                  //      toast.view=LayoutInflater.from(context).inflate(R.layout.custom_view,null)
                        Toast.makeText(context,string,Toast.LENGTH_LONG).show()
                    }
                    //состояние, когда трубку не взяли
                    TelephonyManager.CALL_STATE_OFFHOOK->{
                        Log.i("call","offhook")
                        Log.i("id",phoneNumber)
                    }
                    //состояние, когда сброшен звонок
                    TelephonyManager.CALL_STATE_IDLE->{
                        Log.i("call","IDLE")
                        Log.i("id",phoneNumber)
                    }
                }
                super.onCallStateChanged(state, phoneNumber)
            }

        }
        telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE)
    }
}