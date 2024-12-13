package dev.whysoezzy.domain.utils

interface SimpleUseCase<P, R> {
    suspend fun execute(data: P): R
}

interface UseCase<M,U,R>{
    suspend fun execute(model: M, useCase: U): R
}