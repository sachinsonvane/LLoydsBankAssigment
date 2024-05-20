class MainRepository constructor(private val retrofitService: RetrofitService) {



    suspend fun getWeasley() = retrofitService.getWeasley()

    suspend fun getSpells() = retrofitService.getSpells()

    suspend fun getBooks() = retrofitService.getBooks()

}