package com.euro.sticker.uicommon.base.viewmodel

class BaseDataState<out T, out E>(val status: ViewState, val data: T?, val error: E?) {

    companion object {
        fun <T, E> success(data: T): BaseDataState<T, E> {
            return BaseDataState(ViewState.SUCCESS, data, null)
        }

        fun <T, E> error(error: E?, data: T? = null): BaseDataState<T, E> {
            return BaseDataState(ViewState.ERROR, data, error)
        }

        fun <T, E> loading(data: T? = null): BaseDataState<T, E> {
            return BaseDataState(ViewState.LOADING, data, null)
        }

        fun <T, E> idle(): BaseDataState<T, E> {
            return BaseDataState(ViewState.IDLE, null, null)
        }
    }

    fun getResultData() = data!!

    fun getResultDataSafely() = data
}

enum class ViewState {
    LOADING, SUCCESS, ERROR, IDLE
}
