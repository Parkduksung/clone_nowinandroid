package com.example.core_database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core_database.dao.AuthorDao
import com.example.core_database.dao.EpisodeDao
import com.example.core_database.dao.NewsResourceDao
import com.example.core_database.dao.TopicDao
import com.example.core_database.model.*
import com.example.core_database.util.InstantConverter
import com.example.core_database.util.NewsResourceTypeConverter


@Database(
    entities = [
        AuthorEntity::class,
        EpisodeAuthorCrossRef::class,
        EpisodeEntity::class,
        NewsResourceAuthorCrossRef::class,
        NewsResourceEntity::class,
        NewsResourceTopicCrossRef::class,
        TopicEntity::class
    ],
    version = 9,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = DatabaseMigrations.Schema2to3::class),
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5),
        AutoMigration(from = 5, to = 6),
        AutoMigration(from = 6, to = 7),
        AutoMigration(from = 7, to = 8),
        AutoMigration(from = 8, to = 9),
    ],
    exportSchema = true
)

@TypeConverters(
    InstantConverter::class,
    NewsResourceTypeConverter::class
)
abstract class NiADatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun authorDao(): AuthorDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun newsResourceDao(): NewsResourceDao
}