import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.lloydsbanktest.model.Books
import com.ss.lloydsbanktest.model.MOptions
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.ss.lloydsbanktest.R

class MainActivityViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val mainOptions = MutableLiveData<List<MOptions>>()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getMainOptions() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            var options = ArrayList<MOptions>()
            options.add(MOptions("Books",R.drawable.books_img,"Harry Potter and the Sorcerer's Stone"))
            options.add(MOptions("Weasley",R.drawable.ron_weasley,"Ron Weasley"))
            options.add(MOptions("Spells",R.drawable.harry,"Protects caster from a variety of substances"))
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