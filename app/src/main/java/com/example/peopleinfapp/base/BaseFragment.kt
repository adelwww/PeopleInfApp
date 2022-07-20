package com.example.peopleinfapp.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.peopleinfapp.ui.state.UIState
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel
    protected abstract val binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        setupObserves()
        setupSubscribe()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupObserves() {
    }

    protected open fun setupSubscribe() {
    }

    protected fun <T> StateFlow<UIState<T>>.collectUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        success: ((data: T) -> Unit)? = null,
        loading: ((data: UIState.Loading<T>) -> Unit)? = null,
        error: ((error: String) -> Unit)? = null,
        idle: ((idle: UIState.Idle<T>) -> Unit)? = null,
        doSomethingInCorrect: ((state: UIState<T>) -> Unit)? = null
    ) {
        collectFlowSafely(lifecycleState) {
            collect {
                doSomethingInCorrect?.invoke(it)
                when (it) {
                    is UIState.Idle -> {
                        idle?.invoke(it)
                    }
                    is UIState.Loading -> {
                        loading?.invoke(it)
                    }
                    is UIState.Error -> {
                        error?.invoke(it.error)
                    }
                    is UIState.Success -> {
                        success?.invoke(it.data)
                    }
                }
            }
        }
    }

    private fun collectFlowSafely(
        lifecycleState: Lifecycle.State,
        collect: suspend () -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
                collect()
            }
        }
    }

    protected fun <T> UIState<T>.setupViewVisibility(
        group: Group, loader: CircularProgressIndicator, isNavigationWhenSuccess: Boolean = false
    ){
        fun showLoader(isVisible: Boolean){
            group.isVisible = isVisible
            loader.isVisible = isVisible
        }
        when(this){
            is UIState.Idle -> {
            }
            is UIState.Loading -> {
                showLoader(true)
            }
            is UIState.Error -> {
                showLoader(true)
            }
            is UIState.Success ->  if (isNavigationWhenSuccess){
                showLoader(true)
            } else{
                showLoader(false)
            }
        }
    }

}