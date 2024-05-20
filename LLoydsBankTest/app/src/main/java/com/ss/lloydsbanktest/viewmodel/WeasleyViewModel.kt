import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.lloydsbanktest.model.Weasley
import com.ss.lloydsbanktest.view.WeasleyAct
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeasleyViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val weasley = MutableLiveData<List<Weasley>>()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getWeasley() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getWeasley()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    println(" response : "+response.body().toString())
                    weasley.postValue(response.body())
                    loading.value = false
                } else {
                    println(" response error : "+response.message().toString())
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {

    }

    override fun onCleared() {
        super.onCleared()

    }
}