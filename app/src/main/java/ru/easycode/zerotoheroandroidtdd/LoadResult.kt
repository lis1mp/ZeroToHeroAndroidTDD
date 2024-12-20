package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse) : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            val uiState = UiState.ShowData(data.text)
            updateLiveData.update(uiState)
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            val text = if (noConnection) "No internet connection" else "Something went wrong"
            updateLiveData.update(UiState.ShowData(text))
        }
    }
}