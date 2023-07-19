package com.plcoding.translator_kmm.core.domain.util

import com.plcoding.translator_kmm.core.domain.util.CommonMutableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

class IOSMutableStateFlow<T>(
    initialValue: T
): CommonMutableStateFlow<T>(MutableStateFlow(initialValue))