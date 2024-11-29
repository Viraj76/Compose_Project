import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsv.composeproject.google_translate.mvvm.TranslationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TranslationViewModel(
    private val repository: TranslationRepository
) : ViewModel() {

    private val _translatedText = MutableStateFlow("")
    val translatedText: StateFlow<String> get() = _translatedText

    private val _errorText = MutableStateFlow("")
    val errorText: StateFlow<String> get() = _errorText

    private val _downloadedLanguages = MutableLiveData<List<String>>()
    val downloadedLanguages: LiveData<List<String>> get() = _downloadedLanguages

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun translate(text: String) {
        repository.translateText(
            text,
            onSuccess = { translated ->
                Log.d("Translated", translated)
                _translatedText.value = translated
            },
            onError = { error ->
                _errorText.value = error
            }
        )
    }

    fun fetchDownloadedLanguages() {
        repository.getDownloadedLanguages(
            onSuccess = { languages ->
                _downloadedLanguages.postValue(languages)
            },
            onError = { errorMessage ->
                _error.postValue(errorMessage)
            }
        )
    }
}
