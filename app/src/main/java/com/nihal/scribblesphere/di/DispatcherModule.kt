package com.nihal.scribblesphere.di

import com.nihal.scribblesphere.services.DispatcherProvider
import com.nihal.scribblesphere.services.DispatcherProviderImpl
import com.nihal.scribblesphere.services.alarm.AlarmScheduler
import com.nihal.scribblesphere.services.alarm.AlarmSchedulerImpl
import com.nihal.scribblesphere.domain.repository.trash.TrashNoteRepoImpl
import com.nihal.scribblesphere.domain.repository.trash.TrashNoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    abstract fun bindDispatcherProvider(
        dispatcherProvider: DispatcherProviderImpl,
    ): DispatcherProvider

    @Binds
    abstract fun bindTrashRepo(
        trashNoteRepository: TrashNoteRepoImpl,
    ): TrashNoteRepo

    @Binds
    abstract fun bindAlarm(
        trashNoteRepository: AlarmSchedulerImpl,
    ): AlarmScheduler
}
