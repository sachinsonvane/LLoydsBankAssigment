package com.ss.lloydsbankpoc.common

import android.util.Log
import android.widget.Toast
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ss.lloydsbankpoc.App
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.atomic.AtomicBoolean

interface IPreferenceDataStoreAPI {
    suspend fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T>
    suspend fun <T> getFirstPreference(key: Preferences.Key<T>, defaultValue: T): T
    suspend fun <T> putPreference(key: Preferences.Key<T>, value: T)
    suspend fun <T> removePreference(key: Preferences.Key<T>)
    suspend fun clearAllPreference()
}

fun showMessage(msg: String){
    Toast.makeText(App.instance,msg,Toast.LENGTH_SHORT).show()
}

fun showLogs(msg: String){
    if(Constants.IS_LOGS_ENABLE) {
        Log.e(Constants.APP_LOGS_TAG, msg)
    }
}

class SingleEventLiveData<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { value ->

            if (pending.compareAndSet(true, false)) {
                observer.onChanged(value) // Notify the observer with the value
            }
        }
    }

    override fun setValue(value: T) {
        pending.set(true) // Mark the event as pending
        super.setValue(value) // Set the value in the parent class (MutableLiveData)
    }
}