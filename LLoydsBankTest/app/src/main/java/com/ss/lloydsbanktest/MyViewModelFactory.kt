import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ss.lloydsbanktest.viewmodel.BooksViewModel

class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            MainActivityViewModel(this.repository) as T
        }else  if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            BooksViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}