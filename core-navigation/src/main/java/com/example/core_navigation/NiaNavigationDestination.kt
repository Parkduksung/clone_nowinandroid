package com.example.core_navigation

interface NiaNavigationDestination {

    //고유값이어야 하고 특정 라우트되는곳을 String 으로 지정하나보다. 경로는 내 Composable 에서 정의함.
    val route: String

    // 특정한 destination ID 라고 하네.
    // navigation DLS 일때 사용된다고 하네.
    // 그래프할때 필요한 ID 값을 여기서 받아볼수 있는듯.
    val destination: String
}