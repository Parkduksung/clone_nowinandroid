package com.example.feature_foryou

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier

@Composable
fun ForYouRoute(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewModel: ForYouViewModel = hiltViewModel()
) {


}

//Material3Api,LayoutApi Option 추가, reflection Option 들 추가하는듯 싶다.
/**
 * @param windowSizeClass window 사이즈 크기에 맞게 화면 구성하려고 필요한거로 생각된다.
 * @param interestsSelectionState ForYou 화면에 상태를 나타내는 sealed interface
 * @param feedState ForYou Feed 화면의 상태를 나타내는 sealed interface
 * @param onTopicCheckedChanged TopicCheck 상태에 대한 리스너
 * @param onAuthorCheckedChanged AuthorCheck 상태에 대한 리스너
 * @param saveFollowedTopics 토픽을 저장할때 클릭리스너
 * @param onNewsResourcesCheckedChanged NewsResourcesChecked 상태에 대한 리스너
 * @param modifier 화면 변화에 필요한 Modifier
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ForYouScreen(
    windowSizeClass: WindowSizeClass,
    interestsSelectionState: ForYouInterestsSelectionState,
    feedState: ForYouFeedState,
    onTopicCheckedChanged: (String, Boolean) -> Unit,
    onAuthorCheckedChanged: (String, Boolean) -> Unit,
    saveFollowedTopics: () -> Unit,
    onNewsResourcesCheckedChanged: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

}