package com.example.core_datastore

//각각의 모델에 대한 버전을 sync 처라하기 위한 Data Class
//RoomDB 에 저장되는 버전인거 같다.
data class ChangeListVersions(
    val topicVersion : Int = -1,
    val authorVersion : Int = -1,
    val episodeVersion : Int = -1,
    val newsResourceVersion : Int = -1,
)