import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.lloydsbanktest.model.Books
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val mainOptions = MutableLiveData<List<String>>()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getMainOptions() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val options: List<String> = emptyList()
            withContext(Dispatchers.Main) {
                mainOptions.postValue(options)
            }
        }
    }

    private fun onError(message: String) {

    }

    override fun onCleared() {
        super.onCleared()

    }

}