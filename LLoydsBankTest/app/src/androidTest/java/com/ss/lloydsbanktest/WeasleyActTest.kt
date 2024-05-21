
import com.ss.lloydsbanktest.MyApplication
import org.junit.Test
import org.junit.runner.RunWith
import com.ss.lloydsbanktest.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Assert

class WeasleyActTest {

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        //onError("Exception handled: ${throwable.localizedMessage}")
    }

    @Before
    fun setup() {

    }

    @Test
    fun test() {


        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = MyApplication.instance.mainRepository.getWeasley()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    println(" response : "+response.body().toString())

                    Assert.assertEquals(response.isSuccessful, true)

                } else {
                    println(" response error : "+response.message().toString())
                }
            }
        }

    }
}