package com.example.core_database

import com.example.core_database.dao.AuthorDao
import com.example.core_database.dao.EpisodeDao
import com.example.core_database.dao.NewsResourceDao
import com.example.core_database.dao.TopicDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesAuthorDao(
        database : NiADatabase
    ) : AuthorDao = database.authorDao()

    @Provides
    fun providesTopicsDao(
        database: NiADatabase,
    ): TopicDao = database.topicDao()

    @Provides
    fun providesEpisodeDao(
        database: NiADatabase,
    ): EpisodeDao = database.episodeDao()

    @Provides
    fun providesNewsResourceDao(
        database: NiADatabase,
    ): NewsResourceDao = database.newsResourceDao()
}