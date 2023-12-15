import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab0.api.ApiService
import com.example.lab0.api.Common
import com.example.lab0.api.Common.retrofitService
import com.example.lab0.api.RetrofitHelper
import com.example.lab0.data.Cat
import com.example.lab0.data.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: CatRepository
) : ViewModel() {

    var errorMessage: String by mutableStateOf("")
    var loading: Boolean by mutableStateOf(true)
    var catsList:ArrayList<Cat> by mutableStateOf(arrayListOf())
    val cats = repo.getCatsFromRoom()



    fun requestCatList(){
        viewModelScope.launch (Dispatchers.IO) {
            try {
                catsList = Common.retrofitService.getCats() as ArrayList<Cat>
                val response = retrofitService.getCats()
                catsList = response as ArrayList<Cat>
                repo.addCatListToRoom(response)
                loading = false;
            }
            catch (e: Exception) {
                loading = false;
                errorMessage = e.message.toString()

            }
        }
    }

    fun requestCatListByName(name: String) {
        viewModelScope.launch {
            try {
                catsList = Common.retrofitService.getCatsByName(name) as ArrayList<Cat>
                loading = false;
            }
            catch (e: Exception) {
                loading = false;
                errorMessage = e.message.toString()
            }
        }
    }
}