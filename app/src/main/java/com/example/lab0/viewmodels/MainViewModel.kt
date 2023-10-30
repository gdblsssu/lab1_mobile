import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab0.data.Cat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
class MainViewModel:ViewModel() {
    var catsList:ArrayList<Cat> by mutableStateOf(arrayListOf())
    fun parseCatsList(jsonString:String){
        viewModelScope.launch {
            val myType = object : TypeToken<ArrayList<Cat>>() {}.type
            val list: ArrayList<Cat> = Gson().fromJson(jsonString, myType)
            catsList = list;
        }
    }
}