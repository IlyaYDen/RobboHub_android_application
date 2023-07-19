package ru.robbo.robbohub.domain.usecase.news

import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCase
import ru.robbo.robbohub.domain.usecase.authorization.RegisrationUseCase
import javax.inject.Inject

data class NewsUseCases @Inject constructor(
    val getNewsListUseCase: GetNewsListUseCase,
    val insertNewUseCase: InsertNewUseCase
)